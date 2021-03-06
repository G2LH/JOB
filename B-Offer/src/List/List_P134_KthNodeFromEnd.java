package List;

//链表中倒数第k个节点:使用两个距离为k的指针向右移动，只需扫描一遍
public class List_P134_KthNodeFromEnd {
    //删除链表中倒数第k个节点:使用两个距离为k的指针向右移动，只需扫描一遍
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0){
            return head;
        }
        ListNode pre = new ListNode(0);//为了删除头节点
        pre.next = head;
        ListNode l = pre;
        ListNode r = pre;
        for(int i = 0; i < n; i++){
            r = r.next;
        }
        while(r.next!=null){
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return pre.next;
    }
    ////链表中倒数第k个节点:使用两个距离为k的指针向右移动，只需扫描一遍
    public static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k){
        if(head == null || k <= 0)
            return null;
        ListNode<Integer> ptr1 = head;
        ListNode<Integer> ptr2 = head;
        for(int i = 1; i <= k; i++){
            if(ptr1.next != null || i == k){//注意
                ptr1 = ptr1.next;
            }
            else{
                return null;
            }
        }
        while(ptr1 != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }

    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(findKthToTail(head,1).val);
        System.out.println(findKthToTail(head,2).val);
        System.out.println(findKthToTail(head,3).val);
        System.out.println(findKthToTail(head,4));
    }
}
