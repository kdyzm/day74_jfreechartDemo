package com.kdyzm.test.appline;

import java.awt.BasicStroke;
import java.awt.Font;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 * 折线图的生成方式和柱状图的生成方式几乎没有区别，但是最好设置一下线条的粗细，否则很难看
 * @author kdyzm
 *
 */
public class AppLine {
	public static void main(String[] args) throws Exception {
		//提供数据集合
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.addValue(100,"IBM", "第一季度");
		dataset.addValue(103,"Oracle", "第一季度");
		dataset.addValue(1000,"JBoss", "第一季度");
		dataset.addValue(208,"用友", "第一季度");

		dataset.addValue(2477,"IBM", "第二季度");
		dataset.addValue(2343,"Oracle", "第二季度");
		dataset.addValue(987,"JBoss", "第二季度");
		dataset.addValue(3473,"用友", "第二季度");
		
		dataset.addValue(1890,"IBM", "第三季度");
		dataset.addValue(2980,"Oracle", "第三季度");
		dataset.addValue(3889,"JBoss", "第三季度");
		dataset.addValue(2890,"用友", "第三季度");
		
		dataset.addValue(2347,"IBM", "第四季度");
		dataset.addValue(1340,"Oracle", "第四季度");
		dataset.addValue(2340,"JBoss", "第四季度");
		dataset.addValue(3000,"用友", "第四季度");
		
		//生成图表的进程
		String title="一年之中各大公司Java EE AS销售统计";
		JFreeChart chart=ChartFactory.createLineChart3D(title, "季度", "销量（万台）", dataset, PlotOrientation.VERTICAL, true, false, false);
		
		//集中解决中文乱码问题
		chart.getTitle().setFont(new Font("微软雅黑", Font.BOLD, 30));
		//设置底部bar中的字体样式
		chart.getLegend().setItemFont(new Font("微软雅黑", Font.ITALIC, 14));
		CategoryPlot categoryPlot=chart.getCategoryPlot();
		//设置横坐标字体的样式
		categoryPlot.getDomainAxis().setLabelFont(new Font("微软雅黑", Font.PLAIN, 15));
		//设置横坐标小字体标题的样式
		categoryPlot.getDomainAxis().setTickLabelFont(new Font("微软雅黑",Font.PLAIN,14));
		
		//设置纵坐标标题的字体样式
		categoryPlot.getRangeAxis().setLabelFont(new Font("微软雅黑",Font.PLAIN,15));
		//设置前景色透明度
		categoryPlot.setForegroundAlpha(0.8F);
		
		//设置折线粗细
		/*LineAndShapeRenderer renderer=(LineAndShapeRenderer) categoryPlot.getRenderer();
		renderer.setSeriesStroke(0, new BasicStroke(3F));
		renderer.setSeriesStroke(1, new BasicStroke(3F));
		renderer.setSeriesStroke(2, new BasicStroke(3F));
		renderer.setSeriesStroke(3, new BasicStroke(3F));*/
		
		ChartUtilities.saveChartAsJPEG(new File("d:/appLine.jpg"), chart, 800, 500);
		System.out.println("折线图表生成完毕");
	}
}
