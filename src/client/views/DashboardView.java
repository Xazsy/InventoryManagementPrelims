package client.views;

import javax.swing.*;
import javax.swing.border.AbstractBorder; // For Controller
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D; // For Controller

public class DashboardView {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel searchPanel;
    private JTextField searchField;
    private JList<String> activityList1;
    private JList<String> activityList2;
    private JButton addUserButton;

    public DashboardView() {
        DefaultListModel<String> listModel1 = new DefaultListModel<>();
        listModel1.addElement("User 1");
        listModel1.addElement("User 2");
        listModel1.addElement("User 3");
        listModel1.addElement("User 4");
        listModel1.addElement("User 5");
        activityList1.setModel(listModel1);

        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        listModel2.addElement("Sales Person");
        listModel2.addElement("Purchaser");
        listModel2.addElement("Sales Person");
        listModel2.addElement("Sales Person");
        listModel2.addElement("Purchaser");
        activityList2.setModel(listModel2);

        // Call for Controller
        searchField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedCornerBorder(20),
                new EmptyBorder(5, 5, 5, 5)
        ));
    }

    public static void main(String[] args) {
        DashboardView dashboardView = new DashboardView();

        JFrame frame = new JFrame("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(dashboardView.mainPanel);

        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(700, 500));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Should be added in controller, used only for testing
    private static class RoundedCornerBorder extends AbstractBorder {
        private final int arc;

        public RoundedCornerBorder(int arc) {
            this.arc = arc;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Stroke originalStroke = g2d.getStroke();
            g2d.setStroke(new BasicStroke(3.0f));

            g2d.setColor(Color.WHITE);
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));

            g2d.setStroke(originalStroke);

            g2d.dispose();
        }
    }
}
