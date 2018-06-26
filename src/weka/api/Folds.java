package weka.api;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Folds {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSource source = new DataSource("C:/Users/buse/Documents/weka data/iris.arff");
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes() - 1);

		NaiveBayes nBayes = new NaiveBayes();

		int seed = 1;
		int folds = 15;

		Random random = new Random(seed);

		Instances randData = new Instances(dataset);
		randData.randomize(random);

		if (randData.classAttribute().isNominal())
			randData.stratify(folds);

		for (int n = 0; n < folds; n++) {
			Evaluation evaluation = new Evaluation(randData);
			Instances train = randData.trainCV(folds, n);
			Instances test = randData.testCV(folds, n);
			nBayes.buildClassifier(train);
			evaluation.evaluateModel(nBayes, test);

			System.out.println();
			System.out.println(evaluation.toMatrixString("===Confusion matrix for fold" + (n + 1) + "/" + folds + "==="));
			System.out.println("Correct %= " + evaluation.pctCorrect());
			System.out.println("InCorrect %= " + evaluation.pctIncorrect());
			System.out.println("AUC %= " + evaluation.areaUnderPRC(1));
			System.out.println("kappa %= " + evaluation.kappa());
			System.out.println("MAE %= " + evaluation.meanAbsoluteError());
			System.out.println("RMSE %= " + evaluation.rootMeanSquaredError());
			System.out.println("RRSE %= " + evaluation.rootRelativeSquaredError());
			System.out.println("Precision %= " + evaluation.precision(1));
			System.out.println("Recall %= " + evaluation.recall(1));
			System.out.println("fmeasure %= " + evaluation.fMeasure(1));
			System.out.println("Error rate %= " + evaluation.errorRate());

		}
	}

}
