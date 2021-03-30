package controller;

import model.Employee;
import service.employee.EmployeeService;
import service.employee.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String user = request.getParameter("userName");
        String position = request.getParameter("position");
        String education = request.getParameter("educationDegree");
        String division = request.getParameter("division");

        Employee employee = new Employee(name,date,idCard,salary,phone,email,address,user,position,education,division);
        String messenger = employeeService.insertEmployee(employee);
        request.setAttribute("messenger", messenger);
        if (messenger.equals("OK")){
            listEmployee(request, response);
        } else {
            showNewForm(request, response);
        }



    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String userName = request.getParameter("userName");
        String position = request.getParameter("position");
        String education = request.getParameter("educationDegree");
        String division = request.getParameter("division");

        Employee employee = new Employee(id,name,date,idCard,salary,phone,email,address,userName,position,education,division);
        employeeService.updateEmployee(employee);
        listEmployee(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
            default:
                listEmployee(request,response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Employee> employeeList = employeeService.findEmployee(name);

        request.setAttribute("employeeList", employeeList);

        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("employee/create.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);

        listEmployee(request, response);

//        List<Employee> employeeList = employeeService.findAllEmployee();
//        request.setAttribute("employeeList", employeeList);
//        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findEmployee(id);
        request.setAttribute("employee",employee);

        request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAllEmployee();
        request.setAttribute("employeeList", employeeList);

        request.getRequestDispatcher("employee/list.jsp").forward(request, response);

    }
}
