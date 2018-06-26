package weka.api;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.bayes.NaiveBayes;



public class ClassifyInstance {
	public static void main(String args[]) throws Exception {
		DataSource source = new DataSource("C:/Users/buse/Documents/weka data/iris.arff");
		Instances trainDataSet = source.getDataSet();
		trainDataSet.setClassIndex(trainDataSet.numAttributes() - 1);

		int numClasses = trainDataSet.numClasses();

		for (int i = 0; i < numClasses; i++) {
			String classValue = trainDataSet.classAttribute().value(i);
			System.out.println("Class Value" + i + " is " + classValue);
		}

		NaiveBayes nBayes = new NaiveBayes();
		nBayes.buildClassifier(trainDataSet);

		DataSource source1 = new DataSource("C:/Users/buse/Documents/weka data/iris-unknown.arff");
		Instances testDataSet = source1.getDataSet();
		testDataSet.setClassIndex(testDataSet.numAttributes() - 1);

		System.out.println("===========================");
		System.out.println("Actual Class, NB Predicted");
		for (int i = 0; i < testDataSet.numInstances(); i++) {
			double actualClass = testDataSet.instance(i).classValue();
			String actual = testDataSet.classAttribute().value((int) actualClass);
			Instance newInst = testDataSet.instance(i);
			double predNB = nBayes.classifyInstance((Instance) newInst);
			String predString = testDataSet.classAttribute().value((int) predNB);
			System.out.println(actual + " ,  " + predString);

		}
	}
}
