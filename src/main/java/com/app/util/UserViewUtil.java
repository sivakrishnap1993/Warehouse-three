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
public class UserViewUtil {

	public void generatePie(String path, List<Object[]> data) {

		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}

		JFreeChart chart = ChartFactory.createPieChart3D("User Pi Dataset", dataset, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/user.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void generateBar(String path, List<Object[]> data) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (Object[] od : data) {
			dataset.setValue(new Double(od[1].toString()), od[0].toString(), path);
		}
		JFreeChart chart = ChartFactory.createBarChart("User Bar Chart", "Mode", "Chart", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/userpage.jpg "), chart, 400, 400);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
