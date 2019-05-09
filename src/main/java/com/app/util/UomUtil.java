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
public class UomUtil {

	public void generatePie(String path, List<Object[]> data) {

		// data should be converted to DataSet
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}

		// Data-set should be converted to JFreeChart
		// using ChartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("Uom Type Pi Chart", dataset, true, true, false);

		// JFreeChart should be converted to Image
		// using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/uom.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 1.DATASET
		DefaultCategoryDataset datset = new DefaultCategoryDataset();
		for (Object[] ob : data) {
			datset.setValue(new Double(ob[1].toString()), ob[0].toString(), path);
		}
		// 2.JFREECHART USING CHART FACTORY
		JFreeChart chartt = ChartFactory.createBarChart("Uom Bar Chart Reports", "Mode", "Chart", datset,
				PlotOrientation.VERTICAL, true, true, false);

		// 3.ChartUtils using to save file as image
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/uomm.jpg "), chartt, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
