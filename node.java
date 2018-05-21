/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssisharm
 */
class node{
	int v;
	node next;
	public node(){}
	public node(int v){
		this.v=v;
		this.next=null;
	}
        public void setData(int v){
            this.v=v;
        }
        public int getData(){
            return this.v;
        }
        public node getLink(){
            return next;
        }
        public void setLink(node n){
            this.next=n;
        }
}