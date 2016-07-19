package com.dhasri.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dhasri.model.Categories;
import com.dhasri.model.MediaItem;
import com.dhasri.model.Versions;
import com.dhasri.model.festivals;
import com.dhasri.service.SongsService;


@Controller
public class SongsController{
	
	@Autowired
	SongsService songsService;
/* ========================= Fetch Songs By Categoery ===================================== */
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
	
	
	/* ========================= Add Song ===================================== */	
	@RequestMapping(value = "/addSong",method = RequestMethod.POST)
	public @ResponseBody String addSong(@RequestBody MediaItem song) {
		
		String status = songsService.addSong(song);
		
		return "{ \"status\" : \""+status+"\"}";
		
}

	/* ========================= Update Song ===================================== */	
	@RequestMapping(value = "/updateSong",method = RequestMethod.POST)
	public @ResponseBody String updateSong(@RequestBody MediaItem song) {
		
		String status = songsService.updateSong(song);
		
		return "{ \"status\" : \""+status+"\"}";
		
}
	
	
	/* ========================= Update Lyrics ===================================== */	
	@RequestMapping(value = "/updateLyrics",method = RequestMethod.POST)
	public @ResponseBody String updateLyrics(@RequestBody MediaItem song) {
		
		String status = songsService.updateLyrics(song);
		
		return "{ \"status\" : \""+status+"\"}";
		
}
	
	/* ========================= Fetch Categoeries ===================================== */
	@RequestMapping(value = "/allCategories", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody
	List<String> fetchCategories() {

		List<String> categories = null;
		try {
			categories = songsService.fetchAllCategories();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}
	
	
	/* ========================= Fetch All Categoeries ===================================== */
	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody
	List<MediaItem> fetchRowOfUniqueCategories() {

		List<MediaItem> songsList = null;
		try {
			songsList = songsService.fetchRowOfUniqueCategories();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return songsList;
	}
	/* ========================= Fetch Songs by version===================================== */
	@RequestMapping(value = "/all/{version}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody
	List<MediaItem> fetchSongsByVersion(@PathVariable("version") String version) {

		List<MediaItem> songsList = null;
		try {
			int ver = Integer.parseInt(version);
			songsList = songsService.fetchSongsByVersion(ver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return songsList;
	}
	/* ========================= Fetch All Songs ===================================== */
	@RequestMapping(value = "/allsongs", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody
	List<MediaItem> fetchAllSongs() {

		List<MediaItem> songsList = null;
		try {
			songsList = songsService.fetchAllSongs();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return songsList;
	}
	
	@RequestMapping(value = "/festival", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody
	List<festivals> getfestival() {

		List<festivals> songsList = null;
		try {
			songsList = songsService.fetchFestival();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return songsList;
	}
	
	/* ========================= Fetch All Versions ===================================== */
	@RequestMapping(value = "/versions", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody
	List<Versions> getVersions() {

		List<Versions> songsList = null;
		try {
			songsList = songsService.fetchVersion();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return songsList;
	}
	
/* ========================= Views Controller ===================================== */	
	@RequestMapping(value = "/helo")
	public String test() {
		
		return "index";
	}
	
	@RequestMapping(value = "/upload")
	public String upload() {
		return "upload";
	}
	
	@RequestMapping(value = "/person")
	public String person() {
		return "new_person";
	}
	
	/* ========================= Upload Files ===================================== */	
	@RequestMapping(value = "/uploadFileTest",method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {
		
		if (!file.isEmpty()) {
			try {
				
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("C:/"+ "123")));
                
				FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();
				System.out.println("sucess");
				return "sucess";
			}
			catch (Exception e) {
			 return "uploading failed";
			}
		}
		else {
			
			return "file was empty";
		}

}
	
	
//=============================== Upload Files ==============================================
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				System.out.println("root-path : "+ rootPath);
				System.out.println("root-path : "+ File.separator);
				File dir = new File(rootPath + File.separator + "temp");
				
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	

	
//========================== Uploading Using AngularJS ==========================
	
	@RequestMapping(value="/upload123", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
}
