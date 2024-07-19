package com.yedam.app.book.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;
	
	@Override
	public List<BookVO> bookList() {
		return bookMapper.selectAllBook();
	}

	@Override
	public int saveBook(BookVO bookVO) {
		int result = bookMapper.insertBookInfo(bookVO);
		return result == 1 ? bookVO.getBookNo() : -1;
	}

	@Override
	public Map<String, Object> editBook(BookVO bookVO) {
		int updateBookInfo = bookMapper.updateBookInfo(bookVO);
		boolean isSuccessed = false;
		
		Map<String, Object> map = new HashMap<>();
		
		if(updateBookInfo == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", bookVO);
		
		return map;
	}

	@Override
	public int findBookNo() {
		int result = bookMapper.selectBookNo();
		return result;
	}

	@Override
	public List<BookVO> rentList() {
		return bookMapper.rentList();
	}

}
