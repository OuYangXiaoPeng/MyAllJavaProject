package craft;

public class craft {

    public static void main(String[] args) {
        for (int i = 0; i <= 21; i++) {
            dp(i);
        }
    }

    public static void dp(int money) {
        int bottlePrice = 1; // 水瓶的价格
        int exchangeNum = 2; // 每2个瓶子可以换1瓶水

        int totalBottles = money / bottlePrice; // 可以购买的水瓶总数
        int emptyBottles = totalBottles; // 初始时空瓶子数等于购买的水瓶数
        int exchangedBottles = 0; // 已经兑换的水瓶数

        while (emptyBottles >= exchangeNum) {
            int exchangedWater = emptyBottles / exchangeNum; // 当前可兑换的水瓶数
            exchangedBottles += exchangedWater; // 更新已经兑换的水瓶数
            emptyBottles = exchangedWater + emptyBottles % exchangeNum; // 更新剩余的空瓶数
        }

        int totalWater = totalBottles + exchangedBottles; // 最终获得的水瓶总数

        System.out.println("最终可以换到的水瓶数为：" + totalWater + "瓶");
    }
}
