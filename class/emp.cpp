#include <stdio.h>
#include <iostream>
#include <string>
#include <fstream>
using namespace std;

class emp{
    int id, age,sal ;
    char name[20] ;
    public :
     void input(){
        cout<<"Enter id";
        cin>>id;
        cout<<"denter name";
        cin>>name;
        cout<<"enter age :";
        cin>>age;
        cout<<"Enter sal";
        cin>>sal;
     }

     void display(){
        cout<<id<<"\t"<<name<<"\t"<<age<<"\t"<<sal<<endl;
     }
};

int main(){
    int ch , flag;
    emp e ;
    fstream file;
    char fname[20];


    while(1){

        cout<<"Enter choice :";
        cin>>ch;
        switch(ch){
            case 1:
              e.input();
              file.open("emp.txt", ios::out|ios::app);
              file.write((char *)&e, sizeof(e));
              file.close();
              break;
            case 2:
               cout<<"----infoo ----"<<endl;
               file.open("emp.txt", ios::in);
               if(!file){
                cout<<"Error opening file ";
                break;
               }
               while(file.read((char *)&e, sizeof(e))){
                e.display();
               }
               file.close();
              break;
            case 3 :
              cout <<"enter new file name: ";
              cin>>fname;
              flag = rename("emp.txt",fname);
              if(flag == 0){
                cout<<"Renamed successfully "<<endl;
              }
            case 4 :
              exit(0);
            default : 
              cout<<"enter valid choice "<<endl;

        }
    }
}