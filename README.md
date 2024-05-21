# Capella-tycho-build
- [Devops userguide](wiki/devops.md)
- [Developer userguide](wiki/developer.md)
- [Utils links](wiki/utils.md)
- [Glossary](wiki/glossary.md)

# Architecture

* `root/pom.xml` -> Maven parent POM
* `root/.mvn/extension.xml` -> Allow to activate the tycho extension for Maven
* `root/features/max.capella.console.displayer.feature/feature.xml` -> Allow to create feature from plugin
* `root/plugins/max.capella.console.displayer` -> Simple plugin for test
* `root/releng/target-platform/capella-tp.target` -> Allow to define the target platform
* ~~`root/releng/max.capella.product`~~ -> Allow to build the product `capella.exe` for Windows

# Step by step
### Goals of each steps :
1. Activate the `Tycho` extension for Maven
2. Build the plugin as `JAR` (`max.capella.console.displayer.jar`)
3. Build the plugin as `Feature`
4. ~~Build the Capella product with embedded plugins (`capella.exe`)~~ -> Step failed

### 1. Activate the tycho extension for Maven and create parent POM
1. Create the `extension.xml` file in directory `root/.mvn/`
2. Create the parent `pom.xml` file in directory `root/`

By running the command `mvn clean verify` on the root, we get the following result :
```
[INFO] -------------------< max.capella.tycho.build:releng >-------------------
[INFO] Building releng 1.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] --- clean:3.2.0:clean (default-clean) @ releng ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.821 s
[INFO] Finished at: 2024-05-16T14:41:27+02:00
[INFO] ------------------------------------------------------------------------
```

### 2. Add a plugin, target platform, POM files and build the JAR
1. Create the plugin in directory `root/plugins/max.capella.console.displayer/`
2. Create the target platform `capella-tp.target` file in directory `root/releng/target-platform/`
3. Create the plugin `pom.xml` file in directory `root/plugins/max.capella.console.displayer/`

By running the command `mvn clean verify` on the root, we get the following result :
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for releng 1.0.0-SNAPSHOT:
[INFO]
[INFO] releng ............................................. SUCCESS [  0.126 s]
[INFO] max.capella.console.displayer ...................... SUCCESS [ 10.015 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  16.402 s
[INFO] Finished at: 2024-05-16T15:39:20+02:00
[INFO] ------------------------------------------------------------------------
```

### 3. Add the feature build
1. Create the feature `feature.xml` file in directory `root/features/max.capella.console.displayer.feature/`
2. Update the parent pom  by adding new module to build :
```
<modules>
    <module>plugins/max.capella.console.displayer</module>
    <module>features/max.capella.console.displayer.feature</module>
 </modules>
```
By running the command `mvn clean verify` on the root, we get the following result :
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for releng 1.0.0-SNAPSHOT:
[INFO]
[INFO] releng ............................................. SUCCESS [  0.000 s]
[INFO] max.capella.console.displayer ...................... SUCCESS [ 10.720 s]
[INFO] [feature] Max Capella Console Displayer Feature .... SUCCESS [  0.699 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  17.019 s
[INFO] Finished at: 2024-05-21T16:09:14+02:00
[INFO] ------------------------------------------------------------------------
```