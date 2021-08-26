package leetCode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

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

    /**解法：摩尔投票
     * 多数元素：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param: nums
     * @return int
     */
    public static int majorityElement(int[] nums) {
        int count = 1, most = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                most = nums[i];
            }
            if (nums[i] == most) count++;
            else count--;
        }
        return most;
    }

    /**
     * 能确定center ，left = center-1；不能确定center ，left = center;
     * ------------------------------------------------------------------------
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
            return binarySearch(ints, left, center - 1, target);
        } else {
            return binarySearch(ints, center + 1, right, target);
        }
    }

    public static int firstBadVersion(int n, int firstBadVersion) {
        return getFirstBadVersion(1, n, firstBadVersion);
    }

    public static int getFirstBadVersion(int left, int right, int firstBadVersion) {
        if (left == right) {
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
        return index >= firstBadVersion;
    }

    /**
     * x的平方根：实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param: x
     * @return: int
     */
    public static int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int center = left + (right - left) / 2;
            if (center == x / center) return center;
            if (center < x / center) left = center + 1;
            else right = center - 1;
        }
        return right;
    }

    /**
     * ----------------------------------------------------------------------------------------
     * 题型：双指针
     * <p>
     * 有序数组的平方：给你一个按 非递减顺序 排序的整数数组 nums，
     * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * @Param nums
     * @Return: int[]
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, j = n - 1, index = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[index] = nums[i] * nums[i];
                i++;
            } else {
                res[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }
        return res;
    }

    /**
     * 旋转数组：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * @Param nums
     * @Param: k
     * @Return: void
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(n, k);
        for (int start = 0; start < count; start++) {
            int current = start;
            int pre = nums[current];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
            } while (start != current);
        }
    }


    /**
     * 零移动：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param: nums
     * @return: void
     */
    public static void moveZeroes(int[] nums) {
//        if (nums.length == 0) {
//            return;
//        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    /**
     * 两数之和 II - 输入有序数组：给定一个已按照 升序排列  的整数数组 numbers ，
     * 请你从数组中找出两个数满足相加之和等于目标数 target 。
     * <p>
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
     * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     * <p>
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     *
     * @param: numbers
     * @param: target
     * @return: int
     */
    public static int[] twoSumII(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] == target - numbers[right]) return new int[]{left + 1, right + 1};
            if (numbers[left] < target - numbers[right]) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 反转字符串: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * <p>
     * 示例 1：
     * <p>
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * @param: s
     * @return: void
     */
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 反转字符串中的单词 III: 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例：
     * <p>
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * @param: s
     * @return: String
     */
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] temp = words[i].toCharArray();
            reverseString(temp);
            result.append(String.valueOf(temp));
            if (i != words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
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

        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));

        //  二分查找      ------------------------------------
//        System.out.println(search(new int[]{2, 4, 5, 6, 8}, 3));
//        System.out.println(firstBadVersion(5, 4));
//        System.out.println(mySqrt(2147395599));

        //  双指针      ------------------------------------
//        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
//        int[] nums = {2,7,11,15};
//        rotate(nums, 3);
//        moveZeroes(nums);
//        System.out.println(Arrays.toString(twoSumII(nums,9)));
//        String s = "Let's take LeetCode contest";
//        System.out.println(reverseWords(s));
    }

}
