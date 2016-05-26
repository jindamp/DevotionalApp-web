package com.dhasri.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhasri.dao.SongsDao;
import com.dhasri.model.MediaItem;
import com.dhasri.model.SampleModel;


@Component
public class SongsDaoImpl implements SongsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	@Override
	public List<MediaItem> fetchSongsByCategory(String Category) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		//		List<MediaItem> songsList = session.createCriteria(MediaItem.class).list();
		//		tx.commit();
		
		
		Query query = session.createQuery("from MediaItem where category = :god");
		query.setParameter("god", Category);
		List list = query.list();
		System.out.println(list.toString());
		
		session.close();
		return list;
	}

	@Override
	public List<MediaItem> fetchCategories() {
		// TODO Auto-generated method stub
		
		 session = sessionFactory.openSession(); 
	     tx = session.beginTransaction(); 
	     
	     Criteria crit = session.createCriteria(MediaItem.class); 
	     crit.setProjection(Projections.distinct(Projections.property("category"))); 
	     
	     List gods = crit.list();

	     
	     tx.commit();
	     session.close();
	     
		return gods;
	}
}
