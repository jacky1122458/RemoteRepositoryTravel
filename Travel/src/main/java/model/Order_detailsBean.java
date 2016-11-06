package model;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
public class Order_detailsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int orderid;
	private int  roomid;
	private String name;
	private int price;
	private int peoplenum;
	private int number;
	private String cellphone;
	private String spec;
	private Boolean Status;
	
	private RoomBean roombean;
	public RoomBean getRoombean() {
		return roombean;
	}
	public void setRoombean(RoomBean roombean) {
		this.roombean = roombean;
	}
	
	private Hotel_orderBean ho;
	public Hotel_orderBean getHo() {
		return ho;
	}
	public void setHo(Hotel_orderBean ho) {
		this.ho = ho;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int  roomid) {
		this.roomid = roomid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	   public boolean equals(Object obj) {
	        if(obj == this) {
	            return true;
	        }
	 
	        if(!(obj instanceof Order_detailsBean)) {
	            return false;
	        }
	 
	        Order_detailsBean order_detailsBean = (Order_detailsBean) obj;
	        return  new EqualsBuilder()
	                    .append(this.orderid, order_detailsBean.getOrderid())
	                    .append(this.roomid, order_detailsBean.getRoomid())
	                    .isEquals();
	    }
	   
	    public int hashCode() {
	        return new HashCodeBuilder()
	                    .append(this.orderid)
	                    .append(this.roomid)
	                    .toHashCode();
	    }
		@Override
		public String toString() {
			return "Order_detailsBean [orderid=" + orderid + ", roomid=" + roomid + ", name=" + name + "price=" + price
					+ ", peoplenum=" + peoplenum + ", number=" + number + ", cellphone=" + cellphone + ", spec=" + spec
					+ ", Status=" + Status + "]";
		}
		
		 
}
