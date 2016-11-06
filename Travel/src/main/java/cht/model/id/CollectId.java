package cht.model.id;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CollectId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int memberid;
	private int hotelid;
	
	@Override
	public String toString() {
		return "CollectId [memberid=" + memberid + ", hotelid=" + hotelid + "]";
	}

	
	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	
public boolean equals(Object obj){
		
		if(obj == this){
			return true;
		}
		
		if(!(obj instanceof CollectId)){
			return false;
		}
		
		CollectId collect = (CollectId) obj;
		return new EqualsBuilder()
				.append(this.memberid, collect.getMemberid())
				.append(this.hotelid, collect.getHotelid())
				.isEquals();
	}
	
	public int hashCode(){
		return new HashCodeBuilder()
				.append(this.memberid)
				.append(this.hotelid)
				.toHashCode();
	}
}
