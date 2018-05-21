/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssisharm
 */
class stack{
    node top;
    int size;
    public stack(){
        top=null;
        size=0;
    }
    public void push(int v){
        node ptr=new node(v);
        if(top==null){
            top=ptr;
            size++;
        }
        else{
            if(size==100)
                System.out.println("Stack Overflow");
            else{
                ptr.setLink(top);
                top=ptr;
                size++;
            }
        }
    }
    public int pop(){
        int v=Integer.MIN_VALUE;
        if(size==0)
            System.out.println("Stack Underflow");
        else{
            v=top.getData();
            top=top.getLink();
            size--;
        }
        return v;
    }
    public int top(){
        int v=Integer.MIN_VALUE;
        if(size==0)
            System.out.println("Stack Underflow");
        else{
            v=top.getData();
        }
        return v;        
    }
    public boolean isEmpty(){
        return this.size==0;
    }
}
class stacktest{
    public static void main(String args[]){
        stack stk=new stack();
        for(int i=0;i<10;i++)
            stk.push(i);
        for(int i=0;i<10;i++)
            System.out.print(""+stk.pop()+' ');
    }
}