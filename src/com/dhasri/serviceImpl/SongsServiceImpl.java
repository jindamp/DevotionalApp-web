package com.dhasri.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dhasri.dao.SongsDao;
import com.dhasri.model.MediaItem;
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
	public List<MediaItem> fetchCategories() {
		// TODO Auto-generated method stub
		return songsDao.fetchCategories();
	}

}
