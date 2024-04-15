package org.example.twentyfour.april;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyHashSet {
    private List<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if(i == key) {
                return;
            }
        }
        list.add(key);
    }

    public void remove(int key) {
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if(i == key) {
                iterator.remove();
                return;
            }
        }
    }

    public boolean contains(int key) {
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if(i == key) {
                return true;
            }
        }
        return false;
    }
}
