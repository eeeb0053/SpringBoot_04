package com.example.demo.controllers;

import java.util.Map;

import com.example.demo.domains.BookingDTO;
import com.example.demo.services.BookingService;
import com.example.demo.utils.Printer;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired BookingService bookingService;
    @Autowired Printer printer;
    @Autowired Proxy px;
    @PostMapping("/bookings")
    public Map<?, ?> add(@RequestBody BookingDTO booking){
        var map = px.hashmap();
        int result = bookingService.add(booking);
        map.put("message", (result == 1) ? "SUCCESS": "FAILURE");
        return map;
    }
    @GetMapping("/bookings")
    public Map<?,?> list(){
        printer.accept("========== 목록 =========");
        var map = px.hashmap();
        map.put("count", bookingService.count());
        map.put("list", bookingService.list());
        return map;
    }
}
