package com.example.demo.services;

import java.util.List;

import com.example.demo.domains.BookingDTO;

import org.springframework.stereotype.Component;

@Component
public interface BookingService {
	public int add(BookingDTO booking);
	public List<BookingDTO> list();
	public int count();
}
