package jj.model;

import java.util.List;

public interface Attractions_imgDAO {

	
//	public abstract Attractions_imgBean insert(Attractions_imgBean bean);
//	public abstract List<Attractions_imgBean> select();
//	public abstract Attractions_imgBean select_by_photoid(int photoid);
	public abstract List<Attractions_imgBean> select_by_attractions_id(int attractions_id);
//	public abstract boolean delete(int photoid);
//	public abstract Attractions_imgBean update(int attractions_id,byte[] attractions_img ,int photoid);
	public Attractions_imgBean select_photo(int attractions_id);
}