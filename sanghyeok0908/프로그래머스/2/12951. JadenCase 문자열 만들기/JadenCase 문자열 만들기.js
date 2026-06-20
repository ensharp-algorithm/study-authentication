function solution(s) {
    const arr = s.split(" ")
                .map(o => {
                    const start = o.substring(0, 1);
                    const tail = o.substring(1, o.length).toLowerCase();
                    
                    if (Number.isInteger(start)) {
                        return start + tail;        
                    }
                    return start.toUpperCase() + tail;
                });
    
    let answer = "";
    for (a of arr) {
        answer += a + " ";
    }
    return answer.substring(0, answer.length - 1);
}