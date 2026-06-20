function solution(s) {
    let arr = s.split(" ")
                .map(Number)
                .sort((o1, o2) => o1 - o2);
    let answer = arr[0] + " " + arr[arr.length - 1];
    return answer;
}