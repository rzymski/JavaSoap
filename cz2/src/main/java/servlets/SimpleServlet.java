package servlets;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "simpleServlet", value = "/simple-servlet")
public class SimpleServlet extends HttpServlet {
    private String headerText;

    public void init() {
        headerText = "I love Pizza!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + headerText + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
