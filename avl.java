/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treepackage;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ssisharm
 */

public class avl {
    static class node{
        int key;int height;
        node left;node right;
        public node(){
            key=0;
            height=1;
            left=null;
            right=null;
        }
        public node(int v){
            this.key=v;
            this.height=1;
            this.left=null;
            this.right=null;
        }
        public int getKey(){
            return this.key;
        }
        public void setKey(int v){
            this.key=v;
        }
        public int getHeight(){
            return this.height;
        }
        public void setHeight(int h){
            this.height=h;
        }
        public node getLeft(){
            return this.left;
        }
        public void setLeft(node x){
            this.left=x;
        }
        public node getRight(){
            return this.right;
        }
        public void setRight(node x){
            this.right=x;
        }
    }
    static class avlTree{
        node root;
        public avlTree(){
            root=null;
        }
        public boolean search(int key){
            if(root==null)
                return false;
            else
                return search(root,key);
        }
        private boolean search(node root,int key){
            boolean result=false;
            if(root!=null){
                if(key==root.getKey())
                    result=true;
                else if(key<root.getKey())
                    result=this.search(root.getLeft(),key);
                else
                    result=this.search(root.getRight(),key);
            }
            return result;
        }
        public int minValue(){
            int mv;
            if(root==null)
                mv=Integer.MAX_VALUE;
            else
                mv=minValue(root);
            return mv;
        }
        private int minValue(node root){
            int mv;
            if(root==null)
                mv=Integer.MAX_VALUE;
            else{
                node p=root;
                while(p.getLeft()!=null)
                    p=p.getLeft();
                mv=p.getKey();
            }
            return mv;
        }
        public int maxValue(){
            int mv;
            if(root==null)
                mv=Integer.MIN_VALUE;
            else
                mv=minValue(root);
            return mv;
        }
        private int maxValue(node root){
            int mv;
            if(root==null)
                mv=Integer.MIN_VALUE;
            else{
                node p=root;
                while(p.getRight()!=null)
                    p=p.getRight();
                mv=p.getKey();
            }
            return mv;
        }
        private int height(node root){
            int h=0;
            if(root==null)
                h=0;
            else
                h=root.getHeight();
            return h;
        }
        private int balance(node root){
            int bal=0;
            if(root==null)
                bal=0;
            else
                bal=height(root.getLeft())-height(root.getRight());
            return bal;
        }
        private node rightRotate(node root){
            node lt=root.getLeft();
            node rt=root.getRight();
            node ltrc=lt.getRight();
            
            root.setLeft(ltrc);
            root.setHeight(Math.max(height(root.getLeft()), height(root.getRight()))+1);
            
            lt.setRight(root);
            lt.setHeight(Math.max(height(lt.getLeft()), height(lt.getRight()))+1);
            return lt;
        }
        private node leftRotate(node root){
            node lt=root.getLeft();
            node rt=root.getRight();
            node rtlc=rt.getLeft();
            
            root.setRight(rtlc);
            root.setHeight(Math.max(height(root.getLeft()), height(root.getRight()))+1);
            
            rt.setLeft(root);
            rt.setHeight(Math.max(height(rt.getLeft()), height(rt.getRight()))+1);
            return rt;
        }
        public void insert(int key){
            if(root==null)
                root=new node(key);
            else
                root=insert(root,key);
        }
        private node insert(node root,int key){
            node x=null;
            if(root==null)
                return new node(key);
            if(key<root.getKey()){
                x=insert(root.getLeft(),key);
                root.setLeft(x);
                x=root;
            }
            else if(key>root.getKey()){
                x=insert(root.getRight(),key);
                root.setRight(x);
                x=root;
            }
            int height=Math.max(height(root.getLeft()), height(root.getRight()))+1;
            root.setHeight(height);
            int balance=balance(root);
            node y;
            if(balance>1 && key<root.getLeft().getKey()){
                x=rightRotate(root);
            }
            else if(balance>1 && key>root.getLeft().getKey()){
                y=leftRotate(root.getLeft());
                root.setLeft(y);
                x=rightRotate(root);
            }
            else if(balance<-1 && key>root.getRight().getKey()){
                x=leftRotate(root);
            }
            else if(balance<-1 && key<root.getRight().getKey()){
                y=rightRotate(root.getRight());
                root.setRight(y);
                x=leftRotate(root);
            }
            return x;
        }
        public void delete(int key){
            if(!search(key))
                System.out.println("No such key.");
            else
                root=delete(root,key);
        }
        private node delete(node root,int key){
            node x=null;
            if(key<root.getKey()){
                x=delete(root.getLeft(),key);
                root.setLeft(x);
                x=root;
            }
            else if(key>root.getKey()){
                x=delete(root.getRight(),key);
                root.setRight(x);
                x=root;
            }
            else{
                node lt,rt,p,q;
                lt=root.getLeft();
                rt=root.getRight();
                if(lt==null && rt==null)
                    x= null;
                else if(lt==null){
                    x=root.getRight();
                    root.setRight(null);
                }
                else if(rt==null){
                    x=root.getLeft();
                    root.setLeft(null);
                }
                else{
                    int mv=this.maxValue(root.getLeft());
                    this.delete(mv);
                    root.setKey(mv);
                    x=root;
                }
            }
            node y;
            int h=Math.max(height(root.getLeft()), height(root.getRight()))+1;
            root.setHeight(h);
            int bal=balance(root);
            if(bal>1 && balance(root.getLeft())>=0){
                x=rightRotate(root);
            }
            else if(bal>1 && balance(root.getLeft())<0){
                y=leftRotate(root.getLeft());
                root.setLeft(y);
                x=rightRotate(root);
            }
            else if(bal<-1 && balance(root.getRight())<=0)
                x=leftRotate(root);
            else if(bal<-1 && balance(root.getRight())>0){
                y=rightRotate(root.getRight());
                root.setRight(y);
                x=leftRotate(root);
            }
            return x;
        }
        
