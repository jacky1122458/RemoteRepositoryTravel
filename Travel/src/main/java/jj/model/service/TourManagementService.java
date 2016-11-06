package jj.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberBean;
import jj.model.TourBean;
import jj.model.TourDAO;
import jj.model.Tour_evaluateBean;
import jj.model.Tour_evaluateDAO;
import jj.model.Tour_orderBean;
import jj.model.Tour_orderDAO;
import jj.model.Travel_attractionsBean;
import jj.model.Travel_attractionsDAO;

public class TourManagementService {
	private TourDAO tourDAO;
	private Tour_orderDAO tour_orderDAO;
	private Tour_evaluateDAO tour_evaluateDAO;
	private Travel_attractionsDAO travel_attractionsDAO;
	
	public TourManagementService(TourDAO tourDAO) {
		this.tourDAO = tourDAO;
	}
	public TourManagementService(Tour_orderDAO tour_orderDAO) {
		this.tour_orderDAO = tour_orderDAO;
	}

	public TourManagementService(Tour_evaluateDAO tour_evaluateDAO) {
		this.tour_evaluateDAO = tour_evaluateDAO;
	}
	
	public TourManagementService(Travel_attractionsDAO travel_attractionsDAO) {
		this.travel_attractionsDAO = travel_attractionsDAO;
	}
	
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			

			TourManagementService tourservice = (TourManagementService) context.getBean("tourManagementService");
			TourManagementService tour_orderservice = (TourManagementService) context.getBean("tourManagementService1");
			TourManagementService tour_evaluateservice = (TourManagementService) context.getBean("tourManagementService2");
			TourManagementService travel_attractionsseservice = (TourManagementService) context.getBean("tourManagementService3");
//			List<TourBean> beans = service.select_all();
//			System.out.println("beans=" + beans);
			
			MemberBean bean = new MemberBean();
			
			
			
			
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	
	
	/*-----------------------------  Tour區    -----------------------------*/
	
	
	public List<List> select_all_2(){
		List<List> result = tourDAO.select_all_2();
		return result;
	}
	
	
	public List<List> select_all_tai(){
		List<List> result = tourDAO.select_all_tai();
		return result;
	}
	public List<List> select_all_conatt(){
		List<List> result = tourDAO.select_all_conatt();
		return result;
	}
	
	public List<List> select_all_ying(){
		List<List> result = tourDAO.select_all_yingge();
		return result;
	}
	
	public List<List> select_all_tn(){
		List<List> result = tourDAO.select_all_tn();
		return result;
	}
	
	
	//tour搜尋給修改用 查單筆
	
	public List select_all_by_id(int tour_id){
		List<TourBean> result = null;
		if(tour_id!=0){
			result=tourDAO.select_all_by_id(tour_id);
		}
		return result;
	}
	
	
	//max tour
	public List select_max_id(){
		List result = tourDAO.select_max_id();
		return result;
	}
	
	
	//touid去更新 狀態 因為人數0 判斷0   改是1 true
	public boolean update_status_bytourd_true(int tourid){
		if(tourid!=0){
			boolean result = tourDAO.update_status_bytourd_true(tourid);
		}
		return false;
	}
	
	//touid去更新 狀態 因為人數0 判斷0   改是0 false
	public boolean update_status_bytourd_false(int tourid){
		if(tourid!=0){
			boolean result = tourDAO.update_status_bytourd_false(tourid);
		}
		return false;
	}
	
	//去人數去算
	public List<List> select_nubmer_byid_zero(String tour_id){
		List<List> result = null;
		if(tour_id!=null){
			int INT = Integer.parseInt(tour_id);
			result=tourDAO.select_nubmer_byid_zero(INT);
		}
		return result ;
}
	
	//去人數去算
		public List<List> select_nubmer_byid_zeroINT(int tour_id){
			List<List> result = null;
			if(tour_id!=0){
				result=tourDAO.select_nubmer_byid_zero(tour_id);
			}
			return result ;
	}
	
	//跟新這個訂單人數
	public boolean update_number(int tour_restrict,int tour_id){
		boolean result=false;
		if(tour_id!=0){
			result=tourDAO.update_number(tour_restrict,tour_id);
		}
		return result;
	}
	
