package sample;

public class Customer {
    private String customer_ID;
    private String customer_fname;
    private String customer_lname;
    private String customer_no;
    private String customer_address;
    private String customer_contract;

    public void setCustomer_ID(String cusID){
        this.customer_ID=cusID;
    }

    public String getCustomer_ID(){
        return customer_ID;
    }

    public void setCustomer_fname(String fname){
        this.customer_fname=fname;
    }

    public String getCustomer_fname(){
        return customer_fname;
    }
    public void setCustomer_lname(String lname){
        this.customer_lname=lname;
    }

    public String getCustomer_lname(){
        return customer_lname;
    }
    public void setCustomer_no(String no){
        this.customer_no=no;
    }

    public String getCustomer_no(){
        return customer_no;
    }
    public void setCustomer_address(String address){
        this.customer_address=address;
    }

    public String getCustomer_address(){
        return customer_address;
    }

    public void setCustomer_contract(String contract){
        this.customer_contract=contract;
    }

    public String getCustomer_contract(){
        return customer_contract;
    }
}
