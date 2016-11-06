package jj.model;

import java.util.List;

import org.hibernate.Query;

import model.MemberBean;

public interface Tour_evaluateDAO {
	//搜尋全部給後台
	public abstract List<Tour_evaluateBean> select();
	//後臺搜尋id
	public abstract List<Tour_evaluateBean> select(int member_id);
	//我得評論  **
	public abstract List<Tour_evaluateBean> select_my(int member_id);
	//只秀狀態1評論給行程
	public abstract List<Tour_evaluateBean> select_by_tour(int tour_id);
	//新增 **
	public abstract Tour_evaluateBean insert(Tour_evaluateBean bean);
	//後台遮狀態
	public abstract boolean update_Status(boolean evaluate_status,int order_id);
	//修改自己評論 **
	public abstract boolean update1(String evaluate,int rating,int order_id);
	
	
	//行程分數 
	public abstract List select_tour_rating(int tour_id);
	//查看訂單有沒有這一筆 比對有沒有評過分
	public abstract List select_check(int order_id, int tour_id, int member_id);
	public abstract List<List> select_back();//搜尋給後台
	//判斷UPADA 來更新
	public abstract List<List> select_check_update(int order_id);
	
	//搜尋自己留言
	public abstract List<Tour_evaluateBean> select_mysef(MemberBean bean);
	

}
