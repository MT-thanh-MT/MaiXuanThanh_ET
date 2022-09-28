package com.rrssys.repository;

import com.rrssys.entity.Furniture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FurnitureRepository extends CrudRepository<Furniture, Long> {
    Optional<Furniture> findBySeri(Long seri);
}
