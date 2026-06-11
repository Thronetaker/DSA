#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

class Number{
    int a;
    float b;
    public :
    Number(int x, float y){
        a = x;
        b = y ;
    }
    Number(){}
     Number operator+(Number &T);
     void operator++(int);
     void display(){
        cout<<"Display a : "<<a<< " b : "<<b<<endl ;
     }
};

Number Number :: operator+(Number &T){
    Number temp;
    temp.a = this->a + T.a;
    temp.b = this->b + T.b;
    return temp;
}

void Number :: operator++(int){
    a++;
    b++;
}

int main(){
    Number n1(6,7.5), n2(2,8.0);
    Number n3 = n1+n2;

    n3.display();
    n3++;
    n3.display();
    
   
    return 0;
}