package com.kdyzm.test.pie;

import java.awt.Font;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 测试饼状图的生成
 * @author kdyzm
 * 
 * 需要注意的一点就是为了解决中文乱码问题，一定要在将流写入文件之前设置字体。
 *
 */
public class TestPie {
	public static void main(String[] args) throws Exception {
		String title="各大公司Java EE AS 市场占有率调查";
		DefaultPieDataset dpd=new DefaultPieDataset();
		dpd.setValue("IBM", 25);
		dpd.setValue("Oracle", 25);
		dpd.setValue("JBoss", 25);
		dpd.setValue("用友", 25);
		
		//使用最简单的绘图方式
		JFreeChart chart=ChartFactory.createPieChart3D(title, dpd, true, false, false);
//		解决标题中文乱码问题
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 30));
		//解决底部bar中中文乱码问题
		chart.getLegend().setItemFont(new Font("微软雅黑", Font.PLAIN, 15));
		PiePlot plot = (PiePlot)chart.getPlot();   
//		plot.setExplodePercent("IBM", 0.3D);
//		plot.setExplodePercent("Oracle", 0.1D);
		plot.setLabelFont(new Font("宋体",Font.BOLD,15));  
		plot.setForegroundAlpha(0.7F);
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}/{1}/{2}/{3}"));
		//绘图区
		/**
		 * 这里设置的{}参数只有四种
		 * {0}，标签名称
		 * {1}，实际的数量
		 * {2}，占的百分比
		 * {3}，总的数量
		 * 如果超出了这个范围，则直接不给解析如果加上了{4}，则直接打印{4}
		 */
//		//设置图表区背景
//		chart.setBackgroundImage(ImageIO.read(new File("C:/Users/kdyzm/Pictures/IA.full.1795695.jpg")));
//		//设置绘图区背景
//		plot.setBackgroundImage(ImageIO.read(new File("C:/Users/kdyzm/Pictures/IA.full.1787513.jpg")));
		
		//设置分裂效果
		ChartUtilities.saveChartAsJPEG(new File("D://a.jpg"), chart, 800, 500);
		//解决每个扇形区域中中文乱码问题
		System.out.println("打印完成！");
	}
}
