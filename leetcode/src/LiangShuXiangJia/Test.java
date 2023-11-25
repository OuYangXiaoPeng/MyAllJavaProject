package LiangShuXiangJia;

public class Test {

    public static void main(String[] args) throws Exception {

        ListNode l1 = new ListNode(203);
        ListNode l2 = new ListNode(25);


        LiangShuXiangJia liang = new LiangShuXiangJia();
        //返回头结点“8（3+5）”
        ListNode result = liang.addTwoNumbers(l1, l2);
        System.out.println(result.val);

    }
}
