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
public class PurchaseUtil {

	public void generatePie(String path, List<Object[]> data) {

		// data should be converted to DataSet
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}

		// Data-set should be converted to JFreeChart
		// using ChartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("Purchase Type Mode", dataset, true, true, false);

		// JFreeChart should be converted to Image
		// using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/purchaseA.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DefaultCategoryDataset ddtaset = new DefaultCategoryDataset();
		for (Object[] ob : data) {
			ddtaset.setValue(new Double(ob[1].toString()), ob[0].toString(), path);
		}
		JFreeChart chaart = ChartFactory.createBarChart("purchase bar chart", "Mode", "Chart", ddtaset,
				PlotOrientation.VERTICAL, true, false, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/purchaseB.jpg"), chaart, 400, 200);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
