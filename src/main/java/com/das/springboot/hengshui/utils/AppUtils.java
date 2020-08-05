package com.das.springboot.hengshui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 	类描述：TODO(json)
 *	 项目名称：rseqcsystem
 * 	包名：org.rseqcsystem.utils
 * 	类名称：AppUtils
 * 	创建人：@author qhb
 * 	创建时间：2020年5月8日 下午2:57:45
 * 	修改人：@author
 * 	修改时间：2020年5月8日 下午2:57:45
 * 	修改备注：
 * @version
 */
public class AppUtils {
	
	public static String convertJsonStr(Object obj){
        ObjectMapper om = new ObjectMapper();
        String retStr =null;// (new StringBuilder()).append("{\"msg\":\"\u6570\u636E\u5F02\u5E38!\",\"flag\":\"").append(CodeEnum.ERROR.value()).append("\"}").toString();
        try
        {
            retStr = om.writeValueAsString(obj);
        }
        catch(JsonProcessingException e) { }
        catch(Exception ex) { }
        return retStr;
    }
	
	public static List<String> parseJson2List(String jsonList){
        ObjectMapper mapper = new ObjectMapper();
        List<String> ids = new ArrayList<String>();
        try{
        	 JsonNode jsonNode = mapper.readTree(jsonList);
        	 JsonNode nodes = jsonNode.get("ids");
             if (nodes.isArray()){
                 for (final JsonNode objNode : nodes){
                     ids.add(objNode.asText());
                 }
             }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ids;
    }
	
	/**
	 * 将map数组转成josn
	 * @param map map数组
	 * @return 返回的josn对象
	 */
	public static String convertJsonStr(Map<String, Object> map){
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String convertJsonListStr(Map<String, List<Map<String, Object>>> map){
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>Title:differentDays</p>
	 * <p>Description: 判断两个日期相差的天数</p>
	 * @param date1
	 * @param date2
	 * @return
	 * @author:zp
	 * @date :2018年11月16日下午3:38:50
	 */
	 public static int differentDays(Date date1,Date date2)
	    {
	        Calendar cal1 = Calendar.getInstance();
	        cal1.setTime(date1);
	        Calendar cal2 = Calendar.getInstance();
	        cal2.setTime(date2);
	        int day1= cal1.get(Calendar.DAY_OF_YEAR);
	        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
	        int year1 = cal1.get(Calendar.YEAR);
	        int year2 = cal2.get(Calendar.YEAR);
	        if(year1 != year2)   //同一年
	        {
	            int timeDistance = 0 ;
	            for(int i = year1 ; i < year2 ; i ++)
	            {
	                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
	                {
	                    timeDistance += 366;
	                }
	                else    //不是闰年
	                {
	                    timeDistance += 365;
	                }
	            }
	            return timeDistance + (day2-day1) ;
	        }
	        else    //不同年
	        {
	            return day2-day1;
	        }
	    }
	 
		/**
		 * 获取当前月份的第一天和最后一天
		 * @return
		 */
		public static Map<String,String> getMonthTheHeadAndTheTail(){
			Map<String, String> map=new HashMap<String, String>();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.MONTH, 0);
			c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
			String first = format.format(c.getTime());
			//获取当前月最后一天
			Calendar ca = Calendar.getInstance();    
			ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
			String last = format.format(ca.getTime());
			map.put("firstDay", first);
			map.put("lastDay", last);
			return map;
		}
		
		
	    
	   
	
	    
	/**
	 * 判断一个字符串是不是一个合法的日期格式
	 * @param str
	 * @return
	 */
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}
	
	/**
	 * 判断一个字符串是不是一个合法的日期格式
	 * @param str
	 * @return
	 */
//	public static boolean isValidDate(String str) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2018-02-29会被接受，并转换成2018-03-01 
//            format.setLenient(false);
//            format.parse(str);
//            //判断传入的yyyy年-MM月-dd日 字符串是否为数字
//            String[] sArray = str.substring(0,str.indexOf(" ")).split("-");
//            for (String s : sArray) {
//                boolean isNum = s.matches("[0-9]+");
//                //+表示1个或多个（如"3"或"225"），*表示0个或多个（[0-9]*）（如""或"1"或"22"），?表示0个或1个([0-9]?)(如""或"7")
//                if (!isNum) {
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            // e.printStackTrace();
//            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
//            return false;
//        }
//        return true;
//    }

	/**
	 * 中文转unicode编码
	 * @param gbString
	 * @return
	 */
	public static String gbEncoding(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int i = 0; i < utfBytes.length; i++) {
			String hexB = Integer.toHexString(utfBytes[i]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}

	/**
	 * unicode编码转中文
	 * @param dataStr
	 * @return
	 */
	public static String decodeUnicode(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			end = dataStr.indexOf("\\u", start + 2);
			String charStr = "";
			if (end == -1) {
				charStr = dataStr.substring(start + 2, dataStr.length());
			} else {
				charStr = dataStr.substring(start + 2, end);
			}
			char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
			buffer.append(new Character(letter).toString());
			start = end;
		}
		return buffer.toString();
	}

	/**
	 * 获取一段时间中每一天的日期
	 * @param dBegin 开始时间
	 * @param dEnd 结束时间
	 * @return
	 */
	public static List<String> findDaysStr(String begintTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = null;
        Date dEnd = null;
        try {
            dBegin = sdf.parse(begintTime);
            dEnd = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> daysStrList = new ArrayList<String>();
        daysStrList.add(sdf.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            String dayStr = sdf.format(calBegin.getTime());
            daysStrList.add(dayStr);
        }
        return daysStrList;
    } 
	
	
	 /** 
	    * 获取当前日期之前 第 past天的日期 
	    * @param past 
	    * @return 
	    */  
	   public static String getPastDate(int past) {  
	       Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
	       Date today = calendar.getTime();  
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       String result = format.format(today);   
	       return result;  
	   } 
	   /** 
	    * 获取当前日期之前 第 past天的日期 
	    * @param past 
	    * @return 
	    */  
	   public static String getLastDate(int past) {  
	       Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);  
	       Date today = calendar.getTime();  
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       String result = format.format(today);   
	       return result;  
	   } 
	   
	   
	   /** 
	   * 获得指定日期的后一天 
	   * @param specifiedDay 
	   * @return 
	   */ 
	   public static String getSpecifiedDayAfter(String specifiedDay){ 
	   Calendar c = Calendar.getInstance(); 
	   Date date=null; 
	   try { 
	   date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
	   } catch (ParseException e) { 
	   e.printStackTrace(); 
	   } 
	   c.setTime(date); 
	   int day=c.get(Calendar.DATE); 
	   c.set(Calendar.DATE,day+1); 

	   String dayAfter=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
	   return dayAfter; 
	   } 
	
	
		
	/**
	 * 获取本周开始时间
	 * @return
	 */
    public static String getTimesWeekmorning() {
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
//    	Calendar currentDate = new GregorianCalendar();   
//    	currentDate.setFirstDayOfWeek(Calendar.MONDAY);  
//    	          
//    	currentDate.set(Calendar.HOUR_OF_DAY, 0);  
//    	currentDate.set(Calendar.MINUTE, 0);  
//    	currentDate.set(Calendar.SECOND, 0);  
//    	currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    	 Calendar calendar = Calendar.getInstance();  
         calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 6);  
         Date today = calendar.getTime();  
    	 String dayStr = sdf.format(today);
    	return dayStr;
    } 
    
