/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Student;

/**
 *
 * @author PRINCE D. TOAD
 */
public interface LoginDAO {
    public boolean checkLoginAdmin(String name, String password);
    public Student checkLoginStudent(int id, String password);
}
