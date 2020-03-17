package sample;

public class Contract {


    private String con_ID;
    private String con_name;
    private String con_description;
    private String con_date;
    private String con_jobType;
    private String con_projLeaderID;



    public String getCon_ID() {
        return con_ID;
    }

    public String getCon_name() {
        return con_name;
    }

    public String getCon_description() {
        return con_description;
    }

    public String getCon_date() {
        return con_date;
    }

    public String getCon_jobType() {
        return con_jobType;
    }

    public String getCon_projLeaderID() {
        return con_projLeaderID;
    }

    public void setCon_ID(String ID){
        this.con_ID=ID;
    }

    public void setCon_name(String name){
        this.con_name=name;
    }

    public void setCon_description(String desc){
        this.con_description=desc;
    }

    public void setCon_date(String date){
        this.con_date=date;
    }

    public void setCon_jobType(String job){
        this.con_jobType=job;
    }

    public void setCon_projLeaderID(String ID){
        this.con_projLeaderID=ID;
    }



}
