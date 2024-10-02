package KI35.Kliuchar.lab5;

import java.io.*;
import java.util.Scanner;

public class CalcWFioApp {

    public static void calc(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter data: ");
        double data = scanner.nextDouble();

        CalcWFio calcWFio = new CalcWFio();
        Equations.calculate(data);
        double result = calcWFio.getResult();

        calcWFio.writeResTxt("textRes.txt", result);
        System.out.println("Result is: " + calcWFio.readResult());
        calcWFio.writeResBin("BinRes.dat", result);
        calcWFio.readResBin("BinRes.dat");

    }
}

class CalcWFio {

    public void writeResTxt(String fileName, double result) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.printf("%f ", result);
            writer.close();
        }
    }

    public double readResult() throws IOException {
        try (Scanner scanner = new Scanner(new File("textRes.txt"))) {
            return scanner.nextDouble();
        } catch (FileNotFoundException e) {
            System.out.println("File textRes.txt not found");
            return 0.0; // Повернення значення за замовчуванням
        }
    }

    public void writeResBin(String fileName, double result) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            out.writeDouble(result);
            out.close();
        }
    }

    public void readResBin(String fileName) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
            double r = in.readDouble();
            System.out.println("Result is: " + r);
            in.close();
        }
    }
    public double getResult() {
        return result;
    }

    static double result;
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
    public static void calculate(double x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try {
            y = Math.cos(rad)/ Math.tan(2 * rad);
            // Перевірка на нечислові результати та ділення на нуль
            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            if (Math.abs(2 * rad - Math.PI / 2) < 0.0001 || Math.abs(2 * rad + Math.PI / 2) < 0.0001) {
                throw new CalcException("Exception reason: Tangent of 90 or -90 degrees is undefined");
            } else {
                throw new CalcException("Unknown reason of the exception during calculation");
            }
        }
        CalcWFio.result = y;
    }
}