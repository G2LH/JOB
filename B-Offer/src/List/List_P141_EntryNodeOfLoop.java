package List;

//假设一个链表中包含环，请找出入口节点。若没有环则返回null。
//两个指针，快指针一次前进两步，慢指针一次前进一步，初始化都再链表头部。然后开始移动，如果他们指向了同一个节点，则证明有环，否则没环。
//当指向了同一个节点时，慢指针再次初始化，指向头结点。快慢指针前进步数都改为1，当他们再次指向同一个节点，这个节点就是环的入口节点。
public class List_P141_EntryNodeOfLoop {
    public static ListNode<Integer> findNode(ListNode<Integer> pHead){

        if(pHead == null || pHead.next == null)
            return null;
        ListNode fast = pHead;//快指针每次走两步
        ListNode slow = pHead;//每次走一步
        while(fast!=null && fast.next !=null)//因为fast每次要走两步，所有需要判断fast的下一个是否为空
        {
            slow = slow.next;
            fast = fast.next.next;
            //判断是否相遇 相遇后让快指针从头开始走，每次都是走一步，第二次相遇的节点就是环的入口
            if(fast.val == slow.val)
            {
                fast = pHead;
                while(fast.val != slow.val)
                {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            if(fast.val == slow.val)
            {
                return slow;
            }
        }
        return null;//要是没有相遇，此链表没有环返回空
    }
    public static void main(String[] args){

        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        ListNode<Integer> node = new ListNode<>(3);
        head.next.next = node;
        node.next = new ListNode<>(4);
        node.next.next = new ListNode<>(5);
        node.next.next.next = new ListNode<>(6);
        node.next.next.next.next = node;
        System.out.print(findNode(head).val);
    }
}
