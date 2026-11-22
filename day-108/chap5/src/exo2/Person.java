package exo2;

import java.time.LocalDate;

public class Person implements Comparable<Person>{
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

    @Override
    public int compareTo(Person other)
    {
        if(this.getLastName().compareTo(other.getLastName()) < 0) return -1;
        else if(this.getLastName().compareTo(other.getLastName()) ==0)
        {
            if(this.getFirstName().compareTo(other.getFirstName()) < 0) return -1;
            else if(this.getFirstName().compareTo(other.getFirstName()) == 0)
            {
                if(this.dateOfBrith.compareTo(other.dateOfBrith) < 0) return -1;
                else if(this.dateOfBrith.compareTo(other.dateOfBrith) == 0) return 0;
                return 1;
            }
            return 1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this) return true;
        if(!(other instanceof Person)) return false;
        Person p = (Person) other;
        return this.getLastName().compareTo(this.getLastName()) ==0
                && this.getFirstName().compareTo(p.getFirstName()) == 0
                && this.dateOfBrith.compareTo(p.dateOfBrith) == 0;
    }
}
