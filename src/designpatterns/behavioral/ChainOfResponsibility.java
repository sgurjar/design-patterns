package designpatterns.behavioral;

public class ChainOfResponsibility {
    public static void main(String[] args) throws Exception {
        Chain<Handler> handlerChain = new Chain<Handler>(new FooHandler());

        handlerChain.append(new BarHandler());
        handlerChain.append(new AlphaHandler());

        ChainOfResponsibility cor = new ChainOfResponsibility();

        cor.setHandler(handlerChain);
        cor.invoke();
    }

    private Handler _handler;
    void setHandler(Handler handler) {
        assert handler != null;
        _handler = handler;
    }

    void invoke() {
        assert _handler != null;
        // inovkes handler without knowing its chained or not
        _handler.handle();
    }

}


interface Handler {
    void handle();
}


class FooHandler implements Handler {
    public void handle() {
        System.out.println("this is FooHandler");
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}


class BarHandler implements Handler {
    public void handle() {
        System.out.println("this is BarHandler");
        if (flipcoin()) {
            throw new BreakChainException();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    static boolean flipcoin() {
        int rnd = (int) (Math.random() * 10);

        return (rnd % 2) == 0;
    }
}


class AlphaHandler implements Handler {
    public void handle() {
        System.out.println("this is AlphaHandler");
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}


class BreakChainException extends RuntimeException {}


class Chain<T extends Handler> implements Handler {
    private final T _data;
    private Chain<T> _next;

    public Chain(T data) {
        assert data != null;
        _data = data;
    }

    public void setNext(Chain<T> next) {
        _next = next;
    }

    public void append(T next) {
        append(new Chain<T>(next));
    }

    public void append(Chain<T> next) {
        assert next != null;

        if (_next == null) {
            _next = next;
        } else {
            Chain<T> tmpnext = _next;

            while (tmpnext._next != null) {
                tmpnext = tmpnext._next;
                // find end of the list
            }
            tmpnext.setNext(next);
        }
    }

    public void handle() {
        try {
            _data.handle();
            if (_next != null) {
                _next.handle();
            }
        } catch (BreakChainException ex) {// terminates chain
        }
    }
}