    /**
     * 获取本周结束时间
     * @return
     */
    public static String getTimesWeeknight() {  
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	Calendar currentDate = new GregorianCalendar();   
//    	currentDate.setFirstDayOfWeek(Calendar.MONDAY);  
//    	currentDate.set(Calendar.HOUR_OF_DAY, 23);  
//    	currentDate.set(Calendar.MINUTE, 59);  
//    	currentDate.set(Calendar.SECOND, 59);  
//    	currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//    	String dayStr = sdf.format(currentDate.getTime());
    	String dayStr = sdf.format(new Date());
        return dayStr;  
    }
    
    
    /**
	 * 获取本周开始时间
	 * @return
	 */
    public static String getTimes() {
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    	 Calendar calendar = Calendar.getInstance();  
         calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);  
         Date today = calendar.getTime();  
    	 String dayStr = sdf.format(today);
    	return dayStr;
    } 
    
	public static String printRealSql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			System.out.println("The SQL is------------>\n" + sql);
			return sql;
		}
		int cols = params.length;
		Object[] values = new Object[cols];
		System.arraycopy(params, 0, values, 0, cols);
		for (int i = 0; i < cols; i++) {
			Object value = values[i];
			if (value instanceof Date) {
				values[i] = "'" + value + "'";
			} else if (value instanceof String) {
				values[i] = "'" + value + "'";
			} else if (value instanceof Boolean) {
				values[i] = (Boolean) value ? 1 : 0;
			}
		}
		String statement = String.format(sql.replaceAll("\\?", "%s"), values);
		System.out.println("The SQL is------------>\n" + statement);
		return statement;
	}
    
    
}
