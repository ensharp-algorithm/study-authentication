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
        
        Queue<Work> hardDisk = new ArrayDeque<>();
        
        int current = 0;
        int cnt = 0;
        int total = 0;

        while (cnt < jobs.length){
            // System.out.println("시점 " + current);
            
            for (int i = 0; i < jobs.length; i++){
                
                //현재 시점 == 작업 요청 시각 -> 대기큐에 넣음
                if (current == jobs[i][0]){
                    // System.out.println("작업 요청 " + i + " " + jobs[i][0] + " " + jobs[i][1]);
                    queue.offer(new Request(i,jobs[i][0],jobs[i][1]));
                    jobs[i][0] = -1;
                }
            }
            
            //작업 중이지 않으면 대기큐에서 우선순위가 높은 작업을 빼서 시작함
            if (hardDisk.isEmpty() && !queue.isEmpty()){
                Request request = queue.poll();
                // System.out.println("작업 시작 " + request.idx + " " + request.requestTime + " " + request.workTime);
                hardDisk.offer(new Work (request, current));
            }
            
           if (!hardDisk.isEmpty()) {
                Work work = hardDisk.peek();
                if (current == (work.start + work.request.workTime)){
                    // System.out.println("작업 끝 " + work.request.idx + " " + work.request.requestTime + " " + work.request.workTime);
                    hardDisk.poll();
                    cnt++;
                    
                    // System.out.println("반환시간 " + (current - work.request.requestTime));
                    total += (current - work.request.requestTime);
                    continue;
                }
            }
            
            
            current++;
        }
        

        return total/jobs.length;
    }
}