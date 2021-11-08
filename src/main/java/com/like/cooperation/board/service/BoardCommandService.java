package com.like.cooperation.board.service;

import java.util.List;

import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.like.cooperation.board.boundary.BoardDTO;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.domain.BoardBookmark;
import com.like.cooperation.board.domain.BoardBookmarkRepository;
import com.like.cooperation.board.domain.BoardRepository;
import com.like.cooperation.board.domain.QBoardBookmark;


@Service
@Transactional
public class BoardCommandService {
	
	private BoardRepository boardRepository;
	private BoardBookmarkRepository bookmarkRepository;		
	     
	public BoardCommandService(BoardRepository boardRepository
							  ,BoardBookmarkRepository bookmarkRepository) {
		this.boardRepository = boardRepository;
		this.bookmarkRepository = bookmarkRepository;		
	}

	public Board getBoard(Long id) {
    	return boardRepository.findById(id).orElse(null);
    }
	
	public void saveBoard(BoardDTO.FormBoard dto) {			
		Board board = null;			
		Board parentBoard = dto.getPpkBoard() != null ? boardRepository.findById(dto.getPpkBoard()).orElse(null) : null;			
																
		if (dto.getPkBoard() == null) {
			board = dto.newBoard(parentBoard);
		} else {
			board = boardRepository.findById(dto.getPkBoard()).orElse(null);
			dto.modifyBoard(board, parentBoard);			
		}			
		
		boardRepository.save(board);
	}
	
	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}			
	
	public void deleteBoard(Board board) {
		boardRepository.delete(board);
	}
	
	public List<BoardBookmark> getBookmarkList(String userId) {
		QBoardBookmark qBoardBookmark = QBoardBookmark.boardBookmark;
				
		return Lists.newArrayList(bookmarkRepository.findAll(qBoardBookmark.userId.eq(userId), new QSort(qBoardBookmark.seq.asc())));
	}	
	
	public void saveBookmark(BoardBookmark entity) {
		bookmarkRepository.save(entity);
	}
	
	public void deleteBookmark(Long id) {		
		
		bookmarkRepository.deleteById(id);
	}							
		
}