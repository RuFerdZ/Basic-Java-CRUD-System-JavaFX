package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.*;

public class Dashboard {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Pane customerPane;
    @FXML private Pane employeePane;
    @FXML private Pane contractPane;
    @FXML private Pane rolePane;
    @FXML private Pane credPane;
    @FXML private Pane aboutPane;
    @FXML private Pane loginPane;
    @FXML private Button menuCustomer;
    @FXML private Button menuEmployee;
    @FXML private Button menuContract;
    @FXML private Button menuRoles;
    @FXML private Button menuHelp;
    @FXML private TextField txtCusID;
    @FXML private TextArea txtCusAddress;
    @FXML private TextField txtCusFname;
    @FXML private TextField txtCusLname;
    @FXML private TextField txtCusNo;
    @FXML private TextField txtCusConID;
    @FXML private Button changeCred;
    @FXML private Button roleAdd;
    @FXML private Button roleView;
    @FXML private TextField txtRoleID;
    @FXML private TextField txtHourlyPay;
    @FXML private ComboBox roleCombo;
    @FXML private Button addEmpbtn;
    @FXML private Button viewEmpBtn;
    @FXML private Button upEmpbtn;
    @FXML private Button delEmpbtn;
    @FXML private Button resetEmpbtn;
    @FXML private TextField txtEmpID;
    @FXML private TextField txtEmpFname;
    @FXML private TextField txtEmpLname;
    @FXML private TextField txtEmpPhone;
    @FXML private TextArea txtEmpAddress;
    @FXML private TextField txtEmpRole1;
    @FXML private TextField txtEmpRole2;
    @FXML private TextField txtEmpRole3;
    @FXML private DatePicker txtEmpDOB;
    @FXML private Button conAddBtn;
    @FXML private Button conResetBtn;
    @FXML private Button conUpBtn;
    @FXML private Button conViewBtn;
    @FXML private Button conDelBtn;
    @FXML private TextField txtconID;
    @FXML private TextField txtconName;
    @FXML private TextField txtconDescription;
    @FXML private DatePicker txtconDate;
    @FXML private TextField txtconJobType;
    @FXML private TextField txtconProjLeaderID;
    @FXML private TextField txtusername;
    @FXML private PasswordField txtpassword;
    @FXML private Button exitbtn;
    @FXML private Button loginbtn;
    @FXML private AnchorPane loginAP;
    @FXML private Button resetCredbtn;
    @FXML private Button gobackbtn;
    @FXML private Label viewEmpDOB;
    @FXML private Label viewConDate;
    @FXML private TextField txtOldUsername;
    @FXML private TextField txtNewUsername;
    @FXML private PasswordField txtOldPassword;
    @FXML private PasswordField txtNewPassword;
    @FXML private PasswordField txtConfirmPasword;


    ObservableList<String> roleList= FXCollections.observableArrayList("Hardware Technician","Programmer","Software Installer","Designer","Q/A Engineer" );





    @FXML
    void loadContractPane(ActionEvent event) {
        contractPane.toFront();
    }

    @FXML
    void loadCustomerPane(ActionEvent event) {
        customerPane.toFront();
    }

    @FXML
    void loadEmpPane(ActionEvent event) {
        employeePane.toFront();
    }

    @FXML
    void loadHelpPane(ActionEvent event) {
        aboutPane.toFront();
    }

    @FXML
    void loadRolePane(ActionEvent event) {
        rolePane.toFront();
        roleCombo.setItems(roleList);
    }


//------------------------------LOGIN SECTION---------------------------------

    private String username="admin";
    private String password="admin123";

