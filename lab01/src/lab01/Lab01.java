/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab01;

import org.apache.logging.log4j.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Pattern;
/**
 *
 * @author Admin
 */
public class Lab01 
{
    public static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    private static final Logger loggerDemo = LogManager.getLogger(Lab01.class.getName());
    public static void main(String[] args) 
    {
        // TODO code application logic here
//        System.out.println("Hello world");
//        loggerDemo.info("Bai tap 1");
//        loggerDemo.error("lick1");
//        loggerDemo.debug("lick2");
//        loggerDemo.fatal("lick3");
//        loggerDemo.warn("lick4");
        
        Lab01.Bai01();
        Lab01.Bai02();
//        Lab01.Bai03();
//        Lab01.Bai04();
//       Lab01.Bai05();
//        Lab01.Bai06();
//       Lab01.Bai07();
//        Lab01.Bai08();
//        Lab01.Bai09();
//        Lab01.Bai10(args);
//       Lab01.Bai11(args);
//        Lab01.Bai12(args);
//        Lab01.Bai13();
//        Lab01.Bai14();
//        Lab01.Bai15();
          loggerDemo.info("Bai tap 15");
    }
    
    //Bài 01
    public static void Bai01()
    {
        for(int i = 10; i<=200; i++)
        {
            //các số chia hết cho 7 nhưng không là bội của 5
            if(i%7==0 & i%5 !=0)
            {
                System.out.print( i + ",");
            }
        }
        System.out.print("\n");
    }
    
