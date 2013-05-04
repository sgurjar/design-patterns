package designpatterns.creational;


public class Prototype {
    interface Prototype {
        void setX(int x);

        void printX();

        int getX();
    }


    class PrototypeImpl implements Prototype, Cloneable {
        private int x;

        public PrototypeImpl(int x) {
            setX(x);
        }

        @Override
        public void setX(int x) {
            this.x = x;
        }

        @Override
        public void printX() {
            System.out.println("Value: " + x);
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public PrototypeImpl clone() throws CloneNotSupportedException {
            return (PrototypeImpl) super.clone();
        }
    }

    public static void main(String args[]) throws CloneNotSupportedException {
        PrototypeImpl prototype = new PrototypeImpl(1000);

        for (int y = 1; y < 10; y++) {
            // Create a defensive copy of the object to allow safe mutation
            Prototype tempotype = prototype.clone();

            // Derive a new value from the prototype's "x" value
            tempotype.setX(tempotype.getX() * y);
            tempotype.printX();
        }
    }
}
