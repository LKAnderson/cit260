#include <stdio.h>


void printBits(unsigned char* bits, int length) {
    for (int i=0; i < length; i++){
        unsigned char byte = bits[i];

        for (int j = 0; j < 8; j++) {
            unsigned char bit = (byte >> j) & 0x01;
            printf("%d", bit);
        }
    }
}


int main(int argc, char** argv) {
    
    float a = 0.333;
    float b = 1.0 / 3.0;

    printBits((unsigned char*)&a, sizeof(a));
    printf("\n");
    printBits((unsigned char*)&b, sizeof(b));
    printf("\n");

    return 0;
}