package cht.model.misc;

public class HQLStr {
	public static final String 
	FIRSTSTR ="Select h.hotelid, h.hotelname, h.typeid, h.phone, h.class_level, h.check_in, h.check_out, h.price_bed, h.years, h.address, h.language, h.description, h.note, h.lat, h.lng, h.tol_avg, h.total_comment, h.status From Hotel h join h.services hs  where hs.serviceid in ( ";
	
	public static final String
	LASTSTR =" group by h.hotelid, h.hotelname, h.typeid, h.phone, h.class_level, h.check_in, h.check_out, h.price_bed, h.years, h.address, h.language, h.description, h.note, h.lat, h.lng, h.tol_avg, h.total_comment, h.status having count(*) >= ";
	
	public String mixAddressService(String[] service){
		String serviceStr =" ";
		if(service!= null){
			for(int i=0;i<service.length-1;i++){
				serviceStr=serviceStr+service[i]+",";
			}
			serviceStr=serviceStr+service[service.length-1]+") and h.address like :address ";
			
			System.out.println(HQLStr.FIRSTSTR + serviceStr +HQLStr.LASTSTR + service.length);
		}
		return HQLStr.FIRSTSTR + serviceStr +HQLStr.LASTSTR + service.length;
	}
	
	public String mixNameService(String[] service){
		String serviceStr =" ";
		if(service!= null){
			for(int i=0;i<service.length-1;i++){
				serviceStr=serviceStr+service[i]+",";
			}
			serviceStr=serviceStr+service[service.length-1]+") and h.hotelname like :hotelname ";
		}
		return HQLStr.FIRSTSTR + serviceStr +HQLStr.LASTSTR + service.length;
	}
	
	public String mixAddressTypeService(String[] service){
		String serviceStr =" ";
		if(service!= null){
			for(int i=0;i<service.length-1;i++){
				serviceStr=serviceStr+service[i]+",";
			}
			serviceStr=serviceStr+service[service.length-1]+") and h.typeid = :typeid and h.address like :address ";
		}
		return HQLStr.FIRSTSTR + serviceStr +HQLStr.LASTSTR + service.length;
	}
	
	public String mixNameTypeService(String[] service){
		String serviceStr =" ";
		if(service!= null){
			for(int i=0;i<service.length-1;i++){
				serviceStr=serviceStr+service[i]+",";
			}
			serviceStr=serviceStr+service[service.length-1]+") and h.typeid = :typeid and h.hotelname like :hotelname ";
		}
		return HQLStr.FIRSTSTR + serviceStr +HQLStr.LASTSTR + service.length;
	}
	
}
