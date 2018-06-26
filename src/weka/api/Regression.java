package weka.api;

import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SMOreg;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Regression {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSource source= new DataSource("C:/Users/buse/Documents/weka data/iris.arff");
		Instances dataSet=source.getDataSet();
		dataSet.setClassIndex(dataSet.numAttributes()-1);
		
	/*	LinearRegression lRegression=new LinearRegression();
		lRegression.buildClassifier(dataSet);
		System.out.println(lRegression);*/
		
		SMOreg smOreg=new SMOreg();
		smOreg.buildClassifier(dataSet);
		System.out.println(smOreg);
	}
}
