package com.dhasri.dao;

import java.util.List;

import com.dhasri.model.MediaItem;

public interface SongsDao {

	
		public List<MediaItem> fetchSongsByCategory(String Category);
		public List<MediaItem> fetchSongsBySubCategory(String Category);
		
		public List<MediaItem> fetchCategories();
		public List<MediaItem> fetchRowOfUniqueCategories();
		public List<MediaItem> fetchSubCategories(String parent);
		
		
}
