package model;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.dao.Year_roomsDAOHibernate;

public class Year_roomsService {
	private Year_roomsDAOHibernate year_roomsDAO;
	public Year_roomsService(Year_roomsDAOHibernate year_roomsDAO) {
		this.year_roomsDAO = year_roomsDAO;
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Hotel_orderService service1 = (Hotel_orderService)context.getBean("hotel_orderService");
			Hotel_orderBean bean1 = new Hotel_orderBean();
			bean1.setMemberid(1);
			bean1.setPrice_total(3000);
			int a =service1.insert(bean1);
			int[] roomid = {1,2};
			Order_detailService service2 = (Order_detailService)context.getBean("order_detailsService");
			Order_detailsBean bean2 = new Order_detailsBean();
			bean2.setOrderid(a);
			bean2.setRoomid(1);
			service2.insert(bean2);
			Year_roomsService service = (Year_roomsService)context.getBean("year_roomsService");
			

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	public void update_subtraction(int number,java.util.Date checkinday,String checkoutday,int roomid) {
		 year_roomsDAO.update_subtraction(number, checkinday,checkoutday,roomid);
	}
	public void update_add(Order_detailsBean bean,java.util.Date checkinday,String checkoutday ){
		year_roomsDAO.update_add(bean.getOrderid(), bean.getRoomid(), checkinday, checkoutday);
	}
}
