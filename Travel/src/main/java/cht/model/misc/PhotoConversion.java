package cht.model.misc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import cht.model.HotelPhoto;
import cht.model.dao.HotelPhotoDAOHibernate;

public class PhotoConversion {
	
	public void changePhoto(byte[] imagedata,String name){
		FileOutputStream fos =null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("C:/image/xx"+name);
			bos = new BufferedOutputStream(fos);
			bos.write(imagedata, 0, imagedata.length);
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null){ bos.close();}
				if(fos!=null){ fos.close();}
			} catch (Exception e) { e.printStackTrace();}
		}
	}
	
	public byte[] changeByte(String path){
		FileInputStream fis =null;
		BufferedInputStream bis =null;
		File file = null;
		
		file = new File(path);
		byte[] imageData = new byte [(int)file.length()];
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);

			while (bis.available() > 0) {
				bis.read(imageData); 
			}
			
			if(imageData.length!= 0){
				return imageData;
			}
			
			} catch (Exception e) { 
				e.printStackTrace();
			} finally{
				try {
					if(bis!=null){ bis.close();}
					if(fis!=null){ fis.close();}
				} catch (IOException e) { e.printStackTrace();}
			}
		return null;
	}
	
	public static void main(String[] args){
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			HotelPhoto bean = new HotelPhotoDAOHibernate(HibernateUtil.getSessionFactory()).select(3);
			new PhotoConversion().changePhoto(bean.getPhoto(), bean.getDescription());
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	
}
