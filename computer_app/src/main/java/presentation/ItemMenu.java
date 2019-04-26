package presentation;

import business.Item;
import business.SistemaGestaoStock;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ItemMenu{
    private SistemaGestaoStock sgs;

    private JFrame frame;
    private JPanel panel1;
    private JTextField nameTextField;
    private JButton nameSearchButton;
    private JTextField referenceTextField;
    private JButton referenceSearchButton;
    private JTable table;

    public ItemMenu(SistemaGestaoStock sgs) {

        this.sgs = sgs;
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nome");
        dtm.addColumn("Referência");
        dtm.addColumn("Localização");
        table.setModel(dtm);

        nameSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                Set<Item> items = sgs.getItemsByName(name);

                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn("Nome");
                dtm.addColumn("Referência");
                dtm.addColumn("Localização");
                items.forEach(i -> dtm.addRow(new String[]{i.getName(),i.getReference(),i.getLocation()}));
                table.setModel(dtm);
            }
        });
        referenceSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                Set<Item> items = sgs.getItemsByReference(name);

                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn("Nome");
                dtm.addColumn("Referência");
                dtm.addColumn("Localização");
                items.forEach(i -> dtm.addRow(new String[]{i.getName(),i.getReference(),i.getLocation()}));
                table.setModel(dtm);
            }
        });
    }

    public int show(){
        frame = new JFrame("ItemMenu");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) (screenSize.getWidth()/5),(int) (screenSize.getHeight()/5));
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        return 2;
    }

    public static void main(String[] args) {
        new ItemMenu(null).show();
    }

}
