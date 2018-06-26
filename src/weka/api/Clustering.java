package weka.api;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Clustering {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DataSource source=new DataSource("C:/Users/buse/Documents/weka data/weather.nominal.arff");
		Instances data=source.getDataSet();
		
		SimpleKMeans model=new SimpleKMeans();
		model.setNumClusters(4);
		model.buildClusterer(data);
		System.out.println(model);
		
		ClusterEvaluation clusterEvaluation=new ClusterEvaluation();
		DataSource source1=new DataSource("C:/Users/buse/Documents/weka data/weather.nominal.arff");
		Instances data1= source1.getDataSet();
		clusterEvaluation.setClusterer(model);
		clusterEvaluation.evaluateClusterer(data1);
		System.out.println("# of clusters: "+clusterEvaluation.getNumClusters());
	
	}

}
