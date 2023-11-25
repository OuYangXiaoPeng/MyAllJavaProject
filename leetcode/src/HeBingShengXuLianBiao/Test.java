package HeBingShengXuLianBiao;

public class Test {
    public static void main(String[] args) {
        // 创建示例链表：[[1,4,5], [1,3,4], [2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        HeBingShengXuLianBiao mergeKLists = new HeBingShengXuLianBiao();
        ListNode result = mergeKLists.mergeKLists(lists);

        // 输出合并后链表的所有元素
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

