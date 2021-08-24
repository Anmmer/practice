package nowCoder;

/**
 * @description:
 * @author:
 * @createDate: 2021/7/14
 */
public class LinkedNode {
    private Node head;
    private int length;

    private static class Node {
        Node next = null;// 节点的引用，指向下一个节点
        String data;// 节点的对象，即内容

        public Node(String data) {
            this.data = data;
        }
    }

    public void TraverseNode() {
        System.out.print(this.head.data + "-->");
        Node temp = this.head.next;
        for (int i = 1; i < this.length - 1; i++) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }

    public void LinkedNodeBuilder(String[] str) {
        this.head = new Node(str[0]);
        this.length++;
        Node temp = this.head;
        for (int i = 1; i < str.length; i++) {
            temp.next = new Node(str[i]);
            temp = temp.next;
            this.length++;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"5", "10", "7", "6"};
        LinkedNode linkedNode = new LinkedNode();
        linkedNode.LinkedNodeBuilder(strings);
        linkedNode.TraverseNode();
    }
}
