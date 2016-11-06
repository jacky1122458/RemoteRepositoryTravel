package jj.model;

import java.util.List;

public interface Travel_attractionsDAO {

		//搜尋全部tour_id 
		public abstract List<Travel_attractionsBean> select_by_tour_id(int tour_id);
		//insert訂單 **
		public abstract Travel_attractionsBean insert(Travel_attractionsBean bean);
		
		//搜尋景點給耕莘用
		public List select_id_name(int tour_id);
		public boolean delete(int id);

		//tour id 給景點資訊 他有哪些符合
		public abstract List<Travel_attractionsBean> selectatttion_tour_id(int tour_id);
		public abstract List<Travel_attractionsBean> select_setTourbean(int tour_id);
		//新增順序
		public abstract Travel_attractionsBean insert(int tourid, int squeuence, int attionid);
		public abstract boolean update(int tour_id, int squeuence, int attractions_id);
}
