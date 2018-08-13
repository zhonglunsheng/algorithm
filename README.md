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
#### 在不知道头指针的情况下删掉结点
```
/**
 *情况一：当删掉的结点为尾结点时，不能删除，因为倒数的二个结点的值无法设置为null除
 *情况二：当删掉的结点不是尾结点时，把结点的值换成下一个结点的值，把下一个结点删
 */
public boolean deleteNode(Node node){
    if (node == null || node.next == null) {
        return false;
    }
    node.data = node.next.data;
    node.next = node.next.next;
    return true;
}
```

#### 判断两个链表是否相交，得出相交的结点
```
/**
 *如果两个链表相交，那么他们的尾结点一定相同
 *如果len1 和len2分别为两个链表的长度，假设len1>len2 那么长度大的从len1-len2的位置开始和长度小的一起遍历，第一个相同的结点即相交的结点
 */
public Node isCross(Node h1, Node h2 ){
    if (h1 == null || h2 == null) {
        return null;
    }
    Node nodeA = h1;
    Node nodeB = h2;
    int lengthA = 1;
    int lengthB = 1;
    while(nodeA.next != null || nodeB.next != null){
        if (nodeA.next != null) {
            nodeA = nodeA.next;
            lengthA++;
        }
        if (nodeB.next != null) {
            nodeB = nodeB.next;
            lengthB++;
        }
    }
    if (nodeA != nodeB) {
        return null;
    }
    
    Node nodeH1 = h1;
    Node nodeH2 = h2;
    if (lengthA > lengthB) {
        int abs = lengthA - lengthB;
        while(abs > 0){
            nodeH1 = nodeH1.next;
            abs --;
        }
    }
    
    if (lengthB > lengthA) {
        int abs = lengthB - lengthA;
        while(abs > 0){
            nodeH2 = nodeH2.next;
            abs --;
        }
    }
    
    while(nodeH1 != nodeH2){
        nodeH1 = nodeH1.next;
        nodeH2 = nodeH2.next;
    }
            
    return nodeH1;
}
```
#### 用O(1)的时间复杂度求栈中最小元素
```
/**
 *空间换时间，创建一个辅助栈，每次入栈时，把栈中的最小元素放入辅助栈中，然后推出时的元素和辅助栈顶的元素相同时，也把辅助栈的元素推出
 */
public Object getMin(MyStack<Integer> stack){
    if (stack == null) {
        return null;
    }
    MyStack<Integer> temp = new MyStack<>();
    while(!stack.isEmpty()){
        Integer num = stack.pop();
        if (temp.isEmpty()) {
            temp.push(num);
        }else{
            int min = temp.peek();
            if (num < min) {
                temp.push(num);
            }
        }
    }
    return temp.peek();
    
}
```
#### 用两个栈来模拟队列
/**
 *一个压人栈A 一个弹出栈B 情况一：如果B不是空，直接把B里面的元素弹出 情况二：如果B是空，把A的全部弹出到B内，然后*由B弹出，也把辅助栈的元素推出
 */
```
public class MyQueue<E> {
	MyStack<E> stackA = new MyStack<>();
	MyStack<E> stackB = new MyStack<>();
	
	public void put (E e){
		stackA.push(e);
	}
	
	public E pop(){
		E e = null;
		if (stackB.isEmpty()) {
			while(!stackA.isEmpty()){
				stackB.push(stackA.pop());
			}
		}
		return stackB.pop();
	}
	
	public boolean isEmpty(){
		return stackA.isEmpty() && stackB.isEmpty();
	}	
}
```
#### 冒泡排序
/**
 *相邻之间进行比较 如果已经排序好了 只需遍历一次即可 
 */
```
public void bubbleSort(int arr[]){
    if (arr == null || arr.length <= 0) {
        return;
    }
    int swapCount;
    for(int i = 0; i < arr.length-1; i++){
        swapCount = 0;
        for(int j = 0; j < arr.length-i-1; j++){
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapCount ++;
            }		
        }
        if (swapCount == 0) {
            break;
        }
    }
}
```
#### 选择排序
/**
 *每次遍历选出最小的值 交换位置 
 */
