````java
public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        if (root.left != null) {
            resultList.addAll(inorderTraversal(root.left));
        }
        resultList.add(root.val);
        if (root.right != null) {
            resultList.addAll(inorderTraversal(root.right));
        }
        return resultList;
}
````
----
````java
 public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;
        while (current != null || !nodeStack.empty()) {
            if (current != null) {
                nodeStack.push(current);
                current = current.left;
            } else {
                current = nodeStack.pop();
                resultList.add(current.val);
                current = current.right;
            }
        }

        return resultList;
    }
````
------Morris

````java
    public List<Integer> travel(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                resultList.add(current.val);
                current = current.right;
            } else {
                TreeNode pre = getPre(current);
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else if (pre.right == current) {
                    pre.right =null;
                    resultList.add(current.val);
                    current = current.right;
                }
            }
        }
        return resultList;
    }

    public TreeNode getPre(TreeNode node) {
        TreeNode pre = node;
        if (node.left != null) {
            pre = node.left;
            while (pre.right != null && pre.right != node) {
                pre = pre.right;
            }

        }
        return pre;
    }

````
