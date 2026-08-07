import java.util.*;

class Solution {

    class Request{
        int idx;
        int requestTime;
        int workTime;
        
        Request(int idx, int requestTime, int workTime){
            this.idx = idx;
            this.requestTime = requestTime;
            this.workTime = workTime;
        }
    }
    
    class Work{
        Request request;
        int start;
        
        Work(Request request, int start){
            this.request = request;
            this.start = start;
        }
    }
    
    public int solution(int[][] jobs) {
        
        //요청 시간 단위로 정렬 
        for (int [] job : jobs){
            Arrays.sort(jobs, (o1,o2)->{
                return Integer.compare(o1[0],o2[0]);
            });
        }
        
        //우선순위 : 소요시간 > 요청 시각 > 인덱스 
        PriorityQueue<Request> queue = new PriorityQueue<>((o1,o2)->{
            if (o1.workTime != o2.workTime){
                return Integer.compare(o1.workTime, o2.workTime);
            }
            
            if (o1.requestTime != o2.requestTime){
                return Integer.compare(o1.requestTime, o2.requestTime);
            }
            return Integer.compare(o1.idx, o2.idx);
        });
        
        
        int current = 0;
        int cnt = 0;
        int total = 0;
        int jobIdx = 0;

        while (cnt < jobs.length){
            // System.out.println("시점 " + current);
            
            
            //현재 시점 == 작업 요청 시각 -> 대기큐에 넣음
            while(jobIdx < jobs.length && current >= jobs[jobIdx][0]){
                    // System.out.println("작업 요청 " + jobIdx + " " + jobs[jobIdx][0] + " " + jobs[jobIdx][1]);
                    queue.offer(new Request(jobIdx,jobs[jobIdx][0],jobs[jobIdx][1]));
                    jobIdx++;
            }
            
            //대기 중인 작업이 없는 경우 -> 다음 작업 요청 시간으로 이동 
            if (queue.isEmpty()){
                current = jobs[jobIdx][0];
                continue;
            }
            
            //대기 중인 작업이 있는 경우 -> 작업 실행 후 시간을 종료 시간으로 이동
            Request request = queue.poll();
            
            current += request.workTime;
            total += (current - request.requestTime);
            // System.out.println("반환 시간 " + (current - request.requestTime));
            
            cnt++;
           
        }
        

        return total/jobs.length;
    }
}