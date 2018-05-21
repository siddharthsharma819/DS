/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssisharm
 */
import java.util.Scanner;
public class test {
    static void print(int n){
        for(int i=1;i<=n;i+=2){
            for(int j=(n-i)/2;j>0;j--)
                System.out.print(" ");
            for(int k=1;k<=i;k++)
                System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size:");
        int n=sc.nextInt();
        print(n);
    }
}
