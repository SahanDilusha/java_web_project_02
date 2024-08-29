package contrroler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "User_Logout", urlPatterns = {"/User_Logout"})
public class User_Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("user_login.html");
    }

}
