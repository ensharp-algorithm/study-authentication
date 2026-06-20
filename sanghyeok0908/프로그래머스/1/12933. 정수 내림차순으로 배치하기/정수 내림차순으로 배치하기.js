function solution(n) {
    return Number(String(n)
                  .split('')
                  .sort()
                  .reverse()
                  .reduce((sum, current) => sum + current, ""));
}