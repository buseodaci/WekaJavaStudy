package weka.api;

import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Remove;

public class ClassifierWithFilter {

	public static void main(String args[]) throws Exception{
		DataSource source=new DataSource ("C:/Users/buse/Documents/weka data/ornekData.arff");
		Instances dataset=source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
	
		J48 tree=new J48();
		Remove remove=new Remove();
		String[] options=new String[] {"-R", "1"};
		remove.setOptions(options);
		
		FilteredClassifier fClassifier= new FilteredClassifier();
		fClassifier.setFilter(remove);
		fClassifier.setClassifier(tree);
		fClassifier.buildClassifier(dataset);
		System.out.print(tree.graph());
	}	
}
