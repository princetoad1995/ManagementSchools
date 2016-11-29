/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.LoginDAO;
import Model.ClassName;
import Model.Student;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PRINCE D. TOAD
 */
public class LoginDAOImpl implements LoginDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public LoginDAOImpl() {
        this.conn = ConnectionDB.getConnection();
    }

    @Override
    public boolean checkLoginAdmin(String name, String password) {
        String query = "select * from admin where username = ? and password = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Student checkLoginStudent(int id, String password) {
        String query = "select * from student where id = ? and password = ?";
        Student student = new Student();
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {

                ClassName className = new ClassName();
                className.setId(rs.getInt("idClass"));
                student.setId(rs.getInt("id"));
                student.setPassword(rs.getString("password"));
                student.setFullname(rs.getString("fullname"));
                student.setPointMath(rs.getInt("pointMath"));
                student.setPointPhysical(rs.getInt("pointPhysical"));
                student.setPointChemistry(rs.getInt("pointChemistry"));
                student.setPointBiological(rs.getInt("pointBiological"));
                student.setNameClass(className);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

}
