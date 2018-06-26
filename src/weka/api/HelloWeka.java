package weka.api;

import java.io.File;
//import java.io.FileReader;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;

public class HelloWeka {
 public static void main(String args[]) throws Exception {
	 System.out.print("Hello Weka");
	// DataSource source=new DataSource("C:/Users/buse/Documents/weka data/supermarket.arff");
//	 Instances dataset=source.getDataSet();
	 
//	 Instances dataset=new Instances(new BufferedReader(new FileReader("C:/Users/buse/Documents/weka data/supermarket.arff")));
	 
	 
	 ArffLoader loader=new ArffLoader();
	 loader.setSource(new File("C:/Users/buse/Documents/weka data/supermarket.arff"));
	 Instances data=loader.getDataSet();
	 
	 CSVSaver saver= new CSVSaver();
	 saver.setInstances(data);
	 saver.setFile(new File("C:/Users/buse/Desktop/denemeee.arff"));
	saver.writeBatch();
	 
//	 System.out.println(dataset.toSummaryString());
	 
//	 ArffSaver saver=new ArffSaver();
	// saver.setInstances(dataset);
	// saver.setFile(new File("C:/Users/buse/Desktop/denemee.arff"));
	//	 saver.setFile(new File("C:/Users/buse/Desktop/Documents/weka data/denemee.arff"));
	 //saver.writeBatch();
 }
}
