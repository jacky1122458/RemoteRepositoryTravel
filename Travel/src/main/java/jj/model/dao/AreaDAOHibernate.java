package jj.model.dao;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.AreaBean;
import jj.model.AreaDAO;




public class AreaDAOHibernate implements AreaDAO {
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		
		getsession.getCurrentSession().beginTransaction();
		Session session = getsession.getCurrentSession();
		try {

			AreaDAOHibernate dao = (AreaDAOHibernate)context.getBean("areaDAO");
			AreaBean bean = new AreaBean();

			 List<AreaBean> s = dao.select(1);
			 System.out.println(s);
//			
			
//			 bean.setName("國冰釋");
//			 AreaBean ss = dao.insert(bean);
//			 System.out.println(ss);

//			dao.delete(25);
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}


	
	private SessionFactory sessionFactory;
	public AreaDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	

	public List<AreaBean> select(int id) {
		String a="select new list (A.name) from AreaBean as A WHERE id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("id", id);
		return (List<AreaBean>) query.list();	
}

	public List<AreaBean> select() {
		Query query =this.sessionFactory.getCurrentSession().createQuery("from AreaBean");
		return (List<AreaBean>)query.list();	
	}

	
	public AreaBean insert(AreaBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	
	

	public boolean delete(int id) {
		AreaBean bean = (AreaBean) this.sessionFactory.getCurrentSession().get(AreaBean.class, id);
		if(bean!=null) {
			this.sessionFactory.getCurrentSession().delete(bean);
			return true;
		}
		return false;
	}
	

}
