public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int id;
    private int numOfTimesAbsent = 0;


    public User(String first, String last)
    {
        this.firstName = first;
        this.lastName = last;
    }

    public void setFirstName(String first)
    {
        this.firstName = first;
    }
    public void setLastName(String last)
    {
        this.lastName = last;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void absent(){ this.numOfTimesAbsent++;}

    public String getFirstName(){ return firstName;}
    public String getLastName(){ return lastName;}
    public String getEmail(){ return email;}
    public String getPhone(){ return phone;}
    public int getId(){return id;}
    public int getNumOfTimesAbsent(){ return numOfTimesAbsent;}



}
