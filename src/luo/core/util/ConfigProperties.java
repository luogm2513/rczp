package luo.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigProperties {
	private static Properties prop;
	
	public static Properties getProp() {
		if(prop == null){
			prop=new Properties();
			try {
				InputStream configIs = ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");
				if(configIs!=null){
					prop.load(configIs);
				}
				/*InputStream emailIs = ConfigProperties.class.getClassLoader().getResourceAsStream("email.properties");
				if(emailIs!=null){
					prop.load(emailIs);
				}
				InputStream weibo4jIs = ConfigProperties.class.getClassLoader().getResourceAsStream("weibo4j.properties");
				if(weibo4jIs!=null){
					prop.load(weibo4jIs);
				}*/
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return prop;
	}
	
	public static String get(String key){
		String res = "";
		if(getProp().containsKey(key))
			res = getProp().getProperty(key);
		return res;
	}
	
	public static String get(String key,String defaultValue){
		return getProp().getProperty(key, defaultValue);
	}
	
	public static Integer get(String key,Integer def){
		try {
			Integer res = def;
			if(getProp().containsKey(key))
				res = Integer.parseInt(getProp().getProperty(key));
			return res;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}
		
	}
	
	public static Long get(String key,Long def){
		try {
			Long res = def;
			if(getProp().containsKey(key))
				res = Long.parseLong(getProp().getProperty(key));
			return res;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return def;
		}
		
	}
	
	public static void set(String key , String value){
		getProp().put(key, value);
	}
	
}
