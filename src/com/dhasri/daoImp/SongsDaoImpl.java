package com.dhasri.daoImp;

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
import com.dhasri.model.MediaItem;
import com.dhasri.model.SampleModel;

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
		
		//tx = session.beginTransaction();
		// List<MediaItem> songsList =
		// session.createCriteria(MediaItem.class).list();
		// tx.commit();

		Query query = session.createQuery("from MediaItem where category = :god");
		query.setParameter("god", Category);
		List list = query.list();

		// System.out.println(list.toString());

		session.close();
		return list;
	}

	@Override
	public List<MediaItem> fetchSongsBySubCategory(String Category) {
		// TODO Auto-generated method stub
				session = sessionFactory.openSession();
				Query query = session.createQuery("from MediaItem where sub_category = :god");
				query.setParameter("god", Category);
				List list = query.list();

				// System.out.println(list.toString());

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
		List<MediaItem> gods = crit.list();
		tx.commit();

		session.close();

		return gods;
	}

	@Override
	public List<MediaItem> fetchRowOfUniqueCategories() {

		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		
		//tx = session.beginTransaction();
		// Query query = session.createQuery("from MediaItem");
		// List list = query.list();

		// Query query = session.createQuery("from MediaItem mediaItem WHERE
		// mediaItem.title IS NOT NULL GROUP BY mediaItem.category");
		// List list = query.list();

		Query query = session
				.createQuery("from MediaItem  m, Categories c where c.category = m.category GROUP BY c.category");
		List list = query.list();

		session.close();
		return list;
	}

	@Override
	public List<MediaItem> fetchSubCategories(String parent) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();

		Query query = session.createQuery(
				"from MediaItem  m, Categories c where m.category = :cat AND c.category = m.sub_category GROUP BY sub_category");
		query.setParameter("cat", parent);
		List list = query.list();

		session.close();
		return list;
	}


}
