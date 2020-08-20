package com.das.consultation.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * created by jun on 2020/8/3
 * describe:自定义数据返回格式
 * version 1.0
 */
public class ResultMessage<T> {
    private String msg;
    private String code;
//    private Map<String, Object> dataMap = new HashMap<>();
    private T data;

    // 操作成功时，返回一个存储了成功信息的传输对象
    public static ResultMessage success() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("0");
        resultMessage.setMsg("成功");
        return resultMessage;
    }


    // 操作失败时，返回一个存储了失败信息的传输对象
    public static ResultMessage fail(String msg) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("1");
        resultMessage.setMsg(msg);
        return resultMessage;
    }

//    // 用于添加数据的方法，并使其可以链式操作
//    public ResultMessage addData(String key, Object value) {
//        this.getDataMap().put(key, value);
//        return this;
//    }
    // 用于添加数据的方法，并使其可以链式操作
    public ResultMessage addList(T t) {
        this.data = t;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public Map<String, Object> getDataMap() {
//        return dataMap;
//    }
//
//    public void setDataMap(Map<String, Object> dataMap) {
//        this.dataMap = dataMap;
//    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
