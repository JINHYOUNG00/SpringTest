package com.yedam.app.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;
	
	// 도서 목록 페이지
	@GetMapping
	public String bookList(Model model) {
		List<BookVO> bookList = bookService.bookList();
		
		model.addAttribute("blist", bookList);
		return "book/bookList";
	}
	
	// 도서 등록(페이지)
	@GetMapping("/save")
	public String saveBookForm(Model model) {
		model.addAttribute("bno", bookService.findBookNo());
		return "book/bookInsert";
	}
	
	// 도서 등록(처리)
	@PostMapping("/save")
	public String saveBook(BookVO bookVO) {
		bookService.saveBook(bookVO);
		return "redirect:/book";
	}
	
	// 대여 목록
	@GetMapping("rent")
	public String rentList(Model model) {
		model.addAttribute("rlist", bookService.rentList());
		return "book/rentList";
	}
	
}
