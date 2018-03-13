package com.vjay.jercyapp.util

class PropsUtil {

	File propsFile;
	Properties props

	PropsUtil(File propsFile) {
		this.props = new Properties()
		this.propsFile = propsFile
		propsFile.withInputStream{ this.props.load it }
	}

	PropsUtil(String fileName){
		this.props = new Properties()
		this.propsFile = new File(fileName)
		propsFile.withInputStream{ this.props.load it }
	}

	Properties getPropeties() {
		props
	}
	def methodMissing(String name, args) {
		this.props.load(propsFile.newDataInputStream())
		props.setProperty(name, args.join(","))
		props.store(propsFile.newWriter(), null)
	}

	def propertyMissing(String name) {
		props."$name"

	}
}
