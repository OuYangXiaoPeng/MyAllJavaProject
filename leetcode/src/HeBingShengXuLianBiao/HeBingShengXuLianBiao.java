package HeBingShengXuLianBiao;

public class HeBingShengXuLianBiao {

    public ListNode mergeKLists(ListNode[] lists) {
        // 处理特殊情况，当输入为空或链表数组为空时直接返回null
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 调用辅助方法进行链表合并
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        // 递归出口，当左指针和右指针相等时，说明只有一个链表，直接返回该链表即可
        if (left == right) {
            return lists[left];
        }
        // 计算中间位置
        int mid = (left + right) / 2;
        // 分别递归地合并左右两半部分
        ListNode l1 = mergeLists(lists, left, mid);
        ListNode l2 = mergeLists(lists, mid + 1, right);
        // 合并两个已排序的链表
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建虚拟头结点以便操作
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            // 比较两个链表的节点值，将较小的节点连到当前链表中
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // 将剩余部分连接到当前链表末尾
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next; // 返回合并后的链表
    }

}
