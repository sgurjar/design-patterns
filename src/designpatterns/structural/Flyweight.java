package designpatterns.structural;


public class Flyweight {

    private CoffeeFlavor[] flavors = new CoffeeFlavor[100];
    private CoffeeOrderContext[] tables = new CoffeeOrderContext[100];
    private int ordersMade = 0;
    private CoffeeFlavorFactory flavorFactory = new CoffeeFlavorFactory();

    public void takeOrders(String flavorIn, int table) {
        flavors[ordersMade] = flavorFactory.getCoffeeFlavor(flavorIn);
        tables[ordersMade] = new CoffeeOrderContext(table);
        ordersMade += 1;
    }

    public static void main(String[] args) throws Exception {
        Flyweight flyweight = new Flyweight();

        flyweight.takeOrders("Cappuccino",  2);
        flyweight.takeOrders("Cappuccino",  2);
        flyweight.takeOrders("Frappe"    ,  1);
        flyweight.takeOrders("Frappe"    ,  1);
        flyweight.takeOrders("Espresso"  ,  1);
        flyweight.takeOrders("Frappe"    , 89);
        flyweight.takeOrders("Cappuccino", 97);
        flyweight.takeOrders("Cappuccino", 97);
        flyweight.takeOrders("Frappe"    ,  3);
        flyweight.takeOrders("Espresso"  ,  3);
        flyweight.takeOrders("Cappuccino",  3);
        flyweight.takeOrders("Espresso"  , 96);
        flyweight.takeOrders("Frappe"    , 55);
        flyweight.takeOrders("Cappuccino", 21);
        flyweight.takeOrders("Espresso"  , 12);

        for (int i = 0; i < ordersMade; ++i) {
            flyweight.flavors[i].serveCoffee(tables[i]);
        }

        System.out.println(" ");
        System.out.println("total CoffeeFlavor objects made: " + flavorFactory.getTotalCoffeeFlavorsMade());
    }
}


// Flyweight object interface
interface CoffeeOrder {
    public void serveCoffee(CoffeeOrderContext context);
}


// ConcreteFlyweight object that creates ConcreteFlyweight
class CoffeeFlavor implements CoffeeOrder {
    private final String flavor;

    public CoffeeFlavor(String newFlavor) {
        this.flavor = newFlavor;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public void serveCoffee(CoffeeOrderContext context) {
        System.out.println("Serving Coffee flavor " + flavor + " to table number " + context.getTable());
    }
}


class CoffeeOrderContext {
    private final int tableNumber;

    public CoffeeOrderContext(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTable() {
        return this.tableNumber;
    }
}


// FlyweightFactory object
class CoffeeFlavorFactory {
    private Map<String, CoffeeFlavor> flavors = new HashMap<String, CoffeeFlavor>();

    public CoffeeFlavor getCoffeeFlavor(String flavorName) {
        CoffeeFlavor flavor = flavors.get(flavorName);

        if (flavor == null) {
            flavor = new CoffeeFlavor(flavorName);
            flavors.put(flavorName, flavor);
        }
        return flavor;
    }

    public int getTotalCoffeeFlavorsMade() {
        return flavors.size();
    }
}