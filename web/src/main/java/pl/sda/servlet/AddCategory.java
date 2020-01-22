package pl.sda.servlet;

import pl.sda.entities.Category;
import pl.sda.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
    private CategoryService categoryService=new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        category.setCategory(request.getParameter("category"));

        categoryService.save(category);
        response.sendRedirect("/HomeServlets");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("bookList", categoryService.show());
        request.getRequestDispatcher("AddCategory.jsp").forward(request,response);
    }
}
