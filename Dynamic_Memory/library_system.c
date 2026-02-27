#include <stdio.h>
#include <stdlib.h>

int main()
{
    int shelves = 3;

    int *books = calloc(shelves,sizeof(int));
    int **pages = calloc(shelves,sizeof(int*));

    books[0]++;
    pages[0] = realloc(pages[0],books[0]*sizeof(int));
    pages[0][0] = 100;

    books[0]++;
    pages[0] = realloc(pages[0],books[0]*sizeof(int));
    pages[0][1] = 200;

    printf("Shelf 0 Book 1 Pages = %d\n",pages[0][1]);

    free(books);

    for(int i=0;i<shelves;i++)
        free(pages[i]);

    free(pages);
}