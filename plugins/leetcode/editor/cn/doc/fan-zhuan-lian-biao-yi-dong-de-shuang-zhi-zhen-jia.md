我清晰记得，以前在数据结构课上，老师和我们说：涉及到链表的操作，一定要在纸上把过程先画出来，再写程序。

现在想想，这句话简直就是真理！



#### 好理解的双指针



- 定义两个指针： *pre* 和 *cur* ；*pre* 在前 *cur* 在后。
- 每次让 *pre* 的 *next* 指向 *cur* ，实现一次局部反转
- 局部反转完成之后， *pre* 和 *cur* 同时往前移动一个位置
- 循环上述过程，直至 *pre* 到达链表尾部



 [](https://pic.leetcode-cn.com/9ce26a709147ad9ce6152d604efc1cc19a33dc5d467ed2aae5bc68463fdd2888.gif)




#### 代码

```cpp
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* cur = NULL, *pre = head;
        while (pre != NULL) {
            ListNode* t = pre->next;
            pre->next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
};
```



#### 简洁的递归



- 使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 *ret* .
- 此后，每次函数在返回的过程中，让当前结点的下一个结点的 *next* 指针指向当前节点。
- 同时让当前结点的 *next* 指针指向 *NULL* ，从而实现从链表尾部开始的局部反转
- 当递归函数全部出栈后，链表反转完成。




 [](https://pic.leetcode-cn.com/8951bc3b8b7eb4da2a46063c1bb96932e7a69910c0a93d973bd8aa5517e59fc8.gif)




#### 代码

```cpp
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* ret = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return ret;
    }
};
```





#### 妖魔化的双指针


- 原链表的头结点就是反转之后链表的尾结点，使用 *head* 标记 .
- 定义指针 *cur*，初始化为 *head* .
- 每次都让 *head* 下一个结点的 *next* 指向 *cur*  ，实现一次局部反转
- 局部反转完成之后，*cur* 和 *head* 的 *next* 指针同时 往前移动一个位置
- 循环上述过程，直至 *cur* 到达链表的最后一个结点 .


 [](https://pic.leetcode-cn.com/1c8927d9ff605502793d81ab344dbc17e16d6db2d8dd789045f56af432079519.gif)



#### 代码

```cpp
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL) { return NULL; }
        ListNode* cur = head;
        while (head->next != NULL) {
            ListNode* t = head->next->next;
            head->next->next = cur;
            cur = head->next;
            head->next = t;
        }
        return cur;
    }
};
```



#### 最后

希望以上讲解能帮助您理解链表的反转过程。但无论是文字描述，还是动图演示，都比不了自己在纸上对着代码画一遍来得深刻。

至此，您已经掌握了链表反转的三种实现方式，如果这篇文章对您有所帮助，欢迎关注我的公众号“小小算法”，感谢大家的支持！

![小小算法.png](https://pic.leetcode-cn.com/ecef5d3425d27258a1eb6a6229ac205033df84302ad4124308328351bdf56e86-%E5%AE%A3%E4%BC%A0%E5%9B%BE2.png)
