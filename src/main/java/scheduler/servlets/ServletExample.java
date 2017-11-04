package scheduler.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("userName");
        String pw = req.getParameter("password");
        String ip = req.getRemoteAddr();
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<p>Your IP address is: " + ip + "</p>");
        resp.getWriter().println("<p>Your name is: " + uid + "</p>");
        resp.getWriter().println("<p>Your pw is: " + pw + "</p>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}
