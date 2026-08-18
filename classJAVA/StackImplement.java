/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgabstract;
import java.io.*;
import java.util.*;

/**
 *
 * @author student
 */
abstract class Stack{
    abstract void push(Scanner  sc);
    abstract void pop();
    abstract void peek();
    abstract void display();
    
}

class Stu extends Stack{
    Stu s[] = new Stu[10];
    static int idx = 0;
    int rno,age;
    String name;
    void push(Scanner  sc) {
        if (idx == s.length) {
            System.out.println("Stack Overflow!");
            return;
        }
        s[idx] = new Stu();
        System.out.println("Enter Roll no: ");
        s[idx].rno = sc.nextInt();
        System.out.println("Enter age: ");
        s[idx].age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
       
        s[idx].name = sc.nextLine();
        
        idx++;
        System.out.println("Student pushed successfully.");
    }
    
    void pop() {
        if (idx == 0) {
            System.out.println("Stack Underflow!");
            return;
        }
        Stu delStu = s[idx-1];
        
        
        delStu.display();
        idx--;
    }
    
    void peek(){
        if (idx == 0) {
            System.out.println("Stack is empty!");
            return;
        }
        Stu topStu = s[idx -1];
        topStu.display();
        
    }
    
    void display(){
        System.out.println(rno+"\t"+name);
    }
    
    void displayAll(){
        for(int i = 0 ; i< idx;i++){
            s[i].display();
        }
    }
}
public class StackImplement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no . of stu : ");
        int n = sc.nextInt();
        Stu s = new Stu();
        
        while(true){
           System.out.println("1.Push\t2.Pop\t3.Display\t4.Peek\t5.Exit ");
           System.out.println("Enter ur choice : ");
           int ch = sc.nextInt();
           switch(ch){
               case 1:
                   s.push(sc);
                   break;
               case 2:
                   s.pop();
                   break;
               case 4:
                   s.peek();
                   break;
               case 5:
                   System.out.println("Exiting..........");
                   return;
               case 3:
                   System.out.println("Student details : ");
                   s.displayAll();
                   break;
               default :
                   System.out.println("Enter valid choice!");
                   break;
           }
        }
    }
}
