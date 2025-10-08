import java.util.Scanner;

public class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    public boolean equals(Complex other) {
        return this.real==other.real&&this.imag==other.imag;
    }

    public String toString() {
        if (imag >= 0) {
            return real + " + " + imag + "i";
        } else {
            return real + " - " + (-imag) + "i";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入第一个复数的实部和虚部:");
        double real1 = scanner.nextDouble();
        double imag1 = scanner.nextDouble();
        Complex z1 = new Complex(real1, imag1);

        System.out.println("请输入第二个复数的实部和虚部:");
        double real2 = scanner.nextDouble();
        double imag2 = scanner.nextDouble();
        Complex z2 = new Complex(real2, imag2);

        System.out.println("Z1 = " + z1);
        System.out.println("Z2 = " + z2);
        System.out.println("Z1 + Z2 = " + z1.add(z2));
        System.out.println("Z1 - Z2 = " + z1.subtract(z2));
        System.out.println("Z1 == Z2? " + z1.equals(z2));

        scanner.close();
    }
}