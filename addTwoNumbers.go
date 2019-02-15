
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	up := 0
	var head *ListNode = &ListNode{Val:0}
	var result = head
	for l1 != nil || l2 != nil{
		var a = 0
		var b = 0
		if l1 != nil {
			a = l1.Val
		}
		if l2 != nil {
			b = l2.Val
		}
		sum := a + b + up
		up = sum / 10
		result.Next = &ListNode{Val:sum % 10}
		result = result.Next
		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}

	}
	if up > 0 {
		result.Next = &ListNode{Val:up}
	}


	return head.Next
}

type ListNode struct {
    Val int
    Next *ListNode
}

