package com.jodo.notify.sqlhelper;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

/**
 * 
 * @author ygchiaaa
 * 一個ldap_jdbc實例
 */
public class LDAPNode {

	private ComboPooledDataSource pool;

	public LDAPNode(LDAPNodeConfig config) {
		pool = createPool(config);
	}

	public Connection getConnection(String user,String psw) throws SQLException {
		return pool.getConnection(user,psw);
	}

	public void destroy() throws SQLException {
		DataSources.destroy(pool);
	}

	private static ComboPooledDataSource createPool(LDAPNodeConfig config) {
		ComboPooledDataSource ds = new ComboPooledDataSource();

		try {
			ds.setDriverClass(config.driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Error("unsupported driver : " + config.driverClass);
		}
		String connStr = String.format("jdbc:ldap://%s:%s/%s?SEARCH_SCOPE:=subTreeScope", 
				config.ip,config.my_port, config.dn);
		//String ldapConnectString = "jdbc:ldap://54.64.189.21:389/dc=biee,dc=zd?SEARCH_SCOPE:=subTreeScope";		
		ds.setJdbcUrl(connStr);
		ds.setMinPoolSize(config.minPoolSize);
		ds.setMaxPoolSize(config.maxPoolSize);
		ds.setMaxIdleTime(config.maxIdleTime);
		ds.setCheckoutTimeout(config.checkOutTimeOut);
		ds.setPreferredTestQuery(config.testSql);
		ds.setTestConnectionOnCheckin(config.testConnOnCheckin);
		return ds;
	}
}
