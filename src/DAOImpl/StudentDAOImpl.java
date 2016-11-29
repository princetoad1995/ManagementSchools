/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.StudentDAO;
import Model.ClassName;
import Model.Student;
import Utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PRINCE D. TOAD
 */
public class StudentDAOImpl implements StudentDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;

    public StudentDAOImpl() {
        this.conn = ConnectionDB.getConnection(); // ket noi vao DB
    }

    @Override
    public List<ClassName> getAllListClassName() { 
        List<ClassName> listClass = new ArrayList<ClassName>();

        String query = "SELECT * FROM class";
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                ClassName className = new ClassName();
                className.setName(rs.getString("name"));

                listClass.add(className);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClass;
    }

    @Override
    public List<Student> getAllListStudent() {
        List<Student> listStudent = new ArrayList<Student>();

        String query = "SELECT * FROM student";

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                ClassName className = new ClassName();
                className.setId(rs.getInt("idClass"));
                student.setId(rs.getInt("id"));
                student.setFullname(rs.getString("fullname"));
                student.setPointMath(rs.getInt("pointMath"));
                student.setPointPhysical(rs.getInt("pointPhysical"));
                student.setPointChemistry(rs.getInt("pointChemistry"));
                student.setPointBiological(rs.getInt("pointBiological"));
                student.setNameClass(className);
                listStudent.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent;
    }

    public String getClassName(int id) {
        ClassName className = new ClassName();
        String query = "SELECT * FROM class WHERE id = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                className.setId(id);
                className.setName(rs.getString("name"));
            }
            return className.getName();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Student getItemClassName(int id) {
        Student student = new Student();
        String query = "SELECT * FROM student WHERE id = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                ClassName className = new ClassName();
                className.setId(rs.getInt("idClass"));
                student.setId(id);
                student.setFullname(rs.getString("fullname"));
                student.setPointMath(rs.getInt("pointMath"));
                student.setPointPhysical(rs.getInt("pointPhysical"));
                student.setPointChemistry(rs.getInt("pointChemistry"));
                student.setPointBiological(rs.getInt("pointBiological"));
                student.setNameClass(className);
            }
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Student> getListStudentByClass(int idClass){
        List<Student> listStudent = new ArrayList<Student>();
        String query = "SELECT * FROM student WHERE idClass = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idClass);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Student student = new Student();
                ClassName className = new ClassName();
                className.setId(rs.getInt("idClass"));
                student.setId(rs.getInt("id"));
                student.setFullname(rs.getString("fullname"));
                student.setPointMath(rs.getInt("pointMath"));
                student.setPointPhysical(rs.getInt("pointPhysical"));
                student.setPointChemistry(rs.getInt("pointChemistry"));
                student.setPointBiological(rs.getInt("pointBiological"));
                student.setNameClass(className);
                listStudent.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent;
    }
    
    public int getIdClass(String nameClass){
        ClassName cn = new ClassName();
        String query = "SELECT id FROM class WHERE name = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, nameClass);
            rs = ps.executeQuery();
            
            if(rs.next())
                return rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<Student> getListStudentByNameByIdClass(int idClass, String name) {
        List<Student> listStudent = new ArrayList<Student>();

        String query = "SELECT * FROM student WHERE idClass = ? AND fullname LIKE '%"+name+"%'";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idClass);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                ClassName className = new ClassName();
                className.setId(rs.getInt("idClass"));
                student.setId(rs.getInt("id"));
                student.setFullname(rs.getString("fullname"));
                student.setPointMath(rs.getInt("pointMath"));
                student.setPointPhysical(rs.getInt("pointPhysical"));
                student.setPointChemistry(rs.getInt("pointChemistry"));
                student.setPointBiological(rs.getInt("pointBiological"));
                student.setNameClass(className);
                listStudent.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent;
    }
    
    public List<Student> getListStudentByName(String name) {
        List<Student> listStudent = new ArrayList<Student>();

        String query = "SELECT * FROM student WHERE fullname LIKE '%"+name+"%'";

        try {
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                ClassName className = new ClassName();
                className.setId(rs.getInt("idClass"));
                student.setId(rs.getInt("id"));
                student.setFullname(rs.getString("fullname"));
                student.setPointMath(rs.getInt("pointMath"));
                student.setPointPhysical(rs.getInt("pointPhysical"));
                student.setPointChemistry(rs.getInt("pointChemistry"));
                student.setPointBiological(rs.getInt("pointBiological"));
                student.setNameClass(className);
                listStudent.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudent;
    }
    
//    public static void main(String[] args) {
//        System.out.println("" + new StudentDAOImpl().getIdClass("CN1") );
//    }

    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO student (idClass, password, fullname) VALUES (?, ?, ?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, student.getNameClass().getId());
            ps.setString(2, student.getPassword());
            ps.setString(3, student.getFullname());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editStudent(Student student) {
        String query = "UPDATE student SET idClass = ?, "
                + "fullname = ?, "
                + "pointMath = ?, "
                + "pointPhysical = ?, "
                + "pointChemistry = ?, "
                + "pointBiological = ? "
                + "WHERE id = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, student.getNameClass().getId());
            ps.setString(2, student.getFullname());
            ps.setInt(3, student.getPointMath());
            ps.setInt(4, student.getPointPhysical());
            ps.setInt(5, student.getPointChemistry());
            ps.setInt(6, student.getPointBiological());
            ps.setInt(7, student.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ClassName getClassName(String nameClass){
        ClassName cn = new ClassName();
        String query = "SELECT * FROM class WHERE name = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, nameClass);
            rs = ps.executeQuery();
            
            if(rs.next()){
                cn.setId(rs.getInt("id"));
                cn.setName(nameClass);
            }
            return cn;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    @Override
    public void changePasswordAdmin(String newPass, int id) {
        String query = "UPDATE student SET password = ? WHERE id = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setInt(2, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
