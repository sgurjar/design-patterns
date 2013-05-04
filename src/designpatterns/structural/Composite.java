package designpatterns.structural;


public class Composite {
    public static void main(String[] args) throws Exception {
        Graphic composite = new CompositeGraphic(); // composite
        Graphic composite2 = new CompositeGraphic(); // composite
        Graphic leaf = new SimpleGraphic(); // leaf

        composite2.add(leaf);
        composite.add(composite2);

        GraphicsClient graphicsClient = getGraphicsClient();

        // client can just call paint, without worrying
        // if this is a composite or leaf
        graphicsClient.paint(composite);
    }

    static GraphicsClient getGraphicsClient() {
        return new GraphicsClient();
    }
}


// Client.
public class GraphicsClient {

    /**
     * Given a graphics context, client can just call paint, without
     * worrying if this is a composite or leaf
     */
    public void paint(Graphics g) {
        g.paint();
    }
}


// Component interface
public interface Graphic {
    public void add(Graphic g);
    public void remove(Graphic g);
    public Graphic get(int index);
    public void paint();
}


// Composite
public class CompositeGraphic implements Graphic {
    private List<Graphic> children = new ArrayList<Graphic>();

    public void paint() {
        // run the paint operation for each child
        for (Graphic g: children) {
            g.paint();
        }
    }

    public void add(Graphic g) {
        children.add(g);
    }

    public void remove(Graphic g) {
        if (children.contains(g)) {
            children.remove(g);
        }
    }

    public Graphic get(int index) {
        if (index < children.size()) {
            return children.get(index);
        }
    }
}


// Leaf
public class SimpleGraphic implements Graphic {
    public void paint() {// run the paint operation
    }

    /**
     * Because we have no children, these operations will do nothing
     **/
    public void add(Graphic g) {// unsupported operation
    }

    public void remove(Graphic g) {// unsupported operation
    }

    public void get(int index) {// unsupported operation
    }
}

