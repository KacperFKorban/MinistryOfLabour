import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinistryOfLabour {
    /**
     * Enum map holding records of territorial units and their types
     */
    private static EnumMap<TerritorialUnitType, List<TerritorialUnit>> registry = new EnumMap<>(TerritorialUnitType.class);

    static {
        for(TerritorialUnitType t : TerritorialUnitType.values()) {
            registry.put(t, new LinkedList<>());
        }
    }


    /**
     * Registers given territorial unit as given type
     * @param territorialUnitType type of territorial unit to be registered as
     * @param territorialUnit territorial unit to be registered
     */
    public static void registerAs(TerritorialUnitType territorialUnitType, TerritorialUnit territorialUnit) {
        registry.get(territorialUnitType).add(territorialUnit);
    }

    /**
     * Unregisters given territorial unit as given type
     * @param territorialUnitType type of territorial unit to be unregistered from
     * @param territorialUnit territorial unit to be unregistered
     */
    public static void unregisterAs(TerritorialUnitType territorialUnitType, TerritorialUnit territorialUnit) {
        registry.get(territorialUnitType).remove(territorialUnit);
    }

    /**
     * Sends message to given unit types
     * @param addressees List holding types the message will be send to
     * @param msg Message to be send
     */
    public static void sendTo(List<TerritorialUnitType> addressees, String msg) {
        registry
                .entrySet()
                .stream()
                .filter(e -> addressees.contains(e.getKey()))
                .flatMap(e -> e.getValue().stream())
                .distinct()
                .forEach(t -> t.message(msg));
    }
}
