package com.dhasri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhasri.model.MediaItem;
import com.dhasri.model.SampleModel;
import com.dhasri.service.SongsService;

@Controller
public class SongsController {
	
	@Autowired
	SongsService songsService;
	
	@RequestMapping(value = "/songs/{category}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody
	List<MediaItem> getSongsByCategory(@PathVariable("category") String category) {

		List<MediaItem> songsList = null;
		try {
			songsList = songsService.fetchSongsByCategory(category);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return songsList;
	}
		
	
	@RequestMapping(value = "/helo")
	public String test() {
		return "index";
	}
}
