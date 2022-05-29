package process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.ujmp.core.Matrix;

public class MyMain5 {

	public static void readPara(String[] args) {
		int zz = 0;
		String fileName = args[0];
		String content = FileUtils.readFileByLines(fileName);
		String[] lines = content.split("\n");
//		String host = "localhost";
//		String port = "3306";
//		String dbName = "fga";
//		String user = "root";
//		String password = "123456";
		String start = "";
		String end = "";
		int k = 2000;
		int minPathLength = 2;
		int maxPathLength = 15;
		boolean ifPreciseFindBranch = true;
		String saveTxtPath = "";
		String savePicPath = "";
//		boolean ifStartBySingle = false;
//		boolean ifInterset = true;
//		boolean ifAbundant = false;
		boolean resultVisualization = false;
		int drawNpathways = 5;
		String graPhVizPath = "";
//		double aLength = 0.5;
//		double aFreeEnergy = 0.1;
//		double aTransf = 0.2;
//		double aSim = 0.1;
//		double aPoints = 0.8;
		int TimeLimit = 10;/////////////////
		int solutionNumber = 2000;

		// 添加条件
		// 主要有四个条件
		// 1、有无起始化合物，通过控制ifStart
		// 2、是否使用原子团转移，通过使用minAtomGroupTransfer控制，为0表示不控制原子团转移
		// 3、是否追踪原子团转移，通过使用keepAtomgroupTransfer控制
		// 4、是否控制物种，通过使用ifSpecies控制，通过物种所包含的反应来控制
		boolean ifStart = false;//////////////////////////////////
		int conservedMinimalAtomGroups = 2;
		int nonConservedMinimalAtomGroups = 2;///////////////////////////////////

		boolean ifSpecies = true;///////////////////////////////////
		boolean ifCycle = false;///////////////////////////////////

		boolean saveConserved = true;
		boolean saveNonConserved = true;
		for (String line : lines) {
			String name = line.split(" +")[0].trim();
			String value = line.split(" +")[1].trim();
			if (name.equals("sourceCompound")) {
				start = value;
				ifStart = true;///////////////////////////////////
			}
			else if (name.equals("targetCompound")) {
				end = value;
			} 
			else if (name.equals("nonConservedMinimalAtomGroups")) {
				nonConservedMinimalAtomGroups = Integer.parseInt(value);
			} 
			else if (name.equals("conservedMinimalAtomGroups")) {
				conservedMinimalAtomGroups = Integer.parseInt(value);
			} 
			else if (name.equals("solutionNumber")) {
				solutionNumber = Integer.parseInt(value);
			} 
			else if (name.equals("timeLimit")) {
				TimeLimit = Integer.parseInt(value);
			}
			else if (name.equals("graphVizDirectory")) {
				resultVisualization = true;
				graPhVizPath = value;
			}
			else if (name.equals("drawNpathways")) {
				drawNpathways = Integer.parseInt(value);
			}
			else if (name.equals("resultDirectory")) {
				saveTxtPath = value;
				savePicPath = value;
			} 
//			else if (name.equals("keepAtomgroupTransfer")) {
//				keepAtomgroupTransfer =  true;
//			}
//			else if (name.equals("ifSpecies")) {
//				ifSpecies = true;
//			}
			
//			else if (name.equals("Bio")) {
//				ifBio = true;
//			}
//			else if (name.equals("Cycle")) {
//				ifCycle = true;
//			}
//			else if (name.equals("aT")) {
//				aTransf = Double.parseDouble(value);
//			} else if (name.equals("aS")) {
//				aSim = Double.parseDouble(value);
//			} else if (name.equals("aP")) {
//				aPoints = Double.parseDouble(value);
//			} else if (name.equals("k")) {
//				k = Integer.parseInt(value);
//			} 
//			else if (name.equals("searchingStrategy")) {
//				if (value.equals("non-conserved")) {
//					saveNonConserved = true;
//					saveConserved = false;
//				} else {
//					saveConserved = true;
//					saveNonConserved = false;
//				}
//			}
			
		}

		System.out.println("---" + "start:" + start + " end:" + end + " nonConservedMinimalAtomGroups:" + nonConservedMinimalAtomGroups
				+ " conservedMinimalAtomGroups:" + conservedMinimalAtomGroups + " ifStart:" + ifStart + " ifSpecies:" + ifSpecies
				+ " TimeLimit:" + TimeLimit + " searchingStrategy:" + saveConserved + "or" + saveNonConserved  + " drawNpathways:" + drawNpathways + "----");

		long startTime = System.currentTimeMillis(); // 获取开始时间
		Process1 Process1 = new Process1();
		Process1.setParameter(start, end, k, nonConservedMinimalAtomGroups, conservedMinimalAtomGroups, minPathLength, maxPathLength, saveTxtPath,
				savePicPath, resultVisualization, drawNpathways, ifStart, graPhVizPath, TimeLimit, ifCycle, ifSpecies, solutionNumber, saveConserved, saveNonConserved);
		Process1.start();
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("Runing time：" + (endTime - startTime) + "ms");

	}

