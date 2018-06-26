package weka.api;

import weka.classifiers.functions.SMOreg;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class MakingPredictionsUsingRegression {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DataSource source=new DataSource("C:/Users/buse/Documents/weka data/cpu.arff");
		Instances trainDataSet=source.getDataSet();
		trainDataSet.setClassIndex(trainDataSet.numAttributes()-1);		
		
		SMOreg smOreg=new SMOreg();
		smOreg.buildClassifier(trainDataSet);
		System.out.println(smOreg);
		
		DataSource source1=new DataSource("C:/Users/buse/Documents/weka data/cpu-unknown.arff");
		Instances testDataSet=source1.getDataSet();
		testDataSet.setClassIndex(testDataSet.numAttributes()-1);
		
		System.out.println("------------------");
		System.out.println("Actual Class,     NB Predicted");
		
		for(int i=0; i<testDataSet.numInstances();i++) {
			double actualValue=testDataSet.instance(i).classValue();
			Instance newInst=testDataSet.instance(i);
			double predSMO=smOreg.classifyInstance(newInst);
			System.out.println(actualValue+" , "+ predSMO);
			
		}
		
	}
}
