import java.util.*;

class Solution {
    
    static class Node {
        public int idx, x, y;
        public Node left, right;
        
        public Node(int idx, int[] info) {
            this.idx = idx + 1;
            this.x = info[0];
            this.y = info[1];
        }
    }
    
    static Node[] nodes;
    static int N;
    static int[][] answer;
    static int prevIdx = 0;
    static int backIdx = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        this.N = nodeinfo.length;
        this.nodes = new Node[N];
        this.answer = new int[2][N];
        Node root;
        
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i, nodeinfo[i]);
        }
        
        Arrays.sort(nodes, (a, b) -> b.y - a.y);
        root = nodes[0];
        
        for (int i = 1; i < N; i++) {
            setNode(root, nodes[i]);
        }
        
        prevPrint(root);
        backPrint(root);
        return answer;
    }
    
    void setNode(Node parent, Node node) {
        // 왼쪽
        if (parent.x > node.x) {
            if (parent.left == null) {
                parent.left = node;
            } else {
                setNode(parent.left, node);
            }
            return;
        }
        // 오른쪽
        if (parent.right == null) {
            parent.right = node;
        } else {
            setNode(parent.right, node);
        }
    }
    
    void prevPrint(Node node) {
        if (node == null) return;
        
        answer[0][prevIdx++] = node.idx;
        // System.out.println(String.format("idx = %d, y = %d, x = %d", node.idx, node.y, node.x));
        prevPrint(node.left);
        prevPrint(node.right);
    }
    
    void backPrint(Node node) {
        if (node == null) return;
        
        backPrint(node.left);
        backPrint(node.right);
        // System.out.println(String.format("idx = %d, y = %d, x = %d", node.idx, node.y, node.x));
        answer[1][backIdx++] = node.idx;
    }
}