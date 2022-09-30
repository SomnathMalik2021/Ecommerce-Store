<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecomerce-Shop</title>
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
        </style>
</head>
<body>
<div class="container">
        <div class="header">
            <ul>
                <li><a  class="active" href="/">Home</a></li>
                <li><a href="/order-section">Orders</a></li>
                <li><a href="/product-section/0">Products</a></li>
                <li><a href="#about">About</a></li>
              </ul>
        </div>
        <div class="main">
            
        </div>
    </div>
</body>
</html>