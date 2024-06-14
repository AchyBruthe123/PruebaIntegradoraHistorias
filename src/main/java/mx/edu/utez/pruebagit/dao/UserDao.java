package mx.edu.utez.pruebagit.dao;

import mx.edu.utez.pruebagit.model.User;
import mx.edu.utez.pruebagit.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//me permite hacer funciones crut
public class UserDao {

    //para una lectura de una entidad en la base de datos
    public User getOne(String user_name,String pass){
        User u = new User();
        // los "?" son para evitar la inyeccion de codigo SQL
        String query = "select * from users where user_name=? and pass=sha2(?,256)";


        try {
            //coneccion a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //definir los parametros del query "?"
            ps.setString(1, user_name);
            ps.setString(2, pass);
            // ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            // obtiene la informacion del resultSet
            if (rs.next()){
                //el usuario si existe en la base de datos
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setCody(rs.getString("cody"));
                u.setEmail(rs.getString("email"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return u;
    }
}
