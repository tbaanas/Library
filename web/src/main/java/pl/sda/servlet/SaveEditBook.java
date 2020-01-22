package pl.sda.servlet;

import pl.sda.entities.Author;
import pl.sda.entities.Book;
import pl.sda.entities.Category;
import pl.sda.service.AuthorService;
import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SaveEditBook")
public class SaveEditBook extends HttpServlet {
    private BookService bookService = new BookService();
    private AuthorService authorService = new AuthorService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Integer.parseInt(request.getParameter("bID"));
        long idAuthor = Integer.parseInt(request.getParameter("author"));

        Book book = bookService.find(id);

        Date startDate = new Date(System.currentTimeMillis());
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        book.setCategory(request.getParameter("category"));
        book.setIsbn(request.getParameter("isbn"));
        book.setPages(Integer.parseInt(request.getParameter("pages")));
        book.setSummary(request.getParameter("summary"));
        book.setTitle(request.getParameter("title"));
        book.setDate(startDate);

        book.setAuthor(authorService.find(idAuthor));
        bookService.update(book);
        response.sendRedirect("/HomeServlets");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
