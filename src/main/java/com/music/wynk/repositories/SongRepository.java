package com.music.wynk.repositories;

import com.music.wynk.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, String> {

    Song findBySongName(String songName);

}
