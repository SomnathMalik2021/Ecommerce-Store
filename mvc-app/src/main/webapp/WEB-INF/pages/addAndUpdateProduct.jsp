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
 .form-section input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.form-section input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.form-section input[type=submit]:hover {
  background-color: #45a049;
}

.form-section {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
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
            <c:if test="${addOrUpdate==0}">
            <li><a class="active" href="/product-section/addOrUpdate/0">ADD Product</a></li>
            <li><a href="/product-section/addOrUpdate/1">Update Product</a></li></c:if>
            <c:if test="${addOrUpdate==1}">
            <li><a  href="/product-section/addOrUpdate/0">ADD Product</a></li>
            <li><a class="active" href="/product-section/addOrUpdate/1">Update Product</a></li>
            </c:if>
            <li><a  href="/product-section/0">
            All Products
            </a></li>
            <li><div class="search">
            <form action="/product-section/search/0" method="post">
            <input type="text" placeholder="Enter merchant" name="merchant">
            <input type="Submit" value="Search">
            </form>
            </div></li>
          </ul>
        </div>
        <div class="form-section">
        <c:if test="${addOrUpdate==0}">
  <form action="/product-section/addOrUpdate/${addOrUpdate}" method="post">
    <label for="product_id">Product Id</label>
    <input type="text" id="product_id" name="product_id" placeholder="Enter Product's ID">

    <label for="ProductName">Product Name</label>
    <input type="text" id="ProductName" name="ProductName" placeholder="Enter Product's Name">
	
	<label for="lname">Merchant</label>
    <input type="text" id="merchant" name="merchant" placeholder="Enter Merchant">
    <label for="lname">Inventory</label>
    <input type="text" id="inventory" name="inventory" placeholder="Inventory...">
     <input type="submit" value="Add Product">
  </form>
  </c:if>
  <c:if test="${addOrUpdate==1}">
   <form action="/product-section/addOrUpdate/${addOrUpdate}" method="post">
    <label for="product_id">Product Id</label>
    <input type="text" id="product_id" name="product_id" placeholder="Enter Product's ID">

    <label for="ProductName">Product Name</label>
    <input type="text" id="ProductName" name="ProductName" placeholder="Enter Product's Name">
	
	<label for="lname">Merchant</label>
    <input type="text" id="merchant" name="merchant" placeholder="Enter Merchant">
    <label for="lname">Inventory</label>
    <input type="text" id="inventory" name="inventory" placeholder="Inventory...">
     <input type="submit" value="Update Product">
  </form>
  </c:if>
    </div>
    </div>

</body>
</html>