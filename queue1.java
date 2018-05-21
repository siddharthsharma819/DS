/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssisharm
 */
class queue{
    node head;
    node rear;
    int size;
    public queue(){
        head=null;
        size=0;
    }
    public void enqueue(int v){
        node ptr=new node(v);
        if(head==null){
            head=ptr;
            rear=head;
            size++;
        }
        else{
            if(size==10)
                System.out.println("Queue overflow");
            else{
                rear.setLink(ptr);
                rear=ptr;
                size++;
            }
        }
    }
    public int dequeue(){
        int v=Integer.MIN_VALUE;
        if(size==0)
            System.out.println("Queue underflow");
        else{
            node t=head;
            v=t.getData();
            if(size==1){
                head=null;
                rear=null;
            }
            else{
                head=head.getLink();
            }
            size--;
        }
        return v;
    }
    public int front(){
        return head.getData();
    }
    public int rear(){
        return rear.getData();
    }
    public int size(){
        return size;
    }
}
public class queue1 {
    public static void main(String args[]){
        queue q=new queue();
        for(int i=0;i<11;i++)
            q.enqueue(i);
        for(int i=0;i<11;i++)
            System.out.print(""+q.dequeue()+' ');
    }
}
