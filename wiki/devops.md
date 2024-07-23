# Devops userguide
## How to create XXX environments
* IDE - [Eclipse RCP 2024-03](https://www.eclipse.org/downloads/packages/release/2024-03/r/eclipse-ide-rcp-and-rap-developers)
* TP - [Capella 6.1](https://download.eclipse.org/capella/core/products/releases/6.1.0/)

## How to create .target and .product files
Create a file "*.target"
Open an Eclipse IDE
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<?pde version="3.8"?>
<target name="capella-core">
    <locations>
        <location>
        <location>
    </locations>
</target>
```

```xml
<location path="C:\Software_Development\Capella_DevOps\Capella_6.1.0\capella" type="Directory"/>
```

```xml
<location includeAllPlatforms="false" includeConfigurePhase="true" includeMode="planner" includeSource="true" type="InstallableUnit">
	<repository id="VP-Filtering-1.6.2" location="file:/C:/LOCAL/PATH/Filtering-updateSite-1.6.2"/>
	<unit id="org.polarsys.capella.filtering.feature.source.feature.group"/>
</location>
```

For the path, if the location is a local folder/file, so the location should start with `"file:/"`, and the path should be absolute (relative path doesn't work).

Needs :
* Java
* Maven
* Nexus
    * Tycho (& dependencies)
    * P2 Externals updatesites


## How to mirror P2 repositories  
Some P2 repositories are available only on remote sites.  
It could be usefull to mirror remote P2 repositories on your local machine or on a Nexus repository.  
It's particularly usefull if you have a slow connection, or if your have to work offline.

To perform the mirroring of a remote P2 repository, run the two following commands :
```powershell
<eclipse_install_dir>/eclipse -nosplash -verbose -consoleLog -application org.eclipse.equinox.p2.artifact.repository.mirrorApplication -source <remote_site> -destination<local_folder>
<eclipse_install_dir>/eclipse -nosplash -verbose -consoleLog -application org.eclipse.equinox.p2.metadata.repository.mirrorApplication -source <remote_site> -destination<local_folder>
```

The first command will copy all artifacts (plugins, features, ...).  
The second one will copy all P2 metadata.  

Exemple :
```powershell
C:/Dev/Eclipse_RCP_2024-03/eclipse/eclipse -nosplash -verbose -consoleLog -application org.eclipse.equinox.p2.artifact.repository.mirrorApplication -source "https://download.eclipse.org/capella/core/updates/releases/6.1.0/org.polarsys.capella.rcp.site/" -destination "C:/P2_Mirroring/CapellaSite"
C:/Dev/Eclipse_RCP_2024-03/eclipse/eclipse -nosplash -verbose -consoleLog -application org.eclipse.equinox.p2.metadata.repository.mirrorApplication -source "https://download.eclipse.org/capella/core/updates/releases/6.1.0/org.polarsys.capella.rcp.site/" -destination "C:/P2_Mirroring/CapellaSite"
```

Repositories list for Capella-core :
* https://download.eclipse.org/capella/core/updates/releases/6.1.0/org.polarsys.capella.rcp.site
* https://download.eclipse.org/capella/core/updates/releases/6.1.0/org.polarsys.capella.test.site
* https://download.eclipse.org/releases/2021-06
* https://download.eclipse.org/rmf/updates/releases/0.13.0
* https://download.eclipse.org/sphinx/releases/0.8.x
* https://download.eclipse.org/modeling/gmp/gmf-notation/updates/releases/R202211151334
* https://download.eclipse.org/modeling/gmp/gmf-runtime/updates/releases/R202211041032
* https://download.eclipse.org/tools/gef/classic/releases/3.15.0
* https://download.eclipse.org/modeling/gmp/gmf-runtime/updates/releases/R202204130739
* https://download.eclipse.org/sirius/updates/releases/7.1.0/2021-06
* https://download.eclipse.org/kitalpha/updates/stable/runtime/6.1.0.20230322
* https://download.eclipse.org/kitalpha/updates/stable/sdk/6.1.0.20230322
* https://download.eclipse.org/diffmerge/releases/0.14.0/emf-diffmerge-site
* https://download.eclipse.org/diffmerge/releases/0.14.0/edm-coevolution-site
* https://download.eclipse.org/modeling/amalgam/updates/releases/1.13.0/capella
* https://download.eclipse.org/egf/updates/stable/1.6.3/2021-06
* https://download.eclipse.org/nattable/releases/2.0.1/repository
* https://archive.eclipse.org/nebula/releases/2.3.0
* https://download.eclipse.org/cbi/updates/license

Repositories list for Capella-tp :
* file:/C:/LOCAL/PATH/Filtering-updateSite-1.6.2
* file:/C:/LOCAL/PATH/Requirements-updateSite-0.13.1
* file:/C:/LOCAL/PATH/VPMS-updateSite-0.19.0
* file:/C:/LOCAL/PATH/com.thalesgroup.mde.capella.diagramstyler.repository-60.3.1
* file:/C:/LOCAL/PATH/com.thalesgroup.vpd.property.repository-60.7.0
* file:/C:/LOCAL/PATH/SubsystemTransition-updateSite-1.6.4
* file:/C:/LOCAL/PATH/org.obeonetwork.m2doc.update-3.3.1
* file:/C:/LOCAL/PATH/TextualEditor-updateSite-0.11.1
* https://download.eclipse.org/technology/subversive/4.8/release/4.8.0
* https://download.eclipse.org/capella/addons/xhtmldocgen/updates/releases/6.1.0





