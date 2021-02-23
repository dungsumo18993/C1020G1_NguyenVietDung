package com.example.serivce;

import com.example.repo.ConvertRepo;

import java.util.Map;

public class ConvertService {
    public String search(String text){
        String result;
        Map<String,String> map = ConvertRepo.map;
        result = map.get(text);
        if (result == null){
            result = "Không tìm thấy kết quả !!";
        }
        return result;
    }
}
