<%@ page import="com.decagon.servletmvcsq019.model.Order" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.decagon.servletmvcsq019.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 11/30/23
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PRODUCT APPLICATION</title>
</head>
<body>
<% HttpSession session1 = request.getSession();
    Order order = (Order) session.getAttribute("order");
%>
<h1>
    <%  PrintWriter out1 = response.getWriter();

        out1.println("<h2>Product Dashboard</h2>" +
                "<table>\n" +
                "  <thead> <tr><th>Name </th> <th> Price </th><th> Total Price </th></tr></thead>");
        List<Product> productList = (List<Product>) request.getAttribute("product-list");
        productList.forEach(product -> {
            out1.println(
                    "<tr><td>"+
                            product.getName()+"</td><td>" +
                            product.getProductPrice()+"</td>"
            );
        });

        out1.println("<td>"+order.getTotalPrice()+"</td></tr>");
        out1.println("\n" +
                "</table>");
        out1.println();
        out1.println("<a href ='product?pay="+order.getId()+"'> Make Payment</a>");

    %>
</h1>

</body>
</html>
