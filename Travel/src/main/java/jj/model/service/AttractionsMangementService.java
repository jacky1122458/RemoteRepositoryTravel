package jj.model.service;

import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jj.model.AreaBean;
import jj.model.AreaDAO;
import jj.model.AttractionsBean;
import jj.model.AttractionsDAO;
import jj.model.Attractions_evaluateBean;
import jj.model.Attractions_evaluateDAO;
import jj.model.Attractions_imgBean;
import jj.model.Attractions_imgDAO;
import model.MemberBean;

public class AttractionsMangementService {
	private AreaDAO areaDAO;
	private Attractions_evaluateDAO attractions_evaluateDAO;
	private AttractionsDAO attractionsDAO;
	private Attractions_imgDAO attractions_imgDAO;
	
	public AttractionsMangementService(Attractions_imgDAO attractions_imgDAO) {
		this.attractions_imgDAO = attractions_imgDAO;
	}
	public AttractionsMangementService(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
	public AttractionsMangementService(Attractions_evaluateDAO attractions_evaluateDAO) {
		this.attractions_evaluateDAO = attractions_evaluateDAO;
	}

	public AttractionsMangementService(AttractionsDAO attractionsDAO) {
		this.attractionsDAO = attractionsDAO;
	}
	
	public static void main(String[] args)  {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			
			AttractionsMangementService areaservice = (AttractionsMangementService) context.getBean("attractionsMangementService");
			AttractionsMangementService attractions_evaluatesrvice = (AttractionsMangementService) context.getBean("attractionsMangementService1");
			AttractionsMangementService attractions_service = (AttractionsMangementService) context.getBean("attractionsMangementService2");
			AttractionsMangementService attractions_img_service = (AttractionsMangementService) context.getBean("attractionsMangementService3");
			
			MemberBean bean = new MemberBean();
			
//			AttractionsBean bean1 = new AttractionsBean();
//			bean1.setId(1);
//			List<AttractionsBean> s = attractions_service.select_all(bean1);
//			System.out.println(s);

//			AreaBean bean3 = new AreaBean();
//			bean3.setId(1);
//			List<AttractionsBean> s = attractions_service.select_all(null);
//			System.out.println(s);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
	}
	
	/*-----------------------------  Area區    -----------------------------*/
	
	//id搜尋地區
	public List<AreaBean>select_id(AreaBean bean){
		List<AreaBean> result = null;
			if(bean.getId()!=0 && bean!=null){
				result=areaDAO.select(bean.getId());
			}
		return result;
	}
	
	//顯示全部
	public List<AreaBean> select(){
		 List<AreaBean>result =null;
		 result=areaDAO.select();
		 return result;
	}
	//新增
	public AreaBean insert(AreaBean bean){
		AreaBean result = null ;
		if(bean!=null){
			result =areaDAO.insert(bean);
		}
		return result;
	}
	//刪除
	public boolean delete(AreaBean bean){
		boolean result = false;
		if(bean!=null){
			result=areaDAO.delete(bean.getId());
		}
		return result;
	}
	
	/*-----------------------------  Attractions_evaluate區    -----------------------------*/
	
	
	
	
		//後台全部不管01
		//後台全部依據Member_id
		public List<Attractions_evaluateBean> select_ALL(MemberBean bean){
			List<Attractions_evaluateBean> result = null;
			if(bean != null && bean.getMemberid()!=0){
				result = attractions_evaluateDAO.select_ALL(bean.getMemberid());
			}else{
				result=attractions_evaluateDAO.select_ALL();
			}
			return result ;
		}
		
		//單一景點評價
		public  List<Attractions_evaluateBean> select_Attractions_evaluate_id(Attractions_evaluateBean bean){
			List<Attractions_evaluateBean> result = null;
			if(bean != null && bean.getAttractions_id() !=0){
				result=attractions_evaluateDAO.select_Attractions_evaluate_id(bean.getAttractions_id());
			}
			return result;
		}
		
		//我的評價
		public  List<Attractions_evaluateBean> select_member_id(MemberBean bean){
			List<Attractions_evaluateBean> result =null;
			if(bean !=null && bean.getMemberid()!=0){
				result=attractions_evaluateDAO.select_member_id(bean.getMemberid());
			}
			return result; 
		}
		
		//隱藏別人狀態,後台修改狀態
		public boolean rootupdate_status(Attractions_evaluateBean bean,int memberid){
			boolean result =false;
			if(bean != null & memberid !=0){
				 result=attractions_evaluateDAO.rootupdate_status(bean.isAttractions_status(),memberid,bean.getAttractions_id());
			}
			return result;
		}		
		//計算評價分數 依景點
		public List<Attractions_evaluateBean> select_Attractions_sum(Attractions_evaluateBean bean){
			 List<Attractions_evaluateBean> result = null;
			 if(bean != null && bean.getAttractions_id() !=0){
				 result=attractions_evaluateDAO.select_Attractions_sum(bean.getAttractions_id());
			 }
			return result;
		}
		

		
	/*-----------------------------  Attractions區    -----------------------------*/
		//給新增選單 生程選項
		public List<AttractionsBean>select_id_name(){
			List<AttractionsBean> result = attractionsDAO.select_id_name();
			return result;
		}
		
	
		
		
		
		
		
		//搜尋全部
		//中文收尋以縣市
	 public List<AttractionsBean> select_all(AreaBean bean) {
	 List<AttractionsBean> result = null;
	 if (bean != null && bean.getId() != 0) {
	 	result =attractionsDAO.select_area(bean.getId());
	 } else {
		 result = attractionsDAO.select();
	 }
	 return result;
	 }

		
	 	//新增
		public  AttractionsBean insert(AttractionsBean bean){
			AttractionsBean result =null;
			if(bean != null){
				result=attractionsDAO.insert(bean);
			}
			return result ;
		}
		
		
		
		//更新
		public  AttractionsBean update (AttractionsBean bean){
			AttractionsBean result =null;
			if(bean!=null){
				result=attractionsDAO.update(bean.getName(), bean.getAttractions_type(), bean.getOpeninghours(), bean.getIntroduction(), bean.getDistrict(), bean.getAttractions_address(), bean.getLat(), bean.getLng(), bean.getWebaddress(),bean.getId());
			}
			return result;
		}
		
		//以id刪除
		public  boolean delete(AttractionsBean bean){
			boolean result = false;
			if(bean!=null){
				result=attractionsDAO.delete(bean.getId());
			}
			return result;
		}
	 
	 
		public List<List> select_byDistract(int  id) {
			List<List> result =null ; 
			if(id!=0){
					result = attractionsDAO.select_byDistract(id);
				}
			return result;
		}
		

		public List<List> 	select_byAll() {
			List<List> result =null ; 
			result = attractionsDAO.select_byAll();
			return result;
		}
		
	
	/*-----------------------------  Attractions_img區    -----------------------------*/
		public List<Attractions_imgBean> select_by_attractions_id(Attractions_imgBean bean){
			List<Attractions_imgBean> result =null ;
			if(bean != null && bean.getAttractions_id() !=0){
				result=attractions_imgDAO.select_by_attractions_id(bean.getAttractions_id());
			}
			return result;
		}

		
		public  Attractions_imgBean select_photo(int attractions_id){
			Attractions_imgBean photo = attractions_imgDAO.select_photo(attractions_id);
			return photo;
		}

}