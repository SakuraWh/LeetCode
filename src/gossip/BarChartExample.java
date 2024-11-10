//package gossip;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class BarChartExample extends JFrame {
//
//    public BarChartExample(String title) {
//        super(title);
//
//        // 创建数据集
//        CategoryDataset dataset = createDataset();
//
//        // 创建柱状图
//        JFreeChart chart = ChartFactory.createBarChart(
//                "Sample Bar Chart",     // 图表标题
//                "Category",             // x 轴标签
//                "Value",                // y 轴标签
//                dataset                // 数据集
//        );
//
//        // 创建图表面板并将其添加到窗口
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new Dimension(560, 370));
//        setContentPane(chartPanel);
//    }
//
//    private CategoryDataset createDataset() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        // 添加数据
//        dataset.addValue(10, "Series1", "Category1");
//        dataset.addValue(15, "Series1", "Category2");
//        dataset.addValue(25, "Series1", "Category3");
//
//        return dataset;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            BarChartExample example = new BarChartExample("Bar Chart Example");
//            example.setSize(800, 600);
//            example.setLocationRelativeTo(null);
//            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            example.setVisible(true);
//        });
//    }
//}
