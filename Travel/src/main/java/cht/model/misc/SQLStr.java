package cht.model.misc;

public final class SQLStr {
	
	public static final String CHECK ="select number,roomid,yearday,room_numbers from(select *,row_number() over(partition by roomid order by room_numbers)ran from year_rooms  where roomid= ? and yearday BETWEEN ? and ?) res where ran=1";
	
	
	public static final String ADDRESS = "select res.* from(select h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype ,"
			+ " row_number() over(partition by h.hotelid order by peoplenum,price)ran"
			+ " from hotel h join room r on h.hotelid = r.hotelid and h.address like :address and r.peoplenum>= :peoplenum and h.status=1"
			+ " join year_rooms yr on r.roomid = yr.roomid and yr.yearday BETWEEN :chick_in and :chick_out and yr.room_numbers>= :roomnum"
			+ " Group by h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype"
			+ " having count(*)=DATEDIFF(day ,:dayin,:dayout)+1 ) res where ran=1";
	
	public static final String ADDRESS_TYPE = "select res.* from(select h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype ,"
			+ " row_number() over(partition by h.hotelid order by peoplenum,price)ran"
			+ " from hotel h join room r on h.hotelid = r.hotelid and h.address like :address and typeid= :typeid and r.peoplenum>= :peoplenum and h.status=1"
			+ " join year_rooms yr on r.roomid = yr.roomid and yr.yearday BETWEEN :chick_in and :chick_out and yr.room_numbers>= :roomnum"
			+ " Group by h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype"
			+ " having count(*)=DATEDIFF(day ,:dayin,:dayout)+1 ) res where ran=1";
	
	
	public static final String NAME = "select res.* from(select h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype ,"
			+ " row_number() over(partition by h.hotelid order by peoplenum,price)ran"
			+ " from hotel h join room r on h.hotelid = r.hotelid and hotelname like :name and r.peoplenum>= :peoplenum and h.status=1"
			+ " join year_rooms yr on r.roomid = yr.roomid and yr.yearday BETWEEN :chick_in and :chick_out and yr.room_numbers>= :roomnum"
			+ " Group by h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype"
			+ " having count(*)=DATEDIFF(day ,:dayin,:dayout)+1 ) res where ran=1";
	
	public static final String NAME_TYPE = "select res.* from(select h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype ,"
			+ " row_number() over(partition by h.hotelid order by peoplenum,price)ran"
			+ " from hotel h join room r on h.hotelid = r.hotelid and hotelname like :name and typeid= :typeid and r.peoplenum>= :peoplenum and h.status=1"
			+ " join year_rooms yr on r.roomid = yr.roomid and yr.yearday BETWEEN :chick_in and :chick_out and yr.room_numbers>= :roomnum"
			+ " Group by h.hotelid,h.hotelname,h.class_level,h.address,h.lat,h.lng,h.tol_avg,h.total_comment,r.roomid,r.roomname,r.price,r.weekdayrate,r.peoplenum,r.bedtype"
			+ " having count(*)=DATEDIFF(day ,:dayin,:dayout)+1 ) res where ran=1";
	//price
	public String mixPrice(String str, int pricetype){
		String first = str.substring(0, str.lastIndexOf("join"));
		String last = str.substring(str.lastIndexOf("join"),str.length());
		String pricestr = this.getPriceStr(pricetype);
		
		System.out.println("SQLStr().PriceStr: "+pricestr);
		return first+pricestr+last;
		
	}
	
	
	public String mixService(String str, String[] service){
		String first = str.substring(0, str.lastIndexOf("join"));
		String last = str.substring(str.lastIndexOf("join"),str.length());
		String servicestr = this.getServiceStr(service); 
		
		System.out.println("SQLStr().ServiceStr: "+servicestr);
		return first+servicestr+last;
	}
	public String mixFacilities(String str, String[] facilities){
		String first = str.substring(0, str.lastIndexOf("join"));
		String last = str.substring(str.lastIndexOf("join"),str.length());
		String facilitiesStr = this.getFacilitiesStr(facilities); 
		
		System.out.println("SQLStr().facilitiesStr: "+facilitiesStr);
		return first+facilitiesStr+last;
	}
	//price
	public String mixService(String str, int pricetype, String[] service){
		String first = str.substring(0, str.lastIndexOf("join"));
		String last = str.substring(str.lastIndexOf("join"),str.length());
		String pricestr = this.getPriceStr(pricetype);
		String servicestr = this.getServiceStr(service);
		
		System.out.println("SQLStr().mix: "+pricestr+servicestr);
		return first+pricestr+servicestr+last;
	}
	//price
	public String mixFacilities(String str, int pricetype, String[] facilities){
		String first = str.substring(0, str.lastIndexOf("join"));
		String last = str.substring(str.lastIndexOf("join"),str.length());
		String pricestr = this.getPriceStr(pricetype);
		String facilitiesStr = this.getFacilitiesStr(facilities); 
		
		System.out.println("SQLStr().mix: "+pricestr+facilitiesStr);
		return first+pricestr+facilitiesStr+last;
	}
	
