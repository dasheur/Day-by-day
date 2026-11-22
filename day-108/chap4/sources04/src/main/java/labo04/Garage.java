package labo04;

public class Garage {
    private Car[] cars;
    private int capacity;
    private int count;
    public Garage(int capacity)
    {
      this.capacity = setCapacity(capacity) ? capacity: -1;
      this.cars = new Car[capacity];
      this.count = 0;
      if(this.capacity == -1)
      {
          throw new RuntimeException("Problème");
      }
    }

    public Garage()
    {
        this(3);
    }

    public Car[] getCars() {
        return this.cars;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public int getCount()
    {
        return this.count;
    }
    private boolean setCars(Car[] cars) {
        this.cars = cars;
        return true;
    }
    public boolean setCapacity(int count) {
        if( count >=0)
        {
            this.capacity = count;
            return true;
        }
        return false;
    }

    public int numberOfCars()
    {
        return this.getCars().length;
    }

    public boolean isEmpty()
    {
        return this.getCars() == null || this.getCars().length == 0;
    }

    public boolean isFull()
    {
        return this.getCars().length == this.getCapacity();
    }

    public boolean add(Car car )
    {
        if(this.isEmpty()) return false;
        if(count < this.getCapacity())
        {
            this.getCars()[count] = car;
            ++count;
            return true;
        }
        return false;
    }

    public boolean removeLastCar()
    {
        if(this.isEmpty()) return false;
        Car[] tmp = new Car[this.getCars().length-1];
        for(int i = 0; i< this.getCars().length-1;++i)
        {
            tmp[i] = this.getCars()[i];
        }
        return this.setCars(tmp);
    }

    public boolean contains(Car car)
    {
        if(this.isEmpty()) return false;
        for(int i =0;i<this.getCars().length-1;++i)
        {
            if(this.getCars()[i].compareTo(this.getCars()[i+1]) == 0)
            {
                return true;
            }
        }
        return false;
    }

    public Car getCar(int x)
    {
        // x commence à 1;
        return this.getCars()[x-1];
    }

    public void sort() {
        int count = this.getCount();
        Car[] tmpCar1 = this.copyCarsArray(this.getCars());
        Car[] tmpCar2 = new Car[this.getCars().length];
        if(count > 1) {
            Car min = tmpCar1[0];
            for (int i = 0; i < count; ++i) {
                for (int j = 0; j < count - i; ++j) {
                    if (min.compareTo(tmpCar1[j]) > 0) {
                        min = tmpCar1[j];
                    }
                }
                tmpCar2[i] = min;
                tmpCar1 = Garage.removeCarValue(tmpCar1, min,count-i);
                min =  tmpCar1.length >0? tmpCar1[0] : null; // réinitialise min
            }
            this.setCars(tmpCar2);
        }else
        {
            tmpCar2[count-1]= tmpCar1[count-1];
        }

    }

    public static Car[] removeCarPos(Car[] cars, int pos)
    {
        Car[] tmp = new Car[cars.length-1];
        int nbr = 0;
        for(int i = 0; i< cars.length;++i)
        {
            if(i != pos)
            {
                tmp[nbr] = cars[nbr];
                ++nbr;
            }
        }
        return tmp;
    }

    public static Car[] removeCarValue(Car[] cars, Car car, int count)
    {
        Car[] tmp = new Car[cars.length-1];
        int nbr =0;
        for(int i = 0; i< count;++i)
        {
            if( cars[i].compareTo(car) !=0 )
            {
                tmp[nbr] =cars[nbr];
                nbr++;
            }
        }
        return tmp;
    }

    public void copyCars(Car[] car)
    {
        Car[] tmp = new Car[car.length];
        for(int i = 0; i<car.length;++i)
        {
            tmp[i] = car[i];
        }
        this.setCars(tmp);
    }
    public Car[] copyCarsArray(Car[] car)
    {
        Car[] tmp = new Car[car.length];
        for(int i = 0; i<car.length;++i)
        {
            tmp[i] = car[i];
        }
        return tmp;
    }

    @Override
    public String toString()
    {
        String display="Stock du garage : ";
        display += "\n ---------------------- \n";
        for(int i =0;i<this.getCount();++i)
        {
            display +=this.getCars()[i].toString();
        }
        return display;
    }
}
