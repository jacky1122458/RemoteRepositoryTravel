package cht.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.Query;

import cht.model.id.HotelCardId;
import cht.model.misc.HibernateUtil;
@Entity
public class HotelCard {
	@EmbeddedId
	private HotelCardId hotelcardId;
	public HotelCardId getHotelcardId() {
		return hotelcardId;
	}
	public void setHotelcardId(HotelCardId hotelcardId) {
		this.hotelcardId = hotelcardId;
	}
	
	
	@Override
	public String toString() {
		return "HotelCard [" + hotelcardId + "]";
	}
	
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			Query query = 
					HibernateUtil.getSessionFactory().getCurrentSession().createQuery("From HotelCard");
			System.out.println(query.list());
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
