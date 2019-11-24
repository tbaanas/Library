package pl.sda.servlet;

import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Action")
public class Action extends HttpServlet {
    BookService bookService=new BookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id=1;
        if(request.getParameter("bookId")!=null){
            id = Integer.parseInt(request.getParameter("bookId"));
        }

        switch (action) {
            case "ADD": {
              response.sendRedirect("/ToBookAddServlet");
                break;
            }
            case "EDIT": {

                response.sendRedirect("/EditBookServlet?bookID="+id);
                break;
            }
            case "SHOW": {

                response.sendRedirect("/ShowBookDetails?bookID="+id);
                break;
            }
            case "DELETE": {
                bookService.delete(id);
                response.sendRedirect("/HomeServlets");
                break;
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
