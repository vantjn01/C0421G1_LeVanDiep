package _10_arrayList.bai_tap.bai_tap1;
import java.util.ArrayList;
import java.util.Arrays;
public class MyList<E> {
    public int size = 0;
    public static final int DEFAULT_CAPATITY = 10;
    public Object elements[];

    public MyList(){}
    public MyList(int capacity){
        elements = new Object[capacity];
    }

    public void ensuacapa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }
    public int size(){
        return elements.length;
    }
    public void add(int index, E element){
        ensuacapa();
        size();
        for (int i=size-1; i>=index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
    }
    private void checkIndex(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("index "+ index+ "out of bounds");
        }
    }
    public void add(E element){
        if (size == elements.length){
            ensuacapa();
        }
        elements[size++] = element;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    public int indexOf(E o){
        for (int i=0; i<size; i++){
            if (o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }
    public E remove(int index){
        checkIndex(index);
        E e = (E) elements[index];
        for (int i = index; i<size; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
        return e;
    }
}
