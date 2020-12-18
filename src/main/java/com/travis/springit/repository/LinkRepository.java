package com.travis.springit.repository;

import com.travis.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface LinkRepository extends JpaRepository<Link,Long> {
    //Link findByTitle(String title);
    //List<Link> findAllByTitleLikeOrderByCreationDateDesc(String title);
}

