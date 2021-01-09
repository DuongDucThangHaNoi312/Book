package com.example.webday7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webday7.dto.CreateBookDTO;
import com.example.webday7.dto.UpdateBookDTO;
import com.example.webday7.entity.Book;
import com.example.webday7.service.BookService;
import com.example.webday7.transform.BookTransform;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	// private DateFormat dateFormat;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
		// this.dateFormat = dateFormat;
	}

	@GetMapping
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@GetMapping("/{bookId}")
	public Book getById(@PathVariable long bookId) {
		return bookService.findById(bookId);
	}

	@PostMapping
	public Book insertBook(@RequestBody CreateBookDTO bookDTO) {
		BookTransform transform = new BookTransform();
		Book book = transform.apply(bookDTO);
		bookService.insert(book);
		return book;
	}

	@PutMapping("/{bookId}")
	public Book updateBook(@PathVariable long bookId, @RequestBody UpdateBookDTO bookDTO) {
		Book book = bookService.findById(bookId);
		BookTransform transform = new BookTransform();
		transform.apply(book, bookDTO);
		bookService.update(book);
		return book;
	}

	@DeleteMapping("/{bookId}")
	public String deleteStudent(@PathVariable long bookId) {
		bookService.delete(bookId);
		return "Delete book success";
	}

}
