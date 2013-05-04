package designpatterns.structural;

public class Proxy {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Image img = new ProxyImage();

            img.display(); // only one instance of Real Image
        }
    }
}


interface Image {
    public void display();
}


class RealImage implements Image {
    private final String _imgfilename;

    public RealImage(String imgfilename) {
        _imgfilename = imgfilename;
    }

    public void display() {
        system.out.println("Displaying " + _imgfilename);
    }
}


class ProxyImage implements Image {
    private final String _imgfilename;
    private RealImage _realImage;

    public ProxyImage(String imgfilename) {
        _imgfilename = imgfilename;
    }

    public void display() {
        if (realImage == null) {
            _realImage = new RealImage();
            // control RealImage instance by proxying it.
        }
        _realImage.display();
    }
}

