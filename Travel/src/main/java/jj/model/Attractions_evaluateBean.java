package jj.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import model.MemberBean;

public class Attractions_evaluateBean implements Serializable{
	private int member_id;
	private int attractions_id;
	private int attractions_rating;
	private String attractions_evaluate;
	private boolean attractions_status;
	
	
	private MemberBean memberid;
	public MemberBean getMemberid() {
		return memberid;
	}
	public void setMemberid(MemberBean memberid) {
		this.memberid = memberid;
	}
	
	
	private AttractionsBean attractionsid;
	public AttractionsBean getAttractionsid() {
		return attractionsid;
	}
	public void setAttractionsid(AttractionsBean attractionsid) {
		this.attractionsid = attractionsid;
	}
	
	@Override
	 public int hashCode() {
        return new HashCodeBuilder()
                    .append(this.member_id)
                    .append(this.attractions_id)
                    .toHashCode();
    }
	@Override
	public boolean equals(Object obj) {
		 if(obj == this) {
	            return true;
	        }
	 
	        if(!(obj instanceof Attractions_evaluateBean)) {
	            return false;
	        }
	 
	        Attractions_evaluateBean Attractions_evaluateBean = (Attractions_evaluateBean)obj;
	        return  new EqualsBuilder()
	                    .append(this.member_id,Attractions_evaluateBean.getMember_id())
	                    .append(this.attractions_id,Attractions_evaluateBean.getAttractions_id())
	                    .isEquals();		
	}
	
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getAttractions_id() {
		return attractions_id;
	}
	public void setAttractions_id(int attractions_id) {
		this.attractions_id = attractions_id;
	}
	public int getAttractions_rating() {
		return attractions_rating;
	}
	public void setAttractions_rating(int attractions_rating) {
		this.attractions_rating = attractions_rating;
	}
	public String getAttractions_evaluate() {
		return attractions_evaluate;
	}
	public void setAttractions_evaluate(String attractions_evaluate) {
		this.attractions_evaluate = attractions_evaluate;
	}
	public boolean isAttractions_status() {
		return attractions_status;
	}
	public void setAttractions_status(boolean attractions_status) {
		this.attractions_status = attractions_status;
	}
	
	@Override
	public String toString() {
		return "Attractions_evaluateBean [member_id=" + member_id + ", attractions_id=" + attractions_id
				+ ", attractions_rating=" + attractions_rating + ", attractions_evaluate=" + attractions_evaluate
				+ ", attractions_status=" + attractions_status + "]";
	}
	
	
	
	
	
}