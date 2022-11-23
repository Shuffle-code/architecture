package interview.list;

import java.util.NoSuchElementException;

public class LinkedList implements MyList{

    int size = 0;
    Node first;

    public LinkedList() {
        this.first = null;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        Node currentNode = first;
        if (first == null){
            first = newNode;
        } else {
            while (currentNode.next != null){   // using the "while" we find the last Node.
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // as next - set "newNode"
        }
        size++;
    }


    @Override
    public void insert(int value, int inx) {
        Node currentNode = first;
        Node newNode = new Node(value);
        Node previousNode = null;
        int count = -1;
        while (currentNode != null){
            count++;
            if (count == inx){
                if (currentNode == first){
                    first = newNode.next;
//                    first.next = newNode.next;
                } else {
                    previousNode.next = newNode;
                    newNode.next = currentNode;
//                    currentNode.next = newNode.next;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        size++;


    }


    @Override
    public void iterable() {
        Node currentNode = first;
        if (first != null){
            System.out.println(first.value);
        }
        while (currentNode.next != null){
            currentNode = currentNode.next;
            System.out.println(currentNode.value);
        }
    }


    @Override
    public int get(int value) {
        if (first == null){
            return -1;
        }
        if (first.value == value){
            return 0;
        }
        Node currentNode = first;
        int result = -1;
        while (currentNode != null){
            ++result;
            if (currentNode.value == value) {

                return result;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public void delete( int value) {
        Node currentNode = first;
        Node previousNode = null;

        while (currentNode.next != null){
            if (currentNode.value == value){
                if (currentNode == first){
                    first = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
            size--;
    }

    private static class Node{
        int value;
        Node next;
//        Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
//
//        public Node(int data, Node next){
//            this.value = data;
//            this.next = next;
//        }
    }
}
