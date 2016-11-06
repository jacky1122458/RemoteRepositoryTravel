package model;

import java.util.Date;
import java.util.List;

public interface SignInDAO {
	
	public void insert(SignInBean bean);
	//public void update(SignInBean bean);
	
	public SignInBean select(int memberid);
	public List<List> select();
	public List<List> selectOne(int memberid);
	void update(int memberid, Date signdate);
	
}
