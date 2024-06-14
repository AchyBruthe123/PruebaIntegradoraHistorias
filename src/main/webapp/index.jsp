<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form method="post" action="login">
        <label>ingrese su usuario</label>
        <input type="text" name="user_name">
        <br>
        <label>ingrese su contraseña</label>
        <input type="password" name="pass">
        <br>
        <%

            HttpSession sesion = request.getSession();
            String mensaje = (String) sesion.getAttribute("Mensaje");

            if (mensaje != null) {
        %>
        <p style="color: red"><%=mensaje%></p>
            <% } %>
        <input type="submit" value="Iniciar sesión">
    </form>
</body>
</html>