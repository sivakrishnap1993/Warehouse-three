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
public class AdminUtil {

	public void generatePie(String path, List<Object[]> data) {

		// data should be converted to DataSet
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}

		// Data-set should be converted to JFreeChart
		// using ChartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("Admin Type Mode", dataset, true, true, false);

		// JFreeChart should be converted to Image
		// using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/adminC.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DefaultCategoryDataset datasett = new DefaultCategoryDataset();
		for (Object[] odd : data) {
			datasett.setValue(new Double(odd[1].toString()), odd[0].toString(), path);
		}
		JFreeChart charrt = ChartFactory.createBarChart("Admin Bar Chart", "Mode", "Chart", datasett,
				PlotOrientation.VERTICAL, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/adminone.jpg"), charrt, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
