function solution(s){
    const stack = [];
    
    for (str of s) {
        if (str === '(') {
            stack.push('(');
        } else {
            if (stack.length == 0) {
                return false;
            }
            stack.pop();
        }
    }
    return stack.length === 0;
}