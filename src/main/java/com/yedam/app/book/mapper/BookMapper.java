package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

public interface BookMapper {
	// 도서 리스트
	public List<BookVO> selectAllBook();
	// 도서 정보 등록
	public int insertBookInfo(BookVO bookVO);
	// 도서 등록 전 도서넘버 찾기
	public int selectBookNo();
	// 도서 정보 수정
	public int updateBookInfo(BookVO bookVO);
	
	// 도서별 대여매출현황
	public List<BookVO> rentList();
	
}
