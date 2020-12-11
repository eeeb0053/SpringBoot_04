package com.example.demo.services;

import java.util.List;

import com.example.demo.domains.BookingDTO;

import org.springframework.stereotype.Component;

@Component
public interface BookingService {
	public int add(BookingDTO booking);
	public List<BookingDTO> list();
    public int count();
    public int crawling(String url);
    public BookingDTO getBookingById(String bookNum);
    public int update(BookingDTO booking);
    public int delete(BookingDTO booking);
}
