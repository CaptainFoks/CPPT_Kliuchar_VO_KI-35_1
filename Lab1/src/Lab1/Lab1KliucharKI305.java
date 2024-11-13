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
String filler = null;
Scanner in = new Scanner(System.in);
File dataFile = new File("MyFile.txt");
PrintWriter fout = new PrintWriter(dataFile);
System.out.print("Введіть розмір квадратної матриці: ");
nRows = (int)in.nextInt();
int crock=nRows/6;
arr = new char[nRows/2][nRows];
in.nextLine();
boolean inputFlag = false;
while (!inputFlag)
{
  System.out.print("\nВведіть символ-заповнювач: ");
  filler = in.nextLine();
  if (filler.length() != 1)
  {
    inputFlag=false;
    System.out.print("\nНе введено символ заповнювач");
  }
  
  else 
  {
    inputFlag=true;
  }
}    
    for (int i = 0; i < nRows/2; i++) {
         if (i%crock==0) {
        	 for (int ii = 0; ii < crock; ii++) {
        	 for (int jj = 0; jj< nRows; jj++) {
 	            System.out.print(" ");
 	            fout.print(" ");
        	 }
				System.out.print("\n");
				fout.print("\n");
        	 }
         }
        for (int j = 0; j < nRows; j++) {

        	if (filler.length() == 1) {
	            arr[i][j] = (char) filler.codePointAt(0);
	            System.out.print(arr[i][j] + " ");
	            fout.print(arr[i][j] + " ");
	          
        	}
					}
					System.out.print("\n");
					fout.print("\n");
					} 
			fout.flush();
			fout.close();
			
	}	
}
