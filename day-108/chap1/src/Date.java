public class Date {
    private int day,month,year;
    public Date(int day, int month, int year)
    {
        this.day = setDay(day) ? day : -1 ;
        this.month = setMonth(month) ? month : -1;
        this.year= setYear(year) ? year : -1;
        if(this.day == -1 || this.month == 1 || this.year == -1)
        {
            throw new RuntimeException("error : Date erronée !");
        }
    }

    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    public boolean setDay(int day) {
        if(day >= 1 && day <=31)
        {
            this.day = day;
            return true;
        }
        return false;
    }

    public boolean setMonth(int month) {
        if(month >= 1 && month <=12)
        {
            this.month = month;
            return true;
        }
        return false;
    }
    public boolean setYear(int year) {
        if(year > 0 )
        {
            this.year = year;
            return true;
        }
        return false;
    }

    // Passe à la date suivante.
    public void increment()
    {
        if(this.day < this.day_in_month(this.day))
        {
            this.day +=1;
        }else if(this.day == this.day_in_month(this.day) && this.month > 12)
        {
            this.day = 1;
            this.month +=1;
        }else
        {
            this.day = 1;
            this.day = 1;
            this.year +=1;
        }
    }
    // return le numéro du jour dans l'année.
    public  int datOfYear()
    {
        int day =this.day;
        if(month > 1) for(int i =1; i<this.month;i++) day+=this.day_in_month(this.month);
        return day;
    }
    // Renvoie le numero du jour dans la semaine.
    public int dayOfWeek()
    {
        return this.congruence_zeller();
    }
    @Override
    public String toString()
    {
        return this.day_in_string()+" "+String.valueOf(this.day)+" "+this.month_in_string()+" "+String.valueOf(this.year);
    }
    public void prettyPrint()
    {
        System.out.println(String.valueOf(this.day)+"/"+
                String.valueOf(this.month)+"/"+
                String.valueOf(this.year));
    }

    public String prettyPrintString()
    {
        return String.valueOf(this.day)+"/"+
                String.valueOf(this.month)+"/"+
                String.valueOf(this.year);
    }
    // Renvoie le nombre de jour de la semaine.
    public int congruence_zeller()
    {
        int m = this.month == 1 ? 13: this.month == 2 ?14 :this.month;
        int j = this.year/100;
        int k = this.year%100;
        int h  =
        (
           this.day +
           ((m+1)*13/5) +
           k +
           k/4 +
           j/4 +
           5*j
        )%7;
        return h;
    }
    public int day_in_month(int monthValue)
    {
        int days = switch (monthValue)
        {
            case 1,3,5,7,8,10,12 -> 31;
            case 2 -> isLeapYear(this.year) ? 29 : 28;
            default -> 30; // => 4,6,9,11;
        };
        return days;
    }
    public boolean isLeapYear(int year)
    {
        // if(year%4 != 0) return false;
        if( year%4 ==0 && year%100 !=0 || (year%100 ==0 && year%400 ==0) ) return true;
        return false;
    }
    public String day_in_string()
    {
        String day;
        switch(this.day)
        {
            case 1:
                day = "Lundi";
                break;
            case 2 :
                day = "Mardi";
                break;
            case 3 : 
                day = "Mercredi";
                break;
            case 4 : 
                day = "Jeudi";
                break;
            case 5 :
                day = "Vendredi";
                break;
            case 6 :
                day = "Samedi";
            case 7 : 
                day = "Dimanche";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.day);
        }
        return day;
    }
    public String month_in_string()
    {
        String month ="";

        switch(this.month)
        {
            case 1:
                month = "Janvier";
                break;
            case 2 :
                month = "Février";
                break;
            case 3 :
                month = "Mars";
                break;
            case 4 :
                month = "Avril";
                break;
            case 5 :
                month = "Mai";
                break;
            case 6 :
                month = "Juin";
            case 7 :
                month = "Juillet";
                break;
            case 8 :
                month = "Août";
                break;
            case 9 :
                month = "Septembre";
                break;
            case 10 :
                month = "Octobre";
                break;
            case 11 :
                month = "Novembre";
                break;
            case 12 :
                month = "Décembre";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.day);
        }
        return month;
    }
}