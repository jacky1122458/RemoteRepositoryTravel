package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cht.model.Hotel;
import cht.model.HotelReview;
import cht.model.dao.HotelReviewDAOHibernate;

public class SerachEvaluationService {
	private HotelReviewDAOHibernate hotelReviewDAO;
	
	public SerachEvaluationService(HotelReviewDAOHibernate hotelReviewDAO){
		this.hotelReviewDAO = hotelReviewDAO;
	}
	
	public List<HotelReview> SerachMemberEvalutaion(MemberBean memberbean){
		List<HotelReview> result =null;
		if(memberbean!=null){
			result= hotelReviewDAO.selectByMemberId(memberbean.getMemberid());
		}
		return result;
	}
	
	public List<Map<String,Object>> getEvalutationInformation(MemberBean bean){
		
		long oneDay = 86400000; //一天
		int day = 20;
		java.util.Date first = new java.util.Date();
		java.util.Date last = new java.util.Date(first.getTime()-(oneDay*day));
		List<Map<String,Object>> results = null;
		if(bean !=null){
			List<List> evalbeans = hotelReviewDAO.getEvalutation(bean.getMemberid(), last, first);
			if(evalbeans !=null){
				results = new ArrayList<Map<String,Object>>();
				for(List list : evalbeans){
					Map<String,Object> result = new HashMap<String,Object>();
					Hotel hotelbean = (Hotel)list.get(0);
					Hotel_orderBean orderbean = (Hotel_orderBean)list.get(1);
					result.put("hotelbean", hotelbean);
					result.put("orderbean", orderbean);
					results.add(result);
				}
			}
		}
		return results;
	}
	
}
