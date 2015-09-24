/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head)
{
    if (head == NULL || head->next == NULL) return head;
    struct ListNode* prev = head;
    struct ListNode* cur = head->next;
    struct ListNode* post = cur->next;
    while (cur)
    {
        cur->next = prev;
        prev = cur;
        cur = post;
        if (post != NULL) post = cur->next; //队列尾部时post为空，需要特殊判断一下
    }
    head->next = NULL;//原来头指针再改一下即可
    return prev;
};