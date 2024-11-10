package gossip;

public class gailv {
    public static void main(String[] args) {
//        int[] step = new int[] {0, 10, 60,120,300, 600,900,1200,2400,3600 };
//        for (int i : step)
//        {
//            double p = CalculateSendingProbability(i, 0);
//            System.out.printf("step = {%d}  p = {%f}\n",i,p);
//        }

        for (int i = 0; i < 500; i += 5) {
            double p = CalculateSendingProbability(i, 0);
            System.out.printf("step = {%d}  p = {%f}\n", i, p);
        }
    }

    public static double CalculateSendingProbability(int validTime, int linkNum) {
        double m = 1, n = 0.5;
        if (validTime == 0)
            return 0;
        // 采用差分策略计算
        if (validTime <= 60 * 5)
            m = 5;
        else if (validTime <= 60 * 30) {
            m = 10;
        }else {
            m = 15;
        }

        double p = m / validTime;
        // p *= n / linkNum;
        return p;
    }
}
