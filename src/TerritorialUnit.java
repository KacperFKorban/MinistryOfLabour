import java.util.EnumSet;

public class TerritorialUnit {
    private EnumSet<TerritorialUnitType> registeredAs = EnumSet.noneOf(TerritorialUnitType.class);
    private static int counter = 0;
    private int id;

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
            throw new RuntimeException("Already registered as " + territorialUnitType.toString());
        }
    }
    public void unregisterAs(TerritorialUnitType territorialUnitType) {
        if(registeredAs.contains(territorialUnitType)) {
            MinistryOfLabour.unregisterAs(territorialUnitType, this);
            registeredAs.add(territorialUnitType);
            System.out.println("Unregistered territorial unit id: " + id + " as: " + territorialUnitType.toString());
        } else {
            throw new RuntimeException("Not registered as " + territorialUnitType.toString());
        }
    }

    public void message(String msg) {
        System.out.println("Territorial unit with id: " + id + " received msg: " + msg);
    }
}
