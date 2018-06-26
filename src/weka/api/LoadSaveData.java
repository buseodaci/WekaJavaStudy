package weka.api;

import java.io.File;
import java.io.FileReader;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.BufferedReader;

public class LoadSaveData {
	public static void main(String args[]) throws Exception {
		 System.out.print("Hello Weka");
		 
		 Instances dataset=new Instances(new BufferedReader(new FileReader("C:/Users/buse/Documents/weka data/supermarket.arff")));
		 System.out.println(dataset.toSummaryString());
		
		 ArffSaver saver=new ArffSaver();
		 saver.setInstances(dataset);
		 saver.setFile(new File("C:/Users/buse/Desktop/denemee.arff"));
		 saver.writeBatch();
	 }
}
