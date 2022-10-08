# AFP
**AFP** (**A**tom-group **F**lux **P**athfinder) is a stoichiometry method to find metabolic pathways via atom group tracking. AFP incorporates the movements of atom group into the reaction stoichiometry to construct MILP model to search the pathways containing atom group exchange in the reactions and adapts the stoichiometric MILP model to provide the options of searching pathways from an arbitrary or given compound to a target compound. For a given target compound, our method AFP identifies the metabolic pathways that convert the user-defined or arbitrary start compound to the target compound via three main steps: We first use the reactions that transfer atom groups between substrates and products to construct atom group transfer network. Then, we combine the reaction stoichiometry with the atom group exchanged within reactions to construct a MILP model based on the atom group transfer network. Finally, we solve the objective function of the constructed MILP model to find the linear pathways that start from the user-defined or arbitrary compound to the target compounds by tracking the motion of atom groups in the built atom group transfer network.

# Requirements and installation
AFP was written and tested on Java with version "1.8.0_201" and GUROBI Optimizer with version "9.0.3". **GUROBI Optimizer with version "9.0.3"** is required to be installed to run with AFP.

# Download program and data
The program of AFP model was packaged as a JAR bundle called AFP.jar. The user can download **AFP.jar** to run AFP with command line (see <a  href="#1">Usage Example</a> for details). The data for running AFP were also packaged in AFP.jar. The configure file “config.txt” is a sample configure file for AFP (see <a  href="#2">Running parameters</a> for details).

# Usage Example
1. Please install GUROBI before running our program AFP!!!
2. AFP.jar **requires** the files **“gurobi.jar”** and **“ujmp-complete-0.2.5.jar”** in the folder **“lib” of the directory of AFP on Github**. The user **should download** the directory of AFP (including the folder “lib” and AFP.jar) on Github to run AFP.jar. On the GitHub page of AFP, you can click the button “code”-> ”Download ZIP” to download the directory of AFP.
3. After downloading the directory of AFP on Github (AFP.jar should be in the same directory as the folder “lib”), the user can run AFP to find metabolic pathways by the following command line:

java -jar (the directory of AFP.jar) (the directory of configure file)

**For example**: 
java -jar D:\\AFP-master\\AFP.jar D:\\AFP-master\\config.txt 

The search results can be found in "resultDirectory". This "resultDirectory" can be specified by the user in the configure file. 

**Note that:**
Here we also provide four sample configure files AFP-S-NT.txt, AFP-S-T.txt, AFP-NS-NT.txt, AFP-NS-T.txt for four searching modes: AFP-S-NT, AFP-S-T, AFP-NS-NT, AFP-NS-T.

**AFP-S-NT** searches the pathways containing non-conserved atom group exchange in the reactions from given start to target compounds. 

**AFP-S-T** searches the pathways transferring conserved atom groups from the given start to target compounds. 

**AFP-NS-NT** searches the pathways containing non-conserved atom group exchange in the reactions from an arbitrary start compound to given target compound.

**AFP-NS-T** searches the pathways transferring conserved atom groups from an arbitrary start compound to given target compound.


# Running parameters
<a name="2">The user can use configure file to specify the running parameters of AFP and the following table shows the illustration for specifying configure file.</a>
| Option | Description | Default value |
| -----  | ------| ----|
| startCompound | Start compound in KEGG compound ID. You can specify the start compound here in KEGG compound ID such as **C00022**, then AFP will search the pathways from the given start to target compounds. If the user wants to search the pathways from an arbitrary start compound to given target compound, you can specify the startCompound as: **arbitrary**. | Required |
| targetCompound | Target compound in KEGG compound ID such as **C00183**. | Required |
| searchingStrategy | For this parameter, three searching strategies for tracking atom group can be chosen: **non-conserved**, **conserved**, **default**. The non-conserved/default strategy means that AFP searches the pathways containing non-conserved atom group exchange in the reactions. The conserved strategy means that AFP searches the pathways transferring conserved atom groups from the start to target compounds. | default |
| numberOfTheMinimalAtomGroups | The number of the minimal atom groups transferred in the reactions of the pathway. | 2 |
| solutionNumber | Number of solutions kept in the solution pool | 2000 | 
| timeLimit | Time limit for searching pathways (in seconds) | 200 |
| graphVizDirectory | The directory of graphViz "dot.exe" file. The user can visualize the resulting pathways by graphViz and you need to install the graphViz to get the visualized resulting pathways. You can find the file dot.exe in the setup directory "bin" of your graphViz. The file dot.exe can also be found along with AFP.jar here. | D:\\graphviz\\bin\\dot.exe |
| drawNpathways | Number of the visualized resulting pathways | 5 |
| resultDirectory | The directory of searching results, the user can find the resulting pathway files in this directory. The resulting pathways can be visualized by graphViz, and the user can use graphViz to open resulting pathway file to see the visualization of resulting pathways. | D:\\results\\ |
