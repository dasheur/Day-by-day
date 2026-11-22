import java.util.ArrayList;
import  java.util.Random;
public class exo5_1 {
    public <E> E[]  shuffle(E[] array)
    {
        Random generator = new Random();
        for(int i=0;i< array.length;++i)
        {
            int pos = generator.nextInt(array.length);
            E tmp = array[i];
            array[i]=  array[pos];
            array[pos] = tmp;
        }
        return array;
    }

    public static  <E> ArrayList<E> shuffle(ArrayList<E> array)
    {
        Random generator = new Random();
        for(int i=0;i<array.size();++i)
        {
            int pos = generator.nextInt(array.size());
            E tmp = (E)array.get(i);
            array.set(i, array.set(pos, (E)tmp)) ;
        }
        return array;
    }
    public static  void main(String[] args)
    {
        ArrayList<Integer> arrayInt = new ArrayList<Integer>();
        Random generator = new Random();
        for(int i=0;i<10;++i)
        {
            arrayInt.add(generator.nextInt(100)); // [0;100[
            System.out.print(arrayInt.get(i)+" ");
        }
        ArrayList<Integer> tess = shuffle(arrayInt);
        for(int i=0;i<tess.size();++i)
        {
            System.out.println();
            System.out.print(tess.get(i)+" ");
        }
    }
}