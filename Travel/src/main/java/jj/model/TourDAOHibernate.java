package jj.model;





import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.TourBean;
import jj.model.TourDAO;


public class TourDAOHibernate implements TourDAO {
	private SessionFactory sessionFactory;
	public TourDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory getsession = (SessionFactory)context.getBean("sessionFactory");
		
		try {
			getsession.getCurrentSession().beginTransaction();
			Session session = getsession.getCurrentSession();
			
		
			TourDAOHibernate dao = (TourDAOHibernate)context.getBean("tourDAO");
			TourBean bean = new TourBean();
			
//			List<TourBean> s = dao.select_all();
//			System.out.println(s);
			
//			List<TourBean> e = dao.select_all_web();
//			System.out.println(e);

//			boolean s = dao.update_status(false, 1);
//			System.out.println(s);
			java.util.Date day1 = null;
			try {
				day1 = DateFormat.getDateInstance().parse("2016/10/1");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long time1 = day1.getTime();
			Date date = new java.sql.Date(time1);
			
//			List<TourBean> s = dao.select_tourid();
//			System.out.println(s);
			
//			bean.setTour_name("測試");
//			bean.setTour_restrict(10);
//			bean.setTour_price(1500);
//			bean.setMeeting_time("2點");
//			bean.setCost_gloze("特別服務60");
//			bean.setAge_limit(40);
//			bean.setMeals("自行取用");
//			bean.setRemark("無");
//			bean.setMeeting_place("台北後站");
//			bean.setLat(1.569);
//			bean.setLng(3.11);
//			bean.setTour_status(true);
//			bean.setExplanation("如有颱風取消");
//			bean.setDeparture_date(date);
//			dao.insert(bean);
			
//			dao.update("測試3", 10, 1500, "2點", "特別服務60", 40, "自行"," 無", "台北後站", 1.569, 3.11, true, "如有颱風取消", date, 13);

//			dao.delete(10);
			
			session.getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	
	@Override
	public List<TourBean> select_all() {
		String a ="select new list (tour_id,tour_name,tour_restrict,tour_price,meeting_time,cost_gloze ,age_limit,meals,remark,meeting_place,explanation,departure_date,tour_status) from TourBean";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<TourBean>)query.list();		
	}
	@Override
	public List<List> select_all_2() {
		String a ="select new list( tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status,AVG(te.rating)) From TourBean tb left join tb.tourid1 te group by tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		List list=query.list();
		
//		for(Iterator iterator = list.iterator();iterator.hasNext();){
//			List objects = (List) iterator.next();
//			//int tour_id = (int) objects[0];
//			System.out.println("list : "+objects);
//			System.out.println("================");
//		}
//		
		return (List<List>)query.list();		
	}
	
	@Override
	public List<List> select_all_tai() {
		String a ="select new list( tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status,AVG(te.rating)) From TourBean tb left join tb.tourid1 te group by tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status having tb.meeting_place='臺北車站'";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		List list=query.list();
		
//		for(Iterator iterator = list.iterator();iterator.hasNext();){
//			List objects = (List) iterator.next();
//			//int tour_id = (int) objects[0];
//			System.out.println("list : "+objects);
//			System.out.println("================");
//		}
//		
		return (List<List>)query.list();		
	}
	@Override
	public List<List> select_all_conatt() {
		String a ="select new list( tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status,AVG(te.rating)) From TourBean tb left join tb.tourid1 te group by tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status having tb.meeting_place='臺中車站'";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		List list=query.list();
		
//		for(Iterator iterator = list.iterator();iterator.hasNext();){
//			List objects = (List) iterator.next();
//			//int tour_id = (int) objects[0];
//			System.out.println("list : "+objects);
//			System.out.println("================");
//		}
//		
		return (List<List>)query.list();		
	}
	
	@Override
	public List<List> select_all_yingge() {
		String a ="select new list( tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status,AVG(te.rating)) From TourBean tb left join tb.tourid1 te group by tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status having tb.meeting_place='鶯歌火車站'";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		List list=query.list();
		
//		for(Iterator iterator = list.iterator();iterator.hasNext();){
//			List objects = (List) iterator.next();
//			//int tour_id = (int) objects[0];
//			System.out.println("list : "+objects);
//			System.out.println("================");
//		}
//		
		return (List<List>)query.list();		
	}
	
	
	@Override
	public List<List> select_all_tn() {
		String a ="select new list( tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status,AVG(te.rating)) From TourBean tb left join tb.tourid1 te group by tb.tour_id,tb.tour_name,tb.tour_restrict,tb.tour_price,tb.meeting_time,tb.cost_gloze,tb.age_limit,tb.meals,tb.remark,tb.meeting_place,tb.explanation,tb.departure_date,tb.tour_status having tb.meeting_place='台南車站'";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		List list=query.list();
		
//		for(Iterator iterator = list.iterator();iterator.hasNext();){
//			List objects = (List) iterator.next();
//			//int tour_id = (int) objects[0];
//			System.out.println("list : "+objects);
//			System.out.println("================");
//		}
//		
		return (List<List>)query.list();		
	}
	
	
	
	
	//單一搜尋一筆 給修改用
	@Override
	public List select_all_by_id(int tour_id) {
		String a ="select new list (A.tour_id,A.tour_name,A.tour_restrict,A.tour_price,A.meeting_time,A.cost_gloze,A.age_limit,A.meals,A.remark,A.meeting_place,A.lat,A.lng,A.tour_status,A.explanation,A.departure_date) from TourBean as A WHERE A.tour_id =:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return (List)query.list();		
	}
	
	@Override
	public List<TourBean> select_all_web() {
		String a="select new list ( tour_name,tour_restrict,tour_price,meeting_time,cost_gloze ,age_limit,meals,remark,meeting_place,explanation,departure_date,tour_status) from TourBean";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<TourBean>)query.list();		
	}
 //搜尋id給評價用
	@Override
	public List<List> select_tourid() {
		String a="select new list(A.tour_id) from TourBean  as A";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return (List<List>)query.list();		
	}
	
