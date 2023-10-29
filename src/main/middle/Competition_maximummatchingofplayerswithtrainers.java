package main.middle;

import java.util.Arrays;

public class Competition_maximummatchingofplayerswithtrainers {
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);
            int i = 0;

            for (int j = 0; j < trainers.length; j++) {
                if(players[i]<trainers[j]){
                    i++;
                }
                if(i== players.length)
                    return i;
            }
            return i;
        }
    }
}
