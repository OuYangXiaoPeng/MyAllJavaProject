package HeBingLiangGeYouXuShuZu;

import java.util.Arrays;

public class HeBingLiangGeYouXuShuZu {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0; // 定义两个指针p1和p2，分别指向nums1和nums2的起始位置
        int[] sorted = new int[m + n]; // 创建一个新数组sorted用于存储合并后的有序数组
        int cur; // 当前元素的值
        while (p1 < m || p2 < n) { // 循环条件：只要p1或p2还没有达到数组末尾
            if (p1 == m) { // 如果p1已经达到nums1的末尾，则将nums2[p2]的值赋给cur，并将p2向后移动一位
                cur = nums2[p2++];
            } else if (p2 == n) { // 如果p2已经达到nums2的末尾，则将nums1[p1]的值赋给cur，并将p1向后移动一位
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) { // 如果nums1[p1]的值小于nums2[p2]的值，则将nums1[p1]的值赋给cur，并将p1向后移动一位
                cur = nums1[p1++];
            } else { // 如果nums2[p2]的值小于等于nums1[p1]的值，则将nums2[p2]的值赋给cur，并将p2向后移动一位
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur; // 将当前元素cur放入sorted数组中的正确位置
        }
        for (int i = 0; i != m + n; ++i) { // 将sorted数组中的元素赋值给nums1数组，完成合并操作
            nums1[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 3, 6};
        HeBingLiangGeYouXuShuZu heb = new HeBingLiangGeYouXuShuZu();
        heb.merge(nums1, nums1.length, nums2, nums2.length);
    }

}
