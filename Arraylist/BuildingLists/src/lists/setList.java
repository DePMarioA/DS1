package lists;



import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author Tony
 */
public class setList implements AdvancedList
{
    private Object[] setList;
    private int arraySize=0;
    boolean ifTrue;

    public Object[] getSetList() {
        return setList;
    }

    public setList() {
        setList = new Object[10];
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
//        boolean yN;
//        for (int i =0; i<arraySize-1;i++){
//            yN= emptyList[i]==null;
//            return yN;
//        }
//        return true;

//        if(setList.length<arraySize) {
//        return setList[0]==null;}
//        else

//        return ifTrue;
        return arraySize==0;
    }

    @Override
    public boolean add(Object e)
    {
        if(contains(e)){
            return true;
        }
        setList[arraySize] = e;
        ifTrue = setList[arraySize] == e;
        arraySize++;
        if(arraySize==setList.length){
            Object[] tempArray = new Object[setList.length+10];
            for(int i = 0; i<setList.length;i++){
                tempArray[i]= setList[i];
            }
            setList= tempArray;
            return ifTrue;
        }
        return ifTrue;
    }

    public Object[] getEmptyList() {
        return setList;
    }

    @Override
    public Object remove(int index)
    {
        //System.out.println(Arrays.toString(setList));
        if(index>=0&& index<arraySize) {
            Object x= setList[index];
            for (int i = index; i < arraySize - 1; i++) {
                setList[i] = setList[i + 1];
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
            //System.out.println(Arrays.toString(setList));

        }*/


        //System.out.println(size());
            /*Object[] tempArray = new Object[setList.length];
            for(int i = 0; i<setList.length;i++){
                tempArray[i]= null;
                arraySize--;
        }
            setList=tempArray;*/
        setList = new Object[setList.length];
        arraySize=0;
        ifTrue=true;

    }

    @Override
    public Object get(int index)
    {
        if(index>=0&& index<arraySize) {
            return setList[index];
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
        if(contains(element)){
            return setList[index1];
        }
        if (index >= 0 && index < arraySize) {
            x = setList[index];
            setList[index] = element;
            return x;
        }

        return null;
    }

    @Override
    public boolean remove(Object o)
    {
        for(int i = 0; i<arraySize;i++)
            if(o.equals(setList[i])){
                remove(i);
                return true;
            }
        return false;
    }
    private int index1;
    @Override
    public boolean contains(Object o)
    {
        for(int i = 0; i<arraySize;i++)
            if(o.equals(setList[i])) {
                index1=i;
                return true;
            }
        return false;
    }

    @Override
    public int indexOf(Object o)
    {
        for(int i = 0; i<arraySize;i++)
            if(o.equals(setList[i])) {
                return i;
            }
        return -1;

    }

    @Override
    public int lastIndexOf(Object o)
    {
        int temp=-1;
        for(int i = 0; i<arraySize;i++) {
            if (o.equals(setList[i])) {
                temp = i;
            }
        }
        return temp;
    }
}