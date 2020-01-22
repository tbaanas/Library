package pl.sda.servlet;

import pl.sda.entities.Author;
import pl.sda.entities.Category;
import pl.sda.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddAuthor")
public class AddAuthor extends HttpServlet {
  private   AuthorService authorService=new AuthorService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author=new Author();
       author.setFirstName(request.getParameter("firstName"));
       author.setLastName(request.getParameter("lastName"));
       author.setBirthPlace(request.getParameter("birthPlace"));

        authorService.save(author);
        response.sendRedirect("/HomeServlets");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("author", authorService.show());
        request.getRequestDispatcher("AddAuthor.jsp").forward(request,response);
    }
}
