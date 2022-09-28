package com.rrssys.controller;

import com.rrssys.entity.BookOnTape;
import com.rrssys.service.BookOnTapeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rental-book")
public class BookOnTapeRentalController {
    @Autowired
    private BookOnTapeServiceImpl bookOnTapeService;
    @GetMapping("/list")
    public String listBook(Model model){
        model.addAttribute("book", new BookOnTape());
        List<BookOnTape> listBook = bookOnTapeService.getAll();
        model.addAttribute("listBook",listBook);
        return "bookontape";
    }
    @PostMapping("/save")
    public String save(Model model, @ModelAttribute("book")BookOnTape book) {

        bookOnTapeService.add(book);
        List<BookOnTape> listBook = bookOnTapeService.getAll();
        model.addAttribute("listBook",listBook);
        model.addAttribute("book", book);
        return "bookontape";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        bookOnTapeService.delete(id);
        List<BookOnTape> listBook = bookOnTapeService.getAll();
        model.addAttribute("listBook",listBook);
        model.addAttribute("book", new BookOnTape());
        return "bookontape";
    }
    @GetMapping("/search")
    public String findBySeri(@RequestParam("seriSeach") Long seriSeach, Model model) {
        List<BookOnTape> listBook = new ArrayList<>();
        BookOnTape book;
        try {
            book = bookOnTapeService.getBySeri(seriSeach);
            listBook.add(book);
        } catch (Exception e) {
            book = new BookOnTape();
        }
        model.addAttribute("listBook",listBook);
        model.addAttribute("book", book);
        model.addAttribute("seriSeach", seriSeach);

        return "bookontape";
    }
}
