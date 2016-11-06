package cht.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cht.model.misc.HibernateUtil;

@Entity
public class HotelPhoto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hotelphotoid;
	private int hotelid;
	private String description;
	private byte[] photo;
	
	
	@Override
	public String toString() {
		return "HotelPhoto [hotelphotoid=" + hotelphotoid + ", hotelid=" + hotelid + ", description=" + description
				+ "]";
	}


	//hotel
	@ManyToOne
	@JoinColumn(name="HOTELID", referencedColumnName="HOTELID", 
				insertable=false, updatable=false)
	private Hotel hotel;
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	public int getHotelphotoid() {
		return hotelphotoid;
	}
	public void setHotelphotoid(int hotelphotoid) {
		this.hotelphotoid = hotelphotoid;
	}
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			HotelPhoto bean = 
					HibernateUtil.getSessionFactory().getCurrentSession().get(HotelPhoto.class, 1);
			System.out.println(bean);
			
			Hotel result = bean.getHotel(); //getHotel
			System.out.println(result);
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
