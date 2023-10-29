package main.hard;

import java.util.*;

public class Test_reconstructitinerary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> a = new ArrayList<>();
        ArrayList<String> t = new ArrayList<>();

        t.add("JFK");t.add("KUL");
        a.add(new ArrayList<>(t));
        t.clear();

        t.add("JFK");t.add("NRT");
        a.add(new ArrayList<>(t));
        t.clear();

        t.add("NRT");t.add("JFK");
        a.add(new ArrayList<>(t));
        t.clear();


        List<String> itinerary = solution.findItinerary(a);
        System.out.println(itinerary);
    }
    static class Solution {
        List<String> path = new ArrayList<>();
        List<String> result;

        Map<String,List<String>> graph = new HashMap<>();
        int n;
        public List<String> findItinerary(List<List<String>> tickets) {
            n=tickets.size();
            for(List<String> ticket:tickets){
                List<String> to = graph.getOrDefault(ticket.get(0), new ArrayList<>());
                to.add(ticket.get(1));
                graph.put(ticket.get(0),to);
            }
            for (String key : graph.keySet()){
                //对每个list按大小排序
                List<String> list = graph.get(key);
                list.sort((a,b)->a.compareTo(b));
            }
            path.add("JFK");
            dfs("JFK");
            return result;
        }
        public void dfs(String begin){
            if(path.size()==n+1){
                result = new ArrayList<>(path);
                return;//所有的票已经遍历
            }

            List<String> cango = graph.get(begin);
            if (cango==null)
                return;
            for (int i = 0; i < cango.size(); i++) {

                String target = cango.get(i);
                if(target.equals("false"))
                    continue;
                cango.set(i,"false");
                graph.put(begin,cango);
                path.add(target);

                dfs(target);

                path.remove(path.size()-1);
                cango.set(i,target);
                graph.put(begin,cango);
                if(result!=null)
                    return;
            }
        }
    }
}
