package BaseDataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Window
{
    private Queue<Integer> window;
    private LinkedList<Integer> maxs;
    private int size;

    public Window(int size)
    {
        window = new LinkedList<Integer>();
        maxs = new LinkedList<Integer>();
        this.size = size;
    }

    public void Add(int value)
    {
        AddInWindow(value);
        AddInMaxs(value);
    }

    public int GetMax()
    {
        return maxs.getFirst();
    }

    private void AddInWindow(int value)
    {
        window.add(value);
        if(window.size() > size)
        {
            if(window.peek().equals(maxs.getFirst()))
            {
                maxs.removeFirst();
            }
            window.remove();
        }
    }

    private void AddInMaxs(int value)
    {
        while(!maxs.isEmpty() && maxs.getLast() < value)
        {
            maxs.removeLast();
        }

        maxs.addLast(value);
    }
}

public class MaxSlidingWindow
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        var result = new ArrayList<Integer>();

        var window = new Window(k);
        for (int i = 0; i < k; i++)
        {
            window.Add(nums[i]);
        }

        for (int i = k; i < nums.length; i++)
        {
            result.add(window.GetMax());
            window.Add(nums[i]);
        }

        result.add(window.GetMax());

        return result.stream().mapToInt(x -> x).toArray();
    }
}
