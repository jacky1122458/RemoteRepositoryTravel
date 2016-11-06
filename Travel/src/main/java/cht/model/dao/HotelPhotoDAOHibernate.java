package cht.model.dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cht.model.HotelPhoto;
import cht.model.misc.HibernateUtil;
import cht.model.misc.PhotoConversion;

public class HotelPhotoDAOHibernate {
	
	private SessionFactory sessionFactory = null;
	public HotelPhotoDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//Id
	public HotelPhoto select(int photoId){
		return (HotelPhoto) this.getSession().get(HotelPhoto.class, photoId);
	}
	
	public HotelPhoto select(int Hotelid, String description){
		Query query = this.getSession().createQuery("From HotelPhoto Where hotelid =? and description like ? ");
		query.setInteger(0, Hotelid);
		query.setString(1,description +"%");
		return (HotelPhoto)query.uniqueResult();
	}
	
	public HotelPhoto getOnePhoto(int Hotelid){
		Query query = this.getSession().createQuery("From HotelPhoto Where hotelid =?");
		query.setInteger(0, Hotelid);
		query.setMaxResults(1);
		return (HotelPhoto)query.uniqueResult();
	}
	
	//all
	public List<HotelPhoto> select(){
		Query query = this.getSession().createQuery("From HotelPhoto");
		return (List<HotelPhoto>)query.list();
	}
	
	//delete
	public boolean delete(int id){
		HotelPhoto bean = this.getSession().get(HotelPhoto.class, id);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	//新增
	public HotelPhoto insert(HotelPhoto bean){
		byte[] photoData = 
				new PhotoConversion().changeByte(bean.getDescription());
		if(photoData!= null){
			bean.setPhoto(photoData);
			bean.setDescription(bean.getDescription().substring(bean.getDescription().lastIndexOf("/")+1));
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
	
	
	
	public static void main(String[] args) throws IOException{
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			HotelPhotoDAOHibernate dao = new HotelPhotoDAOHibernate(HibernateUtil.getSessionFactory());
			
			
//			System.out.println(dao.select());			//all
//			System.out.println(dao.select(3));			//id
//			System.out.println(dao.select("ttt.jpg"));	//description
//			System.out.println(dao.delete(2));			//delete
			
			
//			HotelPhoto bean = new HotelPhoto();
//			//insert
//			bean.setHotelid(2);
//			bean.setDescription("C:/image/aaa.jpg");
//			HotelPhoto result = dao.insert(bean);
//			System.out.println(result);
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
