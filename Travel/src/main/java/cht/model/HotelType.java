package cht.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import cht.model.misc.HibernateUtil;
@Entity
public class HotelType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer typeid;
	private	String 	typename;
	
	@Override
	public String toString() {
		return "HotelType [typeid=" + typeid + ", typename=" + typename + "]";
	}
	
	@OneToMany( cascade={CascadeType.REMOVE},
				mappedBy="hoteltype" )
	private Set<Hotel>hotels;
	public Set<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}
	

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			HotelType type = 
					(HotelType)HibernateUtil.getSessionFactory().getCurrentSession().get(HotelType.class,3);
			System.out.println(type);
			
//			System.out.println(type.getHotels());	//getHotel
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
