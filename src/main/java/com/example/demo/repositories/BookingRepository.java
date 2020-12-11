package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domains.BookingDTO;

import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository {
	public int insert(BookingDTO booking);
	public List<BookingDTO> selectAll();
	public int count();
}
