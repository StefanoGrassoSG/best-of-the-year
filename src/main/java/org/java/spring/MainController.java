package org.java.spring;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		final String myName = "stefano";
		model.addAttribute("myName", myName);
		return "index";
	}

	@GetMapping("/movies")
	public String movies(Model model) {
	 List<Movie> bestMovies = getBestMovies(); 
     List<String> titles = new ArrayList<>();
     for (int x=0;x<bestMovies.size();x++) titles.add(bestMovies.get(x).getTitle());
     String bestMoviesString = String.join(", ", titles);
     model.addAttribute("bestMovies", bestMoviesString);

    return "movies";
	}
	@GetMapping("/songs")
	public String songs(Model model) {
	    List<Song> bestSongs = getBestSongs(); 
	    List<String> titles = new ArrayList<>();
	    for (int x=0;x<bestSongs.size();x++) titles.add(bestSongs.get(x).getTitle());
	    String bestSongsString = String.join(", ", titles);
	    model.addAttribute("bestSongs", bestSongsString);
	    return "songs";
	}
	
	@GetMapping("movies/{id}") 
	public String movie(Model model, @PathVariable int id) {
		List<Movie> bestMovies = getBestMovies();
		String movie = null;
		for(int x=0;x<bestMovies.size();x++)
			if(bestMovies.get(x).getId() == id) movie = bestMovies.get(x).getTitle();
		model.addAttribute("title", movie);
		return "movies";
	}
	@GetMapping("songs/{id}") 
	public String song(Model model, @PathVariable int id) {
		List<Song> bestSongs = getBestSongs();
		String song = null;
		for(int x=0;x<bestSongs.size();x++)
			if(bestSongs.get(x).getId() == id) song = bestSongs.get(x).getTitle();
		model.addAttribute("title", song);
		return "songs";
	}
	
	private List<Movie> getBestMovies() {
		   List<Movie> movies = new ArrayList<>();
		   movies.add(new Movie(1, "Titanic"));
		   movies.add(new Movie(2, "Daredevil"));
		   movies.add(new Movie(3, "Superman"));
		   movies.add(new Movie(4, "Batman"));
		   movies.add(new Movie(5, "Narnia"));
		   return movies;
	}
	private List<Song> getBestSongs() {
	       List<Song> songs = new ArrayList<>();
	       songs.add(new Song(1, "Halo"));
	       songs.add(new Song(2, "No Love"));
	       songs.add(new Song(3, "Closer"));
	       songs.add(new Song(4, "Faded"));
	       songs.add(new Song(5, "Rockstar"));
	       return songs;
	}
}
