package org.lessons.java.controllers;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.models.Movie;
import org.lessons.java.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		bestMovies.add(new Movie(1,"Gattaca", "gattaca.jpg"));
		bestMovies.add(new Movie(2,"Natural Born Killers", "natural_born_killers.jpg"));
		bestMovies.add(new Movie(3,"Quei Bravi Ragazzi", "quei_bravi_ragazzi.jpg"));
		bestMovies.add(new Movie(4,"Barry Lyndon", "barry_lyndon.jpg"));
		bestMovies.add(new Movie(5,"Pulp Fiction", "pulp_fiction.jpg"));
		
		return bestMovies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song(1,"Beat It", "beat_it.jpg"));
		bestSongs.add(new Song(2,"Volare", "volare.jpeg"));
		bestSongs.add(new Song(3,"Ormai è tardi", "ormai_e_tardi.jpg"));
		bestSongs.add(new Song(4,"At last", "at_last.jpg"));
		bestSongs.add(new Song(5,"Promises", "promises.jpg"));
		
		return bestSongs;
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		model.addAttribute("bestMovies", this.getBestMovies());
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		model.addAttribute("bestSongs", this.getBestSongs());
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String singleMovie(Model model, @PathVariable("id") String id) {
		model.addAttribute("movie", this.getBestMovies().get(Integer.parseInt(id)-1));
		return "singleMovie";
	}
	
	@GetMapping("/songs/{id}")
	public String singleSong(Model model, @PathVariable("id") String id) {
		model.addAttribute("song", this.getBestSongs().get(Integer.parseInt(id)-1));
		return "singleSong";
	}
}
