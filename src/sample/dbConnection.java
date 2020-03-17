package sample;

import javafx.fxml.FXML;

import javax.swing.*;
import java.sql.*;

public class dbConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public dbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_consultancy_firm", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.println("Connection error...");
        }
    }

//----------------------CUSTOMER SECTION---------------------------------------------------------

    public boolean addCustomer(Customer obj){
        PreparedStatement pst=null;

        try{
            pst=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
            pst.setString(1,obj.getCustomer_ID());
            pst.setString(2,obj.getCustomer_fname());
            pst.setString(3,obj.getCustomer_lname());
            pst.setString(4,obj.getCustomer_no());
            pst.setString(5,obj.getCustomer_address());
            pst.setString(6,obj.getCustomer_contract());
            pst.executeUpdate();
            return true;
        }catch(Exception em){
            JOptionPane.showMessageDialog(null,"Customer ID already exists!!!");
            return false;
        }
    }

    public Customer searchCustomer(Customer obj){
       try{
           String query="SELECT * FROM customer ";
           rs=st.executeQuery(query);
           while (rs.next()){
               if (rs.getString("cus_ID").equals(obj.getCustomer_ID())) {
                   obj.setCustomer_fname(rs.getString("cus_fname"));
                   obj.setCustomer_lname(rs.getString("cus_lname"));
                   obj.setCustomer_no(rs.getString("cus_phone"));
                   obj.setCustomer_address(rs.getString("cus_address"));
                   obj.setCustomer_contract(rs.getString("cus_contractID"));
                   break;
               }
           }
           return obj;


        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Such ID doesn't exist ");
            return null;
        }
    }

    public boolean updateCustomer(Customer obj){

            PreparedStatement pst=null;
            try{
                pst=con.prepareStatement("update customer set cus_fname=?,cus_lname=?,cus_phone=?,cus_address=?,cus_contractID=? where cus_ID=?");
                pst.setString(1,obj.getCustomer_fname());
                pst.setString(2,obj.getCustomer_lname());
                pst.setString(3,obj.getCustomer_no());
                pst.setString(4,obj.getCustomer_address());
                pst.setString(5,obj.getCustomer_contract());
                pst.setString(6,obj.getCustomer_ID());
                pst.executeUpdate();
                return true;
            }catch(Exception e){
                return false;
            }
    }

    public boolean deleteCustomer(Customer obj){
        PreparedStatement pst=null;
        try{
            pst=con.prepareStatement("delete from customer where cus_ID=?");
            pst.setString(1,obj.getCustomer_ID());
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Role viewRole(Role obj){
        try{
            String query="SELECT * FROM role ";
            rs=st.executeQuery(query);
            while (rs.next()){
                if (rs.getString("role_description").equals(obj.getRoleName())) {
                    obj.setRoleID(rs.getString("role_ID"));
                    obj.setPay(Double.parseDouble(rs.getString("role_hourlyPay")));
                    break;
                }
            }
            return obj;


        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Connection Error ");
            return null;
        }
        }

        public void updateRole(Role obj){
            PreparedStatement pst=null;
            try{
                pst=con.prepareStatement("update role set role_hourlyPay=? where role_ID=?");
                pst.setDouble(1,obj.getPay());
                pst.setString(2,obj.getRoleID());


            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Connection error!!!");
            }
        }
//------------------------------------EMPLOYEE SECTION-----------------------------------
    public boolean addEmp(Employee obj){
        PreparedStatement pst=null;

        try{
            pst=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1,obj.getEmp_ID());
            pst.setString(2,obj.getEmp_fname());
            pst.setString(3,obj.getEmp_lname());
            pst.setString(4,obj.getEmp_DOB());
            pst.setString(5,obj.getEmp_phone());
            pst.setString(6,obj.getEmp_address());
            pst.setString(7,obj.getEmp_roleID_01());
            pst.setString(8,obj.getEmp_roleID_02());
            pst.setString(9,obj.getEmp_roleID_03());
            pst.executeUpdate();
            return true;
        }catch(Exception em){
            JOptionPane.showMessageDialog(null,"Employee ID already exists!!!");
            return false;
        }
    }

    public Employee viewEmp(Employee obj){
        try{
            String query="SELECT * FROM employee ";
            rs=st.executeQuery(query);
            while (rs.next()){
                if (rs.getString("emp_ID").equals(obj.getEmp_ID())) {
                    obj.setEmp_fname(rs.getString("emp_fname"));
                    obj.setEmp_lname(rs.getString("emp_lname"));
                    obj.setEmp_DOB(rs.getString("emp_DOB"));
                    obj.setEmp_phone(rs.getString("emp_phone"));
                    obj.setEmp_address(rs.getString("emp_address"));
                    obj.setEmp_roleID_01(rs.getString("emp_roleID_01"));
                    obj.setEmp_roleID_02(rs.getString("emp_roleID_02"));
                    obj.setEmp_roleID_03(rs.getString("emp_roleID_03"));
                    break;
                }
            }
            return obj;


        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Connection Error ");
            return null;
        }
    }

    public boolean updateEmp(Employee obj){
        PreparedStatement pst=null;
        try{
            pst=con.prepareStatement("update employee set emp_fname=?,emp_lname=?,emp_DOB=?,emp_phone=?,emp_address=?,emp_roleID_01=?,emp_roleID_02=?,emp_roleID_03=? where emp_ID=?");
            pst.setString(1,obj.getEmp_fname());
            pst.setString(2,obj.getEmp_lname());
            pst.setString(3,obj.getEmp_DOB());
            pst.setString(4,obj.getEmp_phone());
            pst.setString(5,obj.getEmp_address());
            pst.setString(6,obj.getEmp_roleID_01());
            pst.setString(7,obj.getEmp_roleID_02());
            pst.setString(8,obj.getEmp_roleID_03());
            pst.setString(9,obj.getEmp_ID());
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean deleteEmp(Employee obj){
        PreparedStatement pst=null;
        try{
            pst=con.prepareStatement("delete from employee where emp_ID=?");
            pst.setString(1,obj.getEmp_ID());
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }

//------------------------------------CONTRACT SECTION------------------------------------

    public boolean addCon(Contract obj){
        PreparedStatement pst=null;

        try{
            pst=con.prepareStatement("insert into contract values(?,?,?,?,?,?)");
            pst.setString(1,obj.getCon_ID());
            pst.setString(2,obj.getCon_name());
            pst.setString(3,obj.getCon_description());
            pst.setString(4,obj.getCon_date());
            pst.setString(5,obj.getCon_jobType());
            pst.setString(6,obj.getCon_projLeaderID());
            pst.executeUpdate();
            return true;
        }catch(Exception em){
            JOptionPane.showMessageDialog(null,"Contract ID already exists!!!");
            return false;
        }
    }

    public Contract viewCon(Contract obj){
        try{
            String query="SELECT * FROM contract ";
            rs=st.executeQuery(query);
            while (rs.next()){
                if (rs.getString("con_ID").equals(obj.getCon_ID())) {
                    obj.setCon_name(rs.getString("con_name"));
                    obj.setCon_description(rs.getString("con_description"));
                    obj.setCon_date(rs.getString("con_date"));
                    obj.setCon_jobType(rs.getString("con_jobType"));
                    obj.setCon_projLeaderID(rs.getString("con_projLeaderID"));
                    break;
                }
            }
            return obj;


        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Connection Error ");
            return null;
        }
    }

    public boolean deleteCon(Contract obj){
        PreparedStatement pst=null;
        try{
            pst=con.prepareStatement("delete from contract where con_ID=?");
            pst.setString(1,obj.getCon_ID());
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean upCon(Contract obj){
        PreparedStatement pst=null;
        try{
            pst=con.prepareStatement("update contract set con_name=?,con_description=?,con_date=?,con_jobType=?,con_projLeaderID=? where con_ID=?");
            pst.setString(1,obj.getCon_name());
            pst.setString(2,obj.getCon_description());
            pst.setString(3,obj.getCon_date());
            pst.setString(4,obj.getCon_jobType());
            pst.setString(5,obj.getCon_projLeaderID());
            pst.setString(6,obj.getCon_ID());
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
