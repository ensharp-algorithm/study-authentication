function solution(A,B){
    const n = A.length;
    let a = 0, b = 0;
    
    A.sort((o1, o2) => o1 - o2);
    B.sort((o1, o2) => o1 - o2);
    
    for (let i = 0; i < n; i++) {
        a += A[i] * B[n - 1 - i];
        b += A[n - 1 - i] * B[i];
        // console.log(a + " " + b);
    }
    return a > b ? b : a;
}