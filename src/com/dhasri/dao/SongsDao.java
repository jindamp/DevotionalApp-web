package com.dhasri.dao;

import java.util.List;

import com.dhasri.model.MediaItem;
import com.dhasri.model.Versions;
import com.dhasri.model.festivals;

public interface SongsDao {

		public String addSong(MediaItem song);
		
		public int fetchSong(MediaItem song);
		
		
		
		public List<MediaItem> fetchSongsByVersion(int version);
		public List<MediaItem> fetchAllSongs();
	
		public List<MediaItem> fetchSongsByCategory(String Category);
		public List<MediaItem> fetchRowOfUniqueCategories();
		
		
		public List<festivals> fetchUpcomingFestivals();
		public festivals fetchUpcomingFestival();
		public List<Versions> fetchVersion();
		
		public String updateLyrics(MediaItem song);
		
}
