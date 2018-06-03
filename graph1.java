/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treepackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ssisharm
 */
class vertex{
    int v;
    int w;
    public vertex(int v){
        this.v=v;
        this.w=0;
    }
    public vertex(int v,int w){
        this.v=v;
        this.w=w;
    }
    public int getVertex(){
        return v;
    }
    public int getWeight(){
        return w;
    }
}
class graph{
    int vertices;
    List<vertex>[] adj;
    public graph(int numberOfVertices){
        vertices=numberOfVertices;
        adj=new List[vertices];
        for(int i=0;i<vertices;i++)
            adj[i]=new ArrayList<vertex>();
    }
    public void addEdge(int u,int v){
        adj[u].add(new vertex(v));
        adj[v].add(new vertex(u));
    }
    public void addEdge(int u,int v,int w){
        adj[u].add(new vertex(v,w));
    }
    public void print(){
        for(int i=0;i<vertices;i++){
            Iterator<vertex> itr=adj[i].iterator();
            System.out.print("Adjacency list for vertex "+i+':');
            while(itr.hasNext()){
                System.out.print(""+itr.next().getVertex());
                if(itr.hasNext())
                    System.out.print("->");
            }
            System.out.println();
        }
    }
}
public class graph1 {
    public static void main(String args[]){
        graph g=new graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.print();
    }
}
