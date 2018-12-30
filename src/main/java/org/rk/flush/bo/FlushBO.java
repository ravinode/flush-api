package org.rk.flush.bo;

import java.util.ArrayList;
import java.util.List;

import org.rk.flush.dao.FlushRepository;
import org.rk.flush.model.Approve;
import org.rk.flush.model.Location;
import org.rk.flush.model.Point;
import org.rk.flush.model.Rate;
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
			resp.setServiceType(location.get(i).getServiceType());
			resp.setLongitude(location.get(i).getLongitude());
			resp.setDistance(location.get(i).getDistance());
			resp.setDescription(location.get(i).getDescription());
			resp.setRating(location.get(i).getRating());
			resp.setStatus(location.get(i).getStatus());
			resp.setAddedBy(location.get(i).getAddedBy());
			resp.setMale(location.get(i).getMale());
			resp.setFemale(location.get(i).getFemale());
			resp.setWheel(location.get(i).getWheel());
			resp.setFamily(location.get(i).getFamily());
			
			flushResp.add(resp);
		}
		return flushResp;
	}
	
	public List<Point> addFlush(AddFlush flushReq)
	{
		List<Point> pointReq = new ArrayList<>();
		flushRepository.addLocation(flushReq);
		flushRepository.addPoints(flushReq);
		pointReq = flushRepository.getPoints(flushReq.getUserid());
		return pointReq;

	}
	
	public List<Point> getPoint(String userID)
	{
		List<Point> pointReq = new ArrayList<>();
		pointReq = flushRepository.getPoints(userID);
		return pointReq;

	}
	
	public List<Rate> getRate(String userID)
	{
		List<Rate> pointReq = new ArrayList<>();
		pointReq = flushRepository.getRate(userID);
		return pointReq;

	}
	
	public void approve(Approve approve)
	{
		flushRepository.approve(approve);

	}
	
	public void rate(Rate rate)
	{
		flushRepository.rate(rate);

	}
}
