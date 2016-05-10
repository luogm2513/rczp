package luo.core.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class DateUtil {
//	private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
//	private SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
//	private SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm");
//	private SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy.MM.dd");
//	private SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static final String HHMM = "HHmm";

	/**
	 * 判断两个时间是否在同一天之内
	 * @param inputTime
	 * @param currentTime
	 * @return
	 */
	public static boolean isTheSameDay(long inputTime, long currentTime) {
		 Calendar c1 = Calendar.getInstance();  
	     Calendar c2 = Calendar.getInstance();  
	     c1.setTimeInMillis(inputTime * 1000);  
	     c2.setTimeInMillis(currentTime * 1000);
	     return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))  
	             && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))  
	             && (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));  
	}

	public static Date parseDate(String dateStr, String format) {
		Date res = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try{
			res = sdf.parse(dateStr);
		}catch(Exception e){
			res = new Date();
		}
		return res;
	}

	
	/**
	 * 转化为秒数
	 * @param currentTimeMillis
	 * @return
	 */
	public static Integer getTimeInSec(Date date) {
		return (int)(date.getTime()/1000);
	}

	/**
	 * 获取一天开始的秒数
	 * @param date
	 * @return
	 */
	public static long getStartTime(Date date) {
		Calendar today = Calendar.getInstance();
        today.setTimeInMillis(date.getTime());
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        long beginTime = today.getTimeInMillis() / 1000;
        return beginTime;
	}

	/**
	 * 获取一天结束的秒数
	 * @param date
	 * @return
	 */
	public static long getEndTime(Date date) {
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(date.getTime());
		today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        long endTime = today.getTimeInMillis() / 1000;
        return endTime;
	}

	/**
	 * 秒数转化为时间
	 * @param consignTime
	 * @return
	 */
	public static String getSecToDate(Integer time) {

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(null == time){
			return sdf1.format(new Date());
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time.longValue() * 1000);
		Date date = cal.getTime();
		return sdf1.format(date);
	}
	
	/**
	 * 秒数转化为时间
	 * @param consignTime
	 * @return
	 */
	public static Date getSecInDate(Integer time) {
		if(null == time){
			return new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time.longValue() * 1000);
		Date date = cal.getTime();
		return date;
	}

	/**
	 * parser date
	 * @param beginDayStr
	 * @return
	 */
	public static Date parseDateStr(String dayStr) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		if(StringUtils.isEmpty(dayStr)){
			return new Date();
		}
		try {
			return sdf2.parse(dayStr);
		} catch (ParseException e) {
			return new Date();
		}
	}

	/**
	 * 获取上个月最后一天
	 * @param date
	 * @return
	 */
	public static int getLastDayOfPreviousMonth(Date date) {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		return Integer.parseInt(sdf3.format(cal.getTime()));
	}
	
	/**
	 * 获取上个月第一天
	 * @param date
	 * @return
	 */
	public static int getFirstDayOfPreviousMonth(Date date) {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		return Integer.parseInt(sdf3.format(cal.getTime()));
	}

	/**
	 * 获得本月最后一天
	 * @param date
	 * @return
	 */
	public static int getLastDayOfThisMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);//设为当前月的1号
		cal.add(Calendar.MONTH, 1);//加一个月，变为下月的1号
		cal.add(Calendar.DATE, -1);//减去一天，变为当月最后一天

		return Integer.parseInt(DateUtil.formatDate(cal.getTime(), "yyyyMMdd"));
	}

	/**
	 * 获得本月第一天
	 * @param date
	 * @return
	 */
	public static int getFirstDayOfThisMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);//设为当前月的1号

		return Integer.parseInt(DateUtil.formatDate(cal.getTime(), "yyyyMMdd"));
	}
	
	/**
	 * 获得本月第一天
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfThisMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);//设为当前月的1号
		return cal.getTime();
	}

	/**
	 * 获得本月最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfThisMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);//设为当前月的1号
		cal.add(Calendar.MONTH, 1);//加一个月，变为下月的1号
		cal.add(Calendar.DATE, -1);//减去一天，变为当月最后一天
		return cal.getTime();
	}
	
	/**
	 * 获取相对于指定时间
	 * @param endDay
	 * @param month
	 * @param i
	 * @return
	 */
	public static Date getRelativeDate(Date date, int field, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, add);
		return cal.getTime();
	}

	public static Date getRelativeDate2(Date date, int field, int add) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int abs = Math.abs(add);
		if(add == 0){
			return date;
		}else if(add > 0){
			for(int i=0; i<abs;){
				cal.add(field, 1);
				Date d = cal.getTime();
//				if(StockUtil.isWorkingTime(d)){
				if(true){
					i++;
				}else{
					continue;
				}
			}
		}else{
			for(int i=0; i<abs;){
				cal.add(field, -1);
				Date d = cal.getTime();
//				if(StockUtil.isWorkingTime(d)){
				if(true){
					i++;
				}else{
					continue;
				}
			}
		}
		return cal.getTime();
	}

	/**
	 * 检测连个时间间隔是否大于三个月
	 * @param beginDay
	 * @param endDay
	 * @return
	 */
	public static boolean isValid(Date beginDay, Date endDay) {
		long s = beginDay.getTime();
		long e = endDay.getTime();
		
		if(!(e > s)){
			return true;
		}
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.setTime(beginDay);
		cal2.setTime(endDay);
		
		cal2.add(Calendar.MONTH, -1);
		cal2.add(Calendar.DAY_OF_YEAR, -1);
		
		if(!cal2.after(cal1)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 获取指定日期至今的天数
	 * @param totalIncomeRatio
	 * @return
	 */
	public static long getBetweenDays(Date date) {
		long s = date.getTime();
		long e = new Date().getTime();
		long days = (e - s) / (24 * 60 * 60 * 1000);
		return days;
	}

	/**
	 * 获取时间(HH:mm)
	 * @param turnoverTime
	 * @return
	 */
	public static String getTime(Integer time) {
		SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time.longValue() * 1000);
		Date date = cal.getTime();
		return sdf4.format(date);
	}
	
	/**
	 * 获取时间(HH:mm)
	 * @param turnoverTime
	 * @return
	 */
	public static String getDateTime(int time) {
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis((long)time * 1000);
		Date date = cal.getTime();
		return sdf4.format(date);
	}

	/**
	 * 获取指定日期的开盘时间
	 * @param exrightDayStr
	 * @return
	 * @throws ParseException 
	 */
	public static long getOpenTime(String dayStr) {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date date = null;
		try {
			date = sdf3.parse(dayStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 9);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.SECOND, 0);
		return cal.getTimeInMillis();
	}

	/**
	 * 获取本周最后一天的日期(20110808)
	 * @param date
	 * @return
	 */
	public static int getLastDayThisWeek(Date date) {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.add(Calendar.DAY_OF_WEEK, 1);
		return Integer.parseInt(sdf3.format(cal.getTime()));
	}
	
	/**
	 * 获取本周第一天的日期(20110808)
	 * @param date
	 * @return
	 */
	public static int getFirstDayThisWeek(Date date) {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return Integer.parseInt(sdf3.format(cal.getTime()));
	}
	
	/**
	 * 获取本周第一天的日期 Date
	 * @param date
	 * @return
	 */
	public static Date getFirstDateThisWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	
	/**
	 * 获取本周最后一天的日期 Date
	 * @param date
	 * @return
	 */
	public static Date getLastDateThisWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.add(Calendar.DAY_OF_WEEK, 1);
		return cal.getTime();
	}
	
	/**
	 * 获取上周最后一天的日期(20110808)
	 * @param date
	 * @return
	 */
	public static int getLastDayLastWeek(Date date) {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.add(Calendar.DAY_OF_WEEK, 1);
		return Integer.parseInt(sdf3.format(cal.getTime()));
	}
	
	/**
	 * 获取上周第一天的日期(20110808)
	 * @param date
	 * @return
	 */
	public static int getFirstDayLastWeek(Date date) {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return Integer.parseInt(sdf3.format(cal.getTime()));
	}

	public static String formatDate(Date date, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String res = sdf.format(date);
		return res;
	}
	
	/**
	 * 获取距离多长时间,格式为xx天xx小时xx分
	 * @param time
	 * @param expireTime
	 * @return
	 */
	public static String getRemainTime(int time, int expireTime) {
		String res = "";
		if(time > expireTime){
			res = "已过期";
		}else{
			int interval = expireTime - time;
			//计算差多少天
			int day = interval / (24 * 60 * 60);
			if(day >= 0){
				res = res + day + "天";
				interval = interval - day * 24 * 60 * 60;
			}
			//计算差多少小时
			int hour = interval / (60 * 60);
			if(hour >= 0){
				res = res + hour + "小时";
				interval = interval - hour * 60 * 60;
			}
			//计算差多少分钟
			int minute = interval / 60;
			if(minute >= 0){
				res = res + minute + "分";
			}
			//计算还差多少秒
			if(day == 0 && hour == 0 && minute == 0){
				return interval + "秒";
			}
		}
		return res;
	}
	
	/***
	 * 获得当前时间int类型 格式：yyyyMMdd
	 * @return
	 */
	public static Integer getNow_yyyyMMdd(){
		String s = formatDate(new Date(), "yyyyMMdd");
		return Integer.valueOf(s);
	}
	
	public static String getNowDate(){
		String s = formatDate(new Date(), "yyyy-MM-dd");
		return s;
	}
	
	public static String getNowTime(){
		String s = formatDate(new Date(), "yyyy-MM-dd HH:mm ss");
		return s;
	}
	
	/**
	 * 通过分时数据的 priceVolume数组点，来计算 分时数据对应的时间
	 * @param i
	 * @return
	 */
	public static short getTrendTime(int i){
		int result = 0;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 9);
		cal.set(Calendar.MINUTE, 30);
		if(i > 120){
			cal.set(Calendar.HOUR_OF_DAY, 13);
			cal.set(Calendar.MINUTE, 0);
			i = i - 120;
		}
		cal.add(Calendar.MINUTE, i);
		SimpleDateFormat sdf = new SimpleDateFormat(HHMM);
		result = new Integer(sdf.format(cal.getTime()));
		return (short)result;
	}
	
	/**
	 * 获取当前时间的秒数
	 * @return
	 */
	public static int getIntSecondsNow(){
		Calendar cal = Calendar.getInstance();
		int seconds = (int)(cal.getTimeInMillis()/1000);
		return seconds;
	}
	
	/**
	 * 获取秒时间int型
	 * @param date
	 * @return
	 */
	public static int dateToSecondsInt(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long millis = cal.getTimeInMillis();
		int seconds = (new Long(millis / 1000)).intValue();//毫秒转换成秒
		return seconds;
	}
	
	/**
	 * 秒转毫秒
	 * @param time
	 * @return
	 */
	public static long secondsIntToLong(int time) {
		return (new Integer(time)).longValue() * 1000;//秒转换成毫秒
	}
	
	public static long parseDateToLong(Date date){
		String ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return parseStringToLong(ss);
	}
	/**
	 * 秒数转时间对象
	 * @param time
	 * @return
	 */
	public static Date secondsIntToDate(int time) {
		return new Date(secondsIntToLong(time));
	}
	
	/**
	 * 判断一个时间点是否是昨天
	 * @param check
	 * @param date
	 * @return
	 */
	public static boolean beferDate(long check,Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		long t = cal.getTimeInMillis();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t)));
		return check<=t;
	}
	
	public static String getNowString(){
		return dateToString(new Date(),"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取当前时间的格式化后字符串
	 * yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date){
		return dateToString(date,"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 格式化时间
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static String longToString(long in){
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(in*1000)).toString();
	}
	
	public static String intToString(int time,String formate){
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		Date date = new Date((long)time*(long)1000);
		return sdf.format(date);
	}
	
	public static String longToString(long in,String format){
		return (new SimpleDateFormat(format).format(in*1000)).toString();
	}
	/**
	 * 格式化时间 2 Timestamp
	 * @param time
	 * @param format
	 * @return Timestamp
	 * @throws Exception
	 */
	public static Timestamp stringToTimestamp(String time, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return new Timestamp(sdf.parse(time).getTime());
	}

	public static int getPreHSecondInt(int perHour) {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (hour >= perHour) {
			cal.set(Calendar.HOUR_OF_DAY, hour - perHour);
		} else {
			cal.set(Calendar.HOUR_OF_DAY, 24 - perHour);
			cal.set(Calendar.DAY_OF_MONTH, day - 1);
		}
		return dateToSecondsInt(cal.getTime());
	}
	/**
	 * 字符串时间转成秒数
	 * 2010-01-01 --->121231212
	 * @param pattern
	 * @return
	 */
	public static long getDateTime(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date dateTime = null;
		try {
			dateTime = dateFormat.parse(dateFormat.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTime.getTime() / 1000;
	}

	/**
	 * 获得当前日期的本周周一
	 * @return
	 */
	public static long getCurrentMonday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date modayDate = null;
		try {
			modayDate = dateFormat.parse(dateFormat.format(monday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return modayDate.getTime() / 1000;
	}

	/**
	 * 获得当前日期与本周一相差的天数
	 * @return
	 */
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}

	/**
	 * 获得指定格式日期串
	 * @param pattern
	 * @param dateTime
	 * @return
	 */
   public static int getDateTime(String pattern, String dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return (int)sdf.parse(dateTime).getTime()/1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * (获取第几天前的时间)
	 * @param days
	 * @return
	 */
	public static Date previous(int days) {
		return new Date(System.currentTimeMillis() - days * 3600000L * 24L);
	}
	
	/**
	 * 获取几天前的时间(秒数)
	 * @param days
	 * @return
	 */
	public static int previousSecond(int days){
		Calendar calendar = Calendar.getInstance();
		return (int)(calendar.getTimeInMillis()/1000) - days * 3600 * 24;
	}
	
	public static long strTimeToLinux(String time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date modayDate = null;
		try {
			modayDate = dateFormat.parse(time);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return modayDate.getTime() / 1000;
	}

	/**
	 *method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
	 *@param dateString 需要转换为timestamp的字符串 BigDecimal
	 *@return dataTime timestamp
	 */
	public static java.sql.Timestamp big2Timestamp(BigDecimal tm) {
		Date date = new Date(tm.longValue());
		return new java.sql.Timestamp(date.getTime());
	}
	/**
	 * 字符串转Timestamp
	 * @param dateString
	 * @return
	 */
	public static java.sql.Timestamp string2Time(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设定格式
		java.util.Date timeDate = new Date();
		try {
			timeDate = dateFormat.parse(dateString);//util类型
		} catch (Exception ex) {

		}
		java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}
	/**
	 * 字符串转long型时间
	 * @param str
	 * @return
	 */
	public static long parseStringToLong(String str) {
		Date date = null;
		long datelong = 0;
		Locale.setDefault(new Locale("zh","CN"));
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		try {
			date = dateFormat.parse(str);
			datelong = date.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datelong/1000;
	}
	
	/**
	 * 处理发布时间
	 * @param time
	 * @return
	 */
	public static String parseDisplayTime(Date date){
		int time = DateUtil.dateToSecondsInt(date);
		String res = "2秒前";
		Calendar cal = Calendar.getInstance();
		Date nowDate = new Date(System.currentTimeMillis());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nmonth = cal.get(Calendar.MONTH);
		int nday = cal.get(Calendar.DAY_OF_MONTH);
		int nhour = cal.get(Calendar.HOUR_OF_DAY);
		int nminute = cal.get(Calendar.MINUTE);

		if(year != nyear){return DateUtil.dateToString(date, "yyyy-MM-dd HH:mm");}
		else if(month == nmonth){
			if(day == nday){
				if((hour - nhour) == 0){
					if((minute - nminute) == 0){
						int nowTime = DateUtil.dateToSecondsInt(nowDate);
						int rangTime = nowTime-time;
						if( rangTime <= 0 ){
						}
						else if( rangTime < 60 ){
							res = rangTime + "秒前";
						}
					}else{
						res = (minute - nminute)+"分钟前";
					}
				}else if((hour - nhour) < 0){
					res = DateUtil.dateToString(date, "MM-dd HH:mm");
				}else{
					int nowTime = DateUtil.dateToSecondsInt(nowDate);
					int rangTime = nowTime-time;
					if(rangTime/60 == 0){
						res = rangTime + "秒前";
					}else if(rangTime/(60*60) == 0){
						res = rangTime/(60)+"分钟前";
					}else if(rangTime/(60*60*60) == 0){
						res = rangTime/(60*60)+"小时前";
					}else{
						res = DateUtil.dateToString(date, "MM-dd HH:mm");
					}
				}
			}else if((day-nday) == 1){
				res = "昨天 "+DateUtil.dateToString(date, "HH:mm");
			}else if((day-nday) == 2){
				res = "前天 "+DateUtil.dateToString(date, "HH:mm");
			}else{
				res = DateUtil.dateToString(date, "MM-dd HH:mm");
			}
		}else{
			res = DateUtil.dateToString(date, "MM-dd HH:mm");
		}
		return res;
	}
	
	/**
	 * 处理发布时间
	 * @param time
	 * @return
	 */
	public static String parsePostTime(int time){
		String res = "2秒前";
		Date date = DateUtil.secondsIntToDate(time);
		Calendar cal = Calendar.getInstance();
		Date nowDate = new Date(System.currentTimeMillis());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nmonth = cal.get(Calendar.MONTH);
		int nday = cal.get(Calendar.DAY_OF_MONTH);
		int nhour = cal.get(Calendar.HOUR_OF_DAY);
		int nminute = cal.get(Calendar.MINUTE);

		if(year != nyear){return DateUtil.dateToString(date, "yyyy-MM-dd HH:mm");}
		else if(month == nmonth){
			if(day == nday){
				if((hour - nhour) == 0){
					if((minute - nminute) == 0){
						int nowTime = DateUtil.dateToSecondsInt(nowDate);
						int rangTime = nowTime-time;
						if( rangTime <= 0 ){
						}
						else if( rangTime < 60 ){
							res = rangTime + "秒前";
						}
					}else{
						res = (minute - nminute)+"分钟前";
					}
				}else if((hour - nhour) < 0){
					res = DateUtil.dateToString(date, "MM-dd HH:mm");
				}else{
					int nowTime = DateUtil.dateToSecondsInt(nowDate);
					int rangTime = nowTime-time;
					if(rangTime/60 == 0){
						res = rangTime + "秒前";
					}else if(rangTime/(60*60) == 0){
						res = rangTime/(60)+"分钟前";
					}else if(rangTime/(60*60*60) == 0){
						res = rangTime/(60*60)+"小时前";
					}else{
						res = DateUtil.dateToString(date, "MM-dd HH:mm");
					}
				}
			}else if((day-nday) == 1){
				res = "昨天 "+DateUtil.dateToString(date, "HH:mm");
			}else if((day-nday) == 2){
				res = "前天 "+DateUtil.dateToString(date, "HH:mm");
			}else{
				res = DateUtil.dateToString(date, "MM-dd HH:mm");
			}
		}else{
			res = DateUtil.dateToString(date, "MM-dd HH:mm");
		}
		return res;
	}
	
	/**
	 * 处理发布时间
	 * @param time
	 * @return
	 */
	public static String parsePostTime(int time,String format){
		String res = "刚才";
		Date date = DateUtil.secondsIntToDate(time);
		Calendar cal = Calendar.getInstance();
		Date nowDate = new Date(System.currentTimeMillis());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nmonth = cal.get(Calendar.MONTH);
		int nday = cal.get(Calendar.DAY_OF_MONTH);
		int nhour = cal.get(Calendar.HOUR_OF_DAY);
		int nminute = cal.get(Calendar.MINUTE);

		if(year != nyear){return DateUtil.dateToString(date, format);}
		else if(month == nmonth){
			if(day == nday){
				if((hour - nhour) == 0){
					if((minute - nminute) == 0){
					}else{
						res = (minute - nminute)+"分钟前";
					}
				}else if((hour - nhour) < 0){
					res = DateUtil.dateToString(date, format);
				}else{
					int nowTime = DateUtil.dateToSecondsInt(nowDate);
					int rangTime = nowTime-time;
					if(rangTime/60 == 0){
						res = "刚才";
					}else if(rangTime/(60*60) == 0){
						res = rangTime/(60)+"分钟前";
					}else if(rangTime/(60*60*60) == 0){
						res = rangTime/(60*60)+"小时前";
					}else{
						res = DateUtil.dateToString(date, format);
					}
				}
			}else if((day-nday) == 1){
				res = "昨天 "+DateUtil.dateToString(date, "HH:mm");
			}else if((day-nday) == 2){
				res = "前天 "+DateUtil.dateToString(date, "HH:mm");
			}else{
				res = DateUtil.dateToString(date, format);
			}
		}else{
			res = DateUtil.dateToString(date, format);
		}
		
		return res;
	}
	
	/**
	 * 处理发布时间
	 * @param time
	 * @return
	 */
	public static String parsePostTime2(int time){
		String res = "2秒前";
		Date date = DateUtil.secondsIntToDate(time);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);

		if(year != nyear){
			return DateUtil.dateToString(date, "yyyy-MM-dd");
		}else{
			res = DateUtil.dateToString(date, "MM-dd");
		}
		return res;
	}
	
	public static String seconds2Str(int time){
		String res = "2秒前";
		Date date = DateUtil.secondsIntToDate(time);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nmonth = cal.get(Calendar.MONTH);
		int nday = cal.get(Calendar.DAY_OF_MONTH);

		if(year != nyear){res = DateUtil.dateToString(date, "yyyy-MM-dd HH:mm");}
		else if(month == nmonth){
			if(day == nday){
				res = "今天  "+DateUtil.dateToString(date, "HH:mm");
			}else if((day-nday) == 1){
				res = "昨天  "+DateUtil.dateToString(date, "HH:mm");
			}else if((day-nday) == 2){
				res = "前天  "+DateUtil.dateToString(date, "HH:mm");
			}else{
				res = DateUtil.dateToString(date, "MM-dd HH:mm");
			}
		}else{
			res = DateUtil.dateToString(date, "MM-dd HH:mm");
		}
		
		return res;
	}
	
	public static String seconds2Str2(int time){
		String res = "2秒前";
		Date date = DateUtil.secondsIntToDate(time);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nmonth = cal.get(Calendar.MONTH);
		int nday = cal.get(Calendar.DAY_OF_MONTH);

		if(year != nyear){res = DateUtil.dateToString(date, "yyyy");}
		else if(month == nmonth){
			if(day == nday){
				res = DateUtil.dateToString(date, "HH:mm");
			}else if((day-nday) == 1){
				res = "昨天 ";
			}else if((day-nday) == 2){
				res = "前天 ";
			}else{
				res = DateUtil.dateToString(date, "MM-dd");
			}
		}else{
			res = DateUtil.dateToString(date, "MM-dd");
		}
		
		return res;
	}
	
	public static String seconds2StrDay(int ntime){
		String res = "今天";
		Date date = DateUtil.secondsIntToDate(ntime);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nday = cal.get(Calendar.DAY_OF_YEAR);
		
		int difday = day - nday;
		int difmonth = difday/30;

		if(year > nyear){
			int time = dateToSecondsInt(new Date());
			int dif = time-ntime;
			int difday1 = dif/(60*60*24);
			int difyear = difday1/365;
			if(difyear >=1){
				res = difyear+"年前";
			}else{
				if(difday1 >= 30){
					res = "1月前";
				}else if(difday1 >= 2){
					res = difday1+"天前";
				}else if(difday1 == 1){
					res = "昨天";
				}else if(difday1 == 0){
					if(day != nday)res="昨天";
				}
			}
		}else if(difmonth > 0){
			res = difmonth+"月前";
		}else if(difday >= 2){
			res = difday+"天前";
		}else if(difday == 1){
			res = "昨天";
		}
		return res;
//		String res = "今天";
//		int ntime = dateToSecondsInt(new Date());
//		int dif = ntime-time;
//		int difday = dif/(60*60*24);
//		if(difday >= 365){
//			int difyear = difday/365;
//			if(difyear >=1)res = difyear+"年前";
//			else res = "1年前";
//		}else if(difday >= 30){
//			res = "1月前";
//		}else if(difday >= 2){
//			res = difday+"天前";
//		}else if(difday == 1){
//			res = "昨天前";
//		}
//		return res;
	}
	
	public static int getTodayStart(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND, 0);
		return dateToSecondsInt(cal.getTime());
	}
	
	/**
	 * 获取一个int型时间的当天的时间开始值
	 * @param issueTime
	 * @return
	 */
	public static int getDayStartWithIntTime(int issueTime) {
		Date date = DateUtil.secondsIntToDate(issueTime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		return (int)(cal.getTimeInMillis()/1000);
	}
	
	public static int date2secondInt(Date date){
		if(date == null)
			date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return new Long(cal.getTimeInMillis()/1000).intValue();
	}
	
	public static boolean isToday(int time){
		Date date = DateUtil.secondsIntToDate(time);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nmonth = cal.get(Calendar.MONTH);
		int nday = cal.get(Calendar.DAY_OF_MONTH);
		if(year==nyear&&month==nmonth&&day==nday) return true;
		else return false;
	}

	public static Long date2Long(Date date,String format){
		if(date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(date);
		return new Long(dateStr);
	}
	

	/**
	 * 计算连续登录日数 若连续登录返回1 ,若为同日放回0, 若不是连续返回-1
	 * @param lastTime
	 * @return
	 */
	public static Integer getLoginDay(Integer lastTime){
		if(lastTime==null) return 1;
		
		Date date = DateUtil.secondsIntToDate(lastTime);
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(date);
		int nyear = cal.get(Calendar.YEAR);
		int nmonth = cal.get(Calendar.MONTH);
		int nday = cal.get(Calendar.DAY_OF_MONTH);
		if(year==nyear&&month==nmonth){
			if(day-nday==1) return 1;
			if(day-nday==0) return 0;
			if(day-nday>1) return -1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//System.out.println(new Date());
		//System.out.println(previous(1));
		//System.out.println(big2Timestamp(new BigDecimal(1283140231433L)));
		//System.out.println(dateToString(1283140230980L / 1000));
		//System.out.println(1283140230980L / 1000);
		//System.out.println(new Date((Integer.MAX_VALUE*1000L)));
		//String holidayPath = ValidateCodeService.class.getResource("../../../../com").getPath();
		//File file = new File(holidayPath);
		//System.out.println(new Date(file.lastModified()));
//		boolean b = beferDate(System.currentTimeMillis(),new Date());
		System.out.println(100*1000000000000L);
		System.out.println(seconds2Str(1312362970));
	}
}