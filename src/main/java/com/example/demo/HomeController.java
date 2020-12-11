package com.example.demo;

import com.example.demo.utils.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired Printer printer;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/move/{dir}/{page}")
    public String move(@PathVariable String dir, @PathVariable String page){
        printer.accept("이동경로: "+dir+"/"+page);
        return String.format("%s/%s", dir, page);
    }
}
