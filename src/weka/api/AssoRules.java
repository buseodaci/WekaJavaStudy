package weka.api;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AssoRules {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String dataset="C:/Users/buse/Documents/weka data/weather.nominal.arff";
		DataSource source=new DataSource(dataset);
		Instances data= source.getDataSet();
		Apriori model=new Apriori();
		model.buildAssociations(data);
		System.out.println(model);
		
		
	}

}
