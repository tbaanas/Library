package pl.sda.servlet;

import pl.sda.entities.Users;
import pl.sda.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
  private   UsersService usersService=new UsersService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Users user=new Users();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        if (!password.equals(password2)) {
            response.sendRedirect("/register.jsp?error=pass");
        }else {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            usersService.save(user);
            request.setAttribute("Success","Success");
            request.getRequestDispatcher("/new/index.jsp").forward(request,response);
        }








    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
