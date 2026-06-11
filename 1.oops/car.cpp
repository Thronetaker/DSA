#include <stdio.h>
#include <iostream>
#include <string.h>
#include <fstream>
using namespace std;

class Car{
    public:
    char model[20];
    char company[20];
    float price;
    int regis_no;
    int delivery_status;
    
      void input(){
        cout<<"enter model : ";
        cin>>model;
        cout<<"Enter company : ";
        cin>>company;
        cout<<"enter price: ";
        cin>>price;
        cout<<" Enter registrartion number : ";
        cin>>regis_no;
        cout<<"Enter delivery status : ";
        cin>>delivery_status;

      }

      void display(){
        cout<< model<<" "<<company <<" "<<price<<" "<<regis_no<<" "<<delivery_status<<endl;

      }

      void update_status(){


      }

      int getStatus(){
        return delivery_status;
      }

};

int main(){

    Car c[10];
    Car cc;
    int reg;
    ofstream fout, fout2, fout3;
    ifstream fin, fin1, fin2;
    fout.open("CarDetails.txt",ios::out| ios::binary);

    for(int i = 0 ; i <5; i++){
        cout<<"Enter data for "<<i+1<<" item: "<<endl;
        c[i].input();
        fout.write( (char*)&c[i], sizeof(c[i]));

    }
    
    cout<< "Displauy after input : "<<endl ;
    for(int i = 0 ; i <5; i++){
        c[i].display();

    }

    fout.close();

    fin.open("CarDetails.txt",ios::in);
    fout2.open("Deliveredcars.txt",ios::out);
    fout3.open("Undeliveredcars.txt",ios::out);
    while(fin.read( (char*)&cc, sizeof(cc))){
        if( cc.getStatus() == 1){
             fout2.write( (char*) &cc.regis_no, sizeof(cc.regis_no));
        }
         else if( cc.getStatus() == 0){
             fout3.write( (char*) &cc.regis_no, sizeof(cc.regis_no));
        }
    }

    fout3.close();
    fout2.close();
    fin.close();
   
    cout << "\nDelivered Cars:\n";
    fin1.open("Deliveredcars.txt", ios::in | ios::binary);
    while(fin1.read((char * )&reg, sizeof(reg))){
        cout << reg << endl;
    }
    
    cout << "\nUNDelivered Cars:\n";
    fin2.open("Undeliveredcars.txt", ios::in | ios::binary);
    while(fin2.read((char * )&reg, sizeof(reg))){
        cout << reg << endl;
    }

    fin1.close();
    fin2.close();


return 0 ;

}