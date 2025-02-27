package BaseDataStructures;

import java.util.Stack;

class MyQueue
{
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue()
    {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void push(int x)
    {
        in.push(x);
    }

    public int pop()
    {
        if(out.empty())
        {
            while(!in.empty())
            {
                var moveElement = in.pop();
                out.add(moveElement);
            }
        }

        return out.pop();
    }

    public int peek()
    {
        if(out.empty())
        {
            while(!in.empty())
            {
                var moveElement = in.pop();
                out.add(moveElement);
            }
        }

        return out.peek();
    }

    public boolean empty()
    {
        return in.empty() && out.empty();
    }
}
