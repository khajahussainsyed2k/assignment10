package com.company;
class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data=data;
        this.next=null;
    }
}
class SList<T>{

    Node<T> head=null;
    SList() {
        this.head = null;
    }
    SList(T data){
        this.head=new Node(data);
    }

    public  SListIterator<T> getIterator(){
        return new SListIterator<T>(head);
    }
}
class SListIterator<T>{
    Node<T> head;
    Node<T> tail;
    public SListIterator(Node<T> head){
        this.head=head;
    }
    void insert(T data){
        if(head==null){
            head=new Node(data);
            tail=head;
        }
        else {
            tail.next=new Node(data);
            tail=tail.next;
        }
    }
    void delete(T data) {
        if (head == null) {
            System.out.println("Empty List cannot be deleted");
            return;
        }
        else if((head.data).equals(data)) {
            head = head.next;
            if(head==null)
                tail=null;
        }
        else {
            Node<T> prev = head;
            Node<T> temp = head.next;
            while (temp != null) {
                if ((temp.data).equals(data))
                    break;
                prev = prev.next;
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("No element Found");
                return;
            }
            else if(temp == tail) {
                tail = prev;
                tail.next=null;
            }
            else
                prev.next = temp.next;
        }

    }
    void display(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        System.out.println("the elements in the list are");
        Node<T> current=head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
}
public class LinkedList {

    public static void main(String[] args) {
	// write your code here
        SList<Integer> numbers = new SList<>();
        SListIterator iterator = numbers.getIterator();
        iterator.insert(1);
        iterator.insert(2);
        iterator.insert(3);
        iterator.display();
        iterator.delete(1);
        iterator.delete(3);
        iterator.display();
}}
