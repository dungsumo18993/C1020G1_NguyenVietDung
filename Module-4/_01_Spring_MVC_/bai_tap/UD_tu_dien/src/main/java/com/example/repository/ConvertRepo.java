package com.example.repository;

import java.util.HashMap;
import java.util.Map;

public class ConvertRepo {
    public static Map<String,String> map = new HashMap<>();
    static {
        map.put("cat","con mèo");
        map.put("dog","con chó");
        map.put("mouse","con chuột");
        map.put("pig","con heo");
        map.put("dragon","con rồng");
    }
}
