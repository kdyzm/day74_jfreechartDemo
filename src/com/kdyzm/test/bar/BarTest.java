package com.kdyzm.test.bar;

import java.awt.Font;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 测试柱状图的生成
 * @author kdyzm
 *
 */
public class BarTest {
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
		JFreeChart chart=ChartFactory.createBarChart3D(title, "季度", "销量（万台）", dataset, PlotOrientation.VERTICAL, true, false, false);
		
		//集中解决中文乱码问题
		chart.getTitle().setFont(new Font("微软雅黑", Font.BOLD, 30));
		//设置底部bar中的字体样式
		chart.getLegend().setItemFont(new Font("微软雅黑", Font.ITALIC, 20));
		
		CategoryPlot categoryPlot=chart.getCategoryPlot();
		//设置横坐标字体的样式
		categoryPlot.getDomainAxis().setLabelFont(new Font("微软雅黑", Font.PLAIN, 15));
		//设置横坐标小字体标题的样式
		categoryPlot.getDomainAxis().setTickLabelFont(new Font("微软雅黑",Font.PLAIN,14));
		
		//设置纵坐标标题的字体样式
		categoryPlot.getRangeAxis().setLabelFont(new Font("微软雅黑",Font.PLAIN,15));
		//设置前景色透明度
		categoryPlot.setForegroundAlpha(0.7F);
		
		ChartUtilities.saveChartAsJPEG(new File("d:/bar.jpg"), chart, 800, 500);
		System.out.println("图表生成完毕");
	}
}
