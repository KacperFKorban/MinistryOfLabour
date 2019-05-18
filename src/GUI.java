import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        jListDetails.setBounds(0, 0, 160, 100);
        jListDetails.setBorder(BorderFactory.createLineBorder(Color.black));

        JScrollPane paneDetails = new JScrollPane(jListDetails);
        paneDetails.setBounds(200, 30, 160, 100);
        paneDetails.add(jListDetails);
        frame.add(paneDetails);

        btnDetails.addActionListener(x -> {
            String s = jListUnits.getSelectedValue();
            if(s != null) {
                idx = Integer.parseInt(s);
                listDetails.clear();
                for(String ss : units.get(idx).getRegisteredAs().stream().map(Enum::toString).toArray(String[]::new)) {
                    listDetails.addElement(ss);
                }
            }
        });

        frame.setVisible(true);
    }
}