	//搜尋這個訂單 定幾人
	public List<List> select_number_byid(String tourid){
		List<List> result = null;
		if(tourid != null){
				int intint = Integer.parseInt(tourid);
				result=tourDAO.select_number_byid(intint);
			}
		return result;
	}
	
	//搜尋這個訂單 定幾人給取消用
		public List<List> select_number_bytourid(int tourid){
			List<List> result = null;
			result=tourDAO.select_number_byid2(tourid);
			System.out.println("result+++"+result);
			return result;
		}
	
	//依這個訂單 收尋日期  出團日
	public List<List> select_byid_date(String tour_id){
		List<List> result = null;
		if(tour_id!=null){
			int number = Integer.parseInt(tour_id);
			result=tourDAO.select_byid_date(number);
		}
		return result;
	}
	
	//搜尋tourid 給評價用
	public List<List> select_tourid() {
		List<List> result=null;
		result = tourDAO.select_tourid();
		return result;
	}
		
	//前台顯示訂單
	public List<TourBean> select_all_web() {
		List<TourBean> result=null;
		result = tourDAO.select_all();
		return result;
	}
	
	//後台顯示訂單
	public  List<TourBean> select_all(){
	List<TourBean> result=null;
	result = tourDAO.select_all_web();
	return result;
	}
	
	//後臺更改狀態
	public boolean update_status(TourBean bean) {
		  boolean result = false;
		if(bean!=null) {
			result = tourDAO.update_status(bean.isTour_status(), bean.getTour_id());
		}
		return result;
	}
	
