package cht.model;

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

import org.hibernate.Session;

import cht.model.misc.HibernateUtil;
import model.MemberBean;
import model.RoomBean;
@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	int 	hotelid;
	private String	hotelname;
	private int		typeid;
	private String 	phone;
	private Integer class_level;
	private String 	check_in;
	private String 	check_out;
	private Integer price_bed;
	private Integer years;
	private String 	address;
	private String 	language;
	private String	description;
	private String 	note;
	private Double 	lat;
	private Double 	lng;
	private Double 	tol_avg;
	private Integer total_comment;
	private boolean status;

	
	
	@Override
	public String toString() {
		return "Hotel [hotelid=" + hotelid + ", hotelname=" + hotelname + ", typeid=" + typeid + ", phone=" + phone
				+ ", class_level=" + class_level + ", check_in=" + check_in + ", check_out=" + check_out
				+ ", price_bed=" + price_bed + ", years=" + years + ", address=" + address + ", language=" + language
				+ ", description=" + description + ", note=" + note + ", lat=" + lat + ", lng=" + lng + ", tol_avg="
				+ tol_avg + ", total_comment=" + total_comment + ", status=" + status + "]";
	}


	@OneToOne
	@JoinColumn( name = "TYPEID",
				referencedColumnName="TYPEID",
				insertable=false, updatable=false)
	private HotelType hoteltype;
	public HotelType getHoteltype() {
		return hoteltype;
	}
	public void setHoteltype(HotelType hoteltype) {
		this.hoteltype = hoteltype;
	}
	
	
	@OneToMany( cascade={CascadeType.REMOVE},
			mappedBy="hotel" )
	private Set<HotelPhoto> photos;
	public Set<HotelPhoto> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<HotelPhoto> photos) {
		this.photos = photos;
	}
	
	@OneToMany( cascade={CascadeType.REMOVE},
				mappedBy="hb" )
	private Set<RoomBean> rooms;
	public Set<RoomBean> getRooms() {
		return rooms;
	}
	public void setRooms(Set<RoomBean> rooms) {
		this.rooms = rooms;
	}
	
	@OneToMany( cascade={CascadeType.REMOVE},
			mappedBy="hotel" )
	private Set<HotelReview> reviews;
	public Set<HotelReview> getReviews() {
		return reviews;
	}
	public void setReviews(Set<HotelReview> reviews) {
		this.reviews = reviews;
	}


	@ManyToMany
	@JoinTable( name="COLLECT",
				joinColumns={@JoinColumn(name="HOTELID")},
				inverseJoinColumns={@JoinColumn(name="MEMBERID")} )
	private Set<MemberBean> members;
	public Set<MemberBean> getMembers() {
		return members;
	}
	public void setMembers(Set<MemberBean> members) {
		this.members = members;
	}
	
	@ManyToMany
	@JoinTable( name="HOTELSERVICE",
	joinColumns={@JoinColumn(name="HOTELID")},
	inverseJoinColumns={@JoinColumn(name="SERVICEID")} )
	private Set<Service> services;
	public Set<Service> getServices() {
		return services;
	}
	public void setServices(Set<Service> services) {
		this.services = services;
	}
	
	@ManyToMany
	@JoinTable( name="HOTELCARD",
				joinColumns={@JoinColumn(name="HOTELID")},
				inverseJoinColumns={@JoinColumn(name="CARDTYPE")} )
	private Set<Card> cards;
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
	
	
	
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public Integer getClass_level() {
		return class_level;
	}
	public void setClass_level(Integer class_level) {
		this.class_level = class_level;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getPrice_bed() {
		return price_bed;
	}
	public void setPrice_bed(Integer price_bed) {
		this.price_bed = price_bed;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Double getTol_avg() {
		return tol_avg;
	}
	public void setTol_avg(Double tol_avg) {
		this.tol_avg = tol_avg;
	}
	public Integer getTotal_comment() {
		return total_comment;
	}
	public void setTotal_comment(Integer total_comment) {
		this.total_comment = total_comment;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static void main(String[] args) throws Exception {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			Hotel select = session.get(Hotel.class, 1);
			System.out.println(select);
			
//			System.out.println("Hotle'" +select.getHoteltype());//type
//			System.out.println("Hotle'" +select.getPhotos());	//photos
//			System.out.println("Hotel'" +select.getRooms());	//rooms
//			System.out.println("Hotle'" +select.getMembers());	//member
//			System.out.println("Hotle'" +select.getCards());	//Cards
//			System.out.println("Hotel'" +select.getServices());	//service
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
