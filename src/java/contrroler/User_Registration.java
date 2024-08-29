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

@WebServlet(name = "User_Registration", urlPatterns = {"/User_Registration"})
public class User_Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();

        User user = gson.fromJson(req.getReader(), User.class);

        System.out.println(user.getMobile());
        System.out.println(user.getName());

        HashMap<String, User> userMap = (HashMap<String, User>) req.getServletContext().getAttribute("userMap");

        JsonObject jsonObject = new JsonObject();

        if (userMap.containsKey(user.getMobile())) {
            jsonObject.addProperty("msg", "error1");
        } else {
            userMap.put(user.getMobile(), user);
            jsonObject.addProperty("msg", "success");
        }

        resp.setContentType("application/json");
        System.out.println(jsonObject);
        resp.getWriter().write(gson.toJson(jsonObject));
        
    }

}
