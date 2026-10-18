import com.mky.dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 处理 student.jsp 里“删除”链接发过来的请求：
 * 按学号把学生从数据库中删除，然后把结果以 JSON 返回给页面。
 * 页面收到 success 为 true 后，就把对应的那一行从表格里移除。
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        String studentNo = req.getParameter("student_no");
        if (studentNo == null || studentNo.trim().isEmpty()) {
            resp.getWriter().print("{\"success\":false,\"message\":\"没有拿到学号\"}");
            return;
        }
        studentNo = studentNo.trim();

        try {
            int count = new StudentDao().deleteById(studentNo);
            if (count > 0) {
                resp.getWriter().print("{\"success\":true}");
            } else {
                resp.getWriter().print("{\"success\":false,\"message\":\"没有找到该学号对应的学生\"}");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().print("{\"success\":false,\"message\":\"删除失败\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
