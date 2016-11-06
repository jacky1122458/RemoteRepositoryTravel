package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.dao.Hotel_orderBeanDAOHibernate;

public class Hotel_orderService {
	private Hotel_orderBeanDAOHibernate hotel_orderBeanDAO;
	public Hotel_orderService(Hotel_orderBeanDAOHibernate hotel_orderBeanDAO) {
		this.hotel_orderBeanDAO = hotel_orderBeanDAO;
	}
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
	SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	try {
		sessionFactory.getCurrentSession().beginTransaction();
		
		Hotel_orderService service = (Hotel_orderService) context.getBean("hotel_orderService");
		Hotel_orderBean bean = new Hotel_orderBean();
//		bean.setOrderid(3);
//		List<Hotel_orderBean> beans = service.select(null);
//		System.out.println("beans="+beans);
		
		bean.setMemberid(1);
		bean.setPrice_total(4000);
		int a = service.insert(bean);
		System.out.println(a);
		

		sessionFactory.getCurrentSession().getTransaction().commit();
	} finally {
		((ConfigurableApplicationContext) context).close();
	}
}
	
	public List<List> select_ForMemberByMemberid(Hotel_orderBean bean){
		List<List> result = null;
		if(bean!=null && bean.getMemberid()!=0){
			List<List> temp=null;
			try {
				temp = hotel_orderBeanDAO.select_byMemberid(bean.getMemberid());
			} catch (Exception e) {
				// TODO: handle exception
			}
			List<List> result1 = new ArrayList<List>();
			for(int i =0;i<temp.size();i++){
				if(temp!=null && temp.get(i).get(7).equals(true)){
					result1.add(temp.get(i));
				}
			}
			result = new ArrayList<List>();
			result.add(result1);
			System.out.println("service="+result);
		}
		return result;
	}
	public List<Hotel_orderBean> select_ForMember(Hotel_orderBean bean){
		List<Hotel_orderBean> result = null;
		if(bean!=null && bean.getOrderid()!=0 && bean.getMemberid()!=0) {
				List<Hotel_orderBean> temp = hotel_orderBeanDAO.select_byOrderidAndMemberid(bean.getOrderid(), bean.getMemberid());
				if(temp!=null) {
				result = new ArrayList<Hotel_orderBean>();
				result.addAll(temp);
				}
		}
		return result;	
	}
	public List<Hotel_orderBean> select_ForUs(Hotel_orderBean bean) {
		List<Hotel_orderBean> result = null;
		if(bean!=null && bean.getOrderid()!=0) {
			Hotel_orderBean temp = hotel_orderBeanDAO.select_byOrderid(bean.getOrderid());
			if(temp!=null) {
				result = new ArrayList<Hotel_orderBean>();
				result.add(temp);
			}
		} else {
			result = hotel_orderBeanDAO.select_ALL(); 
		}
		return result;
	}
	public int insert(Hotel_orderBean bean) {
		int result = 0;
		if(bean!=null) {
			result = hotel_orderBeanDAO.insert(bean);
		}
		return result;
	}
//	public Hotel_orderBean update(Hotel_orderBean bean,java.util.Date checkin,java.util.Date checkout) {
//		Hotel_orderBean result = null;
//		if(bean!=null) {
//			result = hotel_orderBeanDAO.update(bean.getOrderid(),bean.getPrice_total(),checkin,checkout);
//		}
//		return result;
//	}
}
