package com.wzx.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FastJsonUtil {

    private static SerializeConfig mapping = new SerializeConfig();

    static {
        /*mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        mapping.put(Timestamp.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));*/
    }

    /**
     * javaBean、list、map convert to json string
     */
    public static String toJson(Object obj) {
        // return JSON.toJSONString(obj,SerializerFeature.UseSingleQuotes);//使用单引号
        // return JSON.toJSONString(obj,true);//格式化数据，方便阅读
        return JSON.toJSONString(obj, mapping);
    }

    /**
     * json string convert to javaBean、map
     */
    public static <T> T toObject(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> toList(String jsonArrayStr, Class<T> clazz) {
        return JSON.parseArray(jsonArrayStr, clazz);
    }

    /**
     * json string convert to map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(String jsonStr) {
        return toObject(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String, T> toMap(String jsonStr, Class<T> clazz) {
        Map<String, T> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, T>>() {
        });
        for (Entry<String, T> entry : map.entrySet()) {
            JSONObject obj = (JSONObject) entry.getValue();
            map.put(entry.getKey(), JSONObject.toJavaObject(obj, clazz));
        }
        return map;
    }


}