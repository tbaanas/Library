package pl.sda.servlet;

import pl.sda.entities.Author;
import pl.sda.entities.Book;
import pl.sda.entities.Category;
import pl.sda.service.AuthorService;
import pl.sda.service.CategoryService;

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
   private CategoryService categoryService=new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> show = author.show();
       List<Category> category=categoryService.show();
        request.setAttribute("author",show);
       request.setAttribute("category",category);
        request.setAttribute("bookList", categoryService.show());
        request.getRequestDispatcher("AddBook.jsp").forward(request,response);
    }
}
