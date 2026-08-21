import java.util.*;

class Solution {
    
    class Node {
        Node parent;
        String name;
        int total;
        
        Node(Node parent, String name) {
            this.parent = parent;
            this.name = name;
        }
    }
    
    Map<String, Node> map = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map.put("-", new Node(null, "-"));
        
        for (int i = 0; i < enroll.length; i++) {
            Node node = new Node(map.get(referral[i]), enroll[i]);
            map.put(enroll[i], node);
        }
        
        for (int i = 0; i < seller.length; i++) {
            setNode(map.get(seller[i]), amount[i] * 100);
        }
        
        // printNode(map.get("-"));
        // for (String name : map.keySet()) {
        //     printNode(map.get(name));
        // }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).total;
        }
        return answer;
    }
    
    void setNode(Node node, int amount) {
        int percent = amount / 10;
        
        if (node.name.equals("-") || percent < 1) {
            node.total += amount;
            return;
        }
        
        node.total += amount - percent;
        setNode(node.parent, percent);
    }
    
    void printNode(Node node) {
        if (node.parent == null) {
            System.out.println("name = " + node.name + ", amount = " + node.total + ", parent = null");
        } else {
            System.out.println("name = " + node.name + ", amount = " + node.total + ", parent = " + node.parent.name);    
        }
        
    }
}