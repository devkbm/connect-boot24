package com.like.term.domain;

import java.util.List;

import com.like.term.boundary.TermDTO;

public interface TermRepository {
	
	TermDictionary getTerm(Long pkTerm);	
	
	List<TermDictionary> getTermList();
	
	List<TermDictionary> getTermList(TermDTO.SearchTerm condition);
	
	void saveTerm(TermDictionary term);	
	
	void deleteTerm(Long pkTerm);
	
}
