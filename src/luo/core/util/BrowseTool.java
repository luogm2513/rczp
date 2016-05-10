package luo.core.util;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 
*    
* 项目名称：parox   
* 类名称：BrowseTool   
* 类描述：   解析浏览器
* 创建人：seasongs   
* 创建时间：2014年1月21日 下午1:58:31   
* 修改人：seasongs   
* 修改时间：2014年1月21日 下午1:58:31   
* 修改备注：   
* @version    
*
 */
public class BrowseTool {
	private final static String IE11="MSIE 11.0"; 
	private final static String IE10="MSIE 10.0";  
	private final static String IE9="MSIE 9.0"; 
    private final static String IE8="MSIE 8.0";  
    private final static String IE7="MSIE 7.0";  
    private final static String IE6="MSIE 6.0";  
    private final static String MAXTHON="Maxthon";  
    private final static String QQ="QQBrowser";  
    private final static String GREEN="GreenBrowser";  
    private final static String SE360="360SE";  
    private final static String FIREFOX="Firefox";  
    private final static String OPERA="Opera";  
    private final static String CHROME="Chrome";  
    private final static String SAFARI="Safari";   
    private final static String OTHER="其它";
      
      
    public static String checkBrowse(String userAgent){  
    	if(regex(MAXTHON, userAgent))return MAXTHON;
    	if(regex(OPERA, userAgent))return OPERA;  
        if(regex(CHROME, userAgent))return CHROME;  
        if(regex(FIREFOX, userAgent))return FIREFOX;  
        if(regex(SAFARI, userAgent))return SAFARI;  
        if(regex(SE360, userAgent))return SE360;  
        if(regex(GREEN,userAgent))return GREEN;  
        if(regex(QQ,userAgent))return QQ;   
        if(regex(IE10,userAgent))return IE10; 
        if(regex(IE9,userAgent))return IE9;  
        if(regex(IE8,userAgent))return IE8;  
        if(regex(IE7,userAgent))return IE7;  
        if(regex(IE6,userAgent))return IE6;  
        if(regex("rv:11.0",userAgent) && regex("Trident/7.0",userAgent))return IE11;
        return OTHER;  
    }
    
    public static String getBrowser(HttpServletRequest request){
    	String userAgent = request.getHeader("user-agent");
    	return checkBrowse(userAgent);
    }    
    
    public static String getOS(HttpServletRequest request)
    {
    	String userAgent = request.getHeader("user-agent");
        String cos = "unknow os";
       
        Pattern p = Pattern.compile(".*(Windows NT 6\\.1).*");
        Matcher m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "Win 7";
            return cos;
        }
       
        p = Pattern.compile(".*(Windows NT 5\\.1|Windows XP).*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "WinXP";
            return cos;
        }
       
        p = Pattern.compile(".*(Windows NT 5\\.2).*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "Win2003";
            return cos;
        }
       
        p = Pattern.compile(".*(Win2000|Windows 2000|Windows NT 5\\.0).*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "Win2000";
            return cos;
        }
       
        p = Pattern.compile(".*(Mac|apple|MacOS8).*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "MAC";
            return cos;
        }
       
        p = Pattern.compile(".*(WinNT|Windows NT).*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "WinNT";
            return cos;
        }
       
        p = Pattern.compile(".*Linux.*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "Linux";
            return cos;
        }
       
        p = Pattern.compile(".*(68k|68000).*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "Mac68k";
            return cos;
        }
       
        p = Pattern.compile(".*(9x 4.90|Win9(5|8)|Windows 9(5|8)|95/NT|Win32|32bit).*");
        m = p.matcher(userAgent);
        if(m.find())
        {
            cos = "Win9x";
            return cos;
        }
       
        return cos;
    }
    
    public static boolean regex(String regex,String str){  
        Pattern p =Pattern.compile(regex,Pattern.MULTILINE);  
        Matcher m=p.matcher(str);  
        return m.find();  
    }  
      
    public static void main(String[] args) {  
        String ie11   ="Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko";
        String ie10   ="Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)";
        String ie9    ="Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)";
        String ie8    ="Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322)";
        String ie7    ="Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.2; .NET CLR 1.1.4322)";
        String ie6    ="Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322)";
        String aoyou  ="Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; Maxthon 2.0)";
        String qq     ="Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322) QQBrowser/6.8.10793.201";
        String green  ="Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; GreenBrowser)";
        String se360  ="Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; 360SE)";
          
        String chrome ="Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/534.11 (KHTML, like Gecko) Chrome/9.0.570.0 Safari/534.11";            
        String safari ="Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN) AppleWebKit/533.17.8 (KHTML, like Gecko) Version/5.0.1 Safari/533.17.8";
        String fireFox="Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";
        String opera  ="Opera/9.80  (Windows NT 5.2; U; zh-cn) Presto/2.9.168 Version/11.51";
        String other  ="(Windows NT 5.2; U; zh-cn) Presto/2.9.168 Version/11.51";
        
        String _2345 = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0; like Gecko; 2345Explorer)";
        String maxthon = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.12 (KHTML, like Gecko) Maxthon/3.0 Chrome/18.0.966.0 Safari/535.12";
        BrowseTool b=new BrowseTool();  
        /*System.out.println(b.checkBrowse(ie9));  
        System.out.println(b.checkBrowse(ie8));  
        System.out.println(b.checkBrowse(ie7));  
        System.out.println(b.checkBrowse(ie6));  
        System.out.println(b.checkBrowse(aoyou));  
        System.out.println(b.checkBrowse(qq));  
        System.out.println(b.checkBrowse(green));  
        System.out.println(b.checkBrowse(se360)); 
        System.out.println(b.checkBrowse(chrome));
        System.out.println(b.checkBrowse(safari));  
        
        System.out.println(b.checkBrowse(opera));  
        System.out.println(b.checkBrowse(other));*/
        System.out.println(b.checkBrowse(_2345));
        System.out.println(b.checkBrowse(fireFox));
        System.out.println(b.checkBrowse(maxthon));
        System.out.println(b.checkBrowse(ie10));
        System.out.println(b.checkBrowse(ie11));
    }
}