```
public void selectSort(int arr[]){
    if (arr == null || arr.length <= 0) {
        return;
    }
    for (int i = 0; i < arr.length; i++){
        int min = arr[i];
        int minIndex = i;
        for (int j = i; j < arr.length; j++){
            if (min < arr[j]){
                min = arr[j];
                minIndex = j;
            }
        }

        if (minIndex != i){
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
```
#### 插入排序
```
/**
 *比较插入合适的位置 
 */
public void insertSort(int arr[]){
    if (arr == null || arr.length <= 0) {
        return;
    }

    for (int i = 0; i < arr.length; i++){
        int temp = arr[i];
        int j = i;
        while(j > 0 && temp < arr[j - 1]){
            arr[j] = arr[j -1];
            j --;
        }
        arr[j] = temp;
    }
```
#### 归并排序
```
/**
 *递归划分半子表 然后合并
 */
public void mergSort(int arr[], int left, int right){
    if (arr == null || arr.length <= 0 || left >= right || right >= arr.length){
        return;
    }

    int mid = (left + right) / 2;
    // 左边递归拆分
    mergSort(arr, left, mid);
    // 右边递归拆分
    mergSort(arr, mid+1, right);
    // 数组合并
    merge(arr, mid , left, right);

}

private void merge(int[] arr, int mid, int left, int right) {
    int[] temp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;
    while(i <= mid && j <= right){
        if (arr[i] < arr[j]){
            temp[k] = arr[i];
            i ++;
        }else {
            temp[k] = arr[j];
            j++;
        }
        k++;
    }
    // 左边有剩余
    while(i <= mid){
        temp[k++] = arr[i++];
    }
    // 右边有剩余
    while(j <= right){
        temp[k++] = arr[j++];
    }
    k = 0;
    // 将排序后的数字赋值到原数组
    while(left <= right){
        arr[left++] = temp[k++];
    }
}
```
#### 快速排序
/**
 *选取基准，小的放左边，大的放右边
 */
```
public void fastSort(int[] arr, int left, int right){
    if (arr == null || left >= right || right >= arr.length){
        return;
    }

    int mid = getMidIndex(arr, left, right);
    // 左边递归
    fastSort(arr, left, mid-1);
    // 右边递归
    fastSort(arr, mid + 1, right);

}

private int getMidIndex(int[] arr, int left, int right) {
    int pointNum = arr[left];
    while(left < right){
        while(left < right && arr[right] >= pointNum){
            right --;
        }
        arr[left] = arr[right];
        while(left < right && arr[left] <= pointNum){
            left ++;
        }
        arr[right] = arr[left];
    }
    arr[left] = pointNum;
    return left;
}
```
#### 希尔排序
```
/**
 *插入排序的优化 数组越有序 插入越快
 */
public void shellSort(int[] arr, int n){
    if (arr == null || n < 1 || arr.length < 0){
        return;
    }

    for (int i = n; i > 0; i--){
        oneShellSort(arr, i);
    }
}

private void oneShellSort(int[] arr, int n) {
    for(int i = 0; i < arr.length; i+=n){
        int temp = arr[i];
        int j = i;
        while(j > 0 && temp < arr[j-n]){
            arr[j] = arr[j-n];
            j -= n;
        }
        arr[j] = temp;
    }
}
```
#### 堆排序
```
/**
 *构造大顶堆 获取最值 交换位置
 *图解https://www.cnblogs.com/MOBIN/p/5374217.html
 */
public void heapSort(int[] arr){
    if (arr == null || arr.length <= 0){
        return;
    }
    // 构建大顶堆 arr.length / 2 为存在叶子的节点个数
    for(int i = arr.length / 2; i >= 0; i--){
        heapAdjust(arr, i, arr.length -1);
    }

    // 每次堆调整 获取的是当前最大值 把堆顶和最后面元素交换 重新调整
    for (int i = 1; i < arr.length; i++){
        int temp = arr[0];
        arr[0] = arr[arr.length -i];
        arr[arr.length - i] = temp;
        heapAdjust(arr, 0 , arr.length-1);
    }
}

private void heapAdjust(int[] arr, int begin, int end) {
    int temp = arr[begin];
    for (int i = begin * 2 + 1; i <= end; i = i * 2 + 1){
        if (i < end && arr[i] < arr[i+1]){
            i ++;
        }

        if (temp > arr[i]){
            break;
        }

        arr[begin] = arr[i];
        begin = i;
    }
    arr[begin] = temp;
}
```


