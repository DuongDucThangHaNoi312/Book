package com.example.webday7.transform;

import com.example.webday7.dto.CreateBookDTO;
import com.example.webday7.dto.UpdateBookDTO;
import com.example.webday7.entity.Book;

public class BookTransform {

	public Book apply(CreateBookDTO dto) {
		Book book = new Book();
		book.setName(dto.getName());
		book.setAuthor(dto.getAuthor());
		book.setRelease_year(dto.getRelease_year());
		book.setNumber_of_pages(dto.getNumber_of_pages());
		book.setPrice(dto.getPrice());
		return book;
	}

	public void apply(Book book, UpdateBookDTO dto) {
		if (dto.getName() != null)
			book.setName(dto.getName());

		if (dto.getAuthor() != null)
			book.setAuthor(dto.getAuthor());

		if (dto.getRelease_year() != 0)
			book.setRelease_year(dto.getRelease_year());

		if (dto.getNumber_of_pages() != 0)
			book.setNumber_of_pages(dto.getNumber_of_pages());

		if (dto.getPrice() != 0)
			book.setPrice(dto.getPrice());

	}
}
