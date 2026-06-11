#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

class Animal{
    public:
     virtual void speed() = 0;
};

class Tiger : public Animal{
    public:
    void speed(){
        cout<<" tiger :- 90 km/h "<<endl;
    }
};

class Cheetah : public Animal{
    public:
    void speed(){
        cout<<" tiger :- 50 km/h "<<endl;
    }
};

int main(){
    Animal *a;
    Tiger t;
    Cheetah c;

    a = &t;
    a->speed();
    a = &c;
    a->speed();

    return 0 ;

}