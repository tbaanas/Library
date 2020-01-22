package pl.sda.servlet;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import pl.sda.entities.Book;
import pl.sda.entities.Users;
import pl.sda.service.BookService;
import pl.sda.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private UsersService usersService = new UsersService();
    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login, password;
        login = request.getParameter("username");
        password = request.getParameter("password");


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
        Users user = usersService.uid(login, md5pass.toString()).get(0);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);

        List<Book> show = bookService.show();
        request.setAttribute("books", show);

        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
