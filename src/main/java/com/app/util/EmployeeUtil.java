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
public class EmployeeUtil {

	public void generatePie(String path, List<Object[]> data) {

		// data should be converted to DataSet
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}

		// Data-set should be converted to JFreeChart
		// using ChartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("employee Type Mode", dataset, true, true, false);

		// JFreeChart should be converted to Image
		// using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/employeeA.jpg"), chart, 800, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generateBar(String path, List<Object[]> data) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Object[] adn : data) {
			dataset.setValue(new Double(adn[1].toString()), adn[0].toString(), path);
		}
		JFreeChart chart = ChartFactory.createBarChart("Employee Bar Chart", "Mode", "Chart", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/employeeB.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
