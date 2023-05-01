package lists;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
    setList setList = new setList();
    setList.add('a');
        setList.add('b');
        setList.add('a');
        setList.add('b');
        setList.add('c');
        System.out.println(Arrays.toString(setList.getSetList()));
        System.out.println(setList.isEmpty());
        setList.clear();
        System.out.println(Arrays.toString(setList.getSetList()));
        System.out.println(setList.isEmpty());

        setList.add('a');
        System.out.println(Arrays.toString(setList.getSetList()));
        System.out.println(setList.isEmpty());
        setList.remove(0);
        System.out.println(setList.isEmpty());
        
    }
}
