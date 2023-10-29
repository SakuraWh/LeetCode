package main.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Daily_numberofstudentsunabletoeatlunch {
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {

            Stack<Integer> sandwichess = new Stack();
            Queue<Integer> studentss = new LinkedList<>();
            for(int i=0;i<students.length;i++){
                sandwichess.push(sandwiches[sandwiches.length-i-1]);
                studentss.offer(students[i]);
            }
            boolean change = true;
            while(change){
                change = false;
                int n = studentss.size();
                while(n>0){
                    if(studentss.peek() == sandwichess.peek()){
                        studentss.poll();
                        sandwichess.pop();
                        change = true;
                    }else {
                        studentss.offer(studentss.poll());
                    }
                    n--;
                }

            }
            return studentss.size();
        }
    }
}
