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

	@Override
	public List<MediaItem> fetchRowOfUniqueCategories() {
		// TODO Auto-generated method stub
		return songsDao.fetchRowOfUniqueCategories();
	}

	@Override
	public List<MediaItem> fetchSubCategories(String parent) {
		// TODO Auto-generated method stub
		return songsDao.fetchSubCategories(parent);
	}

	@Override
	public List<MediaItem> fetchSongsBySubCategory(String Category) {
		// TODO Auto-generated method stub
		return songsDao.fetchSongsBySubCategory(Category);
	}

	
}
