package _10_dsa_list_.bai_tap.trienkhai_arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    static final int DEFAULT_CAPACITY=10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) throws IllegalAccessException {
        if(capacity>=0){
            elements = new Object[capacity];
        }else {
            throw new IllegalArgumentException("capacity: "+ capacity);
        }
    }

    public int size(){
        return this.size;
    }

    public void clear(){
        size=0;
        for (int i=0; i<elements.length; i++){
            elements[i]=null;
        }
    }

    public boolean add(E element){
        if(elements.length==size){
            this.ensureCapacity(1);
        }
        elements[size]=element;
        size++;
        return true;
    }

    public void add(E element, int index){
        if (index>elements.length){
            throw new IllegalArgumentException("index: "+ index);
        } else if (elements.length==size){
            this.ensureCapacity(5);
        }

        if(elements[index]==null){
            elements[index]=element;
            size++;
        }else {
            for (int i=size+1; i>=index; i--){
                elements[i]=elements[i-1];
            }
            elements[index]=element;
            size++;
        }
    }

    public void ensureCapacity(int minCapacity)  {
        if(minCapacity>=0){
            int newSize = elements.length+minCapacity;
            elements= Arrays.copyOf(elements,newSize);
        }else {
            throw new IllegalArgumentException("minCapacity: "+ minCapacity);
        }
    }

    public E get(int index){
        return (E) elements[index];
    }

    public int indexOf(E element){
        int index=-1;
        for (int i=0; i<size; i++){
            if(this.elements[i].equals(element)){
                return i;
            }
        }
        return index;
    }

    public boolean contains(E element) {
//        return this.indexOf(element) >=0;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public MyList<E> clone(){
        MyList<E> array= new MyList<>();
        array.elements=Arrays.copyOf(elements,size);
        array.size = this.size;
        return array;
    }

    public E remove(int index){
        if (index<0 || index>size){
            throw new IllegalArgumentException("Error index: "+ index);
        }
        E element = (E) elements[index];
        for (int i=index; i<size-1; i++){
            elements[i]= elements[i+1];
        }
        elements[size-1]=null;
        size--;
        return element;
    }
}
