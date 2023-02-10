package org.lessons.java.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lessons.java.models.Movie;
import org.lessons.java.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping()
	public String home(Model model) {
		model.addAttribute("nome","Dario");
		
		return "index";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> bestMovies = new ArrayList<>();
		bestMovies.add(new Movie(1,"Gattaca"));
		bestMovies.add(new Movie(2,"Natural Born Killers"));
		bestMovies.add(new Movie(3,"Quei Bravi Ragazzi"));
		
		return bestMovies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song(1,"Beat It"));
		bestSongs.add(new Song(1,"Volare"));
		bestSongs.add(new Song(1,"Ormai è tardi"));
		
		return bestSongs;
	}
	
	@GetMapping("/movies")
	public String getMovies(Model movies) {
		String moviesToString = "";
		for (Movie movie : this.getBestMovies()) {
			moviesToString += movie + ", ";
		}
		movies.addAttribute("movies", moviesToString.substring(0, moviesToString.length() -2));
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model songs) {
		String songsToString = "";
		
		for (Song song : this.getBestSongs()) {
			songsToString += song + ", ";
		}
		songsToString = songsToString.substring(0, songsToString.length() -2);
		songs.addAttribute("songs", songsToString);
		return "songs";
	}
}
