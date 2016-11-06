package jj.model;

import java.util.List;

public interface TourDAO {

	
	
	
		//後臺搜尋all
		public abstract List<TourBean> select_all();
		//前台all
		public abstract List<TourBean> select_all_web();
		//改狀態
		public abstract boolean update_status(boolean tour_status,int tour_id);
		
		
		
		public abstract TourBean insert(TourBean bean);
		public abstract boolean update(String tour_name,int tour_restrict,
				int tour_price, String meeting_time, String cost_gloze
				,int age_limit,String meals,String remark
				,String meeting_place,java.lang.Double lat,java.lang.Double lng
				,boolean tour_status,String explanation,
				java.util.Date departure_date,int tour_id);
		
		public abstract boolean delete(int id);
		
		//搜尋ID 給評分用
		public abstract List<List> select_tourid();
		public abstract List<List> select_byid_toshow(int id);
		//依ID搜尋出團日
		public abstract List<List> select_byid_date(int tour_id);
		//id搜尋tour總人數給計算
		public abstract List<List>  select_number_byid(int tour_id);
		//更改訂單人數 依tourid
		public abstract boolean update_number(int tour_restrict,int tour_id);
		//上面是給扣 這個是加回來
		public boolean update_number_people_back(int tour_restrict,int tour_id,boolean tour_status);
		//id搜尋tour總人數給計算給取消訂單
		public abstract  List<List>select_number_byid2(int tour_id);
		//取得number 給算是否為0 然後更新
		public abstract List<List> select_nubmer_byid_zero(int tour_id);
		//更改狀態 依tour 因為人數被扣光
		public boolean update_status_bytourd_false(int tour_id);
		public boolean update_status_bytourd_true(int tour_id);
		//max tourid
		public List select_max_id();
		//給修改訂單
		public List<TourBean> select_all_by_id(int tour_id);
		
		//改版串連平價
		public List<List> select_all_2();
		public List<List> select_all_tai();
		public List<List> select_all_conatt();
		public List<List> select_all_yingge();
		public List<List> select_all_tn();

}
