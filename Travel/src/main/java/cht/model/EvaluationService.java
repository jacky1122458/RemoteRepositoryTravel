package cht.model;

import java.util.List;
import java.util.Map;

import cht.model.dao.HotelDAOHibernate;
import cht.model.dao.HotelReviewDAOHibernate;

public class EvaluationService {
	private HotelReviewDAOHibernate hotelreviewDAO;
	private HotelDAOHibernate hotelDAO;
	public EvaluationService(HotelReviewDAOHibernate hotelreviewDAO, HotelDAOHibernate hotelDAO){
		this.hotelreviewDAO = hotelreviewDAO;
		this.hotelDAO = hotelDAO;
	}
	
	public HotelReview insert(HotelReview bean){
		HotelReview result = null;
		if(bean!=null){
			result = hotelreviewDAO.insert(bean);
			
			if(result!=null){
				Hotel hotelbean = hotelDAO.selectById(result.getHotelid());
				Map<String, Object> avg = hotelDAO.getReviewAvg(result.getHotelid());
				
				hotelbean.setTol_avg((Double)avg.get("total"));
				hotelbean.setTotal_comment((Integer)avg.get("total_comment"));
			}
		}
		return result;
	}
}
