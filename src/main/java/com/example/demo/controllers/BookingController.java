package com.example.demo.controllers;

import java.util.Map;

import com.example.demo.domains.BookingDTO;
import com.example.demo.services.BookingService;
import com.example.demo.utils.Printer;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @GetMapping("/bookings/{bookNum}")
    public BookingDTO detail(@PathVariable String bookNum){
        return bookingService.getBookingById(bookNum);
    }
    @PutMapping("/bookings")
    public Map<?,?> update(@RequestBody BookingDTO booking){
        var map = px.hashmap();
        map.put("message", (bookingService.update(booking) == 1) ? "SUCCESS" : "FAILURE");
        return map;
    }
    @DeleteMapping("/bookings")
    public Map<?,?> delete(@RequestBody BookingDTO booking){
        var map = px.hashmap();
        map.put("message", (bookingService.delete(booking) == 1) ? "SUCCESS" : "FAILURE");
        return map;
    }
    @GetMapping("/bookings/crawling/{site}")
    public Map<?,?> crawling(@PathVariable String site){
        printer.accept("========== 웹 크롤링 =========");
        var map = px.hashmap();
        var count = bookingService.count();
        if(count == 0){
            switch(site){
                case "wmp":
                map.put("count", bookingService.crawling("https://ticket.wemakeprice.com/category/10005"));
                break;
            }
        }else{
            map.put("count", count);
        }
        return map;
    }
}
