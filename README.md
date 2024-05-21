# Capella-tycho-build
- [Devops userguide](wiki/devops.md)
- [Developer userguide](wiki/developer.md)
- [Utils links](wiki/utils.md)
- [Glossary](wiki/glossary.md)



# Build and run

By running the command `mvn clean verify` on the root, we obtains the following result :
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for releng 1.0.0-SNAPSHOT:
[INFO]
[INFO] releng ............................................. SUCCESS [  0.156 s]
[INFO] max.capella.console.displayer ...................... SUCCESS [ 18.709 s]
[INFO] [feature] Max Capella Console Displayer Feature .... SUCCESS [  0.766 s]
[INFO] [product] Max Capella Product ...................... SUCCESS [03:04 min]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  03:37 min
[INFO] Finished at: 2024-05-21T14:47:13+02:00
[INFO] ------------------------------------------------------------------------
```

So the product is well built for Windows (win32.win32.x86_64), but unable to launch the generated "capella.exe".