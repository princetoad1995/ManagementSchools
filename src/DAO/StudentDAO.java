/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ClassName;
import Model.Student;
import java.util.List;

/**
 *
 * @author PRINCE D. TOAD
 */
public interface StudentDAO {
    public List<ClassName> getAllListClassName();
    public List<Student> getAllListStudent();
    public Student getItemClassName(int id);
    public void addStudent(Student student);
    public void editStudent(Student student);
    public void deleteStudent(int id);
    public void changePasswordAdmin(String newPass, int id);
}
