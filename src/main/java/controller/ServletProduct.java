package controller;

import model.Product;
import sevicer.ProductSevicer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProduct", value = "/products")
public class ServletProduct extends HttpServlet {
    ProductSevicer productSevicer=new ProductSevicer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showUp(request,response);
        }
    }



    private void showUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("product/listUp.jsp");
        String key = request.getParameter("key");
        List<Product> productList= productSevicer.findAll();
        if (key != null) {
           productList = productSevicer.findByName(key);
        }
        request.setAttribute("danhSach",productList);
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
