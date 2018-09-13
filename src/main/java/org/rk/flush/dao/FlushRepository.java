package org.rk.flush.dao;

import java.util.List;

import org.rk.flush.model.Location;
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
	                "SELECT id, name, description, rating,( 3959 * acos (cos ( radians("+flushReq.getLatitude()+")) * cos( radians( lat ) ) * cos( radians( longi ) - radians("+flushReq.getLongtitude()+")) + sin ( radians( "+flushReq.getLatitude()+")) * sin( radians( lat )))) AS distance, LAT,LONGI FROM sys.FLUSH_RECORD  HAVING distance < "+flushReq.getDistance()+"  ORDER BY distance LIMIT 0 , 20", 
	             
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

}
