import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<TerritorialUnit> l = new LinkedList<>();

        for(int i = 0; i < 10; i++) {
            l.add(new TerritorialUnit());
        }

        Random random = new Random();

        for(TerritorialUnit t : l) {
            for(TerritorialUnitType ty : TerritorialUnitType.values()) {
                if(random.nextBoolean()) {
                    t.registerAs(ty);
                }
            }
        }

        for(TerritorialUnitType ty : TerritorialUnitType.values()) {
            MinistryOfLabour.sendTo(List.of(ty), "Andrzej to JS Dev, " + ty.toString());
        }
    }
}
