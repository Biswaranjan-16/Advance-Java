package com.biswa.dao;

import java.util.List;

import com.biswa.entity.BookDtls;

public interface BookDAO {
	
	public boolean addbooks(BookDtls b);

	public List<BookDtls> getAllBooks();
	
	public BookDtls getBookById(int id);
	
	public boolean updateEditBooks(BookDtls b);
	
	public boolean deleteBooks(int id);
	
	public List<BookDtls> getNewBook();
	
	public List<BookDtls> getRecentBook();
	
	public List<BookDtls> getOldBook();
	
	public List<BookDtls> getAllRecentBook();
	
	public List<BookDtls> getAllNewBook();
	
	public List<BookDtls> getAllOldBook();
	
}
