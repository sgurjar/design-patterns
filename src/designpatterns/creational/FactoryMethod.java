package designpatterns.creational;


public class FactoryMethod {

    class Complex {
        public static Complex fromCartesianFactory(double real, double imaginary) {
            return new Complex(real, imaginary);
        }

        public static Complex fromPolarFactory(double modulus, double angle) {
            return new Complex(modulus * Math.cos(angle), modulus * Math.sin(angle));
        }

        private Complex(double a, double b) {// ...
        }
    }

    public static void main(String[] args) throws Exception {
        Complex product = Complex.fromPolarFactory(1, Math.PI);
    }

}
