# AFP
**AFP**(**A**tom-group **F**lux **P**athfinder) is a method to find metabolic pathways through atom group tracking. AFP incorporates the movements of atom group into the reaction stoichiometry to construct MILP model to search the pathways containing atom groups exchange in the reactions and adapts the stoichiometric MILP model to provide the options of searching pathways from an arbitrary or given compound to a target compound. For a given target compound, our pathfinding method AFP identifies the metabolic pathways that convert the user-defined or arbitrary source compound to the target compound through three main steps: **First**, We use the reactions that transfer atom groups between substrates and products to construct atom group transfer network. **Then**, we combine the reaction stoichiometry with the atom group exchanged within reactions to construct a MILP model based on the atom group transfer network. **Finally**, we solve the objective function of the constructed MILP model to find the linear pathways that start from the user-defined or arbitrary compound to the target compounds by tracking the motion of atom groups in the built atom group transfer network. 

# Requirements and installation
1. AFP was written and tested on Java with version "1.8.0_201" and Gurobi Optimizer with version "9.0.3". **Java with version "1.8.0_201"(or higher) and Gurobi Optimizer with version "9.0.3"(or higher)** need to be installed to work with AFP.
2. AFP constructed a MILP model based on the atom group transfer network and GUROBI is required to solve the MILP model. 
3. The data required for AFP program to find pathways are prepared in the directory of data

# Download data and program
AFP program is packaged as a JAR bundle called AFP.jar. To provide ease of use, user can download **AFP.jar** to run AFP with command line(see detail in <a  href="#1">Usage Example</a>). 
The data required for running AFP is also packaged in AFP.jar(see detail in <a  href="#2">Data organization</a>). The sample configure file **"config.txt"** is a sample for adjusting the running parameters of AFP(see detail in <a  href="#3">Running parameters</a>).

# Usage Example
<a name="1">User can run AFP by one command line as follows:</a>

```java -jar (the directory of AFP.jar) (the directory of configure file) ```

**the directory of AFP.jar** is the directory of "AFP.jar".

**the directory of configure file** is the directory of the configure file.

For example: ```java -jar D:\\AFP.jar D:\\config.txt ```
And the Search results are in "resultDirectory" which is specified by user in "config.txt". Note that AFP.jar must be in the same directory as the folder lib and replace the locally installed gurobi.jar with the gurobi.jar in the file Lib.

# Data organization

<a name="2">The directory of data contains the following directories and files:</a>

```
reaction.txt: the detail information of reaction.

compoundName.txt: the list of KEGG ID and metabolite name.

startMetabolitesList.txt: the list of starting metabolites.

reactions-atomgroupcount.txt: the detail information of the atom group transfer.

mol.rar: contains the prepared files of the compound dataset.
```

# Running parameters
<a name="3">User can use configure file to adjust the running patameters of AFP, and the following table is the specific contents of "config.txt"</a>
| Option | Description | Default value |
| -----  | ------| ----|
| sourceCompound | Source compound in KEGG format | Optional |
| targetCompound | Target compound in KEGG format | Required |
| nonConservedMinimalAtomGroups | Number of the minimal atom groups simply exchanged between the compounds of reactions | 2 |
| conservedMinimalAtomGroups | Number of the minimal atom groups transferred from the start to target compounds | 2 |
| solutionNumber | Number of solutions to keep in solution pool | 2000 | 
| timeLimit | Limits the total time expended (in seconds) | 1000 |
| graphVizDirectory | The directory of graphViz "dot.exe" file, users should install the graphViz. | D:\graphviz\bin\dot.exe |
| drawNpathways | N pathways to be shown in the figure | 5 |
| resultDirectory | The directory of searching results, users can find the running results of the program in this directory. | D:\results\ |





