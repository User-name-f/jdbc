import com.mky.dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");
        String remember =req.getParameter("remember");

        AdminDao admin =new AdminDao();
        try {
            boolean is = admin.findByUsername(name);
            if(is)
            {
                HttpSession session = req.getSession();
                session.setAttribute("loginAdmin", name);
                session.setAttribute("loginpwd", pwd);

                if ("1".equals(remember)) {
                    Cookie cookie = new Cookie("loginAdmin", name);
                    Cookie cookie1 = new Cookie("loginpwd", pwd);
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    cookie1.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(cookie);
                    resp.addCookie(cookie1);
                }


                resp.sendRedirect("sucess.jsp");
                System.out.println(is);
            }
            else
            {
                System.out.println(is);
                resp.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
