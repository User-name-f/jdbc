import com.mky.dao.ClazzDao;
import com.mky.dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Clazz;
import pojo.student;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * 处理 addStudent.jsp 表单的提交：
 * 先检查各个输入框，再往数据库里插入一条学生记录，
 * 成功后跳回学生列表页；有错误就带着提示信息回到添加页面。
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String studentNo = req.getParameter("student_no");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String clazzId = req.getParameter("clazz_id");
        String phone = req.getParameter("phone");
        String enrollYear = req.getParameter("enroll_year");
        String status = req.getParameter("status");

        student stu = new student();
        stu.setStudent_no(studentNo);
        stu.setName(name);
        stu.setGender(gender);
        stu.setClazz_id(Integer.valueOf(clazzId));
        stu.setPhone(phone);
        stu.setEnroll_year(Integer.valueOf(enrollYear));
        stu.setStatus(Integer.valueOf(status));

        try {
            new StudentDao().insert(stu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 添加成功后回到学生列表页，新加的学生就会显示出来
        resp.sendRedirect("student");
    }
}
