package controller;

import model.SortByName;
import model.User;
import repository.Impl.UserRepositoryImpl;
import repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"","/users"})
public class UserServlet extends HttpServlet {

    private UserRepository repository = new UserRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String city = request.getParameter("city");

        User book = new User(id, name, email, city);
        repository.updateUser(book);
        request.getRequestDispatcher("user/edit.jsp").forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        User newUser = new User(name, email, city);
        repository.insertUserStore(newUser);

        request.getRequestDispatcher("user/create.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "create":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteUser(request, response);
                        break;
                    case "city":
                        findByCity(request, response);
                        break;
                    case "sortByName":
                        listUserSort(request, response);
                        break;
                    case "permision":
                        addUserPermision(request, response);
                        break;
                    case "test-without-tran":
                        testWithoutTran(request, response);
                        break;
                    default:
                        listUser(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        repository.insertUpdateWithoutTransaction();
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("kien", "kienhoang@gmail.com", "vn");

        int[] permision = {1, 2, 4};

        repository.addUserTransaction(user, permision);
    }

    private void listUserSort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = repository.selectAllUsers();
        SortByName sortByName = new SortByName();
        listUser.sort(sortByName);
        request.setAttribute("listUser", listUser);

        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }


    private void findByCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        List<User> users = repository.selectUserByCity(city);
        request.setAttribute("listUser", users);

        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = repository.showAllUser();
        request.setAttribute("listUser", listUser);

        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        repository.deleteUser(id);

        List<User> listUser = repository.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = repository.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
