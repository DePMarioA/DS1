package lists;

/**
 *
 * @author Tony
 */
public class EmptyList implements AdvancedList
{
    public class node{
        node next;
        Object data;
        public node(Object data){
            this.data=data;
        }
    }
    node head=null;
    int sizeOfList =0;
    public class linkedList {
        node head;
    }

    @Override
    public int size()
    {
        return sizeOfList;
    }

    @Override
    public boolean isEmpty()
    {
        return size()==0;
    }

    @Override
    public boolean add(Object e)
    {

        if(head==null){
            head = new node(e);
            sizeOfList++;
            return head.data==e;

        }

        node current = head;
        while(current.next!=null){
            //************************************************************** UNCOMMENT THIS SECTION IN ORDER TO COMPLY WITH SECTION A *********************************************************
//            if(e==current.data){
//                return true;
//            } // this is for the Set like List.*******************
            current = current.next;
        }
        current.next = new node(e);
        sizeOfList++;
        return current.next.data==e;

    }
    public int count2 (int x){
        int count=0;
        node current = head;
        while (current.next!=null){
            current=current.next;
            count++;
            if(count==x){break;}
        }
//        System.out.println("ok");
        return count;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= sizeOfList) {
            return null;
        }

        Object valueToReturn;
        if (0 == index) {
            valueToReturn = head.data;
            head = head.next;
            sizeOfList--;
//            System.out.println("end");
            return valueToReturn;
        }


        int counter = 0;
        node oneBefore = head;

        while (counter != index - 1) {
            oneBefore = oneBefore.next;
            counter++;
        }
        valueToReturn = oneBefore.next.data;
        oneBefore.next = oneBefore.next.next;
        sizeOfList--;
        return valueToReturn;
    }

    @Override
    public void clear()
    {

        head=null;
//
        sizeOfList =0;
    }

    @Override
    public Object get(int index)
    {
        int counter2=0;
        node current= head;
        if(index>=0&&index< sizeOfList){
            while (counter2!=index){
                current=current.next;
                counter2++;
            }
            return current.data;
        }
        return null;
    }

    @Override
    public Object set(int index, Object element)
    {
        Object temp;
        int counter2=0;
        node current= head;
        if(index>=0&&index< sizeOfList){
//            // to enable set-like Features ************** //*************************** UNCOMMENT THIS SECTION IN ORDER TO COMPLY WITH SECTION A *********************************************************
//            while (current!=null){
//               if(current.data==element){
//                   return current.data;
//               }
//               current = current.next;
//            }
            while (counter2!=index){
                current=current.next;
                counter2++;
            }

             temp=current.data;
             current.data= element;
             return temp;
        }
        return null;
    }

    @Override
    public boolean remove(Object o)
    {
        if(head== null){
            return false;
        }
        if(head.data==o){
            head=head.next;
            return true;
        }
        node current = head;

        while(current.next!=null){
            if(current.next.data==o){
                current.next= current.next.next;
                return true;
            }
            current= current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o)
    {
        if(head== null){
            return false;
        }
        if(head.data==o){
            return true;
        }
        node current = head;

        while(current.next!=null){
            if(current.next.data==o){
                return true;
            }
            current= current.next;
        }
        return false;
    }


    @Override
    public int indexOf(Object o)
    {
        if(head== null){
            return -1;
        }
        if(head.data==o){
            return 0;
        }
        node current = head;
        int counter2=0;
        while(current.next!=null){
            if(current.next.data==o){
                return counter2;
            }
            current= current.next;
            counter2++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        node current = head;
        int counter2=1; //this was for try2 c2 was 0
        int tracker=-1;
        if(head== null){
            return -1;
        }

        while(current.next!=null){
            if(current.next.data==o){
                 tracker=counter2;
            }
            current= current.next;
            counter2++;
        }
        return tracker;
    }
}
