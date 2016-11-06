package model;

import java.util.Arrays;

public class RoomPhotoBean {
	private int roomPhotoId;
	private int roomid;
	private byte[] photo;
	private RoomBean rb;
	
	public RoomBean getRb() {
		return rb;
	}
	public void setRb(RoomBean rb) {
		this.rb = rb;
	}
	public int getRoomPhotoId() {
		return roomPhotoId;
	}
	public void setRoomPhotoId(int roomPhotoId) {
		this.roomPhotoId = roomPhotoId;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "RoomPhotoBean [roomPhotoId=" + roomPhotoId + ", roomid=" + roomid 
				+ "]";
	}
	
	
}
