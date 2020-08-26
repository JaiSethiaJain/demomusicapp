package com.music.wynk;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WynkApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WynkApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private String url(String s) {
		return "http://localhost:"+port+s;
	}

	@Test
	public void testHomePage() throws Exception {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/"), String.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForGetAllSongs() {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/songs"), List.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		assertEquals(3, ((List)(responseEntity.getBody())).size());
	}

	@Test
	public void testForAddDeleteValidSong() throws Exception {
		Song song = new Song("River", "fun");
		song.setSongId("7");
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/songs/4"), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
		responseEntity = testRestTemplate.postForEntity(url("/songs"), song, String.class);
		assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
		responseEntity = testRestTemplate.getForEntity(url("/songs/4"), String.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		testRestTemplate.delete(url("/songs/4"));
		responseEntity = testRestTemplate.getForEntity(url("/songs/4"), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForGetSongByValidName() throws Exception {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/songs/name/Roar"), Song.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForGetSongsByInvalidName() {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/songs/name/R"), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForAddInvalidSong() {
		ResponseEntity responseEntity = testRestTemplate.postForEntity(url("/songs"), new Song(), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForDeleteInvalidSong() {
		testRestTemplate.delete(url("/songs/4"));
	}

	@Test
	public void testForGetPopularSongs() {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/songs/popular"), List.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		assertEquals(3, ((List)(responseEntity.getBody())).size());
	}

	@Test
	public void testForUpdateInvalidSong() {
		testRestTemplate.put(url("/songs/4"), new Song());
	}

	@Test
	public void testForGetAllUsers() {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/users"), List.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		assertEquals(3, ((List)(responseEntity.getBody())).size());
	}

	@Test
	public void testForAddDeleteValidUser() throws Exception {
		User user = new User("Akshatt", "hat");
		user.setUserId("7");
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/users/4"), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
		responseEntity = testRestTemplate.postForEntity(url("/users"), user, String.class);
		assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
		responseEntity = testRestTemplate.getForEntity(url("/users/4"), String.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		testRestTemplate.delete(url("/users/4"));
		responseEntity = testRestTemplate.getForEntity(url("/users/4"), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForGetUserByValidName() throws Exception {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/users/name/jai"), User.class);
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForGetUsersByInvalidName() {
		ResponseEntity responseEntity = testRestTemplate.getForEntity(url("/users/name/R"), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForAddInvalidUser() {
		ResponseEntity responseEntity = testRestTemplate.postForEntity(url("/users"), new User(), String.class);
		assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
	}

	@Test
	public void testForDeleteInvalidUser() {
		testRestTemplate.delete(url("/users/4"));
	}

	@Test
	public void testForUpdateInvalidUser() {
		testRestTemplate.put(url("/users/4"), new User());
	}

	@Test
	public void testForAddValidSongToValidUser() throws Exception {
		Song song = new Song("Rockstar", "pqr");
		song.setSongId("2");
		testRestTemplate.put(url("/users/1/addSong"), song);
	}

}
