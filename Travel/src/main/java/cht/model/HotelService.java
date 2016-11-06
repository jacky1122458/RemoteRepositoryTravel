package cht.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.Query;

import cht.model.id.HotelServiceId;
import cht.model.misc.HibernateUtil;
@Entity
public class HotelService implements Serializable{
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private HotelServiceId hotelServiceId;
	public HotelServiceId getHotelServiceId() {
		return hotelServiceId;
	}
	public void setHotelServiceId(HotelServiceId hotelServiceId) {
		this.hotelServiceId = hotelServiceId;
	}

	@Override
	public String toString() {
		return "HotelService [" + hotelServiceId + "]";
	}
	
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			Query query = 
					HibernateUtil.getSessionFactory().getCurrentSession().createQuery("From HotelService");
			System.out.println(query.list());
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
