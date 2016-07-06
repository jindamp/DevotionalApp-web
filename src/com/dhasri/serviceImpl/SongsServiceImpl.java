package com.dhasri.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhasri.dao.SongsDao;
import com.dhasri.model.MediaItem;
import com.dhasri.model.Versions;
import com.dhasri.model.festivals;
import com.dhasri.service.SongsService;

public class SongsServiceImpl implements SongsService{

	@Autowired
	SongsDao songsDao;
	
	@Override
	public List<MediaItem> fetchSongsByCategory(String Category) {
		// TODO Auto-generated method stub
		return songsDao.fetchSongsByCategory(Category);
	}

	@Override
	public List<MediaItem> fetchRowOfUniqueCategories() {
		// TODO Auto-generated method stub
		return songsDao.fetchRowOfUniqueCategories();
	}



	@Override
	public List<festivals> fetchFestival() {
		// TODO Auto-generated method stub
		return songsDao.fetchUpcomingFestivals();
	}

	@Override
	public List<MediaItem> fetchSongsByVersion(int version) {
		// TODO Auto-generated method stub
		return songsDao.fetchSongsByVersion(version);
	}

	@Override
	public List<Versions> fetchVersion() {
		// TODO Auto-generated method stub
		return songsDao.fetchVersion();
	}

	@Override
	public List<MediaItem> fetchAllSongs() {
		// TODO Auto-generated method stub
		return songsDao.fetchAllSongs();
	}

	@Override
	public String updateLyrics(MediaItem song) {
		// TODO Auto-generated method stub
		return songsDao.updateLyrics(song);
	}

	@Override
	public String addSong(MediaItem song) {
		// TODO Auto-generated method stub
		return songsDao.addSong(song);
	}

}
