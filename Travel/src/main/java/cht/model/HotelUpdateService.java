package cht.model;

import java.util.Map;

import cht.model.dao.HotelDAOHibernate;

public class HotelUpdateService {
	private HotelDAOHibernate hoteldao;
	public HotelUpdateService(HotelDAOHibernate hoteldao){
		this.hoteldao = hoteldao;
	}
	
	public Map<String, Object> getReviewAvg(Hotel bean){
		 Map<String, Object> result = null;
		 if(bean!=null) {
			 result = hoteldao.getReviewAvg(bean.getHotelid());
		 }
		 return result;
	}
	
	public Hotel insert(Hotel bean) {
		Hotel result = null;
		if(bean!=null) {
			result = hoteldao.insert(bean);
		}
		return result;
	}
	
	public Hotel update(Hotel bean) {
		Hotel result = null;
		if(bean!=null) {
			result = hoteldao.update(bean);
		}
		return result;
	}
	
}
