/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PRINCE D. TOAD
 */
public class Student {

    private int id;
    private ClassName nameClass;
    private String password;
    private String fullname;
    private int pointMath;
    private int pointPhysical;
    private int pointChemistry;
    private int pointBiological;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassName getNameClass() {
        return nameClass;
    }

    public void setNameClass(ClassName nameClass) {
        this.nameClass = nameClass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPointMath() {
        return pointMath;
    }

    public void setPointMath(int pointMath) {
        this.pointMath = pointMath;
    }

    public int getPointPhysical() {
        return pointPhysical;
    }

    public void setPointPhysical(int pointPhysical) {
        this.pointPhysical = pointPhysical;
    }

    public int getPointChemistry() {
        return pointChemistry;
    }

    public void setPointChemistry(int pointChemistry) {
        this.pointChemistry = pointChemistry;
    }

    public int getPointBiological() {
        return pointBiological;
    }

    public void setPointBiological(int pointBiological) {
        this.pointBiological = pointBiological;
    }

}
