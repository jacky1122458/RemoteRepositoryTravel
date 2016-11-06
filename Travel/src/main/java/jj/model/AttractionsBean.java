package jj.model;

import java.io.Serializable;
import java.util.Set;

public class AttractionsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private  int  id;		
	private  String name;
	private  String attractions_type;		
	private  String openinghours;
	private  String introduction;
	private  int district;
	private  String attractions_address;
	private  java.lang.Double lat;
	private  java.lang.Double lng;
	private  String webaddress;
	
	private AreaBean area;
	private Set<Attractions_imgBean> attractionsimg;
	public Set<Attractions_imgBean> getAttractionsimg() {
		return attractionsimg;
	}
	public void setAttractionsimg(Set<Attractions_imgBean> attractionsimg) {
		this.attractionsimg = attractionsimg;
	}
	private Set<Attractions_evaluateBean> attractionsid;
	
	
	private Set<Travel_attractionsBean> attractionsid1;
	public Set<Travel_attractionsBean> getAttractionsid1() {
		return attractionsid1;
	}
	public void setAttractionsid1(Set<Travel_attractionsBean> attractionsid1) {
		this.attractionsid1 = attractionsid1;
	}
	public Set<Attractions_evaluateBean> getAttractionsid() {
		return attractionsid;
	}
	public void setAttractionsid(Set<Attractions_evaluateBean> attractionsid) {
		this.attractionsid = attractionsid;
	}
	public AreaBean getArea() {
		return area;
	}
	public void setArea(AreaBean area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "{"+id + ":" + name + ":"
				+ attractions_type + ":" + openinghours + ":"+ introduction + ":"
				+ district + ":"+ attractions_address + ":"+ lat + ":" + lng
				+ ":"+ webaddress +"}";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttractions_type() {
		return attractions_type;
	}
	public void setAttractions_type(String attractions_type) {
		this.attractions_type = attractions_type;
	}
	public String getOpeninghours() {
		return openinghours;
	}
	public void setOpeninghours(String openinghours) {
		this.openinghours = openinghours;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getDistrict() {
		return district;
	}
	public void setDistrict(int district) {
		this.district = district;
	}
	public String getAttractions_address() {
		return attractions_address;
	}
	public void setAttractions_address(String attractions_address) {
		this.attractions_address = attractions_address;
	}
	public java.lang.Double getLat() {
		return lat;
	}
	public void setLat(java.lang.Double lat) {
		this.lat = lat;
	}
	public java.lang.Double getLng() {
		return lng;
	}
	public void setLng(java.lang.Double lng) {
		this.lng = lng;
	}
	public String getWebaddress() {
		return webaddress;
	}
	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}
}
