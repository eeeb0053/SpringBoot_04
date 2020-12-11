package com.example.demo.impls;

import java.util.List;

import com.example.demo.domains.BookingDTO;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.services.BookingService;
import com.example.demo.utils.Crawler;
import com.example.demo.utils.UserGenerator;
import com.example.demo.utils.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpls implements BookingService {
    @Autowired BookingRepository bookingRepository;
    @Autowired Crawler crawler;
    @Autowired UserGenerator ug;
    @Autowired BookingDTO booking;
    @Override
    public int add(BookingDTO booking) {
        return bookingRepository.insert(booking);
    }
    @Override
    public List<BookingDTO> list() {
        return bookingRepository.selectAll();
    }
    @Override
    public int count() {
        return bookingRepository.count();
    }
    @Override
    public int crawling(String url) {
        var bookBox = new Box<BookingDTO>();
        bookBox = crawler.crawling(url);
        System.out.println("box size: "+bookBox.size());
        for(int i =0; i< bookBox.size(); i++){
            booking = new BookingDTO();
            booking = bookBox.get(i);
            System.out.println("Booking : "+booking.toString());
            String userid = ug.makeUserId();
            System.out.println("글쓴이 아이디: "+userid);
            booking.setBookId(ug.makeUserId());
            add(bookBox.get(i));
        }
        return count();
    }
    @Override
    public BookingDTO getBookingById(String bookNum) {
        return bookingRepository.selectById(bookNum);
    }
    @Override
    public int update(BookingDTO booking) {
        return bookingRepository.update(booking);
    }
    @Override
    public int delete(BookingDTO booking) {
        return bookingRepository.delete(booking);
    }
}
