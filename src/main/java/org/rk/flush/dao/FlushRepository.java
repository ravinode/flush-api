package org.rk.flush.dao;

import java.util.List;

import org.rk.flush.model.Location;
import org.rk.flush.model.Point;
import org.rk.flush.request.AddFlush;
import org.rk.flush.request.FlushLocReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlushRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	 public List<Location> getLocation(FlushLocReq flushReq) {
		 System.out.println(flushReq.getLatitude());
		 List<Location> result = jdbcTemplate.query(
	                "SELECT id, name, gender, description, rating,( 3959 * acos (cos ( radians("+flushReq.getLatitude()+")) * cos( radians( lat ) ) * cos( radians( longi ) - radians("+flushReq.getLongtitude()+")) + sin ( radians( "+flushReq.getLatitude()+")) * sin( radians( lat )))) AS distance, LAT,LONGI FROM sys.FLUSH_RECORD  HAVING distance < "+flushReq.getDistance()+"  ORDER BY distance LIMIT 0 , 20", 
	             
	                (rs, rowNum) -> new Location(
	               
	                		   rs.getString("ID"),
	                		   rs.getString("NAME"),
	                		   rs.getString("DESCRIPTION"), 
	                		   rs.getString("RATING"),
	                		   rs.getString("LAT"), 
	                		   rs.getString("LONGI"), 
	                		   rs.getString("DISTANCE")
	                     )
	        );

	        return result;

	 }
	 
	 public List<Point> getPoints(String userID) {
		
		 List<Point> result = jdbcTemplate.query(
	                "SELECT POINTS, STATUS FROM sys.FLUSH_POINTS  where USER_ID = "+userID+"", 
	             
	                (rs, rowNum) -> new Point(
	               
	                		   rs.getString("POINTS"),
	                		   rs.getString("STATUS")
	                		  
	                     )
	        );

	        return result;

	 }

	 
	 public void addPoints(AddFlush flushReq) {
		 
		 String sql = "INSERT INTO sys.FLUSH_POINTS"+ 
			 		"( USER_ID," + 
			 		"POINTS," + 
			 		"STATUS)" + 
			 		"VALUES" + 
			 		"(?,?,?);";
			 jdbcTemplate.update(sql, new Object[] {
					 flushReq.getUserid(),flushReq.getPoint(),flushReq.getStatus()
			 });
	 }
	 
	 public void addLocation(AddFlush flushReq) {
		 
		 String sql = "INSERT INTO sys.FLUSH_RECORD"+ 
			 		"( LONGI," + 
			 		"LAT," + 
			 		"NAME," + 
			 		"DESCRIPTION," + 
			 		"RATING," + 
			 		"CLEANING_R," + 
			 		"SERVICE_R," + 
			 		"GENDER," + 
			 		"SERVICE_TYPE," + 
			 		"ADDED_BY," + 
			 		"STATUS)" + 
			 		"VALUES" + 
			 		"(?,?,?,?,?,?,?,?,?,?,?);";
			 jdbcTemplate.update(sql, new Object[] {
					 flushReq.getLongitude(),flushReq.getLatitude(),flushReq.getName(),flushReq.getDescription(),flushReq.getRating(),
					 flushReq.getC_rating(),flushReq.getS_rating(),flushReq.getGender(),flushReq.getServiceType(),flushReq.getUserid(),flushReq.getStatus()
			 });
	 }

}