	public static void main(String[] args) {
		readPara(args);
	}
	
	
//	public static void main(String[] args) {
//		FileUtils test = new FileUtils();
//		HashMap<String, String> keggname = new HashMap<String, String>();
//		keggname = test.getCompoundName();
//		Process1 test1 = new Process1();
//		
//		ArrayList<String> paths = new ArrayList<String>();
//		paths.add("C00092-->R00835-->C01236-->R02035-->C00345-->R01528-->C00199-->R01529-->C00231-->R01830-->C05345");
//		paths.add("C00881-->R02485-->C00526-->R02484-->C00672-->R01570-->C00214-->R01567-->C00364");
//		paths.add("C00197-->R01513-->C03232-->R04173-->C01005-->R00582-->C00065");
//		paths.add("C00062-->R00832-->C03296-->R04189-->C03415-->R04217-->C05932-->R05049-->C05931-->R00411-->C00025");
//		paths.add("C00148-->R01253-->C03912-->R00707-->C00025");
//		paths.add("C00065-->R00586-->C00979-->R00897-->C00097");
//		paths.add("C00881-->R02485-->C00526-->R02484-->C00672-->R02749-->C00673-->R01066-->C00118");
//		paths.add("C00092-->R00835-->C01236-->R02035-->C00345-->R01528-->C00199-->R01529-->C00231-->R01067-->C00085");
//		paths.add("C01037-->R03182-->C01909-->R01078-->C00120");
//		paths.add("C00158-->R01325-->C00417-->R01900-->C00311-->R01899-->C05379-->R00268-->C00026");
//		paths.add("C00062-->R00566-->C00179-->R01157-->C00134-->R01920-->C00315");
//		paths.add("C00114-->R01025-->C00576-->R02565-->C00719");
//		paths.add("C00267-->R01786-->C00668-->R00959-->C00103-->R00289-->C00029");
//		paths.add("C00049-->R01954-->C03406-->R01086-->C00122");
//		paths.add("C00022-->R00226-->C06010-->R05071-->C04181-->R04440-->C04272-->R04441-->C00141-->R01214-->C00183");
//		paths.add("C00074-->R01826-->C04691-->R03083-->C00944-->R03084-->C02637-->R02413-->C00493-->R02412-->C03175-->R03460-->C01269-->R01714-->C00251");
//		paths.add("C00109-->R08648-->C06006-->R05069-->C14463-->R05068-->C06007-->R05070-->C00671-->R02199-->C00407");
//		paths.add("C00118-->R05636-->C11437-->R05688-->C11434-->R05633-->C11435-->R05634-->C11436-->R05637-->C11453-->R08689-->C11811-->R05884-->C00129-->R01123-->C00235");
//		paths.add("C00188-->R00996-->C00109-->R08648-->C06006-->R05069-->C14463-->R05068-->C06007-->R05070-->C00671-->R02199-->C00407");
//		paths.add("C00251-->R00985-->C00108-->R01073-->C04302-->R03509-->C01302-->R03508-->C03506-->R02722-->C00078");
//		paths.add("C00279-->R01825-->C03393-->R04210-->C06054-->R05085-->C06055-->R05681-->C07335-->R07406-->C11638-->R05838-->C00627-->R00278-->C00018");
//		paths.add("C00183-->R01214-->C00141-->R01216-->C00966-->R02472-->C00522-->R02473-->C00864");
//		paths.add("C00333-->R01983-->C00558-->R02555-->C00817-->R01540-->C00204-->R01541-->C04442-->R05605-->C00022");
//		paths.add("C00880-->R03033-->C01216-->R03387-->C01286-->R01064-->C00118-->R01061-->C00236-->R01515-->C00197");
//		paths.add("C00333-->R01983-->C00558-->R02555-->C00817-->R01540-->C00204-->R01541-->C04442-->R05605-->C00118");
//		paths.add("C00049-->R01954-->C03406-->R01086-->C00062");
//		paths.add("C01279-->R03471-->C04556-->R04509-->C04752-->R03223-->C01081");
//		paths.add("C00191-->R01482-->C00905-->R02454-->C00514-->R05606-->C00204-->R01541-->C04442-->R05605-->C00022");
//		paths.add("C00025-->R00259-->C00624-->R02649-->C04133-->R03443-->C01250-->R02283-->C00437-->R00669-->C00077");
//		paths.add("C00036-->R00431-->C00074-->R00658-->C00631-->R01518-->C00197-->R01512-->C00236-->R01061-->C00118-->R01070-->C05378-->R04780-->C05345");
//		paths.add("C00251-->R01715-->C00254-->R01373-->C00166-->R00694-->C00079");
//		paths.add("C00251-->R01715-->C00254-->R01728-->C01179-->R00734-->C00082");
//		paths.add("C00267-->R01786-->C00668-->R02740-->C05345-->R04779-->C05378-->R01070-->C00118-->R01061-->C00236-->R01512-->C00197-->R01518-->C00631-->R00658-->C00074-->R00200-->C00022");
//		int count = 1;
//		for (String path : paths) {
//			String pathname = "pathway_" + String.valueOf(count);
//			ArrayList<String> onepath = new ArrayList<String>();
//			String[] compounds = path.split("-->");
//			String temp = "";
//			for (String c : compounds) {
//				if (c.contains("C")) {
//					temp += ("-->" + keggname.get(c));
//				} else {
//					temp += ("-->" + c);
//				}
//			}
//			System.out.println(count + "::" +temp.split("-->")[1] + " to " +  temp.split("-->")[temp.split("-->").length-1]);
//			onepath.add(temp.substring(3));
//			test1.savePathwayAsPic(onepath, pathname);
//			count++;
//		}
////		test1.savePathwayAsPic(keggname);
//		
//	}
	
//	public static void main(String[] args) {
//		FileUtils test = new FileUtils();
//		ArrayList<String> cofactor = test.getcofactorsList();
//		ArrayList<String> excluded = test.getExcludedMetabolitesList();
//		ArrayList<String> generic = test.getGenericMetabolitesList();
//		ArrayList<String> path = test.getPath("C:\\Users\\万志远\\Desktop\\研究生文件\\课题\\论文\\my\\contrast\\原始对比数据\\最终入选路径\\40条路径对应的KEGG-8R.txt");
////		for (String string : generic) {
////			System.out.println(string);
////		}
////		System.out.println(generic.size());
//		for (String p : path) {
//			String[] com = p.split(",");
//			for (String c : com) {
//				if (c.contains("C")) {
//					System.out.println(c);
//					if (cofactor.contains(c)) {
//						System.out.println("cofactor:" + c + " path:" + p);
//					} 
//					if (excluded.contains(c)) {
//						System.out.println("excluded:" + c + " path:" + p);
//					} 
//					if (generic.contains(c)) {
//						System.out.println("generic :" + c + " path:" + p);
//					}
//					
//				}
//			}
//		}
//	}
	
//	public static void main(String[] args) {
//		FileUtils test = new FileUtils();
//		HashMap<String, String> keggname = new HashMap<String, String>();
//		keggname = test.getCompoundName();
//		
//		ArrayList<String> path = new ArrayList<String>();
//		ArrayList<String> exist = new ArrayList<String>();
//		path.add("C00668-->R02740-->C05345-->R01827-->C00118");
//		path.add("C00668-->R02740-->C05345-->R04779-->C05378-->R01070-->C00118");
//		path.add("C00668-->R02740-->C05345-->R01830-->C00231-->R06861-->C00118");
//		path.add("C00668-->R02740-->C05345-->R01830-->C00231-->R01067-->C00118");
//		path.add("C00668-->R02740-->C05345-->R01830-->C00231-->R01641-->C00118");
//
//
//		path.add("C00668-->R02740-->C05345-->R01827-->C00118");
//		path.add("C00668-->R02740-->C05345-->R04779-->C05378-->R01070-->C00118");
//		path.add("C00668-->R02740-->C05345-->R04779-->C05378-->R01070-->C00111-->R01015-->C00118");
//		path.add("C00668-->R00959-->C00103-->R08639-->C00092-->R00771-->C00085-->R08575-->C00118");
//		path.add("C00668-->R02740-->C05345-->R01830-->C00279-->R01067-->C00085-->R08575-->C00118");
//		for (String p : path) {
//			String[] c = p.split("-->");
//			for (String string : c) {
//				if (!exist.contains(string) && string.contains("C")) {
//					exist.add(string);
//					System.out.println(string + ":"+keggname.get(string));
//				}
//				if (!exist.contains(string) && string.contains("R")) {
//					exist.add(string);
////					System.out.println(string);
//				}
//				
//			}
//		}
//	}
	
//	public static void main(String[] args) {
//		FileUtils test = new FileUtils();
////		ArrayList<String> rpairArrayList = test.getCarbonRpairData();
////		for (String string : rpairArrayList) {
////			System.out.println("arc::" + string + " size:" + string.length());
////		}
////		System.out.println(rpairArrayList.size());
//		
//		HashMap<String, String> temp = test.getAtomGroupInfo();
//		HashMap<String, String> atomGroupTransferNum = new HashMap<String, String>();
//		for (String string : temp.keySet()) {
//			if (Integer.parseInt(temp.get(string).split(" ")[4]) >= 1) {//this.minAtomGroupTransfer
//				atomGroupTransferNum.put(string, temp.get(string).split(" ")[4]);
//			}
//		}
//		ArrayList<String> reactionALL = test.getReactionAllList();
//		ArrayList<String> reactionColi = test.getSpeciesReactionList();
//		HashMap<String, String> reactionMap = test.getReactionMap();
//		
//		System.out.println("atomGroupTransferNum::" + atomGroupTransferNum.size() + " reactionALL::" + reactionALL.size() +
//				" reactionColi::" + reactionColi.size() + " reactionMap::" + reactionMap.size());
//
//		ArrayList<String> path = new ArrayList<String>();
//		path.add("C00158,C00311,R01324");
//		path.add("C00311,C00026,R00267");
//		path.add("C00026,C00091,R01197");
//		path.add("C00091,C00042,R00405");
//		
//		for (String dijr1 : path) {
//			System.out.println("--------------");
//			if (atomGroupTransferNum.containsKey(dijr1)) {
//				System.out.println("存在：" + dijr1 + "::" + atomGroupTransferNum.get(dijr1));
//			} else {
//				System.out.println("----------------------------------------------------------------------不存在：" + dijr1 + "::" + atomGroupTransferNum.get(dijr1));
//			}
//			
//			if (reactionMap.containsKey(dijr1.split(",")[2])) {
//				System.out.println("reactionMap::" + reactionMap.get(dijr1.split(",")[2]));
//			}
//			
//			if (reactionColi.contains(dijr1.split(",")[2])) {
//				System.out.println("存在reactionColi::" + dijr1.split(",")[2]);
//			} else {
//				System.out.println("-------------------------------------------------------------不存在reactionColi::" + dijr1.split(",")[2]);
//			}
//			
//			if (reactionALL.contains(dijr1.split(",")[2])) {
//				System.out.println("存在reactionALL::" + dijr1.split(",")[2]);
//			} 
//			String reactionReverse = "-"+dijr1.split(",")[2];
//			if (reactionALL.contains(reactionReverse)) {
//				System.out.println("存在可逆反应::" + reactionReverse);
//			} else {
//				System.out.println("----------不存在可逆反应::" + reactionReverse);
//			}
//			System.out.println("++++++++++++++++++");
//		}
//		
//	}
}
