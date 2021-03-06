import List.ListNode;

import java.util.ArrayList;
//圆圈中最后剩下的数字
//题目要求：
//0，1，2...n-1这n个数字拍成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字，求剩下的最后一个数字。
public class P300_LastNumInCircle_review {
    //1
    public static int LastRemaining(int n, int m) {
        if(n < 0 || m < 1){
            return -1;
        }
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> cur = head;
        for(int i = 1; i < n; i++){
            ListNode<Integer> node = new ListNode<>(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;//构成环
        cur = head;
        while(cur.next!=cur){
            for(int i = 1; i < m - 1; i++){
                cur= cur.next;
            }
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return cur.val;
    }
    //2
    public static int LastRemaining2(int n, int m) {
        if(n < 0 || m < 1){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        int cur = -1;
        while(list.size()!=1){
            for(int i = 0; i < m; i++){
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;
        }
        return list.get(0);
    }
    public static void main(String[] args){
        System.out.println(LastRemaining(5,3)); //3
        System.out.println(LastRemaining2(5,3)); //3
//        System.out.println(LastRemaining(0,7)); //-1
    }
}
