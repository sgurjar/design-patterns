package designpatterns.structural;


public class Decorator {
    public static void main(String[] args) throws Exception {
        Reader decoratee = new StringReader("foobar");
        Reader decorator = new BufferedReader(decoratee);

        for (;;) {
            int c = decorator.read();

            if (c == -1) {
                break;
            }
        }
    }

}


interface Reader {
    int read();
    int read(char[] cbuf, int off, int len);
    void close();
}


class StringReader implements Reader {
    private String _str;
    private int index = 0;

    StringReader(String str) {
        _str = str;
    }

    public int read() {
        try {
            return str.charAt(index++);
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    public int read(char[] cbuf, int off, int len) {
        int i = 0, c;

        for (; i < len; i++) {
            c = read();
            if (c == -1) {
                return -1;
            }
            cbuf[off + i] = c;
        }
        return i;
    }

    public void close() {// noop
    }
}


class BufferedReader implements Reader {
    Reader _decoratee;
    int bufsize = 1024;
    char[] buf = new char[bufsize];
    int index = 0;
    public BufferedReader(Reader decoratee) {
        _decoratee = decoratee;
    }

    public int read() {
        return frombuf();
    }

    public int read(char[] cbuf, int off, int len) {
        return frombuf(cbuf, off, len);
    }

    public void close() {
        _decoratee.close();
    }

    public String readLine() {

        /*
         * use _decoratee to create line
         */
        return ""; // <- return line
    }

    private int frombuf() {
        if (index >= bufsize) {
            rebuf();
        }
        return buf[index++];
    }

    private int frombuf(char[] cbuf, int off, int len) {
        // read from buffer
        // if whole buffer is read rebuffer

        return -1;
    }

    private void rebuf() {
        char[] tmpbuf = new char[bufsize];
        int sz = _decoratee.read(tmpbuf, 0, bufsize);

        if (sz != -1) {
            bufsize = sz;
        }
        index = 0; // reset to zero
    }

}

