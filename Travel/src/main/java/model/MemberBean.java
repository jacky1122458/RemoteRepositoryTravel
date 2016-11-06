package model;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cht.model.Hotel;
import cht.model.HotelReview;
import cht.model.misc.HibernateUtil;
import jj.model.Attractions_evaluateBean;
import jj.model.Tour_evaluateBean;
import jj.model.Tour_orderBean;
@Entity
@Table(name="MEMBER")
public class MemberBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int 	memberid;
	private String	account;
	private byte[] 	password;
	private String 	firstname;
	private String	lastname;
	private String 	sex;
	private String 	email;
	private java.util.Date 	birth;
	private String 	cellphone;
	private String 	address;
	private java.util.Date	creatdate;
	private java.util.Date	modate;
	private boolean status;
	
	@Override
	public String toString() {
		return "MemberBean [memberid=" + memberid + ", account=" + account + ", password=" + Arrays.toString(password)
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", sex=" + sex + ", email=" + email
				+ ", birth=" + birth + ", cellphone=" + cellphone + ", address=" + address + ", creatdate=" + creatdate
				+ ", modate=" + modate + ", status=" + status + "]";
	}
	
	
//	@OneToOne
//	@JoinColumn( name = "MEMBERID", referencedColumnName="MEMBERID",
//				insertable=false, updatable=false)
//	private SignInBean signInBean;
//	public SignInBean getSignInBean() {
//		return signInBean;
//	}
//	public void setSignInBean(SignInBean signInBean) {
//		this.signInBean = signInBean;
//	}

	@OneToMany( cascade={CascadeType.REMOVE},
			mappedBy="member" )
	private Set<HotelReview> hotelreview;
	public Set<HotelReview> getHotelreview() {
		return hotelreview;
	}
	public void setHotelreview(Set<HotelReview> hotelreview) {
		this.hotelreview = hotelreview;
	}

	@ManyToMany
	@JoinTable( name="COLLECT",
				joinColumns={@JoinColumn(name="MEMBERID")},
				inverseJoinColumns={@JoinColumn(name="HOTELID")} )
	private Set<Hotel> hotels;
	public Set<Hotel> getHotels() {
		return hotels;
	}
	
	@OneToMany( cascade={CascadeType.REMOVE},
			mappedBy="member" )
	private Set<Hotel_orderBean> orderbeans;
	public Set<Hotel_orderBean> getOrderbeans() {
		return orderbeans;
	}
	public void setOrderbeans(Set<Hotel_orderBean> orderbeans) {
		this.orderbeans = orderbeans;
	}
	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	
	@OneToMany( cascade={CascadeType.REMOVE},
			mappedBy="memberid" )
	private Set<Attractions_evaluateBean> member;
	public Set<Attractions_evaluateBean> getMember() {
		return member;
	}
	public void setMember(Set<Attractions_evaluateBean> member) {
		this.member = member;
	}
	
	
	
	@OneToMany( cascade={CascadeType.REMOVE},
			mappedBy="memberBean" )
	private Set<Tour_orderBean>member1;
	public Set<Tour_orderBean> getMember1() {
		return member1;
	}
	public void setMember1(Set<Tour_orderBean> member1) {
		this.member1 = member1;
	}
	
	
	@OneToMany( cascade={CascadeType.REMOVE},
			mappedBy="memberid" )
	private Set<Tour_evaluateBean>member2;
	public Set<Tour_evaluateBean> getMember2() {
		return member2;
	}
	public void setMember2(Set<Tour_evaluateBean> member2) {
		this.member2 = member2;
	}

	
	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getBirth() {
		return birth;
	}

	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.util.Date getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(java.util.Date creatdate) {
		this.creatdate = creatdate;
	}

	public java.util.Date getModate() {
		return modate;
	}

	public void setModate(java.sql.Date modate) {
		this.modate = modate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
				
			MemberBean bean = 
					(MemberBean)HibernateUtil.getSessionFactory().getCurrentSession().get(MemberBean.class,3);
			System.out.println(bean);

//			System.out.println("Member'"+bean.getHotels());		//getHotels
//			System.out.println("Member'"+bean.getHotelreview());//getHotelreview
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
