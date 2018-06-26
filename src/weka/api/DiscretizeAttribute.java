package weka.api;


import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

public class DiscretizeAttribute {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSource source=new DataSource("C:/Users/buse/Documents/weka data/ornekData.arff");
		Instances dataset=source.getDataSet();
		
		String[] options=new String[4];
		options[0]="-B";
		options[1]="4";
		options[2]="-R";//tüm kolonlar
		options[3]="first";
		
		Discretize discretize=new Discretize();
		discretize.setOptions(options);
		discretize.setInputFormat(dataset);
		Instances newData=Filter.useFilter(dataset,discretize);
		ArffSaver saver=new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("C:/Users/buse/eclipse-workspace/weka-api/discretizeAttribute.arff"));
		saver.writeBatch();
	}
}
