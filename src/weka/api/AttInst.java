package weka.api;

import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.Stats;

public class AttInst {
	public static void main(String argfs[]) throws Exception {
		DataSource source=new DataSource("C:/Users/buse/Documents/weka data/ornekData.arff");
		Instances data = source.getDataSet();

		if (data.classIndex() == -1) {
			data.setClassIndex(data.numAttributes() - 1);
		}
		int numAttr = data.numAttributes() - 1;

		for (int i = 0; i < numAttr; i++) {
			if (data.attribute(i).isNominal()) {
				System.out.println("The" + i + " th Attribute is Nominal");
				int n = data.attribute(i).numValues();
				System.out.print("The" + i + " th Attribute has: " + n + " values");
			}

			AttributeStats as = data.attributeStats(i);
			int dC = as.distinctCount;
			System.out.println("The" + i + " the Attribute has: " + dC + " distinct values");

			if (data.attribute(i).isNumeric()) {
				System.out.println("The " + i + " th Attribuute is Numeric");
				Stats s = as.numericStats;
				System.out.println("The " + i + " th Attribute has min value: " + s.min + " and max value: " + s);
			}
		}

		int numInst = data.numInstances();
		for (int j = 0; j < numInst; j++) {
			Instance instance = data.instance(j);
			if (instance.isMissing(0)) {
				System.out.println("The " + 0 + " th Attribute is missing");

			}
			if(instance.classIsMissing()) {
				System.out.println("The class is missing in  the "+ j+" the instance");
			}
			
			double cV=instance.classValue();
			System.out.println(instance.classAttribute().value((int) cV));
		}
	}
}
