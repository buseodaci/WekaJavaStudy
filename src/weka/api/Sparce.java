package weka.api;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;

public class Sparce {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DataSource source=new DataSource("C:/Users/buse/Documents/weka data/cpu.arff");
		Instances dataset=source.getDataSet();
		NonSparseToSparse sp=new NonSparseToSparse();
		sp.setInputFormat(dataset);
		
		Instances newData=Filter.useFilter(dataset, sp);
		ArffSaver saver=new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("C:/Users/buse/eclipse-workspace/weka-api/sparce.arff"));
		saver.writeBatch();
	}
}
