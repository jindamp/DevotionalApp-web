package com.dhasri.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhasri.dao.SampleDao;
import com.dhasri.model.MediaItem;
import com.dhasri.model.SampleModel;

@Component
public class SampleDaoImpl implements SampleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	
	@Override
	public void addData() {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		SampleModel m1 = new SampleModel("న పెరు పవన్ జిందం");
		session.save(m1);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public List<SampleModel> fetchData() {
		// TODO Auto-generated method stu
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<SampleModel> imagesList = session.createCriteria(SampleModel.class).list();
		tx.commit();
		session.close();
		return imagesList;
	}

	@Override
	public List<MediaItem> fetchSongsByCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MediaItem> fetchCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