        public void inorder(){
        if(root!=null){
            inorder(root);System.out.println();}
        else
            System.out.println("Empty tree");
        }
        private void inorder(node root){
            if(root.getLeft()!=null)
                inorder(root.getLeft());
            System.out.print(""+root.getKey()+' ');
            if(root.getRight()!=null)
                inorder(root.getRight());
        }
        public void preorder(){
            if(root!=null){
                inorder(root);System.out.println();}
            else
                System.out.println("Empty tree");
        }

        private void preorder(node root){
            System.out.print(""+root.getKey()+' ');
            if(root.getLeft()!=null)
                preorder(root.getLeft());
            if(root.getRight()!=null)
                preorder(root.getRight());
        }
        public void postorder(){
            if(root!=null){
                inorder(root);System.out.println();}
            else
                System.out.println("Empty tree");
        }

        private void postorder(node root){
            if(root.getLeft()!=null)
                postorder(root.getLeft());
            if(root.getRight()!=null)
                postorder(root.getRight());
            System.out.print(""+root.getKey()+' ');
        }
        public void levelorder(){
            if(root!=null){
                Queue<node> que=new LinkedList<>();
                que.add(root);
                que.add(null);
                while(que.size()!=0){
                    node x=que.poll();
                    if(x==null){
                        if(que.size()!=0)
                            que.add(null);
                        System.out.println();
                    }
                    else{
                        if(x.getLeft()!=null)
                            que.add(x.getLeft());
                        if(x.getRight()!=null)
                            que.add(x.getRight());
                        System.out.print(""+x.getKey()+','+x.getHeight()+' ');
                    }
                }
            }
            else
                System.out.println("Empty tree");
        }
    }
    public static void main(String args[]){
        avlTree tree=new avlTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        
        tree.levelorder();
        tree.preorder();
        tree.inorder();
        tree.postorder();
        boolean found40=tree.search(40);
        System.out.println(""+found40);
        
        tree.delete(6);
        tree.levelorder();
        
        tree.delete(5);
        tree.levelorder();
        
        tree.delete(7);
        tree.levelorder();
    }
}
