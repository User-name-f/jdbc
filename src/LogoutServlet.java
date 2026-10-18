import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();                    // 整个 session 作废（推荐）
        }

        // ② 清除“记住登录”的 Cookie
        Cookie cookie = new Cookie("loginAdmin", "");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

        // ③ 跳回登录页
        resp.sendRedirect("login.jsp");
    }
}
