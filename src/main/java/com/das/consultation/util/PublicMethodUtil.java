package com.das.consultation.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * created by jun on 2020/8/6
 * describe:公共方法
 * version 1.0
 */
public class PublicMethodUtil {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * str转为Date
     *
     * @param strDate date字符串
     * @return date
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    /**
     * str转为Date YYYY-MM-DD
     *
     * @param strDate date字符串
     * @return date
     */
    public static Date strToDateDay(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    /**
     * 将String类型转化为Date时间格式
     * @param str
     * @param id
     * @return
     */
    public static Date ToDateTime(String str, int id) {
        SimpleDateFormat format = null;
        switch (id) {
            case 1:
                format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case 2:
                format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                break;
            case 3:
                format = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                break;
            case 4:
                format = new SimpleDateFormat("yyyy-MM-dd");
                break;
        }
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 实体转为map
     *
     * @param object 实体对象
     * @return map
     */
    public static Map<String, Object> objectToMap(Object object) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
        Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, Object> entry : entrySet) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /**
     * 判断实体对象为空不
     *
     * @param obj 实体对象
     * @return true 不为空  false 为空
     */
    public static boolean checkObjFieldIsNotNull(Object obj) {
        boolean flag = false;
        try {
            for (Field f : obj.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(obj) == null || f.get(obj) == "") {
                } else {
                    flag = true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return flag;
    }

    /**
     * 获取现在时间
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
