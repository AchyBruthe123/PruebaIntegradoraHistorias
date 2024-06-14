package mx.edu.utez.pruebagit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.User;

import java.io.IOException;

@WebServlet(name = "UserServet", value = "/loguin")
public class UserServet extends HttpServlet {
    //init, destry y doPost y/o doGet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        //aqui se va a conectar la base de base de datos para gestionar un usuario
        //y en
        String user_name = request.getParameter("user_name");
        String pass = request.getParameter("pass");
        UserDao dao = new UserDao();
        User u = dao.getOne(user_name, pass);

        String ruta = "index.jsp";
        if (u.getUser_name() != null) {
            // el usuario si existe en la base de datos

        }else {
            //el usuario no existe
            HttpSession sesion = request.getSession();
            sesion.setAttribute("mensaje", "El usuario no existe");
        }
        response.sendRedirect(ruta);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("user_name");
    }
    public void init() throws ServletException {

    }
}
