package com.example.springboot_activiti.project.test.domain;

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
}

class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 9;
        ListNode node = new ListNode(9);
        ListNode node3 = new ListNode(9);
        l1.next = node;
        l1.next.next = node3;
        ListNode l2 = new ListNode();
        ListNode node26 = new ListNode(9);
//        ListNode node24 = new ListNode(4);
        l2.val = 9;
        l2.next = node26;
//        l2.next.next = node24;
        addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode next = null;
        ListNode preNext = null;
        int nextVal = 0;
        int carry = 0;
        int l2Val=0;
        int l1Val=0;
        System.out.println(l1);
        while (l1 != null || l2 != null || carry !=0) {
            if(l1==null){
                l1Val=0;
            }else{
                l1Val=l1.val;
                l1 = l1.next;
            }

            if(l2==null){
                l2Val=0;
            }else{
                l2Val=l2.val;
                l2 = l2.next;
            }

            nextVal = l1Val+l2Val + carry;
            if (nextVal > 9) {
                carry = nextVal/10;
                nextVal = nextVal%10;

            }else{
                carry=0;
            }
//            l1 = l1.next;
//            l2 = l2.next;

            if (next == null) {
                next = new ListNode(nextVal);
                preNext = next;
            } else {
                ListNode next1 = new ListNode();
                preNext.next=next1;
                preNext=preNext.next;
                preNext.val=nextVal;
            }
        }

        return next;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode present1 = null;
        ListNode present2 = null;
        ListNode result = null;
        ListNode pResult = null;
        int add = 0;
        present1 = l1;
        present2 = l2;
        int addResult;
        int p1Val = 0;
        int p2Val = 0;
        //不存在进位 并且当前两链表节点都已到末尾 则结束循环
        while (present1 != null || present2 != null || add == 1) {
            //若为空则当前节点值为0
            if (present1 == null) {
                p1Val = 0;
            } else {
                p1Val = present1.val;
            }
            if (present2 == null) {
                p2Val = 0;
            } else {
                p2Val = present2.val;
            }

            addResult = p1Val + p2Val;
            //是否有前一位的进位
            if (add == 1) {
                addResult = addResult + 1;
                add = 0;
            }
            //当前位数是否需要进位
            if (addResult >= 10) {
                addResult = addResult % 10;
                add = 1;
            }
            //判断链表是否已到末尾 到末尾则设为空 否则就指针后移
            if (present1 != null) {
                present1 = present1.next;
            } else {
                present1 = null;
            }

            if (present2 != null) {
                present2 = present2.next;
            } else {
                present2 = null;
            }
            //结果链表初始化
            if (result == null) {
                result = new ListNode(addResult);
                pResult = result;
            } else {
                //新节点的构造
                ListNode newNode = new ListNode();
                pResult.next = newNode;
                pResult = pResult.next;
                pResult.val = addResult;
            }


        }
        System.out.println(result);
        return result;
    }


}