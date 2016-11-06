package model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.RoomPhotoBean;

public class RoomPhotoDAOHibernate {
	private SessionFactory sessionFactory;
	public RoomPhotoDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		try {
			RoomPhotoDAOHibernate dao =(RoomPhotoDAOHibernate)context.getBean("roomPhotoDAO");
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
			try {
				dao.insert(2,"C:/Users/Student/Desktop/roomphoto/aaaa.jpg",
							 "C:/Users/Student/Desktop/roomphoto/bbb.jpg",
							 "C:/Users/Student/Desktop/roomphoto/ccc.jpg"
							 );
//				boolean a = dao.delete(23);
//				System.out.println(a);
//				dao.select(50);
				
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}

	
	
	public boolean delete(int roomphotoid){
		Session session = this.sessionFactory.getCurrentSession();
		RoomPhotoBean bean=session.get(RoomPhotoBean.class,roomphotoid );
		if(bean!=null){
			session.delete(bean);
			return true;
		}
		return false;
	}
	public RoomPhotoBean select(int roomid){
		String getPhoto = "select roomid,photo from RoomPhotoBean where roomid=:roomid ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(getPhoto);
		query.setParameter("roomid",roomid);
		return (RoomPhotoBean)query.list();		
	}
//	public void select(int roomphotoid) {
//		Session session = sessionFactory.openSession();	
//		FileOutputStream fos = null;
//		RoomPhotoBean bean = null;
//		BufferedOutputStream bos = null;
//		try{
//			bean =session.get(RoomPhotoBean.class,roomphotoid);
//			if (bean != null) {
//			    byte[] img1 = bean.getPhoto();
//			    System.out.println(img1.length);
//			    if (img1 != null) {
//			        try {
//			        	fos = new FileOutputStream("C:/Users/Student/Desktop/roomphoto/copy/4.jpg");
//			        	bos = new BufferedOutputStream(fos);
//			        	bos.write(img1);
//			        	bos.flush();
//					   
//			            bos.close();
//			            fos.close();
//			        } catch (Exception e) {
//			           
//			        }
//			    }
//			}
//		}catch(Exception e){
//			
//		}finally{
//			session.close();
//		}
//		
//	}
	public void insert(int roomid,String...filePath) throws Exception  {
		for(int i=0;i<filePath.length;i++){
			Session session = this.sessionFactory.getCurrentSession();
			FileInputStream fileInputStream = null;
			BufferedInputStream bis = null;
			File file = new File(filePath[i]);
			byte[] imageData = new byte[(int) file.length()];
			RoomPhotoBean bean = new RoomPhotoBean();
			try{
				fileInputStream = new FileInputStream(file);
				bis = new BufferedInputStream(fileInputStream);			    
					while(bis.available()>0) {
						bis.read(imageData);
				} 
				bean.setRoomid(roomid);
				bean.setPhoto(imageData);
				session.save(bean);
				//session.getTransaction().commit();
			}catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				fileInputStream.close();
				bis.close();
			}
	
		}		
	}
}
