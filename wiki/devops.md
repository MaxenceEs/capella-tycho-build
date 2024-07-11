# Devops userguide
### How to create XXX environments
* IDE - [Eclipse RCP 2024-03](https://www.eclipse.org/downloads/packages/release/2024-03/r/eclipse-ide-rcp-and-rap-developers)
* TP - [Capella 6.1](https://download.eclipse.org/capella/core/products/releases/6.1.0/)

### How to create .target and .product files
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
	<repository id="VP-Filtering-1.6.2" location="file:/C:/Software_Development/Capella_DevOps/External_addons/Filtering-updateSite-1.6.2"/>
	<unit id="org.polarsys.capella.filtering.feature.source.feature.group"/>
</location>
```

For the path, if the location is a local folder/file, so the location should start with `"file:/"`, and the path should be absolute (relative path deosn't work).

Needs :
* Java
* Maven
* Nexus
    * Tycho (& dependencies)
    * P2 Externals updatesites
