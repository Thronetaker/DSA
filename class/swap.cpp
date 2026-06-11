#include <iostream>
#include <cstring>
using namespace std;

int main() {
    char arr[][20] = {"banana", "apple", "cherry"};
    int n = 3;

    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;

        for (int j = i + 1; j < n; j++) {
            if (strcmp(arr[j], arr[minIndex]) < 0) {
                minIndex = j;
            }
        }

        // swap strings
        char temp[20];
        strcpy(temp, arr[i]);
        strcpy(arr[i], arr[minIndex]);
        strcpy(arr[minIndex], temp);
    }

    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";

    return 0;
}