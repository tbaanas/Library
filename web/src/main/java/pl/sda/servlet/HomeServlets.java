package pl.sda.servlet;
import pl.sda.entities.Book;
import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/HomeServlets")
public class HomeServlets  extends HttpServlet{
    private BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> show = bookService.show();
        req.setAttribute("books",show);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
