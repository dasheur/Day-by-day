package labo04;

public class Car implements Comparable<Car> {
    private final String brand, model;
    public Car(String brand, String model)
    {
        this.brand =  !brand.isEmpty() ? brand:"";
        this.model = !model.isEmpty()  ? model:"";
        if(this.brand =="" || this.model =="")
        {
            throw new RuntimeException("Les attributs sont vides");
        }
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Car )) {
            return false;
        }

        Car p = (Car) o;

        return this.brand.compareTo(p.brand) == 0
                && this.model.compareTo(p.model) == 0;
    }
    public String getModel() {
        return model;
    }
    public String getBrand() {
        return brand;
    }
    @Override
    public int compareTo(Car other)
    {
        if( this.brand.compareTo(other.brand) < 0 ) return -1;
        else if( this.brand.compareTo(other.brand) ==0)
        {
            if(this.model.compareTo(other.model) < 0) return -1;
            else if( this.model.compareTo(other.model) == 0) return  0;
            return 1;
        }
        return 1;
    }

    public String toString()
        {
            return " Marque : "+this.brand+" Modèle : "+this.model+" \n";
        }
}
