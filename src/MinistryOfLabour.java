import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinistryOfLabour {
    private static EnumMap<TerritorialUnitType, List<TerritorialUnit>> registry = new EnumMap<>(TerritorialUnitType.class);

    static {
        for(TerritorialUnitType t : TerritorialUnitType.values()) {
            registry.put(t, new LinkedList<>());
        }
    }

    public static void registerAs(TerritorialUnitType territorialUnitType, TerritorialUnit territorialUnit) {
        registry.get(territorialUnitType).add(territorialUnit);
    }

    public static void unregisterAs(TerritorialUnitType territorialUnitType, TerritorialUnit territorialUnit) {
        registry.get(territorialUnitType).remove(territorialUnit);
    }

    public static void sendTo(List<TerritorialUnitType> addressees, String msg) {
        registry.entrySet().stream().filter(e -> addressees.contains(e.getKey())).forEach(e -> e.getValue().forEach(t -> t.message(msg)));
    }
}
