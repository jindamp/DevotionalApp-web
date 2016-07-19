package com.dhasri.daoImp;

import java.io.Console;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhasri.dao.SongsDao;
import com.dhasri.model.Categories;
import com.dhasri.model.MediaItem;
import com.dhasri.model.SampleModel;
import com.dhasri.model.Versions;
import com.dhasri.model.festivals;

@Component
public class SongsDaoImpl implements SongsDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public List<MediaItem> fetchSongsByCategory(String Category) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Query query;

		query = session.createQuery("from MediaItem where category = :god");
		query.setParameter("god", Category);

		List list = query.list();

		session.close();
		return list;
	}

	@Override
	public List<MediaItem> fetchRowOfUniqueCategories() {

		// TODO Auto-generated method stub
		session = sessionFactory.openSession();

		/*
		 * tx = session.beginTransaction(); Query query = session.createQuery(
		 * "from MediaItem"); List list = query.list();
		 */

		/*
		 * Query query = session.createQuery("from MediaItem mediaItem WHERE
		 * mediaItem.title IS NOT NULL GROUP BY mediaItem.category"); List list
		 * = query.list();
		 */

		Query query = session
				.createQuery("from MediaItem  m, Categories c where c.category = m.category GROUP BY c.category");
		List list = query.list();

		session.close();
		return list;
	}

	@Override
	public List<festivals> fetchUpcomingFestivals() {

		session = sessionFactory.openSession();

		Query query = session
				.createQuery("from festivals  where festival_date > CURRENT_DATE() order by festival_date");
		query.setMaxResults(1);
		List list = query.list();

		session.close();
		return list;
	}

	@Override
	public festivals fetchUpcomingFestival() {
		Query query = session
				.createQuery("from festivals  where festival_date > CURRENT_DATE() order by festival_date");

		query.setMaxResults(1);

		session.close();
		return null;
	}

	@Override
	public List<Versions> fetchVersion() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Versions");

		List list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<MediaItem> fetchSongsByVersion(int version) {

		session = sessionFactory.openSession();
		Query query;
		List list = null;

			query = session.createQuery("from MediaItem  m, Categories c where c.category = m.category AND version>:ourVersion");
			query.setParameter("ourVersion", version);
			list = query.list();

			session.close();
		return list;
	}

	@Override
	public List<MediaItem> fetchAllSongs() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Query query = session.createQuery("from MediaItem  m, Categories c where c.category = m.category");
		List list = query.list();
		session.close();
		return list;
	}

	@Override
	public String updateLyrics(MediaItem song) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		
		String hql = "UPDATE MediaItem set lyrics_en = :english, lyrics_telugu = :telugu "  + 
	             "WHERE id = :serialNo";
		Query query = session.createQuery(hql);
		query.setParameter("english", song.getLyrics_en());
		query.setParameter("telugu", song.getLyrics_telugu());
		query.setParameter("serialNo", song.getSerialNo());
		int result = query.executeUpdate();
		
		return "result : "+result;
	}

	@Override
	public String addSong(MediaItem song) {
		// TODO Auto-generated method stub
		
		if(fetchSong(song)<1){
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(song);
	        session.getTransaction().commit();
	        
			return "sucess";
		}else
			return "error";
		
		
	}

	@Override
	public int fetchSong(MediaItem song) {
		
		session = sessionFactory.openSession();
		Query query = session.createQuery("from MediaItem  WHERE title = :title");
		query.setParameter("title", song.getTitle());
		List list = query.list();
		session.close();
		System.out.println("ads"+list.size());
		return list.size();
	}

	@Override
	public String updateSong(MediaItem song) {
		// TODO Auto-generated method stub
				session = sessionFactory.openSession();
				
				String hql = "UPDATE MediaItem set category = :category, title = :title, album = :album,"
						+ " artist = :artist, composer = :composer,title_telugu = :title_telugu, duration = :duration,path = :path "  + 
			             "WHERE id = :serialNo";
				Query query = session.createQuery(hql);
				
				query.setParameter("category", song.getCategory());
				query.setParameter("title", song.getTitle());
				query.setParameter("album", song.getAlbum());
				query.setParameter("artist", song.getArtist());
				query.setParameter("composer", song.getComposer());
				query.setParameter("duration", song.getDuration());
				query.setParameter("path", song.getPath());
				query.setParameter("serialNo", song.getSerialNo());
				query.setParameter("title_telugu", song.getTitle_telugu());
				int result = query.executeUpdate();
				
				return "result : "+result;
	}

	@Override
	public List<String> fetchAllCategories() {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		Query query = session.createQuery("Select category from Categories");
		List list = query.list();
		session.close();
		System.out.println("ads"+list.size());
		
		return list;
	}

}
