package zpy.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DbUtils {
	public static int getMaxPage(String cid){
		String sql = "";
		if(cid==null){
			sql = "select count(*) from blog";
		}else{
			sql = "select count(*) from blog where category_id="+cid;
		}
		QueryRunner qr = DbHelper.getQueryRunner();
		int count = 0;
		try {
		     count = qr.query(sql, new ResultSetHandler<Integer>(){  
		    	  
	                public Integer handle(ResultSet rs) throws SQLException {  
	                    if(rs.next()){  
	                        return rs.getInt(1); //或者rs.getLong("count");  
	                    }  
	                    return 0;  
	                }  
	                  
	            });  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count%10!=0){
			count = count/10+1;
		}else{
			count = count/10;
		}
		return count;
	}
}
