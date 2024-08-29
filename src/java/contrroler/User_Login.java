package contrroler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "User_Login", urlPatterns = {"/User_Login"})
public class User_Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        User user = gson.fromJson(request.getReader(), User.class);

        HashMap<String, User> userMap = (HashMap<String, User>) request.getServletContext().getAttribute("userMap");

        if (userMap.containsKey(user.getMobile())) {

            if (userMap.get(user.getMobile()).getPassword().equals(user.getPassword())) {
                request.getSession().setAttribute("user", userMap.get(user.getMobile()));
                jsonObject.addProperty("msg", "success");
            } else {
                jsonObject.addProperty("msg", "error2");
            }

        } else {
            jsonObject.addProperty("msg", "error2");
        }

        response.setContentType("application/json");
        System.out.println(jsonObject);
        response.getWriter().write(gson.toJson(jsonObject));

    }

}
