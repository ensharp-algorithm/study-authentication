import java.util.*;

class Solution {
    
    private class Node {
        int height;
        int width;

        Node (int width, int height) {
            this.width = Math.max(height,width);
            this.height = Math.min(height,width);
        }
    }
    
    private int countBlocks(int width, int height){
        return width * 2 + height * 2 + 4;
    }
    
    
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        
        //가로를 기준으로 정렬
        TreeSet<Node> ts = new TreeSet<>((o1,o2)-> {
            if (o1.width != o2.width){
                return Integer.compare(o2.width , o1.width);
            }
            else{
                return Integer.compare(o1.width , o2.width);
            }});
        
        
        
        //가로 * 세로 조합을 생각함 
        
        for (int i = 1; i* i <= yellow ; i ++){
            if (yellow % i == 0){
                
                Node node = new Node(i, yellow/i);
                if (!ts.contains(node)){
                    ts.add(node);
                }
            }
        }
        
        for (Node node: ts){
            System.out.println(node.width + " "+ node.height);
              if (countBlocks(node.width, node.height) == brown){
                  
                  int [] arr = new int[2];
                  arr[0] = node.width + 2 ;
                  arr[1] = node.height + 2 ;
                  
                  answer = arr;
                  break;
              }
        }
        
        
        
        
        
        
        
        return answer;
    }
    
    
    
}