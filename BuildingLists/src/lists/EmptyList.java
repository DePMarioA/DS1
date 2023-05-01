package lists;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author Tony
 */
public class EmptyList implements AdvancedList
{
    private Object[] emptyList;
    private int arraySize=0;
    boolean ifTrue;

    public EmptyList() {
        emptyList = new Object[10];
    }

    @Override
    public int size()
    {
        //System.out.println(arraySize);
        return arraySize;
    }

    @Override
    public boolean isEmpty()
    {
//        if(emptyList.length<arraySize) {
//        return emptyList[0]==null;}
//        else

//        return ifTrue;
//        if(arraySize==0){
//        return emptyList[0]==null;}
//        else if(ifTrue){
//            return true;
//        }
//        else
//            return false;
        return arraySize==0;
    }

    @Override
    public boolean add(Object e)
    {
        emptyList[arraySize] = e;
        ifTrue = emptyList[arraySize] == e;
        arraySize++;
        if(arraySize==emptyList.length){
            Object[] tempArray = new Object[emptyList.length+10];
            for(int i = 0; i<emptyList.length;i++){
                tempArray[i]= emptyList[i];
            }
            emptyList= tempArray;
        }
        return ifTrue;
    }

    public Object[] getEmptyList() {
        return emptyList;
    }

    @Override
    public Object remove(int index)
    {
        //System.out.println(Arrays.toString(emptyList));
        if(index>=0&& index<arraySize) {
            Object x= emptyList[index];
            for (int i = index; i < arraySize - 1; i++) {
                emptyList[i] = emptyList[i + 1];
            }
            arraySize--;
            return x;
        }

        return null;
    }

    @Override
    public void clear()
    {
        /*//System.out.println(arraySize);
        while(remove(arraySize-1)!=null){
            //System.out.println(Arrays.toString(emptyList));

        }*/


        //System.out.println(size());
            /*Object[] tempArray = new Object[emptyList.length];
            for(int i = 0; i<emptyList.length;i++){
                tempArray[i]= null;
                arraySize--;
        }
            emptyList=tempArray;*/
        emptyList = new Object[emptyList.length];
        arraySize=0;

    }

    @Override
    public Object get(int index)
    {
        if(index>=0&& index<arraySize) {
            return emptyList[index];
        }
        else {
            return null;
        }
    }

    @Override
    public Object set(int index, Object element)
    {
        //System.out.println(arraySize);

            Object x = 0;
            if (index >= 0 && index < arraySize) {
                x = emptyList[index];
                emptyList[index] = element;
                return x;
            }

        return null;
    }

    @Override
    public boolean remove(Object o)
    {
        for(int i = 0; i<arraySize;i++)
        if(o.equals(emptyList[i])){
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o)
    {
        for(int i = 0; i<arraySize;i++)
            if(o.equals(emptyList[i])) {
                return true;
            }
        return false;
    }

    @Override
    public int indexOf(Object o)
    {
        for(int i = 0; i<arraySize;i++)
            if(o.equals(emptyList[i])) {
                return i;
            }
        return -1;

    }

    @Override
    public int lastIndexOf(Object o)
    {
        int temp=-1;
        for(int i = 0; i<arraySize;i++) {
            if (o.equals(emptyList[i])) {
                temp = i;
            }
        }
        return temp;
    }
}
