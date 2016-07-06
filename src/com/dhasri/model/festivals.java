package com.dhasri.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "festivals")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class festivals {

	@Id
	@GeneratedValue
	@Column(name = "fest_id")
	private int id;
	private Date festival_date;
	private String festival_name;
	private String festival_image;
	
	
	public festivals() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFestival_date() {
		return festival_date;
	}


	public void setFestival_date(Date festival_date) {
		this.festival_date = festival_date;
	}


	public String getFestival_name() {
		return festival_name;
	}


	public void setFestival_name(String festival_name) {
		this.festival_name = festival_name;
	}


	public String getFestival_image() {
		return festival_image;
	}


	public void setFestival_image(String festival_image) {
		this.festival_image = festival_image;
	}

}
