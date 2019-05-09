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
public class ShipmentTypeUtil {

	public void generatePie(String path, List<Object[]> data) {

		// data should be converted to DataSet
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] ob : data) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}

		// Data-set should be converted to JFreeChart
		// using ChartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("Shipment Type Mode", dataset, true, true, false);

		// JFreeChart should be converted to Image
		// using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/shipmentA.jpg"), chart, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		//1.DATASET
				DefaultCategoryDataset setone=new  DefaultCategoryDataset();
				for(Object[] ob: data) {
					setone.setValue(new Double(ob[1].toString()), ob[0].toString(), path);
				}
				//2.use ChartFactory Using JFreeChart
				JFreeChart cchart=ChartFactory.createBarChart("ShipmentType Bar Chart Report", "Mode", "Chount", setone, PlotOrientation.VERTICAL, true, true, false);
				
				//3. ChartUtils save as Image
				try {
					ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/shipmentB.jpg " ), cchart, 400, 400);
				}catch(IOException e) {
					e.printStackTrace();
				}
	}
	
}
