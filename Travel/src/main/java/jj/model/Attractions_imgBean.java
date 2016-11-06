package jj.model;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Attractions_img")
public class Attractions_imgBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int photoid		;		
	private int attractions_id	;	
	private byte[] attractions_img		;
	
	
	@ManyToOne
	@JoinColumn(name="attractions_id", referencedColumnName="ID", 
				insertable=false, updatable=false)
	private AttractionsBean attractions;
	public AttractionsBean getAttractions() {
		return attractions;
	}
	public void setAttractions(AttractionsBean attractions) {
		this.attractions = attractions;
	}
	
	@Override
	public String toString() {
		return "Attractions_imgBean [photoid=" + photoid + ", attractions_id=" + attractions_id + ", attractions_img="
				+ Arrays.toString(attractions_img) + "]";
	}
	public int getPhotoid() {
		return photoid;
	}
	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}
	public int getAttractions_id() {
		return attractions_id;
	}
	public void setAttractions_id(int attractions_id) {
		this.attractions_id = attractions_id;
	}
	public byte[] getAttractions_img() {
		return attractions_img;
	}
	public void setAttractions_img(byte[] attractions_img) {
		this.attractions_img = attractions_img;
	}
	
	
}
