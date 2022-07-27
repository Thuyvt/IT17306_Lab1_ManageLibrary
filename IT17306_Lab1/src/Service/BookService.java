/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Book;
import Repository.BookRepository;
import java.util.List;

/**
 *
 * @author ThuyVT
 */
public class BookService {
    BookRepository repository = new BookRepository();

    public BookService() {
    }
    
    public List<Book> getListBookFromDB() {
        return repository.getListBook();
    }
    
    public String addBook(Book book) {
        return repository.insertToDB(book);
    }
    
    public String updateBook(Book book) {
        if (repository.getIndexBook(book.getId()) == -3) {
            return "Khong tim thay ma trong co so du lieu";
        } else {
            return repository.updateToDB(book); 
        }
    }
    
    public String deleteBook(Book book) {
        if (repository.getIndexBook(book.getId()) == -3) {
            return "Khong tim thay ma trong co so du lieu";
        } else {
            return repository.deleteToDb(book); 
        }
    }
    
    
}
