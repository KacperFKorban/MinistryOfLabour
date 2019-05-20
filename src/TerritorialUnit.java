import java.util.EnumSet;

public class TerritorialUnit {
    /**
     * EnumSet of types unit holds
     */
    private EnumSet<TerritorialUnitType> registeredAs = EnumSet.noneOf(TerritorialUnitType.class);

    private static int counter = 0;

    /**
     * Id of unit
     */
    private int id;

    /**
     * Returns EnumSet of types unit holds
     * @return
     */
    public EnumSet<TerritorialUnitType> getRegisteredAs() {
        return registeredAs;
    }

    /**
     * Getter od id
     * @return id of unit
     */
    public Integer getId() {
        return id;
    }

    /**
     * Basic constructor
     */
    public TerritorialUnit() {
        this.id = counter++;
    }

    /**
     * Constructor with custom id
     * @param id id to be set
     */
    public TerritorialUnit(int id) {
        this.id = id;
    }

    /**
     * Registers unit to given type if it is possible
     * @param territorialUnitType type to be registered as
     */
    public void registerAs(TerritorialUnitType territorialUnitType) {
        if(!registeredAs.contains(territorialUnitType)) {
            MinistryOfLabour.registerAs(territorialUnitType, this);
            registeredAs.add(territorialUnitType);
            System.out.println("Registered territorial unit id: " + id + " as: " + territorialUnitType.toString());
        } else {
            System.out.println("No can do!");
        }
    }

    /**
     * Unregisters unit's type if it is possible
     * @param territorialUnitType type to be unregistered from
     */
    public void unregisterAs(TerritorialUnitType territorialUnitType) {
        if (registeredAs.contains(territorialUnitType)) {
            MinistryOfLabour.unregisterAs(territorialUnitType, this);
            registeredAs.remove(territorialUnitType);
            System.out.println("Unregistered territorial unit id: " + id + " as: " + territorialUnitType.toString());
        } else {
            System.out.println("No can do!");
        }
    }

    /**
     * Used to handle incoming message
     * @param msg Received message
     */
    public void message(String msg) {
        System.out.println("Territorial unit with id: " + id + " received msg: " + msg);
    }
}
