#include <stdio.h>
#include <iostream>
#include <string.h>
#include <fstream>
using namespace std;


class Prod{
    static int cnt ;
    int  price;
    char name[20];
    int id;
    public:
      void input();
      void display();
      void sortt(Prod arr[], int n);
};

int Prod :: cnt = 0;

void Prod :: input(){
    cnt++;
    id =cnt;;
    cout<<"enter name product : ";
    cin>>name;
    cout<<"enter price : ";
    cin>>price;
}

void Prod :: display(){
   cout<<id<<"\t"<<name<<"\t"<<price<<endl;
}

void Prod :: sortt(Prod arr[], int n){
     for(int i = 0;i<n-1 ;i++){
        int min = i;
        for(int j = i+1 ;j<n ; j++){
            if(arr[min].price > arr[j].price){
                min = j;
            }
        }

        if( min != i){
            Prod temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp ;
        }
     }
}


int main(){
    fstream file;
    int ch;
    Prod p;
    char fname[20], newname[20];
    cout<<"enter file name : ";
    cin>>fname;
    cout<<"1.Input\t2.Display\t3.sort\t4.Rename\t5.Delete"<<endl;
    while(1){
        cout<<"Enter ur choice : ";
        cin>>ch;
        
        switch(ch){
            case 1:
              file.open(fname, ios::out|ios::app);
              p.input();
              file.write((char*)&p, sizeof(p));
              file.close();
              break;
            case 2:
              file.open(fname, ios::in);
              if(!file) {
                cout<<"Error opening!";
                break;
              }
              
              while(file.read((char*)&p, sizeof(p))){
                p.display();
              }
              file.close();
              break;
            case 3:
              break;
            case 4:
              cout<<"enter newname (with type): ";
              cin>>newname;
              if(rename(fname,newname)==0){
                cout<<"File name changed!"<<endl;
              }
              strcpy(fname, newname);
              break;
            case 5:
              if(remove(fname)==0){
                cout<<"file deleted";
              }
              
              break;
            case 6:
              exit(0);
            default:
              cout<<"enter valid choice ";

        }
    }

    return 0 ;
}