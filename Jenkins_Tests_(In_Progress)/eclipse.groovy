def installFeature(String targetProductPath, String featureRepository, String featureName) {
	def command = "${targetProductPath} -repository ${featureRepository} -installIU ${featureName} -application org.eclipse.equinox.p2.director -noSplash"  

	def process = command.execute()
	def output = new StringBuffer()
	def error = new StringBuffer()
	process.consumeProcessOutput(output, error)
	process.waitFor()

	println "Output:\n$output"
	println "Error:\n$error"
}