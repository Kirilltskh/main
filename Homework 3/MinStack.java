package BaseDataStructures;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minsStack;

    public MinStack()
    {
        stack = new Stack<Integer>();
        minsStack = new Stack<Integer>();
    }

    public void push(int val)
    {
        stack.push(val);

        if(minsStack.empty() || minsStack.peek() >= val)
        {
            minsStack.push(val);
        }
    }

    public void pop()
    {
        if(stack.peek().equals(minsStack.peek()))
        {
            minsStack.pop();
        }

        stack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return minsStack.peek();
    }
}
