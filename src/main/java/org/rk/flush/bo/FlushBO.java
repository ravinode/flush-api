package org.rk.flush.bo;

import java.util.ArrayList;
import java.util.List;

import org.rk.flush.dao.FlushRepository;
import org.rk.flush.model.Location;
import org.rk.flush.request.AddFlush;
import org.rk.flush.request.FlushLocReq;
import org.rk.flush.response.FlushLocResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
public class FlushBO {

	@Autowired
	FlushRepository flushRepository;
	
	@RequestMapping(value = "/checkSession", method = RequestMethod.POST)
	public List<FlushLocResp>  getLocation(FlushLocReq flushLocReq)
	{
		
		FlushLocResp resp = null;
		List<FlushLocResp> flushResp = new ArrayList<>();
		List<Location> location = flushRepository.getLocation(flushLocReq);
		System.out.println("Size"+location.size());
		for(int i=0;i<location.size();i++) {
			resp = new FlushLocResp();
			resp.setId(location.get(i).getId());
			resp.setName(location.get(i).getName());
			resp.setLatitude(location.get(i).getLatitude());
			resp.setLongitude(location.get(i).getLongitude());
			resp.setDistance(location.get(i).getDistance());
			resp.setDescription(location.get(i).getDescription());
			resp.setRating(location.get(i).getRating());
			flushResp.add(resp);
		}
		return flushResp;
	}
	
	public void addFlush(AddFlush flushReq)
	{
		
		flushRepository.addLocation(flushReq);
		//flushRepository.addPoints(flushReq);

	}
}
