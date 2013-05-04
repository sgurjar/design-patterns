package designpatterns.structural;


public class Facade {
    public static void main(String[] args) {
        Computer facade = new Computer();
        facade.start();
    }
}

/* Facade */

class Computer {
    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public Computer() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }

    static long BOOT_ADDRESS=0xCAFEBABE;
    static long BOOT_SECTOR=0x1BADB002
    static int  SECTOR_SIZE=64;
}

class CPU {
    public void freeze() {/* ...*/}
    public void jump(long position) {/* ...*/}
    public void execute() {/* ...*/}
}

class Memory {
    public void load(long position, byte[] data) {/* ...*/}
}


class HardDrive {
    public byte[] read(long lba, int size) {/* ...*/}
}
