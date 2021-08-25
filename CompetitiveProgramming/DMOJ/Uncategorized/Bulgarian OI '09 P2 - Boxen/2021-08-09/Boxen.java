import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Boxen
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=0; t<2; t++)
        {
            int n = Integer.parseInt(br.readLine());
            List<Set<Integer>> boxes = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                boxes.add(new HashSet<>());
            }

            boolean[] vis = new boolean[n];

            for(int i=0; i<n; i++)
            {
                int idx = Integer.parseInt(br.readLine()) -1;
                if(boxes.get(idx) != null)
                    boxes.get(idx).add(i);
                else
                {
                    Set<Integer> temp = new HashSet<>();
                    temp.add(i);
                    boxes.set(idx, temp);
                }

                if(boxes.get(i) != null)
                    boxes.get(i).add(idx);
                else
                {
                    Set<Integer> temp = new HashSet<>();
                    temp.add(idx);
                    boxes.set(i, temp);
                }

            }

            int count = 0;
            for(int i =0; i<n; i++)
            {
                if(!vis[i])
                {
                    // DFS.
                    Stack<Integer> stack = new Stack<>();
                    stack.push(i);

                    while(!stack.isEmpty())
                    {
                        int val = stack.pop();
                        for(int box : boxes.get(val))
                        {
                            if(! vis[box])
                            {
                                vis[box] = true;
                                stack.push(box);
                            }
                        }
                    }
                    count++;
                }
            }
            System.out.print(count + " ");
        }

    }
}