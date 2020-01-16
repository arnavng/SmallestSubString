import java.io.*;
import java.util.*;
public class SmallestSubString 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();
        int out_ = SmallestSubString(S);
        wr.println(out_);
        wr.close();
        br.close();
    }
    final static int NO_OF_CHARS = 256;
    static int max_distinct_char(String str, int n) 
    {
        int count[] = new int[NO_OF_CHARS];
        for (int i = 0; i < n; i++) 
        {
            count[str.charAt(i)]++;
        }
        int max_distinct = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) 
        {
            if (count[i] != 0) 
            {
                max_distinct++;
            }
        }
        return max_distinct;
    }
    static int SmallestSubString(String str) 
    {
        int n = str.length();
        int MAX_CHARS=256;
        int dist_count = 0;
        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);
        for (int i=0; i<n; i++)
        {
            if (visited[str.charAt(i)] == false)
            {
                visited[str.charAt(i)] = true;
                dist_count++;
            }
        }
        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;
        int count = 0;
        int[] curr_count =  new int[MAX_CHARS];
        for (int j=0; j<n; j++)
        {
            curr_count[str.charAt(j)]++;
            if (curr_count[str.charAt(j)] == 1 )
                count++;
            if (count == dist_count)
            {
                while (curr_count[str.charAt(start)] > 1)
                {
                    if (curr_count[str.charAt(start)] > 1)
                        curr_count[str.charAt(start)]--;
                    start++;
                }
                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
        return str.substring(start_index, start_index+min_len).length();
    }
}