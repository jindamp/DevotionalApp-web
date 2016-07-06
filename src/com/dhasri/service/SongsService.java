package com.dhasri.service;

import java.util.List;

import com.dhasri.model.MediaItem;
import com.dhasri.model.Versions;
import com.dhasri.model.festivals;

public interface SongsService {
	
	
	public String addSong(MediaItem song);
	
 
	public List<MediaItem> fetchSongsByVersion(int version);
	public List<MediaItem> fetchAllSongs();
	
	public List<MediaItem> fetchSongsByCategory(String Category);
	public List<MediaItem> fetchRowOfUniqueCategories();
	
	public List<festivals> fetchFestival();
	public List<Versions> fetchVersion();
	
	public String updateLyrics(MediaItem song);
}