	//後台insert
	public TourBean insert(TourBean bean) {
		TourBean result = null;
		if(bean!=null) {
			result = tourDAO.insert(bean);
		}
		return result;
	}
	//後臺更改旅程
	public boolean update_tour(TourBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = tourDAO.update(bean.getTour_name(),bean.getTour_restrict(),bean.getTour_price(), bean.getMeeting_time(), bean.getCost_gloze(), bean.getAge_limit(), bean.getMeals(), bean.getRemark(), bean.getMeeting_place(),bean.getLat(), bean.getLng(), bean.isTour_status(), bean.getExplanation(),bean.getDeparture_date(),bean.getTour_id());
		}
		return result;
	}
	//後臺刪除旅程
	public boolean delete(TourBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = tourDAO.delete(bean.getTour_id());
		}
		return result;
	}
	
	//給訂單用 傳一筆
	public  List<List>select_setTourbean1(String id){
		List<List>  result= null;
		if(id !=null){
			int intid = Integer.parseInt(id);
			result=tourDAO.select_byid_toshow(intid);
		}
		return result;
	}
	/*-----------------------------  Tour_order區    -----------------------------*/
	
	//------------------------------------------tourmtorder新方法
	
	public List select_tourmyorder_new(int orderid ,int memberid){
		List<List>  result =null;
		if(memberid!=0){
			result = tour_orderDAO.select_tourmyorder_new(orderid,memberid);
		}
		return result;	
	}
	
	
	
	public List select_tourmyorder_newid(int memberid){
		List<List>  result =null;
		if(memberid!=0){
			result = tour_orderDAO.select_tourmyorder_newid(memberid);
		}
		return result;	
	}
	
	
	//-------------------------------------------------
	
	
	//簡訊
	public  List<List> select_tour_sms(int order_id){
		List<List> result =null;
		if(order_id!=0){
			result = tour_orderDAO.select_tour_sms(order_id);
		}
		return result;
		
	}

	
	
	
	
	public  List<Tour_orderBean> select_all_orderbymanag(int tour_id){
		 List<Tour_orderBean>  result = null ;	
		if(tour_id !=0){
			result=tour_orderDAO.select_all_orderbymanagbyid(tour_id);
		}else{
			result=tour_orderDAO.select_all_orderbymanag();
		}
		return result;
	}

	
	
	
	
	
	//更改點取 與取消的 訂單狀態變為false
	public boolean update_status(boolean order_status, int order_id){
		boolean result = false;
		if(order_id!=0){
			result  = tour_orderDAO.update(order_status, order_id);
		}
		return false;
	}
	
	public boolean  update_number_people_back(int tour_restrict,int tour_id,boolean tour_status){
		boolean result =false;
		if(tour_id!=0){
			result=tourDAO.update_number_people_back(tour_restrict,tour_id,tour_status);
		}
		return false;
	}
	
	
	
	
	//依照orderid收詢orderid number
	public List<List> select_by_orderid_get_tourid_number(String orderid) {
		List<List> result=null;
		if(orderid!=null){
			int intordid = Integer.parseInt(orderid);
			result=tour_orderDAO.select_by_orderid_get_tourid_number(intordid);
		}
		return result;
	}
	
	
	
	
	
	
	
	//搜尋我得訂單id
	public List<List> select_by_member_get_tourid(MemberBean bean) {
		List<List> result=null;
		if(bean!=null && bean.getMemberid()!=0){
			result=tour_orderDAO.select_by_member_get_tourid(bean.getMemberid());
		}
		return result;
	}
	
	
	
	
	//後台顯示訂單
	public List<Tour_orderBean> select_all(MemberBean bean){
		List<Tour_orderBean> result = null;
		if(bean!=null && bean.getMemberid()!=0) {
			result = tour_orderDAO.select_all(bean.getMemberid());
		} else {
			result = tour_orderDAO.select_all();
		}
		return result;
	}
	//inset訂單
	public Tour_orderBean insert(Tour_orderBean bean) {
		Tour_orderBean result = null;
		if(bean!=null) {
			result = tour_orderDAO.insert(bean);
		}
		return result;
	}
	
	//算人數給tour 總共多少人訂
	public List<List> select_tour_number(String tourid,String departure_date) {
		List<List> result=null;
		if(tourid !=null && departure_date!=null){
			int num = Integer.parseInt(tourid);
			 Date date = null;  
		        try {  
		            date = new SimpleDateFormat("yyyy-MM-dd").parse(departure_date); 
		        } catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
		        System.out.println("date"+date);
		        result=tour_orderDAO.select_tour_number(num, date);
		}
		return result;
	}
	
	//顯示我得訂單
	public List<Tour_orderBean> select_by_member(MemberBean bean) {
		List<Tour_orderBean> result = null;
		if(bean!=null && bean.getMemberid()!=0) {
			result = tour_orderDAO.select_by_member(bean.getMemberid());
		}
		return result;
	}
	
	//用帳號根 密碼搜尋 我的訂單
	public List<Tour_orderBean> select_by_member_tourid(int member_id,int tour_id){
		List<Tour_orderBean> result = null;
		if(member_id!=0 && tour_id!=0) {
			result = tour_orderDAO.select_by_member_tourid(member_id,tour_id);
		}
		return result;
	}
	
	public List<List> select_by_member_get_tourid1(int member_id) {
		List<List> result=null;
		if(member_id!=0){
			result=tour_orderDAO.select_by_member_get_tourid1(member_id);
		}
		return result;
	}

	
	
	
	/*-----------------------------  Tour_evaluate區    -----------------------------*/
	//依訂單修改狀態
	public boolean update_Status(boolean evaluate_status, int order_id) {
		boolean result = false;
		if(order_id !=0){
			 result = tour_evaluateDAO.update_Status(evaluate_status, order_id);
			}
		return result;
	}
	
	//檢查是不是false;
	public boolean select_check_update(int order_id) {
		if(order_id!=0){
			
			List<List> as = tour_evaluateDAO.select_check_update(order_id);
			System.out.println(as);
			if(!as.isEmpty()){
				return true;
			}else{
				return false;
			}
		
		}
		return false;
	}
	
	
	//收詢所有論給景點
	public List<Tour_evaluateBean> select_by_tour(String tour_id) {
		List<Tour_evaluateBean> result=null;
		if(tour_id!=null){
		int ints = Integer.parseInt(tour_id);
		result = tour_evaluateDAO.select_by_tour(ints);
		}
		return result;
	}
	
	
	//搜尋全部給後台看
	public List<List> select_manger() {
		List<List> result = tour_evaluateDAO.select_back();
		return result;
	}
	
	
	
	
	//搜尋給後台 memberid 或 是全部
	public List<Tour_evaluateBean> selectevaluate(MemberBean bean){
		List<Tour_evaluateBean> result = null;
		if(bean!=null && bean.getMemberid()!=0) {
			result = tour_evaluateDAO.select(bean.getMemberid());
		} else {
			result = tour_evaluateDAO.select();
		}
		return result;
	}
	
	//更改評價狀態
	public  boolean update_Status(Tour_evaluateBean bean) {
		boolean result=false;
		if(bean!= null){
		 result=tour_evaluateDAO.update_Status(bean.isEvaluate_status(),bean.getOrder_id());
		}
		return result;
	}
	
	//搜尋評價為1的給旅程
	public  List<Tour_evaluateBean> select_by_tour(Tour_evaluateBean bean){
		List<Tour_evaluateBean> result =null;
		if(bean!=null){
			result=tour_evaluateDAO.select_by_tour(bean.getTour_id());
		}
		return result;
	}
	//旅程分數計算
	public List<List> select_tour_rating(int d){
		List<List> result =null;
		if(d!=0){
			result=tour_evaluateDAO.select_tour_rating(d);
		}
		return result;
	}
	
	//新增訂單
	public Tour_evaluateBean insert(Tour_evaluateBean bean){
		Tour_evaluateBean result = null;
		System.out.println(bean);
		if(bean.getMember_id()!= 0 && bean!=null){
			result=tour_evaluateDAO.insert(bean);
		}
		return result;
	}
	
	
	
	public List select_check(int order_id ,int tourid,int member_id){
		List result = null;
		if(member_id!=0){
			result=tour_evaluateDAO.select_check(order_id, tourid, member_id);
		}
		return result;
	}
	
	//搜尋我自己的評論
	public List<Tour_evaluateBean> select_mysef(MemberBean bean) {
		List<Tour_evaluateBean> result = null;
		if(bean!=null && bean.getMemberid()!=0){
			 result = tour_evaluateDAO.select_mysef(bean);
		}
		return result;
	}
	
	
	
	
	
	/*-----------------------------  Travel_attractionsDAO區    -----------------------------*/
	
	//查詢tour擁有景點
	public List<Travel_attractionsBean> select_by_tour_id(Travel_attractionsBean bean){
		List<Travel_attractionsBean> result =null;
		if(bean!=null){
			result=travel_attractionsDAO.select_by_tour_id(bean.getTour_id());
		}
		return result;
	}
	
	public List<Travel_attractionsBean> select_by_tour_stringid(String id){
		List<Travel_attractionsBean> result =null;
		if(id!=null){
			int intid = Integer.parseInt(id);
			result=travel_attractionsDAO.selectatttion_tour_id(intid);
		}
		return result;
	}
	//搜尋全部tourbean給order
	public List<Travel_attractionsBean> select_setTourbean(String id){
		List<Travel_attractionsBean> result =null;
		if(id!=null){
			int intid = Integer.parseInt(id);
			result=travel_attractionsDAO.select_setTourbean(intid);
		}
		return result;
	}
	
	
	
	public Travel_attractionsBean inset(int tourid , int sequence,int attractions_id){
		Travel_attractionsBean result =null;
			Travel_attractionsBean bean = new Travel_attractionsBean();
			bean.setTour_id(tourid);
			bean.setSequence(sequence);
			bean.setAttractions_id(attractions_id);
			if(bean !=null){
				result=travel_attractionsDAO.insert(bean);
			}
		return result;
	}
	
	
	
	//單筆update
	public Travel_attractionsBean update(int tour_id, int sequence, int attractions_id){
		if(tour_id!=0){
			boolean result = travel_attractionsDAO.update(tour_id,sequence,attractions_id);
		}
		return null;
	}
	
	public List select_id_name(int tour_id){
		List result = travel_attractionsDAO.select_id_name(tour_id);
		return result;
	}
	
	
	
	public void deletetravel(int id){
		travel_attractionsDAO.delete(id);
	}
	
	
	public boolean delete(Travel_attractionsBean bean) {
		boolean result = false;
		if(bean!=null) {
			result =travel_attractionsDAO.delete(bean.getTour_id());
		}
		return result;
	}
}


