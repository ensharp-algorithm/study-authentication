#include <stdio.h>
#include <string.h>


int main(int argc, const char * argv[]){
    int arr[26]={0};
    char s[101];
    
    scanf("%s",s);
    for (int i=0;i<strlen(s);i++){
        arr[s[i]-'a']++;
    }
    
    for (int i=0;i<26; i++) {
        printf("%d ",arr[i]);
    }
    
    
}




