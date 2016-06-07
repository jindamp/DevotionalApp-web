package com.dhasri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "media_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MediaItem {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int serialNo;
	
	private String category;
	private String sub_category;
	private String lyrics_en;
	private String lyrics_telugu;
	private String title;
	private String artist;
	private String album;
	private String path;
	private long duration;
	private long albumId;
	private String composer;

	MediaItem()
	{
		
	}
	
	
	
	
	public String getSub_category() {
		return sub_category;
	}




	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}




	public String getLyrics_en() {
		return lyrics_en;
	}


	public void setLyrics_en(String lyrics_en) {
		this.lyrics_en = lyrics_en;
	}


	public String getLyrics_telugu() {
		return lyrics_telugu;
	}


	public void setLyrics_telugu(String lyrics_telugu) {
		this.lyrics_telugu = lyrics_telugu;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}
	

}
