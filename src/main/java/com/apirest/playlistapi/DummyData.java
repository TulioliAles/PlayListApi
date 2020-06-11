package com.apirest.playlistapi;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apirest.playlistapi.document.Playlist;
import com.apirest.playlistapi.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

@Component
public class DummyData implements CommandLineRunner {

	private final PlaylistRepository playlistRepository;
	
	DummyData(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		playlistRepository.deleteAll()
			.thenMany(
					Flux.just("API REST Spring Boot", "Deploy de uma aplicação Java", "Java 8",
							"Github", "Spring Security", "Spring Framework", "Angular 9")
							.map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
							.flatMap(playlistRepository::save))
			.subscribe(System.out::println);
	}
}
