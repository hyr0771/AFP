package process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.ujmp.core.Matrix;

public class MyMain {

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
		boolean resultVisualization = false;
		int drawNpathways = 5;
		String graPhVizPath = "";
		int TimeLimit = 10;/////////////////
		int solutionNumber = 2000;

		boolean ifStart = false;//////////////////////////////////
		int numberOfTheMinimalAtomGroups = 2;

		boolean ifSpecies = true;///////////////////////////////////
		boolean ifCycle = false;///////////////////////////////////

		boolean saveConserved = true;
		boolean saveNonConserved = true;
		for (String line : lines) {
			String name = line.split(" +")[0].trim();
			String value = line.split(" +")[1].trim();
			if (name.equals("startCompound")) {
				if (value.contains("C")) {
					start = value;
					ifStart = true;///////////////////////////////////
				} else {
					start = "";
					ifStart = false;
				}
				
			}
			else if (name.equals("targetCompound")) {
				end = value;
			} 
			else if (name.equals("searchingStrategy")) {
				if (value.equals("conserved")) {
					saveConserved = true;
					saveNonConserved = false;
				} else {
					saveConserved = false;
					saveNonConserved = true;
				}
			} 
			else if (name.equals("numberOfTheMinimalAtomGroups")) {
				numberOfTheMinimalAtomGroups = Integer.parseInt(value);
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
		}

		System.out.println("---" + "start:" + start + " end:" + end + " searchingStrategy:" + saveConserved + "or" + saveNonConserved  +  
				" numberOfTheMinimalAtomGroups:" + numberOfTheMinimalAtomGroups
				+ " ifStart:" + ifStart + " ifSpecies:" + ifSpecies
				+ " TimeLimit:" + TimeLimit + " drawNpathways:" + drawNpathways + "----");

		long startTime = System.currentTimeMillis(); // 获取开始时间
		Process1 Process1 = new Process1();
		Process1.setParameter(start, end, k, numberOfTheMinimalAtomGroups, minPathLength, maxPathLength, saveTxtPath,
				savePicPath, resultVisualization, drawNpathways, ifStart, graPhVizPath, TimeLimit, ifCycle, ifSpecies, solutionNumber, saveConserved, saveNonConserved);
		Process1.start();
		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("Runing time：" + (endTime - startTime) + "ms");

	}

	public static void main(String[] args) {
		/**
		 * Remainder: Please install gurobi before running our code
		 */
		readPara(args);
	}
	
}
