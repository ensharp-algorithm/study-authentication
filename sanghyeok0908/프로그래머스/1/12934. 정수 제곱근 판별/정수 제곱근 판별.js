function solution(n) {
    let num = Math.sqrt(n);
    if (Number.isInteger(num)) {
        return Math.pow(num + 1, 2);
    }
    return -1;
}