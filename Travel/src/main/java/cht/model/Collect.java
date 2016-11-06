package cht.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.Query;

import cht.model.id.CollectId;
import cht.model.misc.HibernateUtil;
@Entity
public class Collect {
	@EmbeddedId
	private CollectId collectId;
	public CollectId getCollectId() {
		return collectId;
	}
	public void setCollectId(CollectId collectId) {
		this.collectId = collectId;
	}

	@Override
	public String toString() {
		return "Collect [" + collectId + "]";
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

			Query query = 
					HibernateUtil.getSessionFactory().getCurrentSession().createQuery("From Collect");
			System.out.println(query.list());
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
