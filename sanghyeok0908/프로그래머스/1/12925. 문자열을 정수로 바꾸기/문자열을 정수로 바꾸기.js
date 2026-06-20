function solution(s) {
    let answer = 0;
    
    if (s.startsWith("-")) {
        answer = Number(s.substring(1, s.length)) * -1;
    } else if (s.startsWith("+")) {
        answer = Number(s.substring(1, s.length));
    } else {
        answer = Number(s);
    }
    
    return answer;
}