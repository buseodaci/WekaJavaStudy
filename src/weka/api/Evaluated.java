package weka.api;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Evaluated {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSource source=new DataSource("C:/Users/buse/Documents/weka data/ornekData.arff");
		Instances dataSet=source.getDataSet();
		dataSet.setClassIndex(dataSet.numAttributes()-1);
		
		J48 tree= new J48();
		tree.buildClassifier(dataSet);
		
		Evaluation eval=new Evaluation(dataSet);
		Random random=new Random();
		int folds=2;
				
		DataSource source1=new DataSource("C:/Users/buse/Documents/weka data/ornekData.arff");
		Instances testDataSet= source1.getDataSet();
		testDataSet.setClassIndex(testDataSet.numAttributes()-1);
	//	eval.evaluateModel(tree,  testDataSet);
		eval.crossValidateModel(tree, testDataSet, folds, random);
		System.out.println(eval.toSummaryString("Evaluation  results:\n",false));
		
		System.out.println("Correct %= "+eval.pctCorrect());
		System.out.println("InCorrect %= "+eval.pctIncorrect());
		System.out.println("AUC %= "+eval.areaUnderPRC(1));
		System.out.println("kappa %= "+eval.kappa());
		System.out.println("MAE %= "+eval.meanAbsoluteError());
		System.out.println("RMSE %= "+eval.rootMeanSquaredError());
		System.out.println("RRSE %= "+eval.rootRelativeSquaredError());
		System.out.println("Precision %= "+eval.precision(1));
		System.out.println("Recall %= "+eval.recall(1));
		System.out.println("fmeasure %= "+eval.fMeasure(1));
		System.out.println("Error rate %= "+eval.errorRate());
			
		System.out.println(eval.toMatrixString()+"=== Overall Confusion Matrix ===\n");
	}

}
