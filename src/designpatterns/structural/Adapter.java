package designpatterns.structural;

interface Duck {
    void quack();
    void fly();
}

class MallardDuck implements Duck {
    public void quack() { System.out.println("MallardDuck: quack"); }
    public void fly() { System.out.println("MallardDuck: fly"); }
}

interface Turkey {
    void gobble();
    void fly();
}


class WildTurkey implements Turkey {
    public void gobble() { System.out.println("WildTurkey: gobble"); }
    public void fly() { System.out.println("WildTurkey: fly"); }
}


// make Turkey look like Duck
class TurkeyAdapter implements Duck {
    private Turkey turkey;

    TurkeyAdapter(Turkey turkey) { this.turkey = turkey; }

    public void quack() { turkey.gobble(); }

    public void fly() {
        for (int i = 0; i < 5; i++) { turkey.fly(); } // fly like a duck
    }
}


public class Adapter {
    public static void main(String[] args) throws Exception {

        Duck realDuck = new MallardDuck();

        show(realDuck);

        WildTurkey aTurkey = new WildTurkey();
        TurkeyAdapter aTurkeyAdaptedToADuck = new TurkeyAdapter(aTurkey);

        show(aTurkeyAdaptedToADuck);
    }

    static void show(Duck duck) {
        duck.quack();
        duck.fly();
    }
}

