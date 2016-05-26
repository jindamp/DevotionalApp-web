package com.dhasri.service;

import java.util.List;

import com.dhasri.model.MediaItem;

public interface SongsService {
 
	public List<MediaItem> fetchSongsByCategory(String Category);
	
	public List<MediaItem> fetchCategories();
}
