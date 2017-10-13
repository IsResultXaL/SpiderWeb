package com.caogen.spiderWeb.util;

public class StringUtil {

    public static String getString(Object object){
        if(null == object)return "";
        return object.toString().trim();
    }

    public static String getLongString(Object object) {
        if(null == object)return "0";
        return object.toString().trim();
    }

}
