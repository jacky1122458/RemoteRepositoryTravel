package cht.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import cht.model.misc.HibernateUtil;
@Entity
public class Service {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int 	serviceid;
	private String	servicename;
	
	@Override
	public String toString() {
		return "Service [serviceid=" + serviceid + ", servicename=" + servicename + "]";
	}
	
	@ManyToMany
	@JoinTable( name="HOTELSERVICE",
				joinColumns={@JoinColumn(name="SERVICEID")},
				inverseJoinColumns={@JoinColumn(name="HOTELID")} )
	private Set<Hotel> hotels;
	public Set<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}

	
	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			Service service = 
					(Service)HibernateUtil.getSessionFactory().getCurrentSession().get(Service.class,1);
			System.out.println(service);
			
//			System.out.println("service'"+service.getHotels());	//getHotels
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