    //Bài 2
    public static void Bai02()
    {
        int giaithua = 1;
        var a = "";
        System.out.print("Nhap n de tinh giai thua cua no: ");
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++)
        {
            giaithua = giaithua *i;
            a += i;
            
            //dòng dòng if để cho ra số cuối cùng không còn dấu *
            if(i+1<=n)
            {
                a += "*";
            }            
        }
        System.out.println(a+ " = "+ giaithua);
    }
    
    //Bài 03
    public static void Bai03()
    {
        var a ="";
        System.out.print("Nhap n de tim map:");
        int n = scanner.nextInt();
        for(int i = 1; i<=n; i++)
        {
            
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(i, i*i);  
            Set<Integer> set  =  map.keySet();
            for(Integer key : set)  
            {
                a +=key + ":"+ map.get(key);
                if(i + 1 <= n)
                {
                    a+=",";
                }              
            }            
        }
        System.out.println("{" + a + "}");
    }
    
    //Bài 04.
    public static final char CHAR_55 = 55;
    
    public static void Bai04()
    {
        System.out.print("Nhap mot so tu nhien o he so 10 can chuyen: ");
        int n = scanner.nextInt();
        System.out.println("So "+ n + " trong he co so 16 la: " + Lab01.convertnumber(n, 16));
        System.out.println("So " + n + " trong he co so 2 la: " + Lab01.convertnumber(n, 2));
        System.out.println("So " + n + " trong he co so 8 la: " + Lab01.convertnumber(n, 8));
    }
    public static String convertnumber(int n, int b)
    {
        if(n<0 || b<2 || b>16)
        { 
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int m;
        int remainder = n;
        while (remainder >0)
        {
            if(b>10)
            {
                m = remainder % b;
                if(m>=10)
                {
                    sb.append((char) (CHAR_55 + m));
                }else
                    sb.append(m);                  
            }else
                sb.append(remainder % b);
            remainder = remainder / b;
        }
        return sb.reverse().toString();
    }
    
    //Bai 05
    public static void Bai05()
    {
        System.out.print("Nhap mot so de tim Fibonacci: ");
        int n = scanner.nextInt();
        for(int i = 0; i<=n; i++)
        { 
            System.out.print(fibonacci(i)+" ");
        }
        
        System.out.print("\n");
    }
    
    public static int fibonacci(int n)
    {
        int f0= 0;
        int f1 = 1;
        int fn = 1;    
        if(n<0)
        {
            return -1;
        }else if(n == 0 || n==1)
        {
            return n;   
        }else
            for(int i = 2; i<n; i++)
            {
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }       
        return fn;       
    }   
    
   //Bài 06
    public static void Bai06()
    {
        System.out.print("Nhap so nguyen duong a: ");
        int a = scanner.nextInt();
        System.out.print("Nhap so nguyen duong b: ");
        int b = scanner.nextInt();
        System.out.println("Uoc chung lon nhat cua "+ a + "va "+ b +"la: "+ UCLN(a, b));
        System.out.println("Boi chung nho nhat cua "+ a + "va "+ b +"la: "+ BCNN(a, b));
    }
    
    public static int UCLN(int a, int b)
    {
        if(b==0)
            return a;
        return UCLN(b, a%b);
    }
    public static int BCNN(int a, int b)
    {
        return (a*b)/UCLN(a,b);
    }
    
    //Bài 07
    public static void Bai07()
    {
        System.out.print("Nhap so nguyen duong n: ");
        int n = scanner.nextInt();
        System.out.print("Tat ca cac so nguyen to nho hon "+ n +" la: ");
        if(n>=2)
            System.out.print(2);
        for(int i=3; i<n; i+=2)
        {
            if(CheckSNT(i))
            {
                System.out.print(" "+ i );
            }
        }
        System.out.print("\n");
    }
    public static boolean CheckSNT(int n)
    {
        if(n<2)
            return false;
        int root = (int) Math.sqrt(n);
        for(int i= 2; i<=root; i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }   
    
    //Bài 08
    public static void Bai08()
    {
        System.out.print("Tat ca cac so nguyen to co 5 chu so la: ");
        for(int i=10001; i<=99999; i+=2)
        {
            if(CheckSNT(i))
            {
                System.out.println( i );
            }
        }
    }
    
    
    //Bài 09
    public static void Bai09()
    {
        System.out.print("Nhap so nguyen n: ");
        int n = scanner.nextInt();
        List<Integer> listNumbers  = phantich(n);
        System.out.printf("Ket qua: "+ n + "= ");
        int size = listNumbers.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(listNumbers.get(i) + "x");
        }
        System.out.println(listNumbers.get(size - 1));
    }
    
    public static List<Integer> phantich(int n)
    {
        int i = 2;
        List<Integer> listNumbers = new ArrayList<Integer>();
        while (n > 1)
        {
            if(n%i==0)
            {
                n = n / i;
                listNumbers.add(i);
            }else
                i++;
        }
        if(listNumbers.isEmpty())
            listNumbers.add(n);
        return listNumbers;
    }
    
    //Bài 10
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
    public static void Bai10(String[] args)
    {
        String str = "hoc java     co ban den nang cao";
                
        System.out.println("So tu cua chuoi da cho la: "
                + countWords(str));
    }
    public static int countWords(String input)
    {
        if (input == null) {
            return -1;
        }
        int count = 0;
        int size = input.length();
        boolean notCounted = true;
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB 
                    && input.charAt(i) != BREAK_LINE) {
                if(notCounted) {
                    count++;
                    notCounted = false;
                }
            } else {
                notCounted = true;
            }
        }
        return count;
    }
    
    //Bài 11
    public static void Bai11(String[] args)
    {
        String str = "hoc java     co ban den nang cao"
                + "      \n hoc c++ co ban den nang cao.";
        System.out.println("---------------------------------");
        System.out.println(str);
        System.out.println("---------------------------------");
        //Liệt kê sô lần xuất hiện các từ trong chuỗi trên
        System.out.println("So lan xuat hien cua cac tu: ");
        Map<String, Integer> wordMap = count(str);
        for (String key : wordMap.keySet()) 
        {
            System.out.print(key + " " + wordMap.get(key) + "\n");
        }
    }
    public static Map<String, Integer> count(String input) 
    {
        //Tạo wordMap
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (input == null) 
        {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) 
        {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB 
                    && input.charAt(i) != BREAK_LINE) 
            {
                sb.append(input.charAt(i));
            } else 
            {
                //Thêm từ vào wordMap
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        // thêm từ cuối cùng tìm được vào wordMap
        addWord(wordMap, sb);
        return wordMap;
    }
    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) 
    {
        String word = sb.toString();
        if (word.length() == 0) 
        {
            return;
        }
        if (wordMap.containsKey(word)) 
        {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else 
        {
            wordMap.put(word, 1);
        }
    }
    
    //Bài 12
    public static void Bai12(String[] args)
    {
        String s1 = "hoc java co ban den nang cao";
        String s2 = "java co ban";
        System.out.println(s1.contains(s2));
    }
    
    //Bai 13
    public static void Bai13()
    {
        System.out.print("Nhap so phan tu cua mang: ");
        int n = scanner.nextInt();
        
        //Tạo mảng
        int [] A = new int[n];
        System.out.println("Nhap phan tu cua mang:");
        for(int i =0; i<n; i++)
        {
            System.out.print("A["+i+"] = ");
            A[i]= scanner.nextInt();
        }
        //Phần tử lớn nhất trong mảng
        System.out.print("phan tu lon nhat trong mang la: " );
        Max1(A);
        //Phần tử lớn thứ hai trong mảng
        System.out.print("phan tu lon thu hai trong mang la: " );
        Max2(A);
        
        // Sắp xếp tăng dần
        sort(A);
        System.out.print("Day so duoc sap xep tang dan la: ");
        for(int i = 0; i< A.length; i++)
        {
            System.out.print(A[i]+ " ");
        }
        
        //chèn x vào mảng vẫn đảm bảo tính tăng dần của mảng
        System.out.print("\nNhap phan tu can chen vao mang: ");
        int k = scanner.nextInt();
        A = insert(A, k);
        System.out.print("Mang sau khi chen la: ");
        for(int i= 0; i<A.length; i++)
        {
            System.out.print(A[i]+" ");
        }
        System.out.print("\n");
    }
    
    //a)Tìm phần tử lớn thứ nhất trong mảng
    public static void Max1(int[] A)
    {     
        int stt = 0;
        int maxfirst = A[0];
        for(int i = 1; i<A.length; i++)
        {
            if(maxfirst < A[i])
            {
                maxfirst= A[i];  
                stt = i;
            }            
        } 
        System.out.println("A["+stt+"] "+ "= "+maxfirst);
    }
    
    //a)Tìm phần tử lớn thứ hai trong mảng
     public static void Max2(int[] A)
    {
        int stt = 0;
        int maxfirst = A[0];
        int maxsecond = A[0];
        for(int i = 1; i<A.length; i++)
        {
            if(maxfirst < A[i])
            {
                maxfirst= A[i];
            }
        }
        for(int i = 0; i<A.length;i++)
        {
            if(A[i] != maxfirst)
            {
                if(maxsecond < A[i])
            {
                maxsecond= A[i];
                stt = i;
            }
            }
        }
        
        System.out.println( "A["+stt+"] "+ "= "+maxsecond);
    }
    
    //b)Sắp xếp mảng theo thứ tự tăng dần
    public static void sort(int[] A)
    {
        int temp = A[0];
        for(int i = 0; i<A.length; i++)
        {
            for(int j = i+1; j<A.length; j++)
            {
                if(A[i]>A[j])
                {
                    temp=A[j];
                    A[j]=A[i];
                    A[i]=temp;
                }
            }
        }
    }
    
    //c)Nhập số nguyên x và chèn x vào mảng A sao cho vẫn đảm bảo tính tăng dần cho mảng A
    public static int [] insert(int [] A, int k) {
        int arrIndex = A.length - 1;
        int tempIndex = A.length;
        int [] tempArr = new int [tempIndex + 1];
        boolean inserted = false;
         
        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1 && A[arrIndex] > k) {
                tempArr[i] = A[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = k;
                    inserted = true;
                } else {
                    tempArr[i] = A[arrIndex--];
                }
            }
        }
        return tempArr;
    }
        
    //Bài 14
    public static void Bai14()
    {
        System.out.print("Nhap so dong n cua ma tran: ");
        int n = scanner.nextInt();
        System.out.print("Nhap so cot m cua ma tran: ");
        int m =scanner.nextInt();
        
        int [][] A = new int[n][m];
        System.out.println("Nhap phan tu cua ma tran: ");
        for(int i= 0; i< n; i++)
        {
            for(int j = 0; j<m;j++)
            {
                System.out.print("A["+i+"]"+"["+j+"] = ");
                A[i][j] = scanner.nextInt();
            }
        }
        //In ma trận
        System.out.print("Ma tra da nhap vao la: ");
        INMT(A, n, m);
        
        //a)Phần tử lớn nhất trong ma trận
        System.out.print("\nPhan tu lon nhat trong ma tran la: ");
        for(int i = 0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
               if(A[i][j]==MaxMT(A, n, m))
               {
                   System.out.print("A["+i+"]"+"["+j+"] = "+A[i][j]);
               }
            }
        }
        
        //b)TÌm và in số nguyên tố trong ma trận
        INSNT(A, n, m);
        //c)Sắp xếp các cột của ma trận theo thứ tự tăng dần
        System.out.print("\nSap xep cac cot theo thu tu tang dan: ");
        sortColum(A, n, m);
        
        //d)Cột có số nguyên tố nhiều nhất
        Search(A, n, m);
    }
    
    //In ma trận vừa nhập
    public static void INMT(int [][] A, int n, int m)
    {
        
        for(int i = 0; i<n; i++)
        {
            System.out.print("\n");
            for(int j= 0; j<m; j++)
            {
                System.out.print(A[i][j]+" ");
            }
        }      
    }
    
    //Tìm phần tử lớn nhất của ma trận
    public static int MaxMT(int [][]A, int n, int m)
    {       
        int max = A[0][0];
        for(int i = 0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                if(max<A[i][j])
                {
                    max = A[i][j];
                }                              
            }            
        }        
        return (max);
    }
    
    //Check SNT
    public static boolean checkSNT(int n){
        if(n>1){
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0) 
                    return false;
        }
        return true;
	}
            else return false;
    }
    
    //In phần tử là số nguyên tố của ma trận 
    public static void INSNT(int[][] A, int n, int m)
    {
        System.out.print("\nCac phan tu la SNT (nhung phan tu ko la SNT =0): ");
        for(int i=0 ; i<n ; i++)
        {
            System.out.print("\n");
            for(int j=0 ; j<m ; j++)
            {
                if(checkSNT(A[i][j]))
                {
                    System.out.print(A[i][j]+" ");
                }
                else System.out.print(0+ " ");
            }
        }
    }
    
    //Sắp xếp tất cả các cột của ma trận theo giá trị tăng dần 
    public static void sortColum(int[][] A, int n, int m){
        int temp;
        for(int j=0 ; j<m ; j++)
        {
            for(int i=1 ; i<n ; i++)
            {
                if(A[i-1][j]>A[i][j])
                {
                    temp= A[i-1][j];
                    A[i-1][j]= A[i][j];
                    A[i][j]= temp;
                }
            }
        }
        INMT(A, n, m);
    }
    
    //Tìm cột có số nguyên tố nhiều nhất trong ma trận
    public static void Search(int[][]A, int n, int m)
    {
        int cot = 0;
        int dem;
        int count = 0;
        for(int i=0 ; i<n ; i++)
        {
            dem = 0;
            for(int j=0 ; j<m ; j++)
            {
                if(checkSNT(A[i][j]))
                {
                    dem++;
                }               
            }
            if(count < dem)
            {
                count = dem;
                cot = i+2;
            }
        }
        System.out.print("\nSo cot co SNT nhieu nhat la: "+ cot);
        
    }
    
    //Bài 15
    public static void Bai15()
    {
        String[] text = new String[5];
        Pattern p = Pattern.compile("^00[2-5]{1}L[0-9]{4}$");
        
        for(int i=0;i<5;i++){
            System.out.print("Nhap ma so thu " + i + " : ");
            text[i] = scanner.nextLine();
        }
        
        int dem = 0;
        for(int i=0;i<5;i++){
            if(p.matcher(text[i]).find()==false){
                System.out.println("Sai roi");
                dem++;
                break;
            }
        }
        
        if(dem==0){
            System.out.println("Dung roi ");
        }
        
    }
}
