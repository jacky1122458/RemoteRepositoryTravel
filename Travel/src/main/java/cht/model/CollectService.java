package cht.model;

import cht.model.dao.CollectDAOHibernate;
import cht.model.id.CollectId;
public class CollectService {
	
	private CollectDAOHibernate collectdao;
	public CollectService(CollectDAOHibernate collectdao){
		this.collectdao = collectdao;
	}
	
	public boolean insertFavoriteHotel(CollectId collectId){
		boolean confirm = false;
		Collect bean = new Collect();
		bean.setCollectId(collectId);
		
		bean = collectdao.insert(bean);
		if(bean !=null){
			confirm = true;
		}
		return confirm;
	} 
}
