package com.jodo.notify.sqlhelper;

import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.jodo.notify.util.ApplicationHelper;
import com.jodo.notify.util.ResultObjectBuilder;



/**
 * @author ygchiaaa 管理所有的Db实例（节点）
 */
public class DbManager {
	
	public enum DB_NAME {
		notifycenter,
		googleplay
	}

    private static final ApplicationHelper logger = ApplicationHelper
            .getInstance(DbManager.class);

//    private static final DbManager instance = new DbManager();
    
    private static ConcurrentHashMap<String, DbManager> xxmap = new ConcurrentHashMap<String, DbManager>();
   
    private DbNode dbNode;
    
    public static DbManager getInstnace() {
        return getInstnace(DB_NAME.notifycenter);
    }
    
    public static DbManager getInstnace(DB_NAME dbname) {
    	String name = dbname.name();
    	DbManager db = xxmap.get(name);
    	if(db == null) {
    		xxmap.putIfAbsent(name, new DbManager(name));
    	}
    	return xxmap.get(name);
    }
    
    private DbManager() {
    	this(DB_NAME.notifycenter.name());//default dbname
    }
    
	public static void main(String[] args) {
		DbManager db = null;

		db = getInstnace(DB_NAME.notifycenter);
		try {
			db.executeScalerObject(" select a from b;", null,
					ScalerObjectBuilder.stringBuilder);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
    
    private  DbManager(String dbName) {
        DbNodeConfig config = new DbNodeConfig();
        config.checkOutTimeOut = Integer.valueOf(ConfigManager.instance.getValue(dbName +"."+ "db.config.checkOutTimeOut"));
        config.dbName = ConfigManager.instance.getValue(dbName +"."+"db.config.dbName");
        config.ip = ConfigManager.instance.getValue(dbName +"."+"db.config.ip");
        config.maxIdleTime = Integer.valueOf(ConfigManager.instance.getValue(dbName +"."+"db.config.maxIdleTime"));
        config.maxPoolSize = Integer.valueOf(ConfigManager.instance.getValue(dbName +"."+"db.config.maxPoolSize"));
        config.minPoolSize = Integer.valueOf(ConfigManager.instance.getValue(dbName +"."+"db.config.minPoolSize"));
        config.driverClass = ConfigManager.instance.getValue(dbName +"."+"db.config.driverClass");
        config.userName = ConfigManager.instance.getValue(dbName +"."+"db.config.userName");
        config.password = ConfigManager.instance.getValue(dbName +"."+"db.config.password");
        config.testConnOnCheckin = Boolean.valueOf(ConfigManager.instance .getValue(dbName +"."+"db.config.testConnOnCheckin"));
        config.testSql = "SELECT * FROM T_ConnectTest;";
        dbNode = new DbNode(config);
        
    }

    public int executeCommand(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(sql);
            setParams(stmt, params);
            return stmt.executeUpdate();
        } catch (Exception e) {
            logger.error(String.format("exception in sql =  %s  %s", sql, params != null ? Arrays.toString(params): ""),e);
            e.printStackTrace();
            return 0;
        } finally {
            releaseDbResource(conn, stmt, rs);
        }
    }
    

    public int[] executeBatchCommand(String sql, List<Object[]> paramsList) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < paramsList.size(); i++) {
                setParams(stmt, paramsList.get(i));
                stmt.addBatch();
            }

            int[] effRows = stmt.executeBatch();
            conn.commit();
            return effRows;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                logger.error(String.format("exception in cmd = [ %s ] ", sql),
                        e1);
            }
            return null;
        } finally {
            releaseDbResource(conn, stmt, rs);
        }
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
    
	public List<String> executeQuery_oneList(String cmd, Object[] params,
            String colname) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(cmd);
            setParams(stmt, params);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(colname));
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
	
    public <T> T executeScalerObject(String cmd, Object[] params,
            ResultObjectBuilder<T> builder) throws Throwable {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement(cmd);
            setParams(stmt, params);
            rs = stmt.executeQuery();
            while (rs.next()) {
                return builder.build(rs);
            }
            return null;
        } catch (Throwable t) {
            logger.error(String.format("exception in cmd = [ %s ] ", cmd), t);
            throw t;
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
    
    private void destroy() {
        try {
            this.dbNode.destroy();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.equals(e);
        }
    }
    
    public static void destryAll() {
    	for(Entry<String, DbManager> entry : xxmap.entrySet()) {
    		entry.getValue().destroy();
    	}
    }

    public Connection getConnection() {
        try {
            return dbNode.getConnection();
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
