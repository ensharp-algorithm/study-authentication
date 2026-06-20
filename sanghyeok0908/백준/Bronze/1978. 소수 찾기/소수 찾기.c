//
//  1978.c
//  backjoon
//
//  Created by 서상혁 on 1/28/24.
//

#include <stdio.h>

int main(void) {
    int N;
    int count = 0;
    
    scanf("%d", &N);
    
    int num[N];
    for(int i = 0; i < N; i++)
        scanf("%d", &num[i]);
    
    for(int i = 0; i < N; i++) {
        int isNot = 1;
        
        if (num[i] == 1)
            continue;
        
        for(int j = 2; j < num[i]; j++) {
            if (num[i] % j == 0) {
                isNot = 0;
//                printf("num[i] = %d, j = %d\n", num[i], j);
                break;
            }
        }
        
        if (isNot)
            count++;
    }

    printf("%d\n", count);
    return 0;
}
