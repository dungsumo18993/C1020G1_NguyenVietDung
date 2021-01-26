package controller;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/studentServlet"})
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1, "Duong", "25/01/2021", 1, 4));
//        studentList.add(new Student(2, "Van Phuc", "26/01/2021", 0, 6));
//        studentList.add(new Student(3, "Luong", "27/01/2021", 0, 9));

        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "update":
                Integer id = Integer.parseInt(request.getParameter("id"));
                Student student = studentService.findById(id);

                request.setAttribute("studentInfo", student);
                request.getRequestDispatcher("update_student.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("studentListFromServlet", studentService.findAll());
                request.setAttribute("tmp", "<p style='color: red'>Hello C10</p>");
                request.getRequestDispatcher("list_student.jsp").forward(request, response);
        }


    }
}
