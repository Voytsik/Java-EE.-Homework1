import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    String login = "admin";
    String password = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String loginUser = request.getParameter("userlogin");
        String passwordUser = request.getParameter("userpassword");

        try {
            if (loginUser.equals(login) && passwordUser.equals(password)) {
                writer.println("<p>Welcome to our site!</p>");
            } else if (loginUser.equals(login)) {
                writer.println("<p>You entered uncorrect password!</p>");
            } else {
                writer.println("<p>You entered uncorrect login!</p>");
            }
        } finally {
            writer.close();
        }
    }
}