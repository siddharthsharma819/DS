/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssisharm
 */
class ll{
	node first=null;
	node last=null;
	int size=0;
	public ll(){}
	public int add(int v){
		++this.size;
		node a=new node(v);
		if(first==null){
			this.first=a;
			this.last=this.first;
		}
		else{
			this.last.next=a;
                        this.last=this.last.next;
		}
		return v;
	}
	public int remove(int v){
		int ans=-1;
		if(this.size==1){
			this.first=null;
			this.last=this.first;
			ans=v;
		}
		else{
			node a=this.first;
			if(a.v==v){
				this.first=a.next;
				ans=v;
			}
			else{
				while(a!=null && a.next.v!=v)
					a=a.next;
				if(a!=null){
					if(this.last==a.next)
						this.last=a;
					a.next=a.next.next;
					ans=v;
				}
			}
		}
		if(ans!=-1)
			this.size--;
		return ans;
	}
	public int size(){
		return this.size;
	}
	public void print(){
		node a=this.first;
		if(this.size>0){
			System.out.print(""+a.v);
			a=a.next;
			while(a!=null){
				System.out.print("->"+a.v);
                                a=a.next;
                        }
		}
		System.out.println();
	}
}
class singleLinkedList{
	public static void main(String args[]){
		ll a=new ll();
		for(int i=1;i<=10;i++){
			a.add(i);
			a.print();
		}
		for(int i=1;i<=10;i++){
			a.remove(i);
			a.print();
		}
	}
}