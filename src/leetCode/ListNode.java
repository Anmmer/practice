package leetCode;




/**
 * @description:
 * @author:
 * @createDate: 2021/7/15
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode ListNodeBuilder(int[] ints) {
        ListNode head = null ,temp = null;
        for (int i : ints) {
            if(head == null){
                head = temp = new ListNode(i);
            }else {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
        }
        return head;
    }

    public static void TraverseNode(ListNode head) {
        System.out.print(head.val + "-->");
        ListNode temp = head.next;
        while (temp.next != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        ListNode head = ListNodeBuilder(nums);
        TraverseNode(head);

    }
}
