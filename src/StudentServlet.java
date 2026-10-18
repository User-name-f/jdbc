import com.mky.dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.student;

import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String keyword = req.getParameter("keyword");   // 姓名/学号
        String college = req.getParameter("college");   // 学院

        List<student> list;
        try {
            list = new StudentDao().search(keyword, college);
        } catch (Exception e) {
            throw new ServletException("查询学生信息失败", e);
        }

        req.setAttribute("studentList", list);
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
