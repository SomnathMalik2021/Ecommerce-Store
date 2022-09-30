<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<style>
        *{
            margin:0;
            padding:0;
        }
        .header{
            height:20%;
        }
        ul {
          display: flex;
          flex-direction: row;
          justify-content: flex-start;
          list-style-type: none;
          margin: 0;
          padding: 0;
          overflow: hidden;
          border: 1px solid #e7e7e7;
          background-color: #f3f3f3;
        }
        
        li a {
          display: block;
          color: #666;
          text-align: center;
          padding: 14px 16px;
          text-decoration: none;
        }
        
        li a:hover:not(.active) {
          background-color: #ddd;
        }
        
        li a.active {
          color: white;
          background-color: #04AA6D;
        }
        .search{
            padding:10px;
        }
        #customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
.navigator ul{
    justify-content: space-between;
}
        </style>
<body>
<div class="container">
        <div class="header">
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/order-section">Orders</a></li>
                <li><a class="active" href="/product-section/0">Products</a></li>
                <li><a href="#about">About</a></li>
              </ul>
        </div>
        <div class="main">
            <ul>
            <li><a href="/product-section/addOrUpdate/0">ADD Product</a></li>
            <li><a href="/product-section/addOrUpdate/1">Update Product</a></li>
            <li><a class="active" href="/product-section/0">
            <c:if test="${isSearching}">
            Search Result [X]
            </c:if>
            <c:if test="${!isSearching}">
            All Products
            </c:if>
            </a></li>
            <li><div class="search">
            <form action="/product-section/search/0" method="post">
            <input type="text" placeholder="Enter merchant" name="merchant">
            <input type="Submit" value="Search">
            </form>
            </div></li>
          </ul>
        </div>
        <div class="list">
            <table id="customers">
                <tr>
                  <th>Product Id</th>
                  <th>Product Name</th>
                  <th>Merchant</th>
                  <th>Inventory</th> 
                </tr>
                <tbody>
                <c:forEach items="${products}" var="product">
   	    <tr>
   			<td>${product.productId}</td>
   			<td>${product.productName}</td>
   			<td>${product.merchant}</td>
   			<td>${product.inventory}</td>
   		</tr>
   	    </c:forEach>
                </tbody>
              </table>
        </div>
        <c:if test="${isSearching}">
        <div class="navigator">
            <ul>
            <c:if test="${pageNo > 0}">
       <li><a href="/product-section/search/${merchant}/${pageNo - 1}">Previous</a></li>
   </c:if>
   <c:if test="${hasNextPage}">
      <li> <a href="/product-section/search/${merchant}/${pageNo + 1}">Next</a></li>
   </c:if>
            </ul>
        </div>
        </c:if>
        <c:if test="${!isSearching}">
        <div class="navigator">
            <ul>
            <c:if test="${pageNo > 0}">
       <li><a href="/product-section/${pageNo - 1}">Previous</a></li>
   </c:if>
   <c:if test="${hasNextPage}">
      <li> <a href="/product-section/${pageNo + 1}">Next</a></li>
   </c:if>
            </ul>
        </div>
        </c:if>
        
    </div>

</body>
</html>