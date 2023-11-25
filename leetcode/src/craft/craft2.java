package craft;

public class craft2 {
    public static void main(String[] args) {
        int num = 3;
        int result = total(num);
        System.out.println(result);
    }

    public static int total(int num) {
        int water = num;
        int total = 0;
        int waterYu = 0;
        while (water != 0) {
            System.out.println(water);
            total += water;
            waterYu += water % 2;
            System.out.println("yu:" + waterYu);
            water = water / 2;
        }
        if (num % 2 == 0)
            return total;
        else {
            while (waterYu != 0) {
                total += waterYu / 2;
                waterYu = waterYu / 2;
            }
            return total;
        }
    }
}
