package com.dhasri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "versions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Versions {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	private String table_name;
	private String version;
	
	
	
	public Versions() {
	
	}
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
