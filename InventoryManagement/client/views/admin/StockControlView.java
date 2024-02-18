package client.views.admin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

public class StockControlView extends JFrame{
    private JPanel mainPanel;
    private JTextField searchField;
    private JPanel topPanel;
    private JTable stocksTable;
    private JPanel centerPanel;
    private JButton addItemButton;
    private JButton salesInvoiceButton;
    private JPanel bottomPanel;
    private JScrollPane stocksScrollPane;
    private JPanel searchPanel;
    private SalesInvoiceListener salesInvoiceListener;
    private AddItemListener addItemListener;

    public interface SalesInvoiceListener {
        void onSalesInvoiceRequested();
    }

    public interface AddItemListener {
        void onAddItemRequested();
    }

    public StockControlView() {
        setContentPane(mainPanel);
        setTitle("Stock Control");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);

//For testing
//        Object rowData [][] = {{"00", "Macbook Pro", "Laptop", "120"}
//                ,{"01", "Mechanical Keyboard", "Accessories", "250"}};
//        Object columnNames[] = {"Product ID", "Product Name", "Category", "Available"};
//        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
//        stocksTable.setModel(tableModel);


        stocksScrollPane.setBorder(BorderFactory.createCompoundBorder(
                new StockControlView.RoundedCornerBorder(30),
                new LineBorder(Color.lightGray, 2)

        ));

        searchField.setBorder(BorderFactory.createCompoundBorder(
                new StockControlView.RoundedCornerBorder(20),
                new EmptyBorder(5, 5, 5, 5)
        ));

        salesInvoiceButton.addActionListener(e -> {
            if (salesInvoiceListener != null) {
                salesInvoiceListener.onSalesInvoiceRequested();
            }
        });
        addItemButton.addActionListener(e -> {
            if (addItemListener != null) {
                addItemListener.onAddItemRequested();
            }
        });
    }

    private static class RoundedCornerBorder implements Border {
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

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(5, 5, 5, 5);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(client.views.admin.StockControlView::new);
    }

}
