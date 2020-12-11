package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;

import org.springframework.stereotype.Component;

@Component("px")
public class Proxy {
    public Map<String, Object> hashmap(){
        Supplier<Map<String, Object>> s = HashMap::new;
        return s.get();
    }
    
}
