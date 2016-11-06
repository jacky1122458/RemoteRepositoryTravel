package jj.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Travel_attractionsBean implements Serializable{
	private int tour_id;
	private int sequence;
	private int attractions_id;
	
	private TourBean tourid;
	private AttractionsBean attractionsid;
	
	
	
	
	
	
	public TourBean getTourid() {
		return tourid;
	}
	public void setTourid(TourBean tourid) {
		this.tourid = tourid;
	}
	public AttractionsBean getAttractionsid() {
		return attractionsid;
	}
	public void setAttractionsid(AttractionsBean attractionsid) {
		this.attractionsid = attractionsid;
	}
	@Override
	public int hashCode() {
		  return new HashCodeBuilder()
                  .append(this.tour_id)
                  .append(this.attractions_id)
                  .toHashCode();		
	}
	@Override
	public boolean equals(Object obj) {
		 if(obj == this) {
	            return true;
	        }
	 
	        if(!(obj instanceof Travel_attractionsBean)) {
	            return false;
	        }
	 
	        Travel_attractionsBean Travel_attractionsBean = (Travel_attractionsBean)obj;
	        return  new EqualsBuilder()
	                    .append(this.tour_id,Travel_attractionsBean.getTour_id())
	                    .append(this.attractions_id,Travel_attractionsBean.getAttractions_id())
	                    .isEquals();		
	}
	@Override
	public String toString() {
		return "Travel_attractionsBean [tour_id=" + tour_id + ", sequence=" + sequence + ", attractions_id="
				+ attractions_id + "]";
	}
	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public int getAttractions_id() {
		return attractions_id;
	}
	public void setAttractions_id(int attractions_id) {
		this.attractions_id = attractions_id;
	}     
	
}
