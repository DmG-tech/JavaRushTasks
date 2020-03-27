package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private int treeSize;
    public ArrayList<Entry> listOfTree = new ArrayList();

    public CustomTree() {
        this.root = new Entry<>("0");
    }


    public String getParent(String s){
        for (Entry current: listOfTree) {
            if (current != null && current.elementName.equals(s)) return current.parent.elementName;
        }
            return null;
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        else {
            String s = (String) o;
            ArrayDeque<Entry> queue = new ArrayDeque<>();
            ArrayList<Entry> deleteList = new ArrayList<>();
            for (Entry current: listOfTree) {
                if (current != null && current.elementName.equals(s)) {
                    queue.add(current);
                    deleteList.add(current);
                    break;
                }
            }
            do {
                Entry current = queue.pollFirst();
                if (current.leftChild != null) {
                    deleteList.add(current.leftChild);
                    queue.add(current.leftChild);
                }
                if (current.rightChild != null) {
                    deleteList.add(current.rightChild);
                    queue.add(current.rightChild);
                }
            } while (!(queue.isEmpty()));
            for (Entry current: deleteList) {
                listOfTree.remove(current);
                current.parent.leftChild = null;
                current.parent.rightChild = null;
                treeSize--;
            }
            return true;
        }
    }

    @Override
    public boolean add(String s) {
        ArrayDeque<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        do {
            Entry current = queue.pollFirst();

            if (current.leftChild == null) current.availableToAddLeftChildren = true;
            if (current.rightChild == null) current.availableToAddRightChildren = true;

            if (current.availableToAddLeftChildren) {
                current.leftChild = new Entry<>(s);
                current.leftChild.parent = current;
                current.availableToAddLeftChildren = false;
                listOfTree.add(current.leftChild);
                treeSize++;
                return true;
            }
            else if (current.availableToAddRightChildren){
                current.rightChild = new Entry<>(s);
                current.availableToAddRightChildren = false;
                current.rightChild.parent = current;
                listOfTree.add(current.rightChild);
                treeSize++;
                return true;
            }
            else {
                if (current.leftChild != null) queue.add(current.leftChild);
                if (current.rightChild != null) queue.add(current.rightChild);
            }
        } while (!queue.isEmpty());
        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return treeSize;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }

    }

}
