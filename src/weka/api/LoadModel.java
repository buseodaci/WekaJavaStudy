package weka.api;

import weka.classifiers.functions.SMOreg;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class LoadModel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SMOreg smOreg=(SMOreg) SerializationHelper.read("my_smo_model.model");
		DataSource source=new DataSource("C:/Users/buse/Documents/weka data/cpu-unknown.arff");
		Instances testDataSet=source.getDataSet();
		testDataSet.setClassIndex(testDataSet.numAttributes()-1);
		double actualValue= testDataSet.instance(0).classValue();
		Instance newInst= testDataSet.instance(0);
		double predSMO=smOreg.classifyInstance(newInst);
		System.out.println(actualValue+" , "+predSMO);
		

	}

}
