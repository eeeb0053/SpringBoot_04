package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jsoup.nodes.Document;

import com.example.demo.domains.BookingDTO;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

@Component
public class Crawler {
    @Autowired Printer printer;
    @Autowired Box<BookingDTO> bookBox;
    @Autowired BookingDTO booking;
    public Box<BookingDTO> crawling(String url){
        printer.accept("크롤링 대상 URL : "+url);
        try{
            Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
            Elements titles = rawData.select("div[class=subtitle]");
            Elements dates = rawData.select("div[class=date]");
            Elements locations = rawData.select("div[class=place]");
            Elements prices = rawData.select("span[class=post-discount-price]");
            printer.accept(">>>>>>>>>>>>>>>>>>>>"+titles.size());
            for(int i=0; i< titles.size(); i++){
                booking = new BookingDTO();
                booking.setShowTitle(titles.get(i).text());
                booking.setShowDate(dates.get(i).text());
                booking.setShowLocation(locations.get(i).text());
                booking.setShowPrice(prices.get(i).text());
                printer.accept("크롤링된 게시글 "+i+"번 : " +booking.toString());
                bookBox.add(booking);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return bookBox;
    }
}
