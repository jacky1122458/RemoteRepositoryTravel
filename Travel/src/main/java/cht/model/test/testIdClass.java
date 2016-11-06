package cht.model.test;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


import cht.model.misc.HibernateUtil;

@Entity
//@IdClass(HotelReviewId.class) 
@Table(name="HOTELREVIEW")
public class testIdClass implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id 
	private int memberid;
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	@Id 
	private int hotelid;
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	
	@Override
	public String toString() {
		return "Hotelreview [memberid=" + memberid + ", hotelid=" + hotelid + ", date=" + date + ", cleanliness="
				+ cleanliness + ", comfort=" + comfort + ", location=" + location + ", facilities=" + facilities
				+ ", staff=" + staff + ", cp=" + cp + ", total=" + total + ", advantage=" + advantage + ", defect="
				+ defect + ", display=" + display + "]";
	}

	private java.util.Date date;
	private short cleanliness;
	private short comfort;
	private short location; 
	private short facilities; 
	private short staff;
	private short cp;
	private short total;
	private String advantage;
	private String defect;
	private boolean display;
	

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public short getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(short cleanliness) {
		this.cleanliness = cleanliness;
	}

	public short getComfort() {
		return comfort;
	}

	public void setComfort(short comfort) {
		this.comfort = comfort;
	}

	public short getLocation() {
		return location;
	}

	public void setLocation(short location) {
		this.location = location;
	}

	public short getFacilities() {
		return facilities;
	}

	public void setFacilities(short facilities) {
		this.facilities = facilities;
	}

	public short getStaff() {
		return staff;
	}

	public void setStaff(short staff) {
		this.staff = staff;
	}

	public short getCp() {
		return cp;
	}

	public void setCp(short cp) {
		this.cp = cp;
	}

	public short getTotal() {
		return total;
	}

	public void setTotal(short total) {
		this.total = total;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getDefect() {
		return defect;
	}

	public void setDefect(String defect) {
		this.defect = defect;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	

	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
//			HotelReviewId id = new HotelReviewId();
//			id.setHotelid(2);
//			id.setMemberid(1);
//			testIdClass result =  HibernateUtil.getSessionFactory().getCurrentSession().get(testIdClass.class, id);
//			System.out.println(result);
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}

