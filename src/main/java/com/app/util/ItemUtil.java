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
public class ItemUtil {

	public void generatePie(String path, List<Object[]> data) {

		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		JFreeChart chart = ChartFactory.createPieChart3D("Item Pi Chart", dataset, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/ione.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DefaultCategoryDataset dataseet = new DefaultCategoryDataset();
		for (Object[] obb : data) {
			dataseet.setValue(new Double(obb[1].toString()), obb[0].toString(), path);
		}
		JFreeChart charrt = ChartFactory.createBarChart("Item Bar CHart", "Mode", "Chart", dataseet,
				PlotOrientation.VERTICAL, true, true, false);

		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/itwo.jpg"), charrt, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
