package Lab1;
import java.io.*;
import java.util.*;
/**
* Клас Lab1KliucharKI305 реалізує приклад програми до лабораторної роботи №1
*/
public class Lab1KliucharKI305
{
/**
* Статичний метод main є точкою входу в програму
*
* @param args
* @throws FileNotFoundException
*test
*/
public static void main(String[] args) throws FileNotFoundException

{	
int nRows;
char[][] arr;
String filler;
Scanner in = new Scanner(System.in);
File dataFile = new File("MyFile.txt");
PrintWriter fout = new PrintWriter(dataFile);
System.out.print("Введіть розмір квадратної матриці: ");
nRows = in.nextInt();
int totalCols = nRows/6;
int k = 0;
arr = new char[nRows][nRows];
in.nextLine();
System.out.print("\nВведіть символ-заповнювач: ");
filler = in.nextLine();
exit:
	try {
    for (int i = 0; i < nRows; i++) {
    	 k=k+1;
         if (k>totalCols*2) {
         	k = 1;
         }
        for (int j = 0; j < nRows; j++) {
        	
        	if (filler.length() == 1) {
            if (k<=totalCols) {
	            arr[i][j] = (char) filler.codePointAt(0);
	            System.out.print(" " + " ");
	            fout.print(" " + " ");
            }
            else {
	            arr[i][j] = (char) filler.codePointAt(0);
	            System.out.print(arr[i][j] + " ");
	            fout.print(arr[i][j] + " ");
            }
        	}
            else if (filler.length() == 0)
			{
				System.out.print("\nНе введено символ заповнювач");
				break exit;
			}
			else 
			{
				System.out.print("\nЗабагато символів заповнювачів");
				break exit;
			}
					}
					System.out.print("\n");
					fout.print("\n");
					} 
				}
			finally 
			{
		            in.close();
		    }
			fout.flush();
			fout.close();
			
	}	
}
