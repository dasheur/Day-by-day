import java.time.LocalDate;

public class Person {
    private String firstName, lastName;
    private Date dateOfBrith;
    public Person(String firstName, String lastName, int day, int month, int year)
    {
        this.firstName = setFirstName(firstName) ? firstName:"";
        this.lastName = setLastName(lastName) ? lastName:"";
        this.dateOfBrith = new Date(day,month,year);
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public boolean setFirstName(String firstName) {
        if(!firstName.isEmpty())
        {
            this.firstName = firstName;
            return true;
        }
        return false;
    }
    public boolean setLastName(String lastName) {
        if(!lastName.isEmpty())
        {
            this.lastName = lastName;
            return true;
        }
        return false;
    }

    public String toString()
    {
        return
            "Prénom               : "+this.firstName + " \n"+
            "Nom                  : "+this.lastName  + " \n"+
            "Date de naissance    : "+this.dateOfBrith.prettyPrintString() + "\n"+
            "Age                  : "+this.getage();
    }
    public int getage()
    {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();
        int age = (year-this.dateOfBrith.getYear())-1;
        if(month > this.dateOfBrith.getMonth() || (month == this.dateOfBrith.getMonth() && day >= this.dateOfBrith.getDay()))
        {
            age +=1;
        }
        return age;
    }
}
