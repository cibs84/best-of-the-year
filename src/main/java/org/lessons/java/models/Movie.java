package org.lessons.java.models;

public class Movie {
	private int id;
	private String title;
	private String coverPath;
	
	public Movie(int id, String title, String coverFileName) {
		this.id = id;
		this.title = title;
		this.coverPath = "/img/movie_covers/" + coverFileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	@Override
	public String toString() {
		return title;
	}
}
