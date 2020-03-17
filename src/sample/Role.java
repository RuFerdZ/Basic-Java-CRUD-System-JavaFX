package sample;

public class Role {
    private String roleName;
    private String roleID;
    private double pay;

    public void setRoleName(String name){
        this.roleName=name;
    }

    public void setRoleID(String ID){
        this.roleID=ID;
    }

    public void setPay(double pay){
        this.pay=pay;
    }

    public String getRoleName(){
        return roleName;
    }

    public String getRoleID(){
       return this.roleID;
    }

    public double getPay(){
        return this.pay;
    }
}
