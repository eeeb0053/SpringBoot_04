package com.example.demo.impls;

import java.util.List;

import com.example.demo.domains.BookingDTO;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.services.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpls implements BookingService {
    @Autowired
    BookingRepository bookingRepository;
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
}
