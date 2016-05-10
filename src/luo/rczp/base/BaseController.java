package luo.rczp.base;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public abstract class BaseController {
	
	Logger log = Logger.getLogger(BaseController.class);

	protected Date currentTime;
	
	public String getHostName() {
		//获取本机的主机名
		try{
			InetAddress addr = InetAddress.getLocalHost(); 
			return addr.getHostName();
		}catch(IOException e){
			return "";
		}
	}
	
	/**
	 * 获得当前时间
	 * 
	 * @return
	 */
	public Date getCurrentTime() {
		if (currentTime == null) {
			currentTime = new Date();
		}
		return currentTime;
	}
	
	public String decode(String value){
		String cval=null;
		if(value==null)
			return cval;
		if("".equals(value.trim()))
			return "";
		try{
			cval=java.net.URLDecoder.decode(value,"UTF-8");
			//System.out.println("[before]:"+value+"[after]:"+java.net.URLDecoder.decode(value,"UTF-8"));
		}catch(UnsupportedEncodingException e){
			cval=value;
		}
		return cval;
	}
	
	public String encode(String value){
		String cval=null;
		if(value==null)
			return cval;
		if("".equals(value.trim()))
			return "";
		try{
			//两次编码
			cval=java.net.URLEncoder.encode(value,"UTF-8");
		}catch(UnsupportedEncodingException e){
			cval=value;
		}
		//System.out.println("[before]:"+value+"[after]:"+java.net.URLEncoder.encode(value,"UTF-8"));
    	return cval;
	}
	
	/**
	 * 返回该日的最后时刻.
	 */
	protected Date dateEnd(Date date){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	        String time=sdf.format(date);  
			Calendar cd = Calendar.getInstance();
	        
	        try {
	            cd.setTime(sdf.parse(time));
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        cd.add(Calendar.DATE, 1);//增加一天
	        cd.add(Calendar.SECOND, -1);
	        return cd.getTime();
		}else{
			return null;
		}
	}
	
	/**
	 * 返回该日的开始时刻.
	 */
	protected Date dateStart(Date date){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	        String time=sdf.format(date);  
			Calendar cd = Calendar.getInstance();
	        
	        try {
	            cd.setTime(sdf.parse(time));
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	       
	        return cd.getTime();
		}else{
			return null;
		}
	}
	
	/**
	 * 返回增加天数后的日期
	 * @param date
	 * @param num
	 * @return
	 */
	protected Date dateAddDays(Date date,int num){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        String time=sdf.format(date);  
			Calendar cd = Calendar.getInstance();
	        
	        try {
	            cd.setTime(sdf.parse(time));
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        cd.add(Calendar.DATE, num);
	        return cd.getTime();
		}else{
			return null;
		}
	}
	
	protected String formatDate(Date date){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	        String d=sdf.format(date);  
			return d;
		}else{
			return null;
		}
	}
	
	protected String formatDate2(Date date){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
	        String d=sdf.format(date);  
			return d;
		}else{
			return null;
		}
	}
	
	protected String formatTime(Date date){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        String d=sdf.format(date);  
			return d;
		}else{
			return null;
		}
	}
	
	protected Date convertFromString(String sdate,String format){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(sdate);			
		} catch (ParseException e) {
			log.error("convertFromString ERROR!");
		}
		return date;
	}
	
	protected void setCookie(HttpServletResponse response, String cookieName, String cookieValue){
		Cookie newCookie = new Cookie(cookieName,cookieValue);     //创建一个Cookie  
		if(cookieValue==null)
			newCookie.setMaxAge(0);		//参数是0说明立即删除
		else
			newCookie.setMaxAge(-1);		//设置有效期为N秒
		
		//newCookie.setDomain("tbtianxia.com.cn");		
		//String domain = ConfigReader.getValue("domain", "taobao.com");
		//newCookie.setDomain(domain);
		newCookie.setPath("/");
		response.addCookie(newCookie);			//写入Cookie	
		
		//System.out.println("[set-cookie]"+cookieName+":"+cookieValue);
	}
	
}
