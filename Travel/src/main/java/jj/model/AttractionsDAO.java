package jj.model;

import java.util.List;

public interface AttractionsDAO {

	//id搜尋**
	public abstract List<AttractionsBean> select_id(int attractions_id);

	
	//搜尋全部
	public abstract List<AttractionsBean> select();
	//中文收尋 以縣市
	public abstract List<AttractionsBean> select_area(int id);

	
	
	//後台新增
	public  AttractionsBean insert(AttractionsBean bean);
	//更新
	public abstract AttractionsBean update
	(String name,String attractions_type,
	 String openinghours,String introduction,
	 int district,String attractions_address,
	 java.lang.Double lat,java.lang.Double lng,String webaddress,int attractions_id);
	//以id刪除
	public abstract boolean delete(int attractions_id);
	
	//以地點搜尋 全部 輸入 select_byDistract
	public abstract List<List> select_byDistract(int  id);

	//給新增選單 生程選項
	public abstract List<AttractionsBean> select_id_name();
	//給新增選單 生程選項 byid
	public abstract List<AttractionsBean> select_id_name(int tourid);

	//以地點搜尋 全部 輸入 select_byall
	public abstract List<List> select_byAll();

}
