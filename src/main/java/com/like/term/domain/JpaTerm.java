package com.like.term.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTerm extends JpaRepository<TermDictionary, Long> {

}
