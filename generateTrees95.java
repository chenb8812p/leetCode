

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }


    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> resList = new ArrayList<>();
        if (end < start) {
            resList.add(null);
            return resList;
        }

        for (int current = start; current <= end; current++) {
            List<TreeNode> leftList = generate(start, current-1);
            List<TreeNode> rightList = generate(current + 1, end);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode currentNode = new TreeNode(current);
                    currentNode.left = left;
                    currentNode.right = right;
                    resList.add(currentNode);
                }
            }
        }
        return resList;
    }
