package weka.api;

import weka.classifiers.functions.SMOreg;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class SaveModel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSource source = new DataSource("C:/Users/buse/Documents/weka data/cpu.arff");
		Instances trainDataSet = source.getDataSet();
		trainDataSet.setClassIndex(trainDataSet.numAttributes() - 1);
		SMOreg smOreg = new SMOreg();
		smOreg.buildClassifier(trainDataSet);
		System.out.println(smOreg);
		SerializationHelper.write("my_smo_model.model", smOreg);
	}
}
