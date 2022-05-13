package main;

import main.middle.Daily_OneAwayLcci;

public class Main {

    public static void main(String[] args) {
        Daily_OneAwayLcci daily_oneAwayLcci = new Daily_OneAwayLcci();
        boolean b = daily_oneAwayLcci.oneEditAway("teacher", "bleacher");
        System.out.println(b);


    }
}
