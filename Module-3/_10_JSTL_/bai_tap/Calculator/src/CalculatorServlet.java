import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstNum = Double.parseDouble(request.getParameter("firstNum"));
        double secondNum = Double.parseDouble(request.getParameter("secondNum"));
        String operator = request.getParameter("operator");

        double result = Calculator.operator(firstNum,secondNum,operator);

        request.setAttribute("Result", result);
        request.setAttribute("First", firstNum);
        request.setAttribute("Second", secondNum);
        request.getRequestDispatcher("result.jsp").forward(request,response);

    }
}
