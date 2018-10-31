package de.leuphana.ctschubel.test.appservices.rest;

import de.leuphana.ctschubel.test.model.Song;
import de.leuphana.ctschubel.test.repository.SongSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * RestController for {@link SongSqlRepository}.
 * @author ctschubel
 * @a
 */
@RestController
@RequestMapping("/v1/test/song")
public class TestAppRestController {

    @Autowired
    private SongSqlRepository repository;

    @GetMapping("/getAll")
    public Iterable<Song> findAll(){
        return repository.findAll();
    }

    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSong(@RequestBody Song song){
        repository.save(song);
    }

    @GetMapping("/get/{id}")
    public Song findSongById(@PathVariable("id") int id){
        Optional<Song> song = repository.findById(id);
        return song.orElse(null);



    }

}
