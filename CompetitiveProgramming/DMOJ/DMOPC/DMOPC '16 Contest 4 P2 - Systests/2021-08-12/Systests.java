import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Data
{
    int a, b, p;
    public Data(int a, int b, int p)
    {
        this.a = a;
        this.b = b;
        this.p = p;
    }
}

public class Systests
{
    static int upperBound(int[] arr, int val)
    {
        int lo = 0;
        int hi = arr.length-1;
        int index = arr.length;

        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            if(arr[mid] > val)
            {
                hi = mid - 1;
                index = mid;
            }
            else
                lo = mid + 1;
        }
        return index;
    }

    static int lowerBound(int[] arr, int val)
    {
        int lo = 0;
        int hi = arr.length-1;
        int index = 0;

        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            if(arr[mid] < val)
            {
                lo = mid + 1;
                index = mid+1;
            }
            else
                hi = mid - 1;
        }
        return index;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nBatches = Integer.parseInt(br.readLine());
        Data[] batches = new Data[nBatches];
        for(int i=0; i<nBatches; i++)
        {
            String[] line = br.readLine().split(" ");
            batches[i] = new Data(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }

        int nFail = Integer.parseInt(br.readLine());
        int[] fail = new int[nFail];
        for(int i=0; i<nFail; i++)
            fail[i] = Integer.parseInt(br.readLine());
        Arrays.sort(fail);

        int totalPoints = 0;
        for(Data batch : batches)
        {
            /*
            int lower = lowerBound(fail, batch.a);
            int upper = upperBound(fail, batch.b);
            if(lower == upper)
                totalPoints += batch.p;
            */

            /*
            int lower = Arrays.binarySearch(fail, batch.a);
            if(lower < 0)
                lower = -(lower+1);
            if(lower >= fail.length || fail[lower] > batch.b)
                totalPoints += batch.p;
            */

            int lower = lowerBound(fail, batch.a);
            if(lower >= fail.length || fail[lower] > batch.b)
                totalPoints += batch.p;
        }
        System.out.println(totalPoints);
    }
}