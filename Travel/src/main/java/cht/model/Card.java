package cht.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import cht.model.misc.HibernateUtil;

@Entity
public class Card {
	@Id
	private String cardtype;
	private byte[] cardphoto;
	
	@Override
	public String toString() {
		return "Card [cardtype=" + cardtype + "]";
	}
	
	
	@ManyToMany
	@JoinTable(
			name="HOTELCARD",
			joinColumns={@JoinColumn(name="CARDTYPE")},
			inverseJoinColumns={@JoinColumn(name="HOTELID")}
	)
	private Set<Hotel> hotels;
	public Set<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}

	

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public byte[] getCardphoto() {
		return cardphoto;
	}

	public void setCardphoto(byte[] cardphoto) {
		this.cardphoto = cardphoto;
	}
	
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			Card card = 
					(Card)HibernateUtil.getSessionFactory().getCurrentSession().get(Card.class,"visa");
			System.out.println(card);
			
			System.out.println(card.getHotels());	//Hotels
			
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
