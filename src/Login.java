import com.mky.dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");

        AdminDao admin =new AdminDao();
        try {
            boolean is = admin.findByUsername(name);
            if(is)
            {
                HttpSession session = req.getSession();
                session.setAttribute("loginAdmin", admin);
                resp.sendRedirect("index.jsp");
            }
            else
            {
                System.out.println("<h3>失败</h3>");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
