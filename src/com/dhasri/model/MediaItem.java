package com.dhasri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "media_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MediaItem {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int serialNo;

	private String category;
	private String lyrics_en;
	private String lyrics_telugu;
	private String title;
	private String artist;
	private String album;
	private String path;
	private long duration;
	private long albumId;
	private String composer;
	private int version;

	private String $$hashKey;
	private String title_telugu;

	public MediaItem() {

	}

	public String getTitle_telugu() {
		return title_telugu;
	}

	public void setTitle_telugu(String title_telugu) {
		this.title_telugu = title_telugu;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public String get$$hashKey() {
		return $$hashKey;
	}

	public void set$$hashKey(String $$hashKey) {
		this.$$hashKey = $$hashKey;
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
