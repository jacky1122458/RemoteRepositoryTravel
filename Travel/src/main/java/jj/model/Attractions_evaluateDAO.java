package jj.model;

import java.util.List;

public interface Attractions_evaluateDAO {

	
	
	
	//後台全部不管01
	public abstract List<Attractions_evaluateBean> select_ALL();
	//後台全部依據Member_id
	public abstract List<Attractions_evaluateBean> select_ALL(int member_id);
	
	
	//新增**
	public abstract Attractions_evaluateBean insert(Attractions_evaluateBean bean);
	
	//修改自己評分**
	public abstract void userupdate_status(int Attractions_rating, String Attractions_evaluate,int member_id,int attractions_id);
	
	
	//單一景點評價
	public abstract List<Attractions_evaluateBean> select_Attractions_evaluate_id(int attractions_id);
	
	//我的評價
	public abstract List<Attractions_evaluateBean> select_member_id(int member_id);
	
	//隱藏別人狀態,後台修改狀態
	public boolean rootupdate_status(boolean attractions_status,int member_id,int attractions_id);
	
	//計算評價分數 依景點
	public List<Attractions_evaluateBean> select_Attractions_sum(int attractions_id);

	
}
