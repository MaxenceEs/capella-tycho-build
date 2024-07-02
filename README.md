# Capella-tycho-build
- [Devops userguide](wiki/devops.md)
- [Developer userguide](wiki/developer.md)
- [Utils links](wiki/utils.md)
- [Glossary](wiki/glossary.md)

# Setup
* Download a `JDK`, and set environment variable `JAVA_HOME : C:\..path..\jdk`
* Download `Maven`, and set environmenet variable `MAVEN_HOME : C:\..path..\apache-maven`
* Set environment variable `PATH` to triggered each `bin` directory
    *  `PATH : %MAVEN_HOME%\bin`
    *  `PATH : %JAVA_HOME%\bin`

# Installation
* Clone this repository
* Download `Capella 6.1` software
* Modify the Capella relative path in file `root/releng/target-platform/capella-tp.target`
* Run the following Maven command on root `mvn clean verify`

# Architecture
* `root/pom.xml` -> Maven parent POM
* `root/.mvn/extension.xml` -> Allow to activate the tycho extension for Maven
* `root/features/max.capella.console.displayer.feature/feature.xml` -> Allow to create feature from plugin
* `root/plugins/max.capella.console.displayer` -> Simple plugin for test
* `root/releng/target-platform/capella-tp.target` -> Allow to define the target platform
* `root/releng/max.capella.product` -> Allow to build the product `capella.exe` for Windows

# Step by step
### Goals of each steps :
1. Activate the `Tycho` extension for Maven
2. Build the plugin as `JAR` (`max.capella.console.displayer.jar`)
3. Build the plugin as `Feature`
4. Build the Capella product (`capella.exe`) with embedded internal plugins
5. Build the Capella product (`capella.exe`) with embedded external plugins

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

### 3. Add the feature build and build
1. Create the feature `feature.xml` file in directory `root/features/max.capella.console.displayer.feature/`
2. Update the parent pom  by adding new module to build :
```xml
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

### 4. Add the product definition and build
1. Create the product `max.capella.product` file in directory `root/releng/max.capella.product/`
2. Add a child pom for the product
3. Update the parent pom by adding new module to build :
```xml
<modules>
    <module>plugins/max.capella.console.displayer</module>
    <module>features/max.capella.console.displayer.feature</module>
    <module>releng/max.capella.product</module>
 </modules>
```
By running the command `mvn clean verify` on the root, we get the following result :
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for releng 1.0.0-SNAPSHOT:
[INFO]
[INFO] releng ............................................. SUCCESS [  0.074 s]
[INFO] max.capella.console.displayer ...................... SUCCESS [  6.496 s]
[INFO] [feature] Max Capella Console Displayer Feature .... SUCCESS [  0.279 s]
[INFO] max.capella.tycho.build.product .................... SUCCESS [01:30 min]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:41 min
[INFO] Finished at: 2024-06-18T16:29:38+02:00
[INFO] ------------------------------------------------------------------------
```

Now the Capella product is well generated, and can be found at the following path : `root/releng/max.capella.product/target/products/`.  
The name of generated product is `tychorcpdemo-1.0-win32.win32.x86_64.zip`  
By unziping and launching the `capella.exe` file, the product is well launched.  
But there is still a problem, the product seems to not be complete.  

![](wiki/img/capella_product.png)


### 5. Add external plugins & viewpoints to the target platform & product
1. Download each external plugins & viewpoints `as UpdateSites`
2. Add each directory in the target platform `capella-tp.target` file in directory `root/releng/target-platform/`
    ```xml
    <!-- Local Update Site -->
    <location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
         <repository location="file:/C:/Software_Development/Capella_DevOps/External_addons/Filtering-updateSite-1.6.2"/>
         <unit id="org.polarsys.capella.filtering.feature.source.feature.group"/>
    </location>
    ```
3. Add each feature in the product  `max.capella.product` file in directory `root/releng/max.capella.product/`
     ```xml
    <features>
      <feature id="org.polarsys.capella.rcp.source" version="0.0.0"/>
      <feature id="max.capella.console.displayer.feature" version="0.0.0" installMode="root"/>
      <feature id="org.polarsys.capella.filtering.feature" version="0.0.0"/>
   </features>
     ```

By running the command `mvn clean verify` on the root, we get the following result :
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for releng 1.0.0-SNAPSHOT:
[INFO]
[INFO] releng ............................................. SUCCESS [  0.073 s]
[INFO] max.capella.console.displayer ...................... SUCCESS [  6.744 s]
[INFO] [feature] Max Capella Console Displayer Feature .... SUCCESS [  0.260 s]
[INFO] max.capella.tycho.build.product .................... SUCCESS [01:33 min]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:43 min
[INFO] Finished at: 2024-07-02T19:10:45+02:00
[INFO] ------------------------------------------------------------------------
```

Now the Capella product is well generated, with additionnal plugins.  

![](wiki/img/capella_product_with_updatesites.png)