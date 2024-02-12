import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testcase = Integer.parseInt(br.readLine());
        int total = (1 << 10) -1;  // 모든 숫자가 등장했을 때의 값
        
        for(int i = 1; i <= testcase ; i ++){
            int N = Integer.parseInt(br.readLine());
            
            int visited = 0;
            int count = 0;
            for (count=1;; count++) {
                char[] arr = String.valueOf(N * count).toCharArray();  // N*count 값을 문자열로 표현한 것  (예: 5 * 13 = 65 -> "65")
                for( char c :arr){
                    int num = c - '0';
                    visited = visited | (1 << num);  // 각 숫자에 대해 등장했다는 의미로 bit 를 1로 변경
                }
                if (visited == total) break;  // 모든 숫자가 등장했다면, 종료
            }
            
            System.out.println("#" + i + " " + N*count);
        }
    }
}