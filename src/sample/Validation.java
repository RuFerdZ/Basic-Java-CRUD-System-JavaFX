package sample;



public class Validation {

    private boolean state;
    private String letters;
    private int numbers;


    public boolean checkID(String ID,String typeID){
        if(ID.length()>0) {
            this.letters = ID.substring(0, 3);
            try {
                this.numbers = Integer.parseInt(ID.substring(3));
                if (this.letters.equals(typeID)) {
                    this.state = true;
                }
            } catch (Exception e) {
                return false;
            }
        }else{
            return false;
        }

        return this.state;
    }

}
