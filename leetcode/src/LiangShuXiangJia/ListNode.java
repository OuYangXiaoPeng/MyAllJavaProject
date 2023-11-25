package LiangShuXiangJia;

/*
结点类
每个结点类就是一个元素的结点内存映象，
 */
public class ListNode {
    //    2个成员变量
    int val;//数据域
    ListNode next;//指针域

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
