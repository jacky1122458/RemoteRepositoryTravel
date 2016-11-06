package jj.model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.AttractionsBean;
import jj.model.Attractions_imgBean;
import jj.model.Attractions_imgDAO;


public  class Attractions_imgDAOHibernate implements Attractions_imgDAO {
	private SessionFactory sessionFactory;
	public Attractions_imgDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		try {
			Attractions_imgDAOHibernate dao =(Attractions_imgDAOHibernate)context.getBean("attractions_imgDAO");
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
			try {
//				dao.insert(1, "C:/Users/Student/Desktop/a.jpg");
				List<Attractions_imgBean> s = dao.select_by_attractions_id(1);
				System.out.println(s);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}

	
	
	public boolean delete(int photoid){
		Session session = this.sessionFactory.getCurrentSession();
		Attractions_imgBean bean=session.get(Attractions_imgBean.class,photoid );
		if(bean!=null){
			session.delete(bean);
			return true;
		}
		return false;
	}
	public void select(int photoid) {
		Session session = sessionFactory.openSession();	
		FileOutputStream fos = null;
		Attractions_imgBean bean = null;
		BufferedOutputStream bos = null;
		try{
			bean =session.get(Attractions_imgBean.class,photoid);
			if (bean != null) {
			    byte[] img1 = bean.getAttractions_img();
			    System.out.println(img1.length);
			    if (img1 != null) {
			        try {
			        	fos = new FileOutputStream("C:/Users/Student/Desktop/cc.jpg");
			        	bos = new BufferedOutputStream(fos);
			        	bos.write(img1);
			        	bos.flush();
					   
			            bos.close();
			            fos.close();
			        } catch (Exception e) {
			           
			        }
			    }
			}
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		
	}
	public void insert(int attractions_id,String...filePath) throws Exception  {
		for(int i=0;i<filePath.length;i++){
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
			SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			FileInputStream fileInputStream = null;
			BufferedInputStream bis = null;
			File file = new File(filePath[i]);
			byte[] imageData = new byte[(int) file.length()];
			Attractions_imgBean bean = new Attractions_imgBean();
			try{
				fileInputStream = new FileInputStream(file);
				bis = new BufferedInputStream(fileInputStream);
			    fileInputStream.read(imageData);
					while(bis.available()>0) {
						bis.read(imageData);
				} 
				
				bean.setAttractions_id(attractions_id);
				bean.setAttractions_img(imageData);
				session.save(bean);
				
				session.getTransaction().commit();
			}catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				fileInputStream.close();
				bis.close();
				((ConfigurableApplicationContext)context).close();
			}
	
		}		
	}

	@Override
	public List<Attractions_imgBean> select_by_attractions_id(int attractions_id) {
		String a="select new list (A.attractions_img)from Attractions_imgBean as A WHERE A.attractions_id =:attractions_id";
		Query query = this.sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("attractions_id",attractions_id);
		return (List<Attractions_imgBean>)query.list();
	}
	//一id搜尋圖片
	public Attractions_imgBean select_photo(int attractions_id){
		String a="select a from Attractions_imgBean as a where a.attractions_id=:attractions_id";
		Query query = this.sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("attractions_id",attractions_id);
		System.out.println("queryquery"+query);
		return (Attractions_imgBean) query.uniqueResult();
	}
}