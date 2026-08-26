import java.util.*;

class Solution {
    
    class Node{
        int idx;
        Node prev;
        Node next;
        
        Node(int idx){
            this.idx = idx;
        }
    }
    
    static Node current;
    static Deque<Node> queue;
    
    public String solution(int n, int k, String[] cmd) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append('O');
        }
        
        current = null;
        queue = new ArrayDeque<>();
        init(n,k);
        
        for (int i = 0; i< cmd.length; i++){
            String c = cmd[i];
            
            if (c.startsWith("U")){
                int x = Integer.parseInt(c.substring(2));
                up(x);
            }
            
            if (c.startsWith("D")){
                int x = Integer.parseInt(c.substring(2));
                down(x);
            }
            
            if (c.startsWith("C")){
                remove();
            }
            
            if (c.startsWith("Z")){
                recover();
            }
        }
        
        while(!queue.isEmpty()){
            sb.setCharAt(queue.poll().idx,'X');
        }
        
        return sb.toString();
    }
    
    private void init(int n, int k){
        
        Node node = new Node(0);
        node.prev = null;
        Node prev = node;
        current = node;
        
        for (int i = 1; i < n; i++) {
            node = new Node(i);
            
            if (i == k) {
                current = node;
            }
            
            node.prev = prev;
            prev.next = node;
            prev = node;
        }
        node.next = null;
    }
    
    private void up(int x){
        for (int i = 0; i < x; i++){
            current = current.prev;
        }
    }
    
    private void down(int x){
        for (int i = 0; i < x; i++){
            current = current.next;
        }
    }
    
    private void remove(){
        queue.offer(current);
        
        Node prev = current.prev;
        Node next = current.next;
        
        if (prev != null && next != null) {
            prev.next = next;
            next.prev = prev;
        }
        
        if (prev == null){
            next.prev = prev;
        }
        
        if (next == null){
            prev.next = next;
        }
        
        if (next == null){
            current = current.prev;
        }
        else{
            current = current.next;
        }
    }
    
    private void recover(){
        
        Node removed = queue.pollLast();

        Node prev = removed.prev;
        Node next = removed.next;
        
        
        if (prev != null && next != null) {
            prev.next = removed;
            next.prev = removed;
        }
        
        if (prev == null){
            next.prev = removed;
        }
        
        if (next == null){
            prev.next = removed;
        }
    }
}