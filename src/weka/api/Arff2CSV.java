package weka.api;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;

public class Arff2CSV {

	public static void main(String args[]) throws Exception {

		ArffLoader loader = new ArffLoader();
		loader.setSource(new File("C:/Users/buse/Documents/weka data/supermarket.arff"));
		Instances data = loader.getDataSet();

		CSVSaver saver = new CSVSaver();
		saver.setInstances(data);
		saver.setFile(new File("C:/Users/buse/Desktop/denemeee.arff"));
		saver.writeBatch();
	}

}
