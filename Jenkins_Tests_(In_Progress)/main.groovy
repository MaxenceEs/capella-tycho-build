import groovy.lang.GroovyShell

def shell = new GroovyShell()

def eclipsePath = './Jenkins/eclipse.groovy'
def eclipse = shell.parse(new File(eclipsePath))

def targetProductPath = "C:/Capella_producted/capella/capella.exe"
def featureRepository = "C:/P2_Mirroring/eclipse/capella/core/updates/releases/6.1.0/org.polarsys.capella.test.site"
def featureName = "org.polarsys.capella.test.feature"

eclipse.installFeature(targetProductPath, featureRepository, featureName)
