package com.rrssys.service;

import com.rrssys.entity.BookOnTape;
import com.rrssys.repository.BookOnTapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOnTapeServiceImpl implements IBaseService<BookOnTape>{
    @Autowired
    private BookOnTapeRepository bookOnTapeRepository;
    @Override
    public BookOnTape add(BookOnTape bookOnTape) {
        if (bookOnTape != null) {
            return bookOnTapeRepository.save(bookOnTape);
        }
        return null;
    }

    @Override
    public BookOnTape update(Long id, BookOnTape bookOnTape) {
        if (bookOnTape != null) {
            BookOnTape bookOnTape1 = bookOnTapeRepository.findById(id).get();
            if (bookOnTape1 != null) {
                bookOnTape1.setName(bookOnTape.getName());
                bookOnTape1.setAuthor(bookOnTape.getAuthor());
                bookOnTape1.setChapter(bookOnTape.getChapter());
                bookOnTape1.setSeri(bookOnTape.getSeri());
                bookOnTape1.setRentalPrice(bookOnTape.getRentalPrice());
                bookOnTape1.setQuantity(bookOnTape.getQuantity());

                return bookOnTapeRepository.save(bookOnTape1);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (id >= 1) {
            BookOnTape bookOnTape = bookOnTapeRepository.findById(id).get();
            if (bookOnTape != null) {
                bookOnTapeRepository.deleteById(bookOnTape.getId());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<BookOnTape> getAll() {
        return (List<BookOnTape>) bookOnTapeRepository.findAll();
    }

    @Override
    public BookOnTape getByID(Long id) {
        return bookOnTapeRepository.findById(id).get();
    }

    @Override
    public BookOnTape getBySeri(Long seri) {
        return bookOnTapeRepository.findBySeri(seri).get();
    }
}
