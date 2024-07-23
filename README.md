# Capella-tycho-build

## Overview
This project allows to build automatically a Capella distribution, with additionnal content.  
The automatic build is performed by `Maven` and `Tycho`.  
* `Maven` allows to build Java projects and manage dependencies from Maven format (*pom.xml*)  
* `Tycho` allows to build Eclipse products and manage dependencies from P2 format (*content.jar*, *p2.index*)  

The additional content is defined in a `.product` file  
The target platform is defined in a `.target` file  

## Setup
* Download a `JDK`, and set environment variable `JAVA_HOME : C:\..path..\jdk`
* Download `Maven`, and set environmenet variable `MAVEN_HOME : C:\..path..\apache-maven`
* Set environment variable `PATH` to triggered each `bin` directory
    *  `PATH : %MAVEN_HOME%\bin`
    *  `PATH : %JAVA_HOME%\bin`
* It's mandatory to have an access to `Maven` & `P2` repositories (internet access, or local mirror, or server mirror)

## Installation
* Clone this repository
* Fix paths in target files `root/releng/target-platform/*.target` *(Optionnal)*  
* Run the following Maven command on root `mvn clean verify`

## Sequence
```uml
@startuml
start
:Build modules;
:Configure Target Platform;
:Create the Product;
:Create the Dropins folder;
:Package the Product;
stop
@enduml
```

## Architecture
* `root/pom.xml` -> Maven parent POM
* `root/.mvn/extension.xml` -> Allow to activate the tycho extension for Maven
* `root/features/max.capella.console.displayer.feature/feature.xml` -> Allow to create feature from plugin
* `root/plugins/max.capella.console.displayer` -> Simple plugin for test
* `root/releng/target-platform/capella-tp.target` -> Allow to define the target platform
* `root/releng/max.capella.product` -> Allow to build the product `capella.exe` for Windows

## Documentation
- [Devops userguide](wiki/devops.md)
- [Developer userguide](wiki/developer.md)
- [Utils links](wiki/utils.md)
- [Glossary](wiki/glossary.md)
- [Step by step](wiki/step_by_step.md)
- [How to create .target file]()
- [How to create .product file]()
- [How to mirror P2 repositories]()

## Product content
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

