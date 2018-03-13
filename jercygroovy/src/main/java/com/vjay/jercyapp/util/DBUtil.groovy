package com.vjay.jercyapp.util

import groovy.sql.Sql

@Singleton(strict=false)
class DBUtil {
	private groovy.sql.Sql sqlInstance = null;
	private String dbUrl
	private String user
	private String pwd
	private String driverClassName

	private DBUtil() {
		File file = new File(getClass().getResource("/dbconfig.properties")?.toURI())
		def props = new PropsUtil(file)
		if(props) {
			dbUrl = props."connection.url"
			user = props."connection.username"
			pwd =  props."connection.password"
			driverClassName = props."connection.driverclass"
			println "Configs are:$dbUrl ,$user, $pwd, $driverClassName" 
			sqlInstance = Sql.newInstance(dbUrl,user,pwd,driverClassName)
		}else
			throw new Exception("DB Config Props not defined")
	}
}
