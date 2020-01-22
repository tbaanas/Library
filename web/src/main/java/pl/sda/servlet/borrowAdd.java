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

@WebServlet("/borrowAdd")
public class borrowAdd extends HttpServlet {
    BookService bookService = new BookService();
    BorrowerService borrowerService = new BorrowerService();
    BorrowService borrowService = new BorrowService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("bookId"));
        int idBorrower = Integer.parseInt(request.getParameter("borrowersList"));

        Borrower borrower = borrowerService.find(idBorrower);
        Book book = bookService.find(id);

        book.setBorrow(true);
        book.setSetCurrentBorrowerName(borrower.getFirstName() + " " + borrower.getLastName());
        bookService.update(book);

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setBorrower(borrower);
      /*  borrow.setBookId(book.getId_book());
        borrow.setBorowerId(borrower.getId());*/
        Date date = new Date(System.currentTimeMillis());

        borrow.setDate(date);
        borrowService.save(borrow);
        response.sendRedirect("/ShowBookDetails?bookID="+id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
