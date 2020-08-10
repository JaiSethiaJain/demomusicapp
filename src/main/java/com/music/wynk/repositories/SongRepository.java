package com.music.wynk.repositories;

import com.music.wynk.models.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {

    Song findBySongId(String songId);
    Song findBySongName(String songName);

}
