package abstractfactory;

public class Demo {
    public static void main(String[] args) {

        AbstractFactory factory =  AbstractFactory.getFactory(Architecture.EMBER);
        CPU cpu = factory.createCPU();
    }
}
