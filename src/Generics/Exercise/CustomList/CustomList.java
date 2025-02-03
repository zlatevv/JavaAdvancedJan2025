package Generics.Exercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }
    public T remove(int index){
        return this.list.remove(index);
    }
    public boolean contains(T element){
        return this.list.contains(element);
    }
    public void swap(int index1, int index2){
        T temp = this.list.get(index1);
        this.list.set(index1, list.get(index2));
        this.list.set(index2, temp);
    }
    public int countGreaterThan(T element){
        int count = 0;
        for (T box : list) {
            if (box.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
    public T getMax(){
        return Collections.max(this.list);
    }
    public T getMin(){
        return Collections.min(this.list);
    }
    public void print(){
        for (T t : list) {
            System.out.println(t);
        }
    }
}
