package de.leuphana.ctschubel.test.repository;

import de.leuphana.ctschubel.test.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongSqlRepository extends CrudRepository <Song, Integer>{


}
