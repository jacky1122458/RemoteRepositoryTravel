package jj.model;

import java.util.List;

public  interface Tour_orderDAO {

	//我的訂單狀態1顯示 **
	public abstract List<Tour_orderBean> select_by_member(int member_id);
	//後台全部訂單10都顯示 帳號
	public abstract List<Tour_orderBean> select_all(int member_id);
	//後臺全部
	public abstract List<Tour_orderBean> select_all();
	//自己取消訂單 **
	public abstract boolean update(boolean order_status,int order_id);
	//insert訂單 
	public abstract Tour_orderBean insert(Tour_orderBean bean);
	//算總人數給tour
	public abstract List<List> select_tour_number(int tourid,java.util.Date departure_date);
	//取得訂單編號odrid 依帳號
	public abstract List<List> select_by_member_get_tourid(int member_id);
	//取得訂單tourid&number 依照ORDERID
	public abstract List<List> select_by_orderid_get_tourid_number(int tour_id);
	
	//取得訂單所有得給後台
	public abstract List<Tour_orderBean> select_all_orderbymanag();
	//依照tourid 分類
	public abstract List<Tour_orderBean> select_all_orderbymanagbyid(int orderid);
	//簡訊給id
	public abstract List<List> select_tour_sms(int tour_id);
	public abstract List<Tour_orderBean> select_by_member_tourid(int member_id, int tour_id);
	public abstract List<List> select_by_member_get_tourid1(int member_id);
	
	public abstract List<List> select_tourmyorder_new(int order_id,int member_id);
	public abstract List<List> select_tourmyorder_newid(int member_id);

}
