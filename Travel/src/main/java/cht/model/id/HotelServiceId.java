package cht.model.id;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.Query;

import cht.model.misc.HibernateUtil;

public class HotelServiceId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int hotelid;
	private int serviceid;
	
	@Override
	public String toString() {
		return "HotelServiceId [hotelid=" + hotelid + ", serviceid=" + serviceid + "]";
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	
	
	public boolean equals(Object obj){
		
		if(obj == this){ return true; }
		
		if(!(obj instanceof HotelServiceId)){ return false; }
		
		HotelServiceId hotelservice = (HotelServiceId) obj;
		return new EqualsBuilder()
				.append(this.hotelid, hotelservice.getHotelid())
				.append(this.serviceid, hotelservice.getServiceid())
				.isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder()
				.append(this.hotelid)
				.append(this.serviceid)
				.toHashCode();
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
