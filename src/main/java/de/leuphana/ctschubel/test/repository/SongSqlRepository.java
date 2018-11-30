package de.leuphana.ctschubel.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.leuphana.ctschubel.test.model.Song;

/**
 * SQL crud repository for {@link Song} objects
 * @author ctschubel
 */
@Repository
public interface SongSqlRepository extends CrudRepository <Song, Integer>{


}
