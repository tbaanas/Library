package pl.sda.servlet;

import pl.sda.entities.Author;
import pl.sda.entities.Book;
import pl.sda.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ToBookAddServlet")
public class ToBookAddServlet extends HttpServlet {
   private AuthorService author =new AuthorService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> show = author.show();
        request.setAttribute("author",show);
        request.getRequestDispatcher("AddBook.jsp").forward(request,response);
    }
}
