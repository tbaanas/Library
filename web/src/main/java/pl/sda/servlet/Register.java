package pl.sda.servlet;

import pl.sda.entities.Users;
import pl.sda.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private UsersService usersService = new UsersService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = new Users();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");





        if (!password.equals(password2)) {
            response.sendRedirect("/register.jsp?error=pass");
        } else {


            String original = password;
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer md5pass = new StringBuffer();
            for (byte b : digest) {
                md5pass.append(String.format("%02x", b & 0xff));
            }




            usersService.save(user);
            request.setAttribute("Success", "Success");
String con="https://webtom.herokuapp.com/Hash/"+md5pass.toString();

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
