package ListCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Toàn","1983-08-20",1,"Hà Nội", 3,"https://phunugioi.com/wp-content/uploads/2020/01/anh-avatar-supreme-dep-lam-dai-dien-facebook.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam","1983-08-21",1,"Bắc Giang", 7,"https://zicxaphotos.com/wp-content/uploads/2019/07/Tuy%E1%BB%83n-t%E1%BA%ADp-h%C3%ACnh-%E1%BA%A3nh-avatar-c%E1%BA%B7p-%C4%91%E1%BA%B9p-d%E1%BB%85-th%C6%B0%C6%A1ng-28.jpg"));
        customerList.add(new Customer("Huỳnh Yến Nhi","1996-09-15",0,"Đà Nẵng", 11,"https://scr.vn/wp-content/uploads/2020/07/H%C3%ACnh-%C4%91%E1%BA%A1i-di%E1%BB%87n-%C4%91%E1%BA%B9p-1.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa","1983-08-17",1,"Hà Tây", 9,"https://thuthuatnhanh.com/wp-content/uploads/2019/07/anh-dai-dien-dep-de-thuong-cho-facebook-zalo-20.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi","1983-08-19",0,"Hồ Chí Minh", 20,"https://img4.thuthuatphanmem.vn/uploads/2020/08/27/anh-dai-dien-zalo-doc-dao_052909265.jpg"));

        request.setAttribute("customerListFromServlet",customerList);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
