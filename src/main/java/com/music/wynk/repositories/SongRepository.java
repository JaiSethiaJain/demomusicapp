package com.music.wynk.repositories;

import com.music.wynk.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, String> {

//    Song findBySongId(String songId);
    Song findBySongName(String songName);

}
