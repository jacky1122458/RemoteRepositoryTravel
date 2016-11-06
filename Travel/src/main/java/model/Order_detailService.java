package model;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.dao.Order_detailsDAOHibernate;

public class Order_detailService {
	private Order_detailsDAOHibernate order_detailsDAO;
	public Order_detailService(Order_detailsDAOHibernate order_detailsDAO) {
		this.order_detailsDAO = order_detailsDAO;
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
//			Hotel_orderService service = (Hotel_orderService) context.getBean("hotel_orderService");
//			Hotel_orderBean bean = new Hotel_orderBean();			
//			bean.setMemberid(1);
//			bean.setPrice_total(4000);
//			int a = service.insert(bean);
//			System.out.println(a);
			Order_detailService service1 = (Order_detailService) context.getBean("order_detailsService");
//			Order_detailsBean bean3 = new Order_detailsBean();
//			Order_detailsBean bean4 = new Order_detailsBean();
//			Order_detailsBean bean5 = new Order_detailsBean();
//			Order_detailsBean [] bean2 = {bean3,bean4,bean5};
//			int[] dd ={1,2};
//			for(int i=0;i<dd.length;i++){
//				bean2[i].setOrderid(a);
//				bean2[i].setRoomid(dd[i]);
//				bean2[i].setName("bb");
//				java.sql.Date date1 = null;
//				java.sql.Date date2 = null;
//				java.sql.Date date3 = null;
//				try {
//					java.util.Date day1 = DateFormat.getDateInstance().parse("2016/10/1");
//					java.util.Date day2 = DateFormat.getDateInstance().parse("2016/10/3");
//					java.util.Date day3 = DateFormat.getDateInstance().parse("2016/10/5");
//					long time1 = day1.getTime();
//					long time2 = day2.getTime();
//					long time3 = day3.getTime();
//					date1 = new java.sql.Date(time1);
//					date2 = new java.sql.Date(time2);
//					date3 = new java.sql.Date(time3);
//				} catch (Exception e) {
//					
//				}
//			
//				bean2[i].setOrderdate(date1); 
//				bean2[i].setCheckin(date2);
//				bean2[i].setCheckout(date3);
//				bean2[i].setPrice(1000);
//				bean2[i].setPeoplenum(2);
//				bean2[i].setNumber(1);	 
//				bean2[i].setCellphone("");
//				bean2[i].setSpec("");
//				bean2[i].setStatus(true);
//				service1.insert(bean2[i]);
//			}
			Order_detailsBean bean = new Order_detailsBean();
//			bean.setOrderid(3);
//			List<Order_detailsBean> output = service1.select(bean);
//			System.out.println(output);
			java.sql.Date date2 = null;
			java.sql.Date date3 = null;
			try {
				java.util.Date day2 = DateFormat.getDateInstance().parse("2016/10/3");
				java.util.Date day3 = DateFormat.getDateInstance().parse("2016/10/5");
				long time2 = day2.getTime();
				long time3 = day3.getTime();
				date2 = new java.sql.Date(time2);
				date3 = new java.sql.Date(time3);
			} catch (Exception e) {
				
			}
			bean.setOrderid(13);
			bean.setRoomid(1);
			bean.setName("cc");
			bean.setCellphone("");

			//service1.update(bean);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	public Order_detailsBean insert(Order_detailsBean bean) {
		Order_detailsBean result = null;
		if(bean!=null) {
			if(bean.getNumber()!=0){
				result = order_detailsDAO.insert(bean);
			}
		}
		return result;
	}
	public List<List> select(Order_detailsBean bean) {
		List<List> result = null;
		if(bean!=null && bean.getOrderid()!=0) {
				List<List> temp = order_detailsDAO.select(bean.getOrderid());
				if(temp!=null && temp.get(0).get(9).equals(true)) {
					result = new ArrayList<List>();
					result.addAll(temp);
				}			
		}
		return result;
	}
	public List<Order_detailsBean> select(){
		List<Order_detailsBean> result = order_detailsDAO.select();
		return result;
	}
//	public int update(Order_detailsBean bean) {
//		int update_success = 0;
//		if(bean!=null) {
//			update_success = order_detailsDAO.update(bean.getOrderid(), bean.getName(), bean.getCellphone(),bean.getPrice(),bean.getRoomid());
//		}
//		return update_success;
//	}
	public int cancel_order(Order_detailsBean bean){
		int cancel_numbers = 0;
		if(bean!=null){
			if(bean.getOrderid()!=0 && bean.getStatus()==true){
				cancel_numbers = order_detailsDAO.cancel_order(bean.getOrderid(),false);
			}
				cancel_numbers = 0;
		}
		return cancel_numbers;
	}
}
