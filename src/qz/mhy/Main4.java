package qz.mhy;

public class Main4 {
    public static void main(String[] args) {
        double t = 1.0;

        for (int i = 0; i < 15; i++) {
            t = t * (1 / 6.0);
        }
        System.out.println(t);
    }
}
