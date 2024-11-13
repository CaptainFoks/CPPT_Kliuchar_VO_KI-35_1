package KI35.Kliuchar.lab4;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

/**
 * Class EquationsApp Implements driver for Equations class
 * @author Vlad Kliuchar
 * @version 1.0
 */
public class EquationsApp {
	/**
	 * Class Equations implements method for y=cos(x)/tg(2x) expression
	 * calculation
	 * @author Vlad Kliuchar
	 * @version 1.0
	 */
	public static void main(String[] args) 
	{
	try
	{
	out.print("Enter file name: ");
	Scanner in = new Scanner(System.in);
	String fName = in.nextLine();
	PrintWriter fout = new PrintWriter(new File(fName));
	try
	{
	try
	{
	Equations eq = new Equations();
	out.print("Enter X: ");
	fout.print(eq.calculate(in.nextInt()));
	}
	finally
	{
	// Цей блок виконається за будь-яких обставин
	fout.flush();
	fout.close();
	}
	}
	catch (CalcException ex)
	{
	// Блок перехоплює помилки обчислень виразу
	out.print(ex.getMessage());
	}
	}
	catch (FileNotFoundException ex)
	{
	out.print("Exception reason: Perhaps wrong file path");
	}
	}
}

/**
 * Class CalcException more precises ArithmeticException
 * @author EOM Stuff
 * @version 1.0
 */
class CalcException extends ArithmeticException {
	public CalcException(){}
	public CalcException(String cause)
	{
	super(cause);
	}
}

/**
 * Class Equations implements method for y=cos(x)/tg(2x) expression
 * calculation
 * @author Vlad Kliuchar
 * @version 1.0
 */

class Equations {
    /**
     * Method calculates the y=cos(x)/tg(2x) expression
     * @param x Angle in degrees
     * @throws CalcException
     */
    public double calculate(double x) throws CalcException {
        double y;
        try {
            y = Math.cos(x)/ Math.tan(2 * x);
            // Перевірка на нечислові результати та ділення на нуль
            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            if (Math.abs(2 * x - Math.PI / 2) < 0.0001 || Math.abs(2 * x + Math.PI / 2) < 0.0001) {
                throw new CalcException("Exception reason: Tangent of 90 or -90 degrees is undefined");
            } else {
                throw new CalcException("Unknown reason of the exception during calculation");
            }
        }
        return y;
    }
}