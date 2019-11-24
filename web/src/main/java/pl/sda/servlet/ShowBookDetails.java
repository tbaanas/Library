package pl.sda.servlet;

import pl.sda.entities.Borrow;
import pl.sda.entities.Borrower;
import pl.sda.service.AuthorService;
import pl.sda.service.BookService;
import pl.sda.service.BorrowService;
import pl.sda.service.BorrowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShowBookDetails")
public class ShowBookDetails extends HttpServlet {
    private BookService bookService = new BookService();
    private BorrowerService borrowerService = new BorrowerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bookId = Integer.parseInt(request.getParameter("bookID"));
        try {
            request.setAttribute("book", bookService.find(bookId));
            request.setAttribute("borrowersList", borrowerService.findAll());
            request.getRequestDispatcher("/bookDetails.jsp").forward(request, response);
        } catch (NullPointerException e) {
            request.setAttribute("book", bookService.find(bookId));
            request.setAttribute("borrowersList", borrowerService.findAll());
            request.getRequestDispatcher("/bookDetails.jsp").forward(request, response);
        }

    }
}
