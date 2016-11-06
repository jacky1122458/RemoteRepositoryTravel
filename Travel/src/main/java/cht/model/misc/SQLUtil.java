package cht.model.misc;

public class SQLUtil {
	static String conditionStr="";
	
	public static String getName_ServiceSql(String[] service){
		conditionStr=" h.name like ? and ";
		return getServiceStr(service);
	}
	public static String getAddr_ServiceSql(String[] service){
		conditionStr=" h.address like ? and ";
		return getServiceStr(service);
	}
	public static String getNameType_ServiceSql(String[] service){
		conditionStr=" typeid=? and h.name like ? and ";
		return getServiceStr(service);
	}
	public static String getAddrType_ServiceSql(String[] service){
		conditionStr=" typeid=? and h.address like ? and ";
		return getServiceStr(service);
	}
	
	public static String getServiceStr(String[] service){
		String serviceStr = " ";
		if(service.length !=0 && service!= null){
			serviceStr="serviceid in(";
			for(int i=0;i<service.length-1;i++){
				serviceStr=serviceStr+service[i]+" ,";
			}
			serviceStr=serviceStr+service[service.length-1]+") ";
		}
		String sqlstr="SELECT h.hotelid ,h.name ,h.phone,h.class_level,h.check_in,h.check_out,h.price_bed,h.years,h.address,h.lng,h.lat,h.language,h.note,h.tol_avg,h.total_comment,h.typeid,h.status "  
				+"FROM hotelservice hs join (SELECT distinct h.* FROM hotel h JOIN room r ON h.hotelid = r.hotelid WHERE h.status=1 and peoplenum >= ?  and number>= ? ) h "
				+"ON hs.hotelid = h.hotelid "
				+"WHERE"+ conditionStr + serviceStr
				+"GROUP BY h.hotelid ,h.name ,h.phone,h.class_level,h.check_in,h.check_out,h.price_bed,h.years,h.address,h.lng,h.lat,h.language,h.note,h.tol_avg,h.total_comment,h.typeid,h.status " 
				+"having count(*)>="+service.length ;
;
		return sqlstr;
	}
	public static void main(String[] args){
		String[] service={"2","3"};
		//String serviceStr=MyUtil.getServiceStr(service);
		//String sql=SQLUtil.getName_ServiceSql(service);
		//String sql=SQLUtil.getAddr_ServiceSql(service);
		//String sql=SQLUtil.getNameType_ServiceSql(service);
		String sql=SQLUtil.getAddrType_ServiceSql(service);
		System.out.println(sql);
	} 
}
