package cht.model.test;

import java.util.List;

import cht.model.Hotel;
import cht.model.dao.HotelDAOJdbc;

public class test_Hotel {

	public static void main(String[] args){
		HotelDAOJdbc dao = new HotelDAOJdbc();
		Hotel result = new Hotel();
		String[] service ={"2","3"};
		List<Hotel> results;
//		results=dao.select();
//		results=dao.selectByName("愛");
//		results=dao.selectByName("愛",2,2);
//		results=dao.selectByAddress("台北",2,2);
		results = dao.selectByNameType("旅館",2,2,2);
		//results = dao.selectByAddressType("高雄",3,3,5);
		//results = dao.selectByName_Service("愛",2,2,service);
		//results = dao.selectByAddress_Service("高雄",2,2,service);
		//results = dao.selectByNameType_Service("愛",1,1,2,service);
		//results = dao.selectByAddressType_Service("高雄",2,2,5,service);
//		System.out.println(results);
		
//		result = dao.selectById(4);
//		Hotel bean = new Hotel();
		//bean.setHotelid(5);
//		bean.setHotelname("實在有病醫院");
//		bean.setLat(10.652413);
//		bean.setLng(10.561214);
//		bean.setStatus(true);
//		bean.setCheck_in("11:00:00");
//		bean.setCheck_out("12:00:00");
//		bean.setAddress("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		bean.setClass_level(5);
//		bean.setNote("yyyyyyyyyyyyyyyyyyyyyyy");
//		bean.setLanguage("土魯哇語");
//		bean.setPhone("0937204ccc");
//		bean.setPrice_bed(500);
//		bean.setTol_avg(5.2);
//		bean.setTotal_comment(15000);
//		bean.setYears(16);
//		bean.setTypeid(5);
//		result = dao.insert(bean);
		
		
//		result = dao.update(5, "xx",3, "545", "11:00:00", "13:00:00", 1, 300, "彰化", 20.6122, 20.6122, "日", "sss", 4, 100, true, 5);
		System.out.println(result);
		
//		boolean resultb;
//		resultb = dao.delete(4);
//		System.out.println(resultb);
		
	}

}
