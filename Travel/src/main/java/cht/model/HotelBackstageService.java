package cht.model;

import java.util.List;
import java.util.Map;

import cht.model.dao.HotelDAOHibernate;

public class HotelBackstageService {
	private HotelDAOHibernate hoteldao;
	public HotelBackstageService(HotelDAOHibernate hoteldao){
		this.hoteldao = hoteldao;
	}
	
	public List<Hotel> selectByArea(String area) {
		List<Hotel> result = null;
		if(area.equals("")) {
			result = hoteldao.selectByAddress(area);
				return result;
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
	public boolean delete(Hotel bean) {
		boolean result = false;
		if(bean!=null) {
			result = hoteldao.delete(bean.getHotelid());
		}
		return result;
	}
	
	public Map<String, Object> getReviewAvg(Hotel bean){
		 Map<String, Object> result = null;
		 if(bean!=null) {
			 result = hoteldao.getReviewAvg(bean.getHotelid());
		 }
		 return result;
	}
}
