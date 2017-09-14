public class Student {

    private String Fname;
    private String Lname;
    private int ID;
    private int Year;

    public Student() {
        Fname = "";
        Lname = "";
        ID = 0;
        Year = 0;
    }

    public Student(String Fname, String Lname, int ID, int Year) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.ID = ID;
        this.Year = Year;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getFname() {
        return Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getLname() {
        return Lname;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getYear() {
        return Year;
    }

    public String toString() {
        return Fname +"," + Lname + "," + ID + "," + Year;
    }


}
