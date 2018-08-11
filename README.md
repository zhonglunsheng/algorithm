##### 从链表删除重复数据
```
/**
 * 额外空间，链表遍历把值存放在HashMap里
 */
public void deleteDuplecate(Node head){
    if (head == null) {
        return;
    }
    Map<Object,Object> map = new HashMap<>();
    Node temp = head;
    Node pre = null;
    while(temp != null){
        if (map.containsKey(temp.data)) {
            pre.next = temp.next;
        }else{
            map.put(temp.data, 1);
            pre = temp;
        }
        temp = temp.next;
    }
}

/**
 * 双重循环：外层正常循环遍历链表，内层循环假如从curl节点开始，那么将后面指向的节点值和curl节点值比较是否有相同的，如果有的直接去掉
 */
public void deleteDuplecate02(Node head){
    Node temp = head;
    Node cur = null;
    Node pre = null;
    while(temp != null){
        cur = temp.next;
        while(cur != null){
            if (cur.next == null) {
                break;
            }
            if (temp.data == cur.data) {
                pre.next = temp.next;
            }else{
                pre = temp;
            }
            cur = cur.next;
        }
        temp = temp.next;
    }
}
```

#### 如何找出单链表倒数第K个值
```
/**
 *遍历的到长度，查找length-k+1的结点值
 */
public int findElem(Node head, int k){
		int count = 0;
		Node temp = head;
		if (k < 0) {
			return 0;
		}
		while(temp != null){
			temp = temp.next;
			count++;
		}
		for(int i = 0; i < count-k; i++){
			head = head.next;
		}
		return head.data;
	}

/**
 * 两个指针，一个指针指向头结点，另一个指针往前领先k-1个位置，然后同时往前遍历，当快指针指向尾部的时候，慢指针指* 向的结点的值就是倒数第K个值
 */
public int findElem02(Node head, int k){
		Node temp = head;
		for(int i = 0; i < k; i++){
			temp = temp.next;
		}
		Node fastNode = temp;
		Node lowNode = head;
		
		while(fastNode != null){
			fastNode = fastNode.next;
			lowNode = lowNode.next;
		}
		return lowNode.data;
	}
```
#### 如何实现单链表反转
```
/**
 * 假设i j k 三个结点反转，反转是后面结点的下一个指向前一个结点，显然链表的头结点就是原链表的尾结点即null,那么必须要有一个来保存j结点保证链表不断
 * [图解](https://blog.csdn.net/feliciafay/article/details/6841115)
 */
public Node reverseIteralively(Node head){
    Node pReverseNode = head;
    Node qNode = head.next;
    head.next = null;
    Node rNode = null;
    
    while(qNode != null){
        rNode = qNode.next;			
        qNode.next = pReverseNode;
        pReverseNode = qNode;
        qNode = rNode;			
    }
    head = pReverseNode;
    return head;
}
```
#### 从尾到头输出单链表
```
/**
 * 利用递归
 */
public void printReverseLinkedList(Node head){
    if (head != null) {
        printReverseLinkedList(head.next);
        System.out.println(head.data);
    }
}

/**
 * 跟据栈的特性先进后出
 */
public void printReverseLinkedList(Node head){
    Stack<Integer> stack = new Stack<>();
    while(head != null){
        stack.add(head.data);
        head = head.next;
    }
    while(!stack.isEmpty()){
        System.out.println(stack.peek());
        stack.pop();
    }
}
```
#### 寻找单链表中间结点
```
/**
 *两个指针，两个指针指向头结点，一个指针每次移动一步，另一个指针每次移动两步，当快指针到达尾部时。当链表长度为奇数：慢指针的位置就是中间结点，偶数时慢指针的位置和下一个结点位置是中间结点
 */
public Node searchMin(Node head){
    Node fastNode = head;
    Node lowNode = head;
    int length = 0;
    while(fastNode != null && fastNode.next != null && fastNode.next.next != null){
        fastNode = fastNode.next.next;
        lowNode = lowNode.next;
        length++;
    }
    
    return lowNode;
}
```
#### 检测链表是否有环
```
/**
 *两个指针指向头结点，快指针每次移动两步步，慢指针每次移动一步，当快指针等于慢指针时那么链表有环
 */
public boolean isLoop(Node head){
    if (head == null) {
        return false;
    }
    Node fastNode = head;
    Node lowNode = head;
    while(fastNode != null && fastNode.next != null){
        fastNode = fastNode.next.next;
        lowNode = lowNode.next;
        if (fastNode == lowNode) {
            return true;
        }
    }
    return !(fastNode == null || fastNode.next == null);
}
```
