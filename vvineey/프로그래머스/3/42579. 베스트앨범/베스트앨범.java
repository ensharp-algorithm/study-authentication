import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> answerList = new ArrayList<>();

        HashMap<String, Integer> total = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]  );
        }
        
        //
   
        TreeSet<Node> ts = new TreeSet<>(
            (o1, o2) -> Integer.compare(o2.play, o1.play));
        
        
        for (String name : total.keySet()) {
            ts.add(new Node(name, total.get(name)));
        }
        
        
        for (Node node : ts) {
            System.out.println(node.name + " " + node.play);
        }
        
        
        //
        
        HashMap<String, List<Node>> genreList  = new HashMap<>();
  
        for (int i = 0; i < genres.length; i++) {
            
            //없으믄 만들어서 넣어라 
            if (!genreList.containsKey(genres[i])) {
                genreList.put(genres[i], new ArrayList<>());
            }

            //있으믄 추가 추가 
            genreList.get(genres[i]).add(new Node(i, plays[i]));
        }
        
    
        
        //
        
        for (Node genreNode : ts) {
            List<Node> songs = genreList.get(genreNode.name);

            songs.sort((o1, o2) -> { 
                if (o1.play != o2.play) {
                    return Integer.compare(o2.play, o1.play);
                }
                
                return Integer.compare(o1.idx, o2.idx);
            });
            
            int limit = Math.min(2, songs.size());

            for (int i = 0; i < limit; i++) {
                answerList.add(songs.get(i).idx);
            } 
        }

        int [] answer = new int[answerList.size()];
        int cnt = 0;
        
        for (int idx : answerList){
            answer[cnt++] = idx;
        }

        return answer;
    }
    
    static class Node{
        
        String name;
        int idx;
        int play;
        
        Node(int idx,int play){
            this.idx = idx;
            this.play = play;
        }
                
        
        Node(String name ,int play){
            this.name = name;
            this.play = play;
        }
    }
    
}