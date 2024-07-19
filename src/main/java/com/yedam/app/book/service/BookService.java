package com.yedam.app.book.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	// 도서리스트
	public List<BookVO> bookList();
	// 도서 등록
	public int saveBook(BookVO bookVO);
	// 등록 전 북 넘버 조회
	public int findBookNo();
	// 도서 수정
	public Map<String, Object> editBook(BookVO bookVO);
	// 대여목록
	public List<BookVO> rentList();
}
