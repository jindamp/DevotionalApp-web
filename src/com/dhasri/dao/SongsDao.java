package com.dhasri.dao;

import java.util.List;

import com.dhasri.model.MediaItem;

public interface SongsDao {

	
		public List<MediaItem> fetchSongsByCategory(String Category);
		public List<MediaItem> fetchCategories();
		
}