	public String mix(String str, String[] service, String[] facilities){
		String first = str.substring(0, str.lastIndexOf("join"));
		String last = str.substring(str.lastIndexOf("join"),str.length());
		String servicestr = this.getServiceStr(service); 
		String facilitiesStr = this.getFacilitiesStr(facilities); 
		System.out.println("SQLStr().mix: "+servicestr+facilitiesStr);
		return first+servicestr+facilitiesStr+last;
	}
	
	public String mix(String str, int pricetype, String[] service, String[] facilities){
		String first = str.substring(0, str.lastIndexOf("join"));
		String last = str.substring(str.lastIndexOf("join"),str.length());
		String pricestr = this.getPriceStr(pricetype);
		String servicestr = this.getServiceStr(service); 
		String facilitiesStr = this.getFacilitiesStr(facilities); 
		
		System.out.println("SQLStr().mix: "+pricestr+servicestr+facilitiesStr);
		return first+pricestr+servicestr+facilitiesStr+last;
	}
	
	public String getPriceStr(int pricetype){
		String priceStr =" ";
		if(pricetype==1){
			priceStr = "and price < 1700 ";
		}else if(pricetype==2){
			priceStr = "and price BETWEEN 1700 and 3400 ";
		}else if(pricetype==3){
			priceStr = "and price BETWEEN 3400 and 5200 ";
		}else if(pricetype==4){
			priceStr = "and price > 5200 ";
		}
		return priceStr;
	}
	
	public String getServiceStr(String[] service){
		String serviceStr =" ";
		if(service!= null){
			//serviceStr="where serviceid in (";
			serviceStr ="and h.hotelid in(select hotelid from hotelservice where serviceid in (";
			for(int i=0;i<service.length-1;i++){
				serviceStr=serviceStr+service[i]+",";
			}
			serviceStr=serviceStr+service[service.length-1]+") ";
		}
//		String Str =" join (select hotelid from hotelservice "
//				+ serviceStr
//				+ "group by hotelid having count(*)>="+service.length+") hs on h.hotelid = hs.hotelid ";
		String Str =serviceStr+"group by hotelid having count(*)>="+service.length+")" ;
		return Str;
	}
	
	public String getFacilitiesStr(String[] facilities){
		String facilitiesStr =" ";
		if(facilities!= null){
//			facilitiesStr="where facilitieid in (";
			facilitiesStr ="and r.roomid in(select roomid from roomfacilities where facilitieid in (";
			for(int i=0;i<facilities.length-1;i++){
				facilitiesStr=facilitiesStr+facilities[i]+",";
			}
			facilitiesStr=facilitiesStr+facilities[facilities.length-1]+") ";
		}
//		String Str =" join (select roomid from roomfacilities "
//				+ facilitiesStr
//				+ "group by roomid having count(*)>="+facilities.length+") rf on r.roomid = rf.roomid ";
		String Str =facilitiesStr+"group by roomid having count(*)>="+facilities.length+")" ;
		return Str;
	}
	
	public static void main(String args[]){
		SQLStr ss = new SQLStr();
		String[] service= {"1","2"};
		String[] facilities= {"1","2"};
		System.out.println(ss.getFacilitiesStr(facilities));
		//String SQLstr = ss.mixService(SQLStr.ADDRESS, service);
		//System.out.println(SQLstr);
	}
}
