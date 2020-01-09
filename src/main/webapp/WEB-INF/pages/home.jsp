<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<div class="card">
    <div class="content">
        <div class="field">
            mobileNo :  <c:out value="${user.mobileNo}"/>
        </div>
        <div class="field">
            Name : <c:out value="${user.name}"/>
        </div>
        <div class="field">
            Account type :  <c:out value="${user.accountType}"/>
         </div>
         <div class="field">
            Balance : <c:out value="${user.balance}"/>
         </div>
    </div>
</div>
<div class="abc">
    <a href="/signout">Sign out</a>
</div>


</body>

<style>
body {
  background: #76b852;
  text-align: center;
}

.card {
  background: floralwhite;
  border-radius: 2px;
  text-align: left;
  display: inline-block;
  height: 300px;
  margin: 1rem;
  position: relative;
  width: 300px;
  box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
}

.field {
  margin: 10px;
      height: 20px;
      padding: 20px;
      background-color: beige;
}

.abc {
font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 20%;
  margin: auto;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
</style>

</html>