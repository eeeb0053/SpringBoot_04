package com.example.demo.domains;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component @Getter @Setter
public class BookingDTO {
    private String bookNum, bookId, showTitle, showDate, showLocation, showPrice;
}
