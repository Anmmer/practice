package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author:
 * @createDate: 2021/7/15
 */
public class leetCode {
    /**
     * 两数之和  :给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 target  的那 两个 整数，
     * 并返回它们的数组下标。
     * <p>
     * 使用hash进行缓存
     *
     * @Param: [ints, target]
     * @Return: int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = map.get(nums[i]);
                index[1] = i;
                return index;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return index;
    }

    /**
     * 两数相加 :给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @Param: [l1, l2]
     * @Return: leetCode.ListNode
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, temp = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = temp = new ListNode(sum % 10);
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 无重复字符的最长子串：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @Param: [str]
     * @Return: int
     */
    public static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>(); //判断是否重复
        int index = -1, maxLength = 0;
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            if (i != 0) {
                set.remove(str.charAt(i - 1));
            }
            while (index + 1 < strLength && !set.contains(str.charAt(index + 1))) {
                set.add(str.charAt(index + 1));
                index++;
            }
            maxLength = Math.max(maxLength, index + 1 - i);
        }
        return maxLength;
    }

    /**
     * 寻找两个正序数组的中位数 : 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出并返回这两个正序数组的 中位数 。
     *
     * @Param: [nums1, nums2]
     * @Return: double
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middle = (int) Math.ceil((nums1.length + nums2.length) >> 1);
        return 0;

    }

    /**
     * 二分查找 :给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * @Param nums
     * @Param target
     * @Return: int
     */
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] ints, int left, int right, int target) {
        // 数组里target不存在的情况
        if (left == right) {
            if (target == ints[left]) return left;
            else return -1;
        }
        int center = left + (right - left) / 2;
        if (target == ints[center]) {
            return center;
        }
        if (target < ints[center]) {
            return binarySearch(ints, left, center, target);
        } else {
            return binarySearch(ints, center + 1, right, target);
        }
    }

    public static int firstBadVersion(int n, int firstBadVersion) {
        return getFirstBadVersion(1, n, firstBadVersion);
    }

    public static int getFirstBadVersion(int left, int right, int firstBadVersion) {
        if (left == right && !isBadVersion(left, firstBadVersion)) {
            return left;
        }
        int center = left + (right - left) / 2;
        if (isBadVersion(center, firstBadVersion)) {
            return getFirstBadVersion(left, center, firstBadVersion);
        } else {
            return getFirstBadVersion(center + 1, right, firstBadVersion);
        }
    }

    public static boolean isBadVersion(int index, int firstBadVersion) {
        return index <= firstBadVersion;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 4};
//        int target = 6;
//        System.out.println(Arrays.toString(twoSum(nums, target)));
        //----------------------------------

//        int[] l1 = {9, 9, 9, 9, 9, 9, 9};
//        int[] l2 = {9, 9, 9, 9};
//        ListNode.TraverseNode(addTwoNumbers(ListNode.ListNodeBuilder(l1), ListNode.ListNodeBuilder(l2)));
//        ------------------------------------

//        String str = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(str));

        //  二分查找      ------------------------------------
//        System.out.println(search(new int[]{2, 5}, 6));
        System.out.println(firstBadVersion(5, 4));

    }
}
