#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

class Book{
    static int cnt ;
    string  id ;
    string author;
    string title ;
    int price ;

    public : 
       void input();
       void display();
       
};

int Book :: cnt = 0 ;

void Book :: input(){
    cnt++;
    id = "BOOK"+ to_string(1000+cnt) ;
    cout<<"enter book title ";
    cin>>title;
    cout<<"enter book author ";
    cin>>author;
    cout<<"enter price ";
    cin>>price;

}
void Book :: display(){
    cout<<id<<"\t"<<title<<"\t"<<author<<"\t"<<price<<endl;
}

int main(){
    int ch ;
    int n ; 
    Book *b;
    cout<<"enter number of records : ";
    cin>>n;
    b= new Book[n];
    
    while(1){
        cout<<"1.Insert\t2.Display\t3.Exit"<<endl;
        cout<<"Enter ur choice : ";
        cin>>ch;
        switch(ch){
            case 1 :
               for(int i = 0 ; i<n ;  i++){
                b[i].input();
               }

               break;
            case 2 :
               cout<<"ID"<<"\t"<<"Title"<<"\t"<<"Author"<<"\t"<<"Price"<<endl;
               for(int i = 0 ; i<n ;  i++){
                   b[i].display();
               }
               break;
            case 3 : 
               exit(0);
            default :
               cout<<"enter valid choice ";
        }
    }
    return 0 ;
}