    @FXML
    void exitProgram(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void loadScreen(ActionEvent event) {
        if ((txtusername.getText().equals(this.username))&&(txtpassword.getText().equals(this.password))) {
            loginAP.toBack();
        }else{
            JOptionPane.showMessageDialog(null,"Username and password doesn't match");
            txtusername.setText("");
            txtpassword.setText("");
        }

    }

//------------------------------ROLE SECTION-----------------------------------



    @FXML
    void roleViewdb(ActionEvent event) {
        try {
            Role obj = new Role();
            dbConnection connect = new dbConnection();
            boolean state;

            //obj.setRoleID(txtRoleID.getText());
            try {
                obj.setRoleName(roleCombo.getValue().toString());
                obj = connect.viewRole(obj);

                txtRoleID.setText(obj.getRoleID());
                txtHourlyPay.setText(Double.toString(obj.getPay()));

                System.out.println(obj.getRoleName());
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Please select a Role name!!!");
            }
        }
        catch (Exception x){
            JOptionPane.showMessageDialog(null,"Connection error!!!");
        }
        //System.out.println(obj.getRoleName())
        //obj.setPay(Double.parseDouble(txtHourlyPay.getText()));


    }
    @FXML
    public void upRole(){
        try {
            Role obj = new Role();
            dbConnection connect = new dbConnection();
            try {
                obj.setRoleName(roleCombo.getValue().toString());
                obj.setPay(Double.parseDouble(txtHourlyPay.getText()));
                obj.setRoleID(txtRoleID.getText());
                connect.updateRole(obj);
                JOptionPane.showMessageDialog(null, "Update Successful!!!");
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Please select a Role name!!!");
            }
        }catch (Exception x){
            JOptionPane.showMessageDialog(null,"Connection Error!!!");
        }
    }







// ---------------------------CUSTOMER SECTION-----------------------------------------
    @FXML
    void addCus(ActionEvent event) {
        boolean state = false;

        dbConnection connect = new dbConnection();
        Customer obj = new Customer();

        Validation val = new Validation();
        if (val.checkID(txtCusID.getText(),"cus")) {

            if ((txtCusID.getLength() > 0) && (txtCusFname.getLength() > 0) && (txtCusFname.getLength() > 0) && (txtCusNo.getLength() > 0) && (txtCusAddress.getLength() > 0) && (txtCusConID.getLength() > 0)) {

                obj.setCustomer_ID(txtCusID.getText());
                obj.setCustomer_fname(txtCusFname.getText());
                obj.setCustomer_lname(txtCusLname.getText());
                obj.setCustomer_no(txtCusNo.getText());
                obj.setCustomer_address(txtCusAddress.getText());
                obj.setCustomer_contract(txtCusConID.getText());

                state = connect.addCustomer(obj);

                if (state) {
                    JOptionPane.showMessageDialog(null, "Data Entry Successful!!!");
                    txtCusID.setText("");
                    txtCusFname.setText("");
                    txtCusLname.setText("");
                    txtCusNo.setText("");
                    txtCusAddress.setText("");
                    txtCusConID.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Data Entry Aborted!!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all fields!!!");
            }

        }else{
            if (txtCusID.getLength()==0){
                JOptionPane.showMessageDialog(null,"Customer ID required !!!");
            }else {
                JOptionPane.showMessageDialog(null, "Invalid Customer ID !!!");
            }
        }
    }



    @FXML
    void resetCus(ActionEvent event) {
        txtCusID.setText("");
        txtCusFname.setText("");
        txtCusLname.setText("");
        txtCusNo.setText("");
        txtCusAddress.setText("");
    }

    @FXML
    void upCus(ActionEvent event) {
        boolean state=false;
        dbConnection connect=new dbConnection();
        Customer obj=new Customer();
        Validation valid=new Validation();

        if(valid.checkID(txtCusID.getText(),"cus")) {

            if (txtCusID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a Customer ID and View to Update!!!");
            } else {
                try {
                    obj.setCustomer_ID(txtCusID.getText());
                    obj.setCustomer_ID(txtCusID.getText());
                    obj.setCustomer_fname(txtCusFname.getText());
                    obj.setCustomer_lname(txtCusLname.getText());
                    obj.setCustomer_no(txtCusNo.getText());
                    obj.setCustomer_address(txtCusAddress.getText());

                    state = connect.updateCustomer(obj);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection Error!!!");
                }
            }


            if (state) {
                JOptionPane.showMessageDialog(null, "Record Update Successful!!!");
                txtCusID.setText("");
                txtCusFname.setText("");
                txtCusLname.setText("");
                txtCusNo.setText("");
                txtCusAddress.setText("");
                txtCusConID.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Record update Aborted!!!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Customer ID!!!");
        }
    }

    @FXML
    void viewCus(ActionEvent event) {
        dbConnection connect = new dbConnection();
        Customer obj = new Customer();
        Validation valid=new Validation();

        if(valid.checkID(txtCusID.getText(),"cus"))
            if (txtCusID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a Customer ID to View");
            } else {
                obj.setCustomer_ID(txtCusID.getText());
                try {
                    obj = connect.searchCustomer(obj);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Such record doesn't exist!!!");
                }
                try {
                    txtCusID.setText(obj.getCustomer_ID());
                    txtCusFname.setText(obj.getCustomer_fname());
                    txtCusLname.setText(obj.getCustomer_lname());
                    txtCusNo.setText(obj.getCustomer_no());
                    txtCusAddress.setText(obj.getCustomer_address());
                    txtCusConID.setText(obj.getCustomer_contract());
                }
                catch (Exception l){
                    JOptionPane.showMessageDialog(null,"Connection error");
                }
        }else
        {
            JOptionPane.showMessageDialog(null,"Invalid Customer ID!!!");
        }

    }

    @FXML
    void delCus(ActionEvent event){
        boolean state=false;

        Validation valid=new Validation();
        if(valid.checkID(txtCusID.getText(),"cus")) {
            try {
                dbConnection connect = new dbConnection();
                Customer obj = new Customer();


                if (txtCusID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a Customer ID and View in order to delete it!!!");
                } else {
                    obj.setCustomer_ID(txtCusID.getText());
                    try {
                        state = connect.deleteCustomer(obj);
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Such record doesn't exist!!!");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Connection Error!!!");
            }

            if (state) {
                JOptionPane.showMessageDialog(null, "Record Deletion Successful!!!");
                txtCusID.setText("");
                txtCusFname.setText("");
                txtCusLname.setText("");
                txtCusNo.setText("");
                txtCusAddress.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Record Deletion Aborted!!!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Customer ID!!!");
        }
    }
// -------------------------------EMPLOYEE SECTION---------------------------------------
    @FXML
    void addEmp(ActionEvent event) {
        boolean state = false;
            dbConnection connect = new dbConnection();
            Employee obj = new Employee();

            Validation val = new Validation();
            if (val.checkID(txtEmpID.getText(),"emp")) {

                if ( (txtEmpFname.getLength() > 0) && (txtEmpLname.getLength() > 0) && (txtEmpAddress.getLength() > 0) && (txtEmpAddress.getLength() > 0) ) {

                    obj.setEmp_ID(txtEmpID.getText());
                    obj.setEmp_fname(txtEmpFname.getText());
                    obj.setEmp_lname(txtEmpLname.getText());
                    obj.setEmp_phone(txtEmpPhone.getText());
                    obj.setEmp_address(txtEmpAddress.getText());
                    try {
                        obj.setEmp_DOB(txtEmpDOB.getValue().toString());
                        try {
                            obj.setEmp_roleID_01(txtEmpRole1.getText());
                            obj.setEmp_roleID_02(txtEmpRole2.getText());
                            obj.setEmp_roleID_03(txtEmpRole3.getText());
                            state = true;
                            connect.addEmp(obj);
                        } catch (Exception js) {
                            JOptionPane.showMessageDialog(null, "Invalid Role ID's");
                        }

                        if (state) {
                            JOptionPane.showMessageDialog(null, "Data Entry Successful!!!");
                            txtEmpID.setText("");
                            txtEmpFname.setText("");
                            txtEmpLname.setText("");
                            txtEmpDOB.setValue(null);
                            txtEmpPhone.setText("");
                            txtEmpAddress.setText("");
                            txtEmpRole1.setText("");
                            txtEmpRole2.setText("");
                            txtEmpRole3.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Entry Aborted!!!");
                        }
                    }catch (Exception x){
                        JOptionPane.showMessageDialog(null, "Please enter DOB!!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all fields!!!");
                }

        }else{
            if (txtEmpID.getLength()==0){
                JOptionPane.showMessageDialog(null,"Employee ID required !!!");
            }else {
                JOptionPane.showMessageDialog(null, "Invalid Employee ID !!!");
            }
        }
    }

    @FXML
    void viewEmp(ActionEvent event) {
        dbConnection connect = new dbConnection();
        Employee obj = new Employee();
        Validation val = new Validation();
        if (val.checkID(txtEmpID.getText(),"emp")) {
            if (txtEmpID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a Employee ID to View");
            } else {
                obj.setEmp_ID(txtEmpID.getText());
                try {
                    obj = connect.viewEmp(obj);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Such record doesn't exist!!!");
                }
                try {
                    txtEmpID.setText(obj.getEmp_ID());
                    txtEmpFname.setText(obj.getEmp_fname());
                    txtEmpLname.setText(obj.getEmp_lname());
                    viewEmpDOB.setText(obj.getEmp_DOB());
                    txtEmpPhone.setText(obj.getEmp_phone());
                    txtEmpAddress.setText(obj.getEmp_address());
                    txtEmpRole1.setText(obj.getEmp_roleID_01());
                    txtEmpRole2.setText(obj.getEmp_roleID_02());
                    txtEmpRole3.setText(obj.getEmp_roleID_03());
                } catch (Exception l) {
                    JOptionPane.showMessageDialog(null, "Connection error");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Employee ID!!!");
        }
    }
    @FXML
    void upEmp(ActionEvent event) {

        Employee obj = new Employee();

        Validation val = new Validation();
        if (val.checkID(txtEmpID.getText(), "emp"))
            if (txtEmpID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a Employee ID and View to Update!!!");
            } else {
                try {
                    dbConnection connect = new dbConnection();
                    obj.setEmp_ID(txtEmpID.getText());
                    obj.setEmp_fname(txtEmpFname.getText());
                    obj.setEmp_lname(txtEmpLname.getText());
                    obj.setEmp_phone(txtEmpPhone.getText());
                    obj.setEmp_address(txtEmpAddress.getText());
                    try {
                        obj.setEmp_DOB(txtEmpDOB.getValue().toString());

                        try {
                            obj.setEmp_roleID_01(txtEmpRole1.getText());
                            obj.setEmp_roleID_02(txtEmpRole2.getText());
                            obj.setEmp_roleID_03(txtEmpRole3.getText());
                            connect.updateEmp(obj);
                            JOptionPane.showMessageDialog(null, "Update Successful!!");
                        } catch (Exception js) {
                            JOptionPane.showMessageDialog(null, "Invalid Role ID's");
                        }
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Please enter DOB!!!");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection Error!!!");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Employee ID!!!");
        }

    }

    @FXML
    void delEmp(ActionEvent event) {
        Validation val = new Validation();
        if (val.checkID(txtEmpID.getText(),"emp")) {
            boolean state = false;
            try {
                dbConnection connect = new dbConnection();
                Employee obj = new Employee();


                if (txtEmpID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a Employee ID and View in order to delete it!!!");
                } else {
                    obj.setEmp_ID(txtEmpID.getText());
                    try {
                        state = connect.deleteEmp(obj);
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Such record doesn't exist!!!");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Connection Error!!!");
            }

            if (state) {
                JOptionPane.showMessageDialog(null, "Record Deletion Successful!!!");
                txtEmpID.setText("");
                txtEmpFname.setText("");
                txtEmpLname.setText("");
                txtEmpDOB.setValue(null);
                txtEmpPhone.setText("");
                txtEmpAddress.setText("");
                txtEmpRole1.setText("");
                txtEmpRole2.setText("");
                txtEmpRole3.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Record Deletion Aborted!!!");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Invalid Employee ID!!!");
        }
    }
    @FXML
    void resetEmp(ActionEvent event) {
        txtEmpID.setText("");
        txtEmpFname.setText("");
        txtEmpLname.setText("");
        txtEmpDOB.setValue(null);
        txtEmpPhone.setText("");
        txtEmpAddress.setText("");
        txtEmpRole1.setText("");
        txtEmpRole2.setText("");
        txtEmpRole3.setText("");
    }

//------------------------------------CONTRACT SECTION------------------------------------

    @FXML
    void conAdd(ActionEvent event) {
        boolean state = false;
        try {
            dbConnection connect = new dbConnection();
            Contract obj = new Contract();

            Validation val = new Validation();
            if (val.checkID(txtconID.getText(), "con")) {

                if ((txtconName.getLength() > 0) && (txtconDescription.getLength() > 0) && (txtconJobType.getLength() > 0) && (txtconProjLeaderID.getLength() > 0)) {

                    obj.setCon_ID(txtconID.getText());
                    obj.setCon_name(txtconName.getText());
                    obj.setCon_description(txtconDescription.getText());
                    obj.setCon_jobType(txtconJobType.getText());
                    try {
                        obj.setCon_date(txtconDate.getValue().toString());
                        try {
                            obj.setCon_projLeaderID(txtconProjLeaderID.getText());
                            state =connect.addCon(obj);

                        } catch (Exception js) {
                            JOptionPane.showMessageDialog(null, "Invalid Project Leader ID's");
                        }

                        if (state) {
                            JOptionPane.showMessageDialog(null, "Data Entry Successful!!!");
                            txtconID.setText("");
                            txtconName.setText("");
                            txtconDescription.setText("");
                            txtconDate.setValue(null);
                            txtconJobType.setText("");
                            txtconProjLeaderID.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Data Entry Aborted!!!");
                        }
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Please enter DOB!!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all fields!!!");
                }

            } else {
                if (txtEmpID.getLength() == 0) {
                    JOptionPane.showMessageDialog(null, "Contract ID required !!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Contract ID !!!");
                }
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Connection Error!!!");
        }
    }

    @FXML
    void conDel(ActionEvent event) {
        Validation val = new Validation();
        if (val.checkID(txtconID.getText(),"con")) {
            boolean state = false;
            try {
                dbConnection connect = new dbConnection();
                Contract obj = new Contract();


                if (txtconID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a Contract ID and View in order to delete it!!!");
                } else {
                    obj.setCon_ID(txtconID.getText());
                    try {
                        state = connect.deleteCon(obj);
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Such record doesn't exist!!!");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Connection Error!!!");
            }

            if (state) {
                JOptionPane.showMessageDialog(null, "Record Deletion Successful!!!");
                txtconID.setText("");
                txtconName.setText("");
                txtconDescription.setText("");
                txtconDate.setValue(null);
                txtconJobType.setText("");
                txtconProjLeaderID.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Record Deletion Aborted!!!");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Invalid Contract ID!!!");
        }
    }

    @FXML
    void conReset(ActionEvent event) {
        txtconID.setText("");
        txtconName.setText("");
        txtconDescription.setText("");
        txtconDate.setValue(null);
        txtconJobType.setText("");
        txtconProjLeaderID.setText("");
    }

    @FXML
    void conUp(ActionEvent event) {
        try{
            boolean state=false;
            dbConnection connect = new dbConnection();
            Contract obj = new Contract();
            Validation val = new Validation();
            if ((txtconName.getLength() > 0) && (txtconDescription.getLength() > 0) && (txtconJobType.getLength() > 0) && (txtconProjLeaderID.getLength() > 0)) {
                if (val.checkID(txtconID.getText(), "con")) {
                    obj.setCon_ID(txtconID.getText());
                    obj.setCon_name(txtconName.getText());
                    obj.setCon_description(txtconDescription.getText());
                    obj.setCon_jobType(txtconJobType.getText());
                    try {
                        obj.setCon_date(txtconDate.getValue().toString());
                        try {
                            obj.setCon_projLeaderID(txtconProjLeaderID.getText());
                            state =connect.upCon(obj);

                        } catch (Exception js) {
                            JOptionPane.showMessageDialog(null, "Invalid Project Leader ID's");
                        }

                        if (state) {
                            JOptionPane.showMessageDialog(null, "Update Successful!!!");
                            txtconID.setText("");
                            txtconName.setText("");
                            txtconDescription.setText("");
                            txtconDate.setValue(null);
                            txtconJobType.setText("");
                            txtconProjLeaderID.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Update Aborted!!!");
                        }
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Please enter DOB!!!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Contract ID!!!");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Fill all the Fields");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Connection ERROR!!");
        }
    }

    @FXML
    void conView(ActionEvent event) {
        try {
            dbConnection connect = new dbConnection();
            Contract obj = new Contract();
            Validation val = new Validation();
            if (val.checkID(txtconID.getText(), "con")) {
                if (txtconID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a Contract ID to View");
                } else {
                    obj.setCon_ID(txtconID.getText());
                    try {
                        obj = connect.viewCon(obj);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Such record doesn't exist!!!");
                    }
                    try {
                        txtconID.setText(obj.getCon_ID());
                        txtconName.setText(obj.getCon_name());
                        txtconDescription.setText(obj.getCon_description());
                        viewConDate.setText(obj.getCon_date());
                        txtconJobType.setText(obj.getCon_jobType());
                        txtconProjLeaderID.setText(obj.getCon_projLeaderID());
                    } catch (Exception l) {
                        JOptionPane.showMessageDialog(null, "Connection error");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Contract ID!!!");
            }
        }catch (Exception x){
            JOptionPane.showMessageDialog(null,"Connection Error!!!");
        }
    }

//----------------------OPEN CRED CHANGE SECTION------------------------------------
    @FXML
    void changeLogin(ActionEvent event) {
        credPane.toFront();
    }

//----------------------CHANGE CREDENTIAL SECTION-----------------------------------
    @FXML
    void goback() {
        aboutPane.toFront();
    }

    @FXML
    void resetCred(ActionEvent event) {
        if((txtOldUsername.getText().equals(this.username))&&(txtOldPassword.getText().equals(this.password))){
            if(txtConfirmPasword.getText().equals(txtNewPassword.getText())){
                this.password=txtNewPassword.getText();
                this.username=txtNewUsername.getText();
                JOptionPane.showMessageDialog(null,"Username and password changed successfully!!!");
            }else{
                JOptionPane.showMessageDialog(null,"The passwords doesn't match!!!");
            }

        }else{
            JOptionPane.showMessageDialog(null,"Username and password doesn't match!!!");

        }
        txtOldPassword.setText("");
        txtOldUsername.setText("");
        txtNewPassword.setText("");
        txtNewUsername.setText("");
        txtConfirmPasword.setText("");
    }

    @FXML
    void changeCred(ActionEvent event) {
        if ((txtusername.getText().equals(this.username))&&(txtpassword.getText().equals(this.password))) {
            loginAP.toBack();
        }else{
            JOptionPane.showMessageDialog(null,"Username and password doesnt match");
            txtusername.setText("");
            txtpassword.setText("");
        }
    }
}