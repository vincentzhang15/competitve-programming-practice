import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Arrays;

public class SpreadsheetSortingOOP
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        // Store spreadsheet.
        int r = Integer.parseInt(br.readLine().split(" ")[0]);
        Col[] sheet = new Col[r]; for(int i=0; i<r; i++) sheet[i] = new Col(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        // Sort sheets.
        for(int i=0, n=Integer.parseInt(br.readLine()); i<n; i++) {
            Col.i = Integer.parseInt(br.readLine())-1;
            Arrays.sort(sheet);
        }
        br.close();
        
        for(int j=0; j<sheet.length; j++) sheet[j].print();
    }

    static class Col implements Comparable<Col>
    {
        public static int i;
        public int[] c;
        public Col(int[] c) {this.c = c;}
        @Override public int compareTo(Col a) {return Integer.compare(c[i], a.c[Col.i]);}

        public void print() {
            for(int i=0; i<c.length-1; i++) System.out.print(c[i] + " ");
            System.out.println(c[c.length-1]);
        }
    }
}