package com.codegym.model.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository{
    @Override
    public String find(String english) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("i", "Tôi");
        dictionary.put("you", "Bạn");
        dictionary.put("bye", "Tạm biệt");
        String result = dictionary.get(english.toLowerCase());
        String error = "Không có từ này trong từ điển!";
        if (result != null) {
            return result;
        } else {
            return error;
        }
    }

}
