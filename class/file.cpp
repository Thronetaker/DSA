#include <stdio.h>
#include <iostream>
#include <string>
#include <fstream>


using namespace std;

int main(){
    string name;
    string label;
    int words = 0,lines=0,alphabets=0,digits=0;
    char ch;

    // cin.ignore(); 
     //imp to write  only if used cin before getline
//    getline(cin, name);  // string header included 
    ofstream fout;
    ifstream fin;
    fin.open("f.txt",ios::in);
    fout.open("2_new.txt",ios::out);

    while(fin.get(ch) ){
        
        if( ch == ' '|| ch == '\n' || ch == '\t')  words++;
        if (ch == '\n') lines++;
        fout<<ch;
        // alphabet count
        if (isalpha(ch)) {
            alphabets++;
        }
        // digit count
        else if (isdigit(ch)) {
            digits++;
        }

    }

    cout<<"Lines : "<<lines<<endl;
    cout<<"words: "<<words<<endl;
    fin.close();
    fout.close();

    cout<<"reading from new file : - "<<endl;
    fin.open("2_new.txt",ios::in);
    while( fin.eof() == 0 ){
        fin.get(ch);
        cout<<ch;
    }

    fin.close();

    return 0;
}


