import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GUI {
    private static int idx = 0;
    public static void main(String[] args) {
        ArrayList<TerritorialUnit> units = new ArrayList<>();

        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton btnCreate = new JButton("Create new unit");
        btnCreate.setBounds(10, 10, 160, 30);
        frame.add(btnCreate);

        JLabel unitsLabel = new JLabel();
        unitsLabel.setText("Territorial units:");
        unitsLabel.setBounds(10, 40, 160, 20);
        frame.add(unitsLabel);

        DefaultListModel<String> listUnits = new DefaultListModel<>();
        JList<String> jListUnits = new JList<>(listUnits);
        jListUnits.setBounds(0, 30, 160, 200);

        JScrollPane pane = new JScrollPane(jListUnits);
        pane.setBounds(10, 60, 160, 250);
        frame.add(pane);

        JButton btnDetails = new JButton("Show details");
        btnDetails.setBounds(10, 320, 160, 30);
        frame.add(btnDetails);

        btnCreate.addActionListener(x -> {
            TerritorialUnit t = new TerritorialUnit();
            units.add(t);
            listUnits.addElement(t.getId().toString());
        });

        JLabel typesLabel = new JLabel();
        typesLabel.setText("Types of selected unit:");
        typesLabel.setBounds(200, 10, 160, 20);
        frame.add(typesLabel);

        DefaultListModel<String> listDetails = new DefaultListModel<>();
        JList<String> jListDetails = new JList<>(listDetails);
        jListDetails.setBounds(0, 0, 160, 300);
        jListDetails.setBorder(BorderFactory.createLineBorder(Color.black));

        JScrollPane paneDetails = new JScrollPane(jListDetails);
        paneDetails.setBounds(200, 30, 160, 300);
        paneDetails.add(jListDetails);
        frame.add(paneDetails);

        JLabel jUnitsTypesLabel = new JLabel();
        jUnitsTypesLabel.setText("Available unit's types:");
        jUnitsTypesLabel.setBounds(400, 10, 250, 20);
        frame.add(jUnitsTypesLabel);



        DefaultListModel<String> listUnitsTypes = new DefaultListModel<>();
        JList<String> jListUnitsTypes = new JList<>(listUnitsTypes);
        jListUnitsTypes.setBounds(0, 0, 160, 300);
        jListUnitsTypes.setBorder(BorderFactory.createLineBorder(Color.black));

        JScrollPane paneUnitTypes = new JScrollPane(jListUnitsTypes);
        paneUnitTypes.setBounds(420, 30, 160, 300);
        paneUnitTypes.add(jListUnitsTypes);
        frame.add(paneUnitTypes);

        JButton btnAdd = new JButton("<");
        btnAdd.setBounds(365, 60, 50, 50);
        frame.add(btnAdd);

        JButton btnRm = new JButton(">");
        btnRm.setBounds(365, 120, 50, 50);
        frame.add(btnRm);

        btnDetails.addActionListener(x -> {
            String s = jListUnits.getSelectedValue();
            if(s != null) {
                idx = Integer.parseInt(s);
                listDetails.clear();
                listUnitsTypes.clear();
                var properties = Arrays.asList(units.get(idx).getRegisteredAs().stream().map(Enum::toString).toArray(String[]::new));
                for(String ss : properties) {
                    listDetails.addElement(ss);
                }
                var missing = Stream.of(TerritorialUnitType.values()).map(TerritorialUnitType::name).collect(Collectors.toList());
                missing.removeAll(properties);
                for(String ss : missing) {
                    listUnitsTypes.addElement(ss);
                }
            }

        });

        btnAdd.addActionListener(x -> {
            String s = jListUnits.getSelectedValue();
            String t = jListUnitsTypes.getSelectedValue();
            if(s != null && t != null) {
                idx = Integer.parseInt(s);
                TerritorialUnitType type = TerritorialUnitType.valueOf(t);
                units.get(idx).registerAs(type);
                listDetails.clear();
                listUnitsTypes.clear();
                var properties = Arrays.asList(units.get(idx).getRegisteredAs().stream().map(Enum::toString).toArray(String[]::new));
                for(String ss : properties) {
                    listDetails.addElement(ss);
                }
                var missing = Stream.of(TerritorialUnitType.values()).map(TerritorialUnitType::name).collect(Collectors.toList());
                missing.removeAll(properties);
                for(String ss : missing) {
                    listUnitsTypes.addElement(ss);
                }
            }
        });

        btnRm.addActionListener(x -> {
            String s = jListUnits.getSelectedValue();
            String t = jListDetails.getSelectedValue();
            if(s != null && t != null) {
                idx = Integer.parseInt(s);
                TerritorialUnitType type = TerritorialUnitType.valueOf(t);
                units.get(idx).unregisterAs(type);
                listDetails.clear();
                listUnitsTypes.clear();
                var properties = Arrays.asList(units.get(idx).getRegisteredAs().stream().map(Enum::toString).toArray(String[]::new));
                for(String ss : properties) {
                    listDetails.addElement(ss);
                }
                var missing = Stream.of(TerritorialUnitType.values()).map(TerritorialUnitType::name).collect(Collectors.toList());
                missing.removeAll(properties);
                for(String ss : missing) {
                    listUnitsTypes.addElement(ss);
                };
            }
        });

        frame.setVisible(true);
    }
}
