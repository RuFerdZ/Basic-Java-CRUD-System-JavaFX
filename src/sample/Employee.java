package sample;

import java.util.Date;

public class Employee{
    private String emp_ID;
    private String emp_fname;
    private String emp_lname;
    private String emp_DOB;
    private String emp_phone;
    private String emp_address;
    private String emp_roleID_01;
    private String emp_roleID_02;
    private String emp_roleID_03;

    public void setEmp_ID(String ID){
        this.emp_ID=ID;
    }

    public void setEmp_fname(String fname){
        this.emp_fname=fname;
    }

    public void setEmp_lname(String lname){
        this.emp_lname=lname;
    }

    public void setEmp_DOB(String date){
        this.emp_DOB=date;
    }

    public void setEmp_phone(String no){
        this.emp_phone=no;
    }

    public void setEmp_address(String address){
        this.emp_address=address;
    }

    public void setEmp_roleID_01(String ID){
        this.emp_roleID_01=ID;
    }

    public void setEmp_roleID_02(String ID){
        this.emp_roleID_02=ID;
    }

    public void setEmp_roleID_03(String ID){
        this.emp_roleID_03=ID;
    }

    public String getEmp_ID(){
        return emp_ID;
    }

    public String getEmp_fname(){
        return emp_fname;
    }

    public String getEmp_lname(){
        return emp_lname;
    }

    public String getEmp_DOB(){
        return emp_DOB;
    }

    public String getEmp_phone(){
        return emp_phone;
    }

    public String getEmp_address(){
        return emp_address;
    }

    public String getEmp_roleID_01(){
        return this.emp_roleID_01;
    }

    public String getEmp_roleID_02(){
        return this.emp_roleID_02;
    }

    public String getEmp_roleID_03(){
        return this.emp_roleID_03;
    }
}