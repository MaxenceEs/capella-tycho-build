# Capella-tycho-build
- [Devops userguide](wiki/devops.md)
- [Developer userguide](wiki/developer.md)
- [Utils links](wiki/utils.md)
- [Glossary](wiki/glossary.md)
- [Step by step](wiki/step_by_step.md)

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

# Product content
The list of installed plugins is the following :
* Capella RCP
* Eclipse
    * EGit
    * SVN
* Capella
    * DocGen (XHTML)
    * VP Filtering
    * VP System to Subsystem (SSS)
    * VP Requirements
    * VP Modes & States (VP MS)
    * Textual Editor
* Thales
    * DiagramStyler (DS)
    * PVMT (VPD)
* Obeo
    * M2Doc