package abstractfactory;

public abstract class AbstractFactory {

    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();


    public static AbstractFactory getFactory(Architecture architecture) {

        AbstractFactory factory = null;

        switch (architecture) {
            case EMBER:
                factory = EMBER_TOOLKIT;
                break;
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
                break;
        }
        return factory;
    }

    public abstract CPU createCPU();
    public abstract MMU createMMU();

}
