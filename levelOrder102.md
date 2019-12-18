public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<List<TreeNode>> nodeQueue = new LinkedList<>();
        List<TreeNode> first = new ArrayList<>();

        first.add(root);
        nodeQueue.offer(first);


        while (nodeQueue.size() != 0) {
            List<Integer> valueList = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            List<TreeNode> current = nodeQueue.poll();
            for (TreeNode treeNode : current) {
                valueList.add(treeNode.val);
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }
            if (nextLevel.size() > 0) {
                nodeQueue.offer(nextLevel);
            }

            resultList.add(valueList);
        }

        return resultList;
    }




-------------

  
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        get(nodes);
        return res;
    }

    public void get(List<TreeNode> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }
        List<Integer> currentRes = new ArrayList<>();
        List<TreeNode> nextNode = new ArrayList<>();

        for (TreeNode node : nodes) {
            if (node == null) {
                continue;
            }
            currentRes.add(node.val);
            nextNode.add(node.left);
            nextNode.add(node.right);
        }
        if (currentRes.size() > 0) {
            res.add(currentRes);
        }
        get(nextNode);
    }
