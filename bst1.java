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
class node{
    int v;
    node left;
    node right;
    public node(){
        v=0;
        left=null;
        right=null;
    }
    public node(int v){
        this.v=v;
        left=null;
        right=null;
    }
    public int getKey(){
        return v;
    }
    public void setKey(int v){
        this.v=v;
    }
    public node getLeft(){
        return left;
    }
    public node getRight(){
        return right;
    }
    public void setLeft(node x){
        this.left=x;
    }
    public void setRight(node x){
        this.right=x;
    }
}
class bst{
    node root;
    public bst(){
        root=null;
    }
    public void insert(int v){
        if(root==null)
            root=new node(v);
        else
            root=insert(root,v);
    }
    public node insert(node root,int v){
        node x=null;
        if(root==null){
            x=new node(v);
        }
        else{
            if(v<root.getKey()){
                x=insert(root.getLeft(),v);
                root.setLeft(x);
            }
            else{
                x=insert(root.getRight(),v);
                root.setRight(x);
            }
            x=root;
        }
        return x;
    }
    public boolean search(int v){
        return search(root,v);
    }
    public boolean search(node root,int v){
        boolean found=false;
        if(root==null)
            found=false;
        else{
            if(v==root.getKey())
                found=true;
            else if(v<root.getKey())
                found=search(root.getLeft(),v);
            else
                found=search(root.getRight(),v);
        }
        return found;
    }
    public void delete(int v){
        if(root==null)
            System.out.println("Empty tree");
        else if(this.search(v)==false)
            System.out.println("Key not found");
        else{
            root=this.delete(root,v);
            System.out.println("Key deleted");
        }
    }
    public node delete(node root,int v){
        node p,q,lt,rt;
        if(v<root.getKey()){
            p=delete(root.getLeft(),v);
            root.setLeft(p);
            return root;
        }
        else if(v>root.getKey()){
            p=delete(root.getRight(),v);
            root.setRight(p);
            return root;
        }
        else{
            lt=root.getLeft();
            rt=root.getRight();
            if(lt==null && rt==null)
                return null;
            else if(lt==null){
                p=rt;
                return p;
            }
            else if(rt==null){
                p=lt;
                return p;
            }
            else{
                p=lt;
                q=root;
                while(p.getRight()!=null){
                    q=p;
                    p=p.getRight();
                }
                root.setKey(p.getKey());
                if(root.getLeft()==p)
                    root.setLeft(null);
                else
                    q.setRight(null);
                return root;
            }
        }
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
                    System.out.print(""+x.getKey()+' ');
                }
            }
        }
        else
            System.out.println("Empty tree");
    }
}
public class bst1 {
    public static void main(String args[]){
        bst tree=new bst();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        tree.levelorder();
        tree.preorder();
        tree.inorder();
        tree.postorder();
        boolean found40=tree.search(40);
        System.out.println(""+found40);
        
        tree.delete(20);
        tree.levelorder();
        
        tree.delete(30);
        tree.levelorder();
        
        tree.delete(70);
        tree.levelorder();
    }
}
