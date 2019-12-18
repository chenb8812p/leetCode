class MinStack {


    private Integer size;
    private Integer minSize;
    private List<Integer> dataList;
    private List<Integer> minList;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        size = 0;
        minSize = 0;
        dataList = new ArrayList<>();
        minList = new ArrayList<>();
    }

    public void push(int x) {
        dataList.add(x);
        size++;
        if (minSize == 0) {
            minList.add(x);
            minSize++;
        } else if (minList.get(minSize - 1) >= x) {
            minList.add(x);
            minSize++;
        }
    }

    public void pop() {
        if (size == 0) {
            return;
        }

        if (minSize >= 1 && dataList.get(size - 1).equals(minList.get(minSize - 1))) {
            minList.remove(minSize - 1);
            minSize--;
        }
        dataList.remove(size - 1);
        size--;
    }

    public int top() {
        if (size == 0) {
            return 0;
        }
        return dataList.get(size - 1);
    }

    public int getMin() {
        if (size == 0 || minSize == 0) {
            return 0;
        }

        return minList.get(minSize - 1);
    }
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        System.out.println(stack.top());
        System.out.println(stack.getMin());


    }
}
