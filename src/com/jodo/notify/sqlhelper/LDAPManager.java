package com.jodo.notify.sqlhelper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.directory.api.ldap.aci.UserClass.ThisEntry;

import com.jodo.notify.model.AdminSynLDAPModel;
import com.jodo.notify.util.ApplicationHelper;
import com.jodo.notify.util.Base64Utils;
import com.jodo.notify.util.ResultObjectBuilder;

/**
 * @author ygchiaaa 管理所有的Db实例（节点）
 */
public class LDAPManager {

    private static final ApplicationHelper logger = ApplicationHelper
            .getInstance(DbManager.class);

    private static final LDAPManager instance = new LDAPManager();

    private LDAPNode ldapNode;

    public static LDAPManager getInstnace() {
        return instance;
    }
    
	private LDAPManager() {
    	LDAPNodeConfig config = new LDAPNodeConfig();
        config.checkOutTimeOut = Integer.valueOf(ConfigManager.instance.getValue("ldap.config.checkOutTimeOut"));
        config.dn = ConfigManager.instance.getValue("ldap.config.dn");
        config.ip = ConfigManager.instance.getValue("ldap.config.ip");
        config.my_port = ConfigManager.instance.getValue("ldap.config.port");
        config.maxIdleTime = Integer.valueOf(ConfigManager.instance.getValue("ldap.config.maxIdleTime"));
        config.maxPoolSize = Integer.valueOf(ConfigManager.instance.getValue("ldap.config.maxPoolSize"));
        config.minPoolSize = Integer.valueOf(ConfigManager.instance.getValue("ldap.config.minPoolSize"));
        config.driverClass = ConfigManager.instance.getValue("ldap.config.driverClass");     
        config.testConnOnCheckin = Boolean.valueOf(ConfigManager.instance .getValue("ldap.config.testConnOnCheckin"));
        config.testSql = "select * from dc=biee,dc=zd where  uid='wujianhai'";
        ldapNode = new LDAPNode(config);
    }
    
    public static void main(String[] args) throws Exception {
		List<AdminSynLDAPModel> ddAdminUserSynModels= LDAPManager.getInstnace().executeQuery_ObjcetList("select * from dc=biee,dc=zd ",null, AdminSynLDAPModel.builder);
		System.out.println(Base64Utils.decode(ddAdminUserSynModels.get(1).getSn()));
	}
	
	
    public <T> List<T> executeQuery_ObjcetList(String cmd, Object[] params,
            ResultObjectBuilder<T> builder) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<T> list = new ArrayList<T>();
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(cmd);
            setParams(stmt, params);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(builder.build(rs));
            }
            return list;
        } catch (Throwable t) {
            logger.error(String.format("exception in cmd = [ %s ]", cmd), t);
            return null;
        } finally {
            releaseDbResource(conn, stmt, rs);
        }
    }
    
	public Map<String, String> executeQuery_twoList(String cmd, Object[] params,String colname1,String colname2) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Map<String,String> map = new HashMap<String, String>();
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(cmd);
            setParams(stmt, params);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	map.put(rs.getString(colname1), rs.getString(colname2));
            }
            return map;
        } catch (Throwable t) {
            logger.error(String.format("exception in cmd = [ %s ]", cmd), t);
            return null;
        } finally {
            releaseDbResource(conn, stmt, rs);
        }
    }
	
	
    private void setParams(PreparedStatement stmt, Object[] param)
            throws SQLException {
        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                Object o = param[i];
                if (o instanceof Integer) {
                    stmt.setInt(i + 1, (Integer) o);
                } else if (o instanceof Short) {
                    stmt.setShort(i + 1, (Short) o);
                } else if (o instanceof Long) {
                    stmt.setLong(i + 1, (Long) o);
                } else if (o instanceof String) {
                    stmt.setString(i + 1, (String) o);
                } else if (o instanceof String) {
                    stmt.setString(i + 1, (String) o);
                } else if (o instanceof Date) {
                    stmt.setDate(i + 1, (Date) o);
                } else if (o instanceof Boolean) {
                    stmt.setBoolean(i + 1, (Boolean) o);
                } else if (o instanceof byte[]) {
                    stmt.setBytes(i + 1, (byte[]) o);
                } else if (o instanceof Byte) {
                    stmt.setByte(i + 1, (Byte) o);
                } else if (o instanceof Double) {
                    stmt.setDouble(i + 1, (Double) o);
                } else if (o instanceof Float) {
                    stmt.setFloat(i + 1, (Float) o);
                } else if (o == null) {
                    stmt.setFloat(i + 1, Types.OTHER);
                } else {
                    logger.error(" params contains null value");
                }
            }
        }
    }

    public void destroy() {
        try {
            this.ldapNode.destroy();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.equals(e);
        }
    }

    public Connection getConnection() {	
        try {
            return ldapNode.getConnection(ConfigManager.instance.getValue("ldap.config.userName"),
            ConfigManager.instance.getValue("ldap.config.password"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void releaseDbResource(Connection conn,
            PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
