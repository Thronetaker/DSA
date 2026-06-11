#include <iostream>
#include <fstream>
using namespace std;

class Car {
public:
    string model;
    string company;
    float price;
    int regis_no;
    int delivery_status;

    void input() {
        cout << "Enter model: ";
        cin >> model;
        cout << "Enter company: ";
        cin >> company;
        cout << "Enter price: ";
        cin >> price;
        cout << "Enter registration number: ";
        cin >> regis_no;
        cout << "Enter delivery status (1/0): ";
        cin >> delivery_status;
    }

    void display() {
        cout << model << " "
             << company << " "
             << price << " "
             << regis_no << " "
             << delivery_status << endl;
    }
};

int main() {
    Car c;

    // 🔹 Writing to file
    ofstream fout("CarData.txt");

    for(int i = 0; i < 3; i++) {
        cout << "\nEnter details for car " << i+1 << endl;
        c.input();

        fout << c.model << " "
             << c.company << " "
             << c.price << " "
             << c.regis_no << " "
             << c.delivery_status << endl;
    }

    fout.close();

    // 🔹 Reading from file
    ifstream fin("CarData.txt");

    cout << "\nData from file:\n";

    while(fin >> c.model
              >> c.company
              >> c.price
              >> c.regis_no
              >> c.delivery_status) {

        c.display();
    }

    fin.close();

    return 0;
}