package org.rk.flush.dao;

import java.util.List;

import org.rk.flush.model.Approve;
import org.rk.flush.model.Location;
import org.rk.flush.model.Point;
import org.rk.flush.model.Rate;
import org.rk.flush.model.Rating;
import org.rk.flush.request.AddFlush;
import org.rk.flush.request.FlushLocReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.apache.commons.text.StringEscapeUtils;
@Repository
public class FlushRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	 public List<Location> getLocation(FlushLocReq flushReq) {
		 System.out.println(flushReq.getLatitude());
		 List<Location> result = jdbcTemplate.query(
	                "SELECT id, name, male,female,wheelchair,family, service_type, description, status, added_by, rating,( 3959 * acos (cos ( radians("+flushReq.getLatitude()+")) * cos( radians( lat ) ) * cos( radians( longi ) - radians("+flushReq.getLongtitude()+")) + sin ( radians( "+flushReq.getLatitude()+")) * sin( radians( lat )))) AS distance, LAT,LONGI FROM sys.FLUSH_RECORD  HAVING distance < "+flushReq.getDistance()+"  ORDER BY distance LIMIT 0 , 20", 
	             
	                (rs, rowNum) -> new Location(
	               
	                		   rs.getString("ID"),
	                		   rs.getString("NAME"),
	                		   rs.getString("DESCRIPTION"), 
	                		   rs.getString("SERVICE_TYPE"), 
	                		   rs.getString("RATING"),
	                		   rs.getString("LAT"), 
	                		   rs.getString("LONGI"), 
	                		   rs.getString("DISTANCE"),
	                		   rs.getString("STATUS"),
	                		   rs.getString("ADDED_BY"),
	                		   rs.getString("MALE"), 
	                		   rs.getString("FEMALE"),
	                		   rs.getString("WHEELCHAIR"),
	                		   rs.getString("FAMILY")
	                     )
	        );

	        return result;

	 }
	 
	 public List<Point> getPoints(String userID) {
		System.out.println(""+userID);
		 List<Point> result = jdbcTemplate.query(StringEscapeUtils.escapeJava(
	                "SELECT sum(points) as points,status,user_id FROM sys.FLUSH_POINTS where user_id = '"+userID+"' group by status"), 
	             
	                (rs, rowNum) -> new Point(
	               
	                		   rs.getString("user_id"),
	                		   rs.getString("points"),
	                		   rs.getString("status")
	                		  
	                		  
	                     )
	        );

	        return result;

	 }

	 
	 public void addPoints(AddFlush flushReq) {
		 
		 String sql = "INSERT INTO sys.FLUSH_POINTS"+ 
			 		"( ID,"+
				    "USER_ID," + 
			 		"POINTS," + 
			 		"STATUS)" + 
			 		"VALUES" + 
			 		"(?,?,?,?);";
			 jdbcTemplate.update(sql, new Object[] {
					 flushReq.getId(),flushReq.getUserid(),flushReq.getPoint(),flushReq.getStatus()
			 });
	 }
	 
	 
 public void approve(Approve approve) {
		 
		 String sql = "UPDATE sys.FLUSH_RECORD SET STATUS = '2' WHERE ID = ?";
			 jdbcTemplate.update(sql, new Object[] {
					 approve.getId()
			 });
	 }
	 
 
 public void rate(Rate rate) {
	 
	 String sql = "UPDATE sys.FLUSH_RECORD SET RATING = ?, CLEANING_R = ?, SERVICE_R = ? WHERE ID = ?";
		 jdbcTemplate.update(sql, new Object[] {
				 rate.getRating(),rate.getC_rating(),rate.getS_rating(),rate.getId()
		 });
 }
 
 public List<Rate> getRate(String rate) {
	 
		 
		 List<Rate> result = jdbcTemplate.query(StringEscapeUtils.escapeJava(
	                "SELECT ID, RATING,CLEANING_R,SERVICE_R,COUNT FROM sys.FLUSH_RECORD WHERE ID = '"+rate+"' "), 
	             
	                (rs, rowNum) -> new Rate(
	               
	                		   rs.getString("id"),
	                		   rs.getString("RATING"),
	                		   rs.getString("CLEANING_R"),
	                		   rs.getString("SERVICE_R"),
	                		   rs.getString("COUNT")
	                		  
	                		  
	                     )
	        );
		 return result;
 }
 
	 
	 public void addLocation(AddFlush flushReq) {
		 
		 String sql = "INSERT INTO sys.FLUSH_RECORD"+ 
			 		"( ID," + 
			 		"LONGI," + 
			 		"LAT," + 
			 		"NAME," + 
			 		"DESCRIPTION," + 
			 		"RATING," + 
			 		"CLEANING_R," + 
			 		"SERVICE_R," + 
			 		"MALE," + 
			 		"FEMALE," + 
			 		"WHEELCHAIR," + 
			 		"FAMILY," + 
			 		"SERVICE_TYPE," + 
			 		"ADDED_BY," +
			 		"STATUS," + 
			 		"COUNT)" + 
			 		"VALUES" + 
			 		"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			 jdbcTemplate.update(sql, new Object[] {flushReq.getId(),
					 flushReq.getLongitude(),flushReq.getLatitude(),flushReq.getName(),flushReq.getDescription(),flushReq.getRating(),
					 flushReq.getC_rating(),flushReq.getS_rating(),flushReq.getMale(),flushReq.getFemale(),flushReq.getWheel(),flushReq.getFamily(),flushReq.getServiceType(),flushReq.getUserid(),flushReq.getStatus(),
					 flushReq.getCount()
			 });
	 }

}
