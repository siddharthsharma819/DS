/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treepackage;

/**
 *
 * @author ssisharm
 */
import java.util.Arrays;
class heap{
    private static final int childCount=2;
    static int heapSize;
    static int[] heap;
    public heap(){
        heapSize=0;
        heap=new int[100];
    }
    public heap(int size){
        heapSize=0;
        heap=new int[size];
        Arrays.fill(heap,Integer.MAX_VALUE);
    }
    public void swap(int i,int j){
        int t=heap[i];
        heap[i]=heap[j];
        heap[j]=t;
    }
    public int left(int index){
        int ix=index*2+1;
        if(ix<heapSize)
            return ix;
        else
            return Integer.MAX_VALUE;
    }
    public int right(int index){
        int ix=index*2+2;
        if(ix<heapSize)
            return ix;
        else
            return Integer.MAX_VALUE;
    }
    public int parent(int index){
        return(index-1)/2;
    }
    public int minChild(int index){
        int l=2*index+1;
        int r=2*index+2;
        if(l<heapSize && r<heapSize)
            return Math.min(heap[l],heap[r])==heap[l]?l:r;
        else if(l<heapSize)
            return l;
        else if(r<heapSize)
            return r;
        else
            return Integer.MAX_VALUE;
    }
    public boolean isEmpty(){
        return heapSize==0;
    }
    public boolean isFull(){
        return heapSize==heap.length;
    }
    public void add(int e){
        if(this.isFull())
            System.out.println("Heap overflow");
        else{
            heap[heapSize++]=e;
            heapifyUp(heapSize-1);
        }
    }
    public int poll(){
        int min=Integer.MAX_VALUE;
        if(this.isEmpty()){
            System.out.println("Heap underflow");
        }
        else{
            min=heap[0];
            heap[0]=heap[heapSize-1];
            heap[heapSize-1]=Integer.MAX_VALUE;
            heapSize--;
            heapifyDown(0);
        }
        return min;
    }
    public int top(){
        int min=Integer.MAX_VALUE;
        if(heapSize>0)
            min=heap[0];
        return min;
    }
    public int remove(int e){
        int el=Integer.MAX_VALUE;
        int ix=0;
        if(!isEmpty()){
            for(int i=0;i<heapSize && heap[i]!=e;i++,ix++);
            if(ix!=heapSize){
                el=heap[ix];
                heap[ix]=Integer.MAX_VALUE;
                heapSize--;
                heapifyDown(ix);
            }
        }
        return el;
    }
    public void heapifyDown(int index){
        int temp=index;
        int mc=minChild(temp);
        while(mc<heapSize){
            if(heap[mc]<heap[temp]){
                swap(temp,mc);
                temp=mc;
                mc=minChild(temp);
            }
            else
                break;
        }
    }
    public void heapifyUp(int index){
        int temp=index;
        int parent=parent(temp);
        while(temp>0){
            if(heap[temp]<heap[parent]){
                swap(temp,parent);
                temp=parent;
                parent=parent(temp);
            }
            else
                break;
        }
    }
    public void print(){
        for(int i=0;i<heapSize;i++)
            System.out.print(""+heap[i]+' ');
        System.out.println();
    }
}
public class bheap1 {
    public static void main(String args[]){
        int arr[]={1,9,2,8,3,7,4,6,5,0};
        heap h=new heap();
        for(int i=0;i<arr.length;i++)
            h.add(arr[i]);
        h.print();
        h.remove(8);
        while(!h.isEmpty())
            System.out.print(""+h.poll()+' ');
    }
}
