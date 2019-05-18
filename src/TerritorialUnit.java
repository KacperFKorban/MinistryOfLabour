import java.util.EnumSet;

public class TerritorialUnit {
    private EnumSet<TerritorialUnitType> registeredAs = EnumSet.noneOf(TerritorialUnitType.class);
    private static int counter = 0;
    private int id;

    public EnumSet<TerritorialUnitType> getRegisteredAs() {
        return registeredAs;
    }

    public Integer getId() {
        return id;
    }

    public TerritorialUnit() {
        this.id = counter++;
    }

    public TerritorialUnit(int id) {
        this.id = id;
    }

    public void registerAs(TerritorialUnitType territorialUnitType) {
        if(!registeredAs.contains(territorialUnitType)) {
            MinistryOfLabour.registerAs(territorialUnitType, this);
            registeredAs.add(territorialUnitType);
            System.out.println("Registered territorial unit id: " + id + " as: " + territorialUnitType.toString());
        } else {
            System.out.println("No can do!");
        }
    }
    public void unregisterAs(TerritorialUnitType territorialUnitType) {
        if(registeredAs.contains(territorialUnitType)) {
            MinistryOfLabour.unregisterAs(territorialUnitType, this);
            registeredAs.add(territorialUnitType);
            System.out.println("Unregistered territorial unit id: " + id + " as: " + territorialUnitType.toString());
        } else {
            System.out.println("No can do!");
        }
    }

    public void message(String msg) {
        System.out.println("Territorial unit with id: " + id + " received msg: " + msg);
    }
}
