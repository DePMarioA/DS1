package lists;


import org.w3c.dom.Node;

import java.awt.desktop.PreferencesEvent;
import java.awt.geom.Line2D;

/**
 *
 * @author Tony
 */
public class EmptyList implements AdvancedList
{
    public  class node{
        node next;
        Object data;
        node(){
            data=0;
            next=null;
        }
        node(Object n){
            data=n;
            next=null;

        }
        node(Object n, node p){
            data = n;
            next= p;
        }

    }


node head;




    @Override
    public int size()
    {
        return size_(head);

    }

    public int size_(node node){
        if (node==null){
            return 0;
        }

        return 1 +size_(node.next);
    }


    @Override
    public boolean isEmpty()
    {
        return size()==0;
    }

    @Override
    public boolean add(Object e)
    {
        if(e==null){
            return false;
        }
        if(head==null){
            head = new node(e);
            return true;
        }
        // to enable set-like Features ************** //*************************** UNCOMMENT THIS SECTION IN ORDER TO COMPLY WITH SECTION A *********************************************************
//        if(contains_(e,head)){
//            return true;
//        }
        add_(e,head);
        return true;
    }


    public void add_(Object e, node curr){
        if (curr.next == null){
            curr.next= new node(e);
            return;
        }

        add_(e, curr.next);
    }



    @Override
    public Object remove(int index)
    {
        if (index<0){
            return null;
        }
        if (head==null){
        return null;}
        if(index == 0){
            Object dato_ = head.data;
            head=head.next;
            return dato_;
        }
        return remove_2(index,head);
    }



    public Object remove_2(int index, node curr){
        if (curr==null){
            return null;
        }
        if(index==1){
            Object dato_ = curr.next.data;
            curr.next=curr.next.next;
            return dato_;
        }
        return remove_2(index-1,curr.next);
    }





//    public Object remove_(int index, node curr, int count){
//        if(curr==null){
//            return null;
//        }
//        if(index==0){
//            Object o= head.data;
//            head=head.next;
//            return o;
//        }
//        if(index==count){
//            Object o = curr.data;
//            curr=curr.next;
//            return o;
//        }
//        count++;
//        return remove_(index,curr.next,count);
//
//    }


    @Override
    public void clear()
    {
        head=null;
    }

    @Override
    public Object get(int index)
    {
        if (index<0){
            return null;
        }
        return get_(index,head);

    }
    public Object get_(int index, node curr){
        if(curr==null){
            return null;
        }
        if(index==0){
            return curr.data;

        }
        return get_(index-1,curr.next);
    }



//    public node get_ (int i , node node, int j){
//        if (node.next==null){
//           return node;
//        }
//        if(i==j){
//            node.next;
//            return
//        }
//
//        j++;
//        node.next =  get_(i,node.next,j);
//        return node;
//    }




    @Override
    public Object set(int index, Object element)
    {
        if(index<0) {
            return null;
        }
        if (index==0){
            Object dato=head.data;
            head.data=element;
            return dato;
        }

        return set_(index,element,head);
    }

    public Object set_(int index, Object o, node curr){
        if (curr==null){
            return null;
        }
        if(index==0){
            Object dato_ = curr.data;
            curr.data=o;
            return dato_;
        }
        // to enable set-like Features ************** //*************************** UNCOMMENT THIS SECTION IN ORDER TO COMPLY WITH SECTION A *********************************************************
//        if(contains_(o,curr)){
//            return curr.data;
//        }

        return set_(index-1,o,curr.next);
    }

    @Override
    public boolean remove(Object o)
    {

     return remove_Object2(o,head);
    }

    public boolean remove_Object2(Object o, node current){
        if (current==null){
            return false;
        }
        if(current.data==o){
            head= head.next;
            return true;
        }
        if (current.next==null){
            return false;
        }
        if(current.next.data==o){
            current.next=current.next.next;
            return true;
        }
        return contains_(o,current.next);
    }

    public Object remove_Object(int index, node curr){
        if (curr==null){
            return null;
        }
        if(index==1){
            Object dato_ = curr.next.data;
            curr.next=curr.next.next;
            return dato_;
        }
        return remove_2(index-1,curr.next);
    }




    @Override
    public boolean contains(Object o)
    {
        return contains_(o,head);
    }
    public boolean contains_(Object o, node current){
        if (current==null){
            return false;
        }
        if(current.data==o){
            return true;
        }
        return contains_(o,current.next);
    }

    @Override
    public int indexOf(Object o)
    {
        if (o==null){
        return -1;}
        if (head.data==o){
            return 0;
        }
    return indexOf_(o,head,-2);
    }
    public int indexOf_(Object o,node curr, int index){
        if(curr==null){
            return -1;
        }
        if (o==curr.data){
            return index;
        }

        return indexOf_(o,curr.next,index+1);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        if (o==null){
        return -1;}
        if(head==null){
            return -1;
        }
        return lastIndexOf_(o,head,0,-1);
    }


    public int lastIndexOf_(Object o,node curr, int index,int dato_){
        if(curr==null){
            return dato_;
        }
    if (o==curr.data){
        dato_=index;
        dato_= lastIndexOf_(o,curr.next,index+1,dato_);
        return dato_;
    }

    return lastIndexOf_(o,curr.next,index+1,dato_);
}
}
