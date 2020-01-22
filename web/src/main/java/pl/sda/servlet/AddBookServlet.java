package pl.sda.servlet;

import pl.sda.entities.Author;
import pl.sda.entities.Book;
import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddBookServlet extends HttpServlet {

    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = new Book();
        Author author = new Author();


        book.setCategory(request.getParameter("category"));
        book.setIsbn(request.getParameter("isbn"));
        book.setPages(Integer.parseInt(request.getParameter("pages")));
        book.setSummary(request.getParameter("summary"));
        book.setTitle(request.getParameter("title"));
        int a = 1;
        if (request.getParameter("author") != null) {

            a = Integer.parseInt(request.getParameter("author"));
        }

        author.setId((long) a);
        book.setAuthor(author);
        bookService.save(book);

        response.sendRedirect("/HomeServlets");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
