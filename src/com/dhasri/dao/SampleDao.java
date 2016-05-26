package com.dhasri.dao;

import java.util.List;

import com.dhasri.model.MediaItem;
import com.dhasri.model.SampleModel;


public interface SampleDao {

	public void addData();
	public List<SampleModel> fetchData();
	
	public List<MediaItem> fetchSongsByCategories();
	public List<MediaItem> fetchCategories();
	
}
