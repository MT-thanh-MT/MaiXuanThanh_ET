package com.rrssys.repository;

import com.rrssys.entity.BookOnTape;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookOnTapeRepository extends CrudRepository<BookOnTape, Long> {
    Optional<BookOnTape> findBySeri(Long seri);
}
