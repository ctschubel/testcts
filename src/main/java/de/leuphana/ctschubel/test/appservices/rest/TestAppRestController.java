
package de.leuphana.ctschubel.test.appservices.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.ctschubel.test.model.Song;
import de.leuphana.ctschubel.test.repository.SongSqlRepository;

/**
 * RestController for {@link SongSqlRepository}.
 * @author ctschubel
 */
@RestController
@RequestMapping("/v1/test/song")
public class TestAppRestController {

	@Autowired
	private SongSqlRepository repository;

	@GetMapping("/getAll")
	public Iterable<Song> findAll() {

		return this.repository.findAll();
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addSong(@RequestBody final Song song) {

		this.repository.save(song);
	}

	@GetMapping("/get/{id}")
	public Song findSongById(@PathVariable("id") final int id) {

		Optional<Song> song = this.repository.findById(id);
		return song.orElse(null);

	}

}
