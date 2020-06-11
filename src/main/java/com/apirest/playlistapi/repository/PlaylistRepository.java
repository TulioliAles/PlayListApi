package com.apirest.playlistapi.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.playlistapi.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
