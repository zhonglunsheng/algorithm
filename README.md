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

