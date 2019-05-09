package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class OrderMethodUtil {

	public void genereatePie(String path, List<Object[]> data) {

		// DATASET
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		// DATA-SET SHOULD BE CONVERTED TO JFREECHART
		JFreeChart chart = ChartFactory.createPieChart3D("OrderMethod Pie Chart", dataset, true, true, false);

		// JFREE CHART SHOULD BE CONVERTED TO IMAGE
		try {
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/orderOne.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DefaultCategoryDataset dataseet = new DefaultCategoryDataset();
		for (Object[] ob : data) {
			dataseet.setValue(new Double(ob[1].toString()), ob[0].toString(), path);
		}
		JFreeChart charrt = ChartFactory.createBarChart("OrderMethod Bar Chart", "Mode", "Chart", dataseet,
				PlotOrientation.VERTICAL, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path +"/resources/images/orderTwo.jpg"), charrt, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
