package Controller;

import Model.Product;
import Service.Impl.ProductServiceImpl;
import Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/products"})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateUpdate(request, response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        if (product == null){
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/view.jsp").forward(request,response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        if (product == null){
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            this.productService.remove(id);
            response.sendRedirect("/products");
        }
    }

    private void updateUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = this.productService.findById(id);

        if (product == null){
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setProducer(producer);
            this.productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message", "Product information was updated");
            request.getRequestDispatcher("product/edit.jsp").forward(request, response);
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        int id = (int)(Math.random() * 10000);

        Product product = new Product(id,name,price,description,producer);
        this.productService.save(product);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
        request.setAttribute("massage","New product was created");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        if (product == null){
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/delete.jsp").forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        if (product == null){
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/edit.jsp").forward(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);

        request.getRequestDispatcher("product/list.jsp").forward(request,response);
    }
}
