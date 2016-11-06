package jj.model.dao;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.AttractionsBean;
import jj.model.AttractionsDAO;


public class AttractionsDAOHibernate implements AttractionsDAO {
	private SessionFactory sessionFactory;
	public AttractionsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
		
			AttractionsDAOHibernate dao = (AttractionsDAOHibernate)context.getBean("attractionsDAO");
			AttractionsBean bean = new AttractionsBean();
	

//			List<AttractionsBean> a = dao.select_id(1);
//			System.out.println(a);
			
//			List<AttractionsBean> a = dao.select();
//			System.out.println(a);

//			List<AttractionsBean> a = dao.select_area("臺北市");
//			System.out.println(a);
			
//			bean.setName("桃園冥衣日");
//			bean.setAttractions_type("應朝地撫");
//			bean.setOpeninghours("壞人才能去");
//			bean.setIntroduction("總共有十八層，好逛又好玩");
//			bean.setDistrict(5);
//			bean.setAttractions_address("全球地下");
//			bean.setLat(4.4444);
//			bean.setLng(4.4444);
//			bean.setWebaddress("www:www");
//			dao.insert(bean);
			
//			dao.update("炒泥馬勒元", "小孩遊樂", "屁還剩地","屁還無極限6~68歲", 9, "鶯歌區北北路", 15.22, 136.22, "WWWBE/dfdsf", 11);
			
			dao.delete(11);
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	@Override
	public List<AttractionsBean> select_id(int id) {
		String a = "select new list(ab.id ,ab.name,ab.attractions_type,ab.openinghours,ab.introduction,ar.name,ab.attractions_address,ab.lat,ab.lng,ab.webaddress) from AttractionsBean as ab  join ab.area as ar where ar.id=:id";  
		 Query query = sessionFactory.getCurrentSession().createQuery(a);
		 query.setParameter("id", id);
		return (List<AttractionsBean>) query.list();
	}
	@Override
	//給選單 產生選項
	public List<AttractionsBean> select_id_name() {
		String a = "select new list(A.id,A.name) from AttractionsBean as A order by  A.id asc";  
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<AttractionsBean>) query.list();
	}

	@Override
	public List<AttractionsBean> select() {
		String b = "select new list(ab.id ,ab.name,ab.attractions_type,ab.openinghours,ab.introduction,ar.name,ab.attractions_address,ab.lat,ab.lng,ab.webaddress) from AttractionsBean as ab join ab.area as ar ";  
		Query query = this.sessionFactory.getCurrentSession().createQuery(b);
		return (List<AttractionsBean>)query.list();
	}

	@Override
	public List<AttractionsBean> select_area(int  id) {
		String c = "  select new list(ab.id ,ab.name,ab.attractions_type,ab.openinghours,ab.introduction,ar.name,ab.attractions_address,ab.lat,ab.lng,ab.webaddress) from AttractionsBean as ab  join ab.area as ar where ar.id=? ";  
		Query query = sessionFactory.getCurrentSession().createQuery(c);
		query.setParameter(0, id);
		return (List<AttractionsBean>) query.list();	}
	
	//依照地區選擇景點
		@Override
		public List<List> select_byDistract(int  id) {
			String c = "select new list(a.id,a.name,a.attractions_type,a.openinghours,a.introduction,(select c.name from AreaBean as c where c.id=:district)+a.attractions_address,a.lat,a.lng,a.webaddress) from AttractionsBean as a left join a.area as c where a.district=:district";  
			Query query = sessionFactory.getCurrentSession().createQuery(c);
			query.setParameter("district", id);
			return (List<List>) query.list();	}

		//all搜尋全部
				@Override
				public List<List> select_byAll() {
					String c = "select new list(a.id,a.name,a.attractions_type,a.openinghours,a.introduction,c.name+a.attractions_address,a.lat,a.lng,a.webaddress) from AttractionsBean as a  join a.area as c ";  
					Query query = sessionFactory.getCurrentSession().createQuery(c);
					return (List<List>) query.list();	}
	
	@Override
	public AttractionsBean insert(AttractionsBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
		int a = (int) session.save(bean);
		return bean;
	}

	@Override
	public AttractionsBean update(String name, String attractions_type, String openinghours, String introduction,
			int district, String attractions_address, Double lat, Double lng, String webaddress, int id) {
		AttractionsBean result = (AttractionsBean)
				this.sessionFactory.getCurrentSession().get(AttractionsBean.class, id);
		if(result!=null) {
			result.setName(name);
			result.setAttractions_type(attractions_type);
			result.setOpeninghours(openinghours);
			result.setIntroduction(introduction);
			result.setDistrict(district);
			result.setAttractions_address(attractions_address);
			result.setLat(lat);
			result.setLng(lng);
			result.setWebaddress(webaddress);
		}
		return result;
	}

	@Override
	public boolean delete(int id) {

		AttractionsBean bean = (AttractionsBean) this.sessionFactory.getCurrentSession().get(AttractionsBean.class, id);
		if(bean!=null) {
			this.sessionFactory.getCurrentSession().delete(bean);
			return true;
		}
		return false;

	}
	@Override
	public List<AttractionsBean> select_id_name(int tourid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
