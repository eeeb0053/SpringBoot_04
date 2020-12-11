package com.example.demo.utils;

import java.util.ArrayList;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data @Lazy
public class Box<T> {
    private ArrayList<T> list;
    public Box(){
        list = new ArrayList<T>();
    }
    public void add(T t){
        list.add(t);
    }
    public T get(int i){
        return list.get(i);
    }
    public ArrayList<T> get(){
        return list;
    }
    public int size(){
        return list.size();
    }
}
