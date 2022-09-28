package com.rrssys.repository;

import com.rrssys.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
    Optional<Video> findBySeri(Long seri);
}
