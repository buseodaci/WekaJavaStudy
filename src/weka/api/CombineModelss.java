package weka.api;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.Bagging;
import weka.classifiers.meta.Stacking;
import weka.classifiers.meta.Vote;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.trees.RandomTree;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class CombineModelss {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String data="C:/Users/buse/Documents/weka data/weather.nominal.arff";
		DataSource source=new DataSource(data);
		Instances trainingData=source.getDataSet();
		
		if(trainingData.classIndex()==-1) {
			trainingData.setClassIndex(trainingData.numAttributes()-1);
		}
		
		
		//AdaBoost
		AdaBoostM1 m1=new AdaBoostM1();
		m1.setClassifier(new DecisionStump());
		m1.setNumIterations(20);
		m1.buildClassifier(trainingData);
		
		//Bagging
		Bagging bagger=new Bagging();
		bagger.setClassifier(new RandomTree());
		bagger.setNumIterations(25);
		bagger.buildClassifier(trainingData);
		
		//Stacking
		Stacking stacker=new Stacking();
		stacker.setMetaClassifier(new J48());
		Classifier[] classifiers= {
				new J48(),
				new NaiveBayes(),
				new RandomForest()
		};
		stacker.setClassifiers(classifiers);
		stacker.buildClassifier(trainingData);
		
		//Vote
		Vote voter=new Vote();
		voter.setClassifiers(classifiers);
		voter.buildClassifier(trainingData);
		System.out.println(voter);
	}

}
