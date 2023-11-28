package org.java.spring;

public class Movie {
	
	private int id;
	private String title;
	
	public Movie(int id, String title) {
		setId(id);
		setTitle(title);
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
	
}
