package designpatterns.creational;


public class AbstractFactory {
    interface Button {
        void paint();
    }


    interface GUIFactory {
        Button createButton();
    }


    class WinFactory implements GUIFactory {
        public Button createButton() {
            return new WinButton();
        }
    }


    class OSXFactory implements GUIFactory {
        public Button createButton() {
            return new OSXButton();
        }
    }


    class WinButton implements Button {
        public void paint() {
            System.out.println("I'm a WinButton");
        }
    }


    class OSXButton implements Button {
        public void paint() {
            System.out.println("I'm an OSXButton");
        }
    }


    class Application {
        public Application(GUIFactory factory) {
            Button button = factory.createButton();

            button.paint();
        }
    }

    static GUIFactory createOsSpecificFactory() {
        String sys = System.getProperty("OS_TYPE"); // or from a config file

        if ("windows".equals(sys)) {
            return new WinFactory();
        } else {
            return new OSXFactory();
        }
    }

    public static void main(String[] args) throws Exception {
        new Application(createOsSpecificFactory());
    }

}
