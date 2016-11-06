package model.dao;

import model.SignInDAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.SignInBean;

public class SignInDAOHibernate implements SignInDAO{
	private SessionFactory sessionFactory=null;
	public SignInDAOHibernate(SessionFactory factory) {
		this.sessionFactory=factory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public List<List>  selectOne(int memberid) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("select new list(MB,s.signdate)from MemberBean as MB join MB.signin as s where MB.memberid=:memberid");
		query.setParameter("memberid", memberid);
		return(List<List>)query.list();

		
	}
	
	@Override
	public List<List> select() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("select new list(MB,s.signdate)from MemberBean as MB join MB.signin as s");
		return(List<List>)query.list();
	}
	
	@Override
	public void insert(SignInBean bean) {
		SignInBean result = (SignInBean)this.getSession().get(SignInBean.class, bean.getMemberid());
		if(result == null){
			this.getSession().save(bean);
		}
	}

	@Override
	public  SignInBean select(int memberid) {
		return (SignInBean)
				this.getSession().get(SignInBean.class, memberid);
	}
	
	@Override
	public void update(int memberid,java.util.Date signdate){
	Query query = this.getSession().createQuery("Update SignInBean set signdate = :signdate  where memberid =:memberid ");
	query.setParameter("memberid",memberid);
	query.setParameter("signdate",signdate);
	query.executeUpdate();
	}

}
