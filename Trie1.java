/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treepackage;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ssisharm
 */
class TrieNode{
    Character ch;
    Map<Character,TrieNode> childNodes;
    boolean isEndNode;
    public TrieNode(){
        this.ch=null;
        this.childNodes=new HashMap<Character,TrieNode>();
        this.isEndNode=false;
    }
    public void setCharacter(Character ch){
        this.ch=ch;
    }
    public Character getCharacter(){
        return this.ch;
    }
    public void setIsEndNode(boolean value){
        this.isEndNode=value;
    }
    public boolean getIsEndNode(){
        return this.isEndNode;
    }
    public int getChildCount(){
        if(this.childNodes!=null)
            return this.childNodes.size();
        return 0;
    }
    public TrieNode(Character ch){
        this.ch=ch;
        this.childNodes=new HashMap<Character,TrieNode>();
        this.isEndNode=false;
    }
    public TrieNode addChildNode(Character ch){
        if(!this.childNodes.containsKey(ch))
            this.childNodes.put(ch, new TrieNode(ch));
        return this.childNodes.get(ch);
    }
    public void removeChildNode(Character ch){
        if(this.childNodes.containsKey(ch))
            this.childNodes.remove(ch);
    }
    public TrieNode getChildNode(Character ch){
        if(this.childNodes.containsKey(ch))
            return this.childNodes.get(ch);
        else
            return null;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        this.root=new TrieNode(' ');
    }
    public void insert(String str){
        if(!this.search(str))
            this.insert(root,str.toCharArray());
    }
    public boolean search(String str){
        return this.search(root,str.toCharArray());
    }
    public void delete(String str){
        if(this.search(str))
            this.delete(root,str.toCharArray(),0);
    }
    private void insert(TrieNode root,char arr[]){
        TrieNode cur=root;
        for(int i=0;i<arr.length;i++){
            if(cur.getChildNode(arr[i])==null)
                cur.addChildNode(arr[i]);
            cur=cur.getChildNode(arr[i]);
        }
        cur.setIsEndNode(true);
    }
    private boolean search(TrieNode root,char[] arr){
        boolean result=false;
        TrieNode cur=root;
        for(int i=0;i<arr.length;i++){
            cur=cur.getChildNode(arr[i]);
            if(cur==null)
                break;
        }
        if(cur!=null && cur.getIsEndNode())
            result=true;
        return result;
    }
    private boolean delete(TrieNode root,char[] arr,int i){
        TrieNode mapping=root.getChildNode(arr[i]);;
        boolean result=false;boolean last=false;
        if(i==arr.length-1){
            mapping.setIsEndNode(false);
            if(mapping.getChildCount()==0){
                root.removeChildNode(arr[i]);
                last=true;
            }
        }
        else
            result=delete(mapping,arr,i+1);
        if(result)
            root.removeChildNode(arr[i-1]);
        if((last||result) && !root.getIsEndNode() && root.getChildCount()==0)
            return true;
        else
            return false;
    }
}
public class Trie1 {
    public static void main(String args[]){
        Trie t=new Trie();
        System.out.println(""+t.search("aed"));
        System.out.println(""+t.search("aedf"));
        System.out.println(""+t.search("aedfg"));
        t.insert("aed");
        t.insert("aedf");
        t.insert("aedfg");
        System.out.println(""+t.search("aed"));
        System.out.println(""+t.search("aedf"));
        System.out.println(""+t.search("aedfg"));
        t.delete("aed");
        t.delete("aedfg");
        System.out.println(""+t.search("aed"));
        System.out.println(""+t.search("aedf"));
        System.out.println(""+t.search("aedfg"));
    }
}
