import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class PostfixNotation
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input()
    {
        try
        {
            return br.readLine().split(" ");
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return null;
    }

    boolean isNum(String s)
    {
        try
        {
            Double.parseDouble(s);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    void run()
    {
        String[] data = input();
        Stack<Double> s = new Stack<>();
        for(String d : data)
        {
            if(isNum(d))
            {
                s.push(Double.parseDouble(d));
            }
            else
            {
                double b = s.pop();
                double a = s.pop();
                switch(d.charAt(0))
                {
                    case '+': s.push(a+b); break;
                    case '-': s.push(a-b); break;
                    case '*': s.push(a*b); break;
                    case '/': s.push(a/b); break;
                    case '%': s.push(a%b); break;
                    case '^': s.push(Math.pow(a, b)); break;
                }
            }
        }
        System.out.println(s.pop());
    }

    public static void main(String[] args)
    {
        PostfixNotation pn = new PostfixNotation();
        pn.run();
    }
}