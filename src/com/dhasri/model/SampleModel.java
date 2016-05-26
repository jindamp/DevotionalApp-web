package com.dhasri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "telugu_writer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SampleModel {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int srno;
	
	@Column(name = "telugu")
	private String text;
	
	
	public SampleModel() {
		// TODO Auto-generated constructor stub
	}
	
	public SampleModel(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