	//ID算旅程人數給加減用 總共最大出團數
	public  List<List> select_number_byid(int tour_id) {
		String a="select A.tour_restrict from TourBean  as A where A.tour_id=:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id", tour_id);
		return (List<List>)query.list();
	}
	
	
	//ID算旅程人數給加減用 總共最大出團數
		public  List<List> select_number_byid2(int tour_id) {
			String a="select new list(A.tour_restrict) from TourBean  as A where A.tour_id=:tour_id";
			Query query = sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("tour_id", tour_id);
			System.out.println((List<List>)query.list());
			return (List<List>)query.list();
		}
	
		
		
		
		//ID算旅程人數為0 tourid 用string帶入
		public  List<List> select_nubmer_byid_zero(int tour_id) {
			String a="select new list(A.tour_restrict,A.tour_id) from TourBean  as A where A.tour_id=:tour_id";
			Query query = sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("tour_id", tour_id);
			return (List<List>)query.list();
		}
		
	@Override
	public boolean update_status(boolean tour_status, int tour_id) {
		String a="update from TourBean set tour_status=:tour_status where tour_id=:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_status", tour_status);
		query.setParameter("tour_id", tour_id);
		int i = query.executeUpdate();
		if(i==1){
		return true;
			}
		return false;
		}
	
	
	@Override
	public TourBean insert(TourBean bean) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bean);		
		return bean;
	}
	@Override
	public boolean update(String tour_name, int tour_restrict, int tour_price, String meeting_time,
			String cost_gloze, int age_limit, String meals, String remark, String meeting_place, Double lat, Double lng,
			boolean tour_status, String explanation, java.util.Date departure_date, int tour_id) {
		String a="update from TourBean set tour_name=:tour_name ,tour_restrict=:tour_restrict,tour_price=:tour_price ,meeting_time=:meeting_time ,cost_gloze=:cost_gloze,age_limit=:age_limit,meals=:meals ,remark=:remark,meeting_place=:meeting_place,lat=:lat,lng=:lng,tour_status=:tour_status, explanation=:explanation,departure_date=:departure_date where tour_id=:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_name", tour_name);
		query.setParameter("tour_restrict", tour_restrict);
		query.setParameter("tour_price", tour_price);
		query.setParameter("meeting_time", meeting_time);
		query.setParameter("cost_gloze", cost_gloze);
		query.setParameter("age_limit", age_limit);
		query.setParameter("meals", meals);
		query.setParameter("remark", remark);
		query.setParameter("meeting_place", meeting_place);
		query.setParameter("lat", lat);
		query.setParameter("lng", lng);
		query.setParameter("tour_status", tour_status);
		query.setParameter("explanation", explanation);
		query.setParameter("departure_date", departure_date);
		query.setParameter("tour_id", tour_id);
		int i = query.executeUpdate();
		if(i==1){
		return true;
			}
		return false;
		}
	@Override
	public boolean delete(int id) {
		TourBean bean = (TourBean)this.sessionFactory.getCurrentSession().get(TourBean.class, id);
		if(bean!=null) {
			this.sessionFactory.getCurrentSession().delete(bean);
			return true;
		}
		return false;		
}
	
	@Override
	public List<List> select_byid_toshow(int tour_id) {
		String a="select new list (A.tour_id,A.tour_name,A.tour_price,A.tour_restrict,A.lat,A.lng,A.departure_date,A.tour_status) from TourBean as A WHERE A.tour_id =:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id",tour_id);
		return (List<List>)query.list();
	}
	
	//搜尋日期
	@Override
	public  List<List> select_byid_date(int tour_id) {
		String a="select new list(A.departure_date) from TourBean as A WHERE A.tour_id =:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_id",tour_id);
		return (List<List>)query.list();
	}
	//搜尋max  id
	@Override
	public  List select_max_id() {
		String a="select   max(A.tour_id) from TourBean as A";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		return query.list();
	}
	
	//更改訂單人數 依tourid
	public boolean update_number(int tour_restrict,int tour_id) {
		String a="update from TourBean set tour_restrict=:tour_restrict where tour_id=:tour_id";
		Query query = sessionFactory.getCurrentSession().createQuery(a);
		query.setParameter("tour_restrict", tour_restrict);
		query.setParameter("tour_id", tour_id);
		query.executeUpdate();
		return false ;
		}
	
	
		//更改狀態 依tourid 因為被訂光 人數0更新false
		public boolean update_status_bytourd_false(int tour_id) {
			String a="update from TourBean set tour_status=false where tour_id=:tour_id";
			Query query = sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("tour_id", tour_id);
			query.executeUpdate();
			return false ;
			}
	
		//更改狀態 依tourid 因為被訂光 人數1更新true
		public boolean update_status_bytourd_true(int tour_id) {
			String a="update from TourBean set tour_status=true where tour_id=:tour_id";
			Query query = sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("tour_id", tour_id);
			query.executeUpdate();
			return false ;
			}
		
		
		
	//更改訂單人數 依tourid,跟peloe 加回來
		public boolean update_number_people_back(int tour_restrict,int tour_id,boolean tour_status) {
			String a="update from TourBean set tour_restrict=:tour_restrict ,tour_status=:tour_status  where tour_id=:tour_id";
			Query query = sessionFactory.getCurrentSession().createQuery(a);
			query.setParameter("tour_restrict", tour_restrict);
			query.setParameter("tour_id", tour_id);
			query.setParameter("tour_status", tour_status);
			query.executeUpdate();
			return false ;
			}
}