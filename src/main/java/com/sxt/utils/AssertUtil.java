package com.sxt.utils;

import com.sxt.exception.ParamException;



public class AssertUtil {
    
    /**
     * 表达式结果真时判断
     * @param flag
     * @param msg
     */
    public static void isTrue(Boolean expression,String msg){
        if(expression){
            throw new ParamException(msg);
        }   
    }
    public static void isTure(Boolean expression){
        if(expression){
            throw new ParamException("操作失败!");
        }
    }   
    /**
     * 参数为空时
     * @param object
     * @param msg
     */
    public static void isNull(Object object,String msg){
        if(object==null){
            throw new ParamException(msg);
        }
    }
    /**
     * 参数不空时
     * @param object
     * @param msg
     */
    public static void notNull(Object object,String msg){
        if(object!=null){
            throw new ParamException(msg);
        }
    }
}
