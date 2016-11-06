package jj.model;

import java.util.List;

public interface AreaDAO {
	//id搜尋回傳單一地名
	public abstract List<AreaBean> select(int id);

	public abstract List<AreaBean> select();

	public abstract AreaBean insert(AreaBean bean);

//	public abstract AreaBean update(String name,int id);

	public abstract boolean delete(int id);
}
