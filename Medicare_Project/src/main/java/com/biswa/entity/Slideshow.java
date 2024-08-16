package com.biswa.entity;

public class Slideshow {
	private int slide_id;
	private String slide_name;
	private String slide_image;

	public int getSlide_id() {
		return slide_id;
	}

	public void setSlide_id(int slide_id) {
		this.slide_id = slide_id;
	}

	public String getSlide_name() {
		return slide_name;
	}

	public void setSlide_name(String slide_name) {
		this.slide_name = slide_name;
	}

	public String getSlide_image() {
		return slide_image;
	}

	public void setSlide_image(String slide_image) {
		this.slide_image = slide_image;
	}

	@Override
	public String toString() {
		return "Slideshow [slide_id=" + slide_id + ", slide_name=" + slide_name + ", slide_image=" + slide_image + "]";
	}

}
