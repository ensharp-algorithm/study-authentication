//
//  1924.c
//  backjoon
//
//  Created by 서상혁 on 1/28/24.
//

#include <stdio.h>

int main(void) {
    int x, y;
    int month[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    char week[7][4] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    scanf("%d %d", &x, &y);
    
    for(int i = 0; i < x - 1; i++)
        y += month[i];
    
    printf("%s\n", week[y % 7]);
    return 0;
}
