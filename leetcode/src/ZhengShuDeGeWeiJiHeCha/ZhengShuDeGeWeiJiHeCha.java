package ZhengShuDeGeWeiJiHeCha;

public class ZhengShuDeGeWeiJiHeCha {

    int sum = 0, acc = 1;

    public int subtractProductAndSum(int n) {
        System.out.println("sum:" + sum + ",acc:" + acc + ",n:" + n);
        if (n != 0) {
            sum += n % 10;
            acc *= n % 10;
            n /= 10;
            subtractProductAndSum(n);
        }
        return acc - sum;
    }

    public int subtractProductAndSum2(int n) {
        for (int i = n; i != 0; i /= 10) {
//            System.out.println("sum:" + sum + ",acc:" + acc + ",n:" + i);
            sum += i % 10;
            acc *= i % 10;
        }
        return acc - sum;
    }

    public static void main(String[] args) {
        ZhengShuDeGeWeiJiHeCha zheng = new ZhengShuDeGeWeiJiHeCha();
        int result = zheng.subtractProductAndSum2(705);
        System.out.println(result);
    }

}
