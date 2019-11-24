package pl.sda.servlet;

import pl.sda.entities.Book;
import pl.sda.entities.Borrow;
import pl.sda.entities.Borrower;
import pl.sda.service.BookService;
import pl.sda.service.BorrowService;
import pl.sda.service.BorrowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
    BookService bookService = new BookService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("bookId"));


        Book book = bookService.find(id);

        book.setBorrow(false);
        book.setSetCurrentBorrowerName(null);
        bookService.update(book);

        response.sendRedirect("/ShowBookDetails?bookID=" + id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
