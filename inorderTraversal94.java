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
