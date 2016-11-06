package cht.model.id;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import cht.model.HotelService;

public class HotelCardId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int hotelid;
	private String cardtype;
	
	@Override
	public String toString() {
		return "HotelCardId [hotelid=" + hotelid + ", cardtype=" + cardtype + "]";
	}

	
	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	public boolean equals(Object obj){
		
		if(obj == this){ return true; }
		if(!(obj instanceof HotelService)){ return false; }
		
		HotelCardId hotelcardid = (HotelCardId) obj;
		return new EqualsBuilder()
				.append(this.hotelid, hotelcardid.getHotelid())
				.append(this.cardtype, hotelcardid.getCardtype())
				.isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder()
				.append(this.hotelid)
				.append(this.cardtype)
				.toHashCode();
	}
}
