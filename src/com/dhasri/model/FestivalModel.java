package com.dhasri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "festival")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FestivalModel {
		
	@Id
	@GeneratedValue
	private int festival_Id;
	private String abt_celebration,why_celebrated,pooja_procedure,todo;
	
	
	

	public int getFestival_Id() {
		return festival_Id;
	}

	public void setFestival_Id(int festival_Id) {
		this.festival_Id = festival_Id;
	}


	public FestivalModel() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAbt_celebration() {
		return abt_celebration;
	}

	public void setAbt_celebration(String abt_celebration) {
		this.abt_celebration = abt_celebration;
	}

	public String getWhy_celebrated() {
		return why_celebrated;
	}

	public void setWhy_celebrated(String why_celebrated) {
		this.why_celebrated = why_celebrated;
	}

	public String getPooja_procedure() {
		return pooja_procedure;
	}

	public void setPooja_procedure(String pooja_procedure) {
		this.pooja_procedure = pooja_procedure;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	
	
}
