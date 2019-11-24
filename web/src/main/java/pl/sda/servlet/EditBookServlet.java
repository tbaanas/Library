package pl.sda.servlet;

import pl.sda.entities.Author;
import pl.sda.service.AuthorService;
import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    private AuthorService author =new AuthorService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Long bookId = Long.parseLong(request.getParameter("bookID"));
        request.setAttribute("author",author.show());
        request.setAttribute("book", bookService.find(bookId));
        request.setAttribute("bookList", bookService.show());
        request.getRequestDispatcher("/editBook.jsp").forward(request, response);
    }
}
