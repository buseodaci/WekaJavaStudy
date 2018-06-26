package weka.api;


import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class AttributeFilter  {
// load dataset
	public static void main(String args[]) throws Exception{
		DataSource source=new DataSource ("C:/Users/buse/Documents/weka data/ornekData.arff");
		Instances dataset=source.getDataSet();
	//	System.out.println(dataset.toSummaryString());
		
		String[] opts=new String[] {"-R", "1"};
		Remove remove =new Remove();
		remove.setOptions(opts);
		remove.setInputFormat(dataset);
		Instances newData=Filter.useFilter(dataset, remove);
		

		ArffSaver saver=new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("C:/Users/buse/Desktop/Documents/weka data/denemeee.arff"));
		saver.writeBatch();
		System.out.println(newData);
	}
	}
