package org.rk.flush.controller;

import java.util.List;

import javax.sql.DataSource;

import org.rk.flush.bo.FlushBO;
import org.rk.flush.model.Approve;
import org.rk.flush.model.Point;
import org.rk.flush.model.Rate;
import org.rk.flush.model.Rating;
import org.rk.flush.request.AddFlush;
import org.rk.flush.request.FlushLocReq;
import org.rk.flush.request.PointReq;
import org.rk.flush.response.FlushLocResp;
import org.rk.flush.response.FlushResp;
import org.rk.flush.response.PointResp;
import org.rk.flush.response.RateResp;
import org.rk.flush.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlushRestController {
	
	 Logger logger = LoggerFactory.getLogger(FlushRestController.class);
	 

	@Autowired
	DataSource dataSource;
	
	@Autowired
	FlushBO flushBo;
	
	@RequestMapping(value = "/getLocation", method = RequestMethod.POST, produces = "application/json")
	public FlushResp getLocation(@RequestBody FlushLocReq flushReq)
	{
		FlushResp res = new FlushResp();
		try
		{
		System.out.println("+INCOMING"+flushReq.toString());
		 logger.info("Req is+++"+flushReq.toString());
		List<FlushLocResp> locationResult = flushBo.getLocation(flushReq);
		res.setFlushLoc(locationResult);
		 logger.info("RESPONSE"+locationResult.get(0).getName());
		return res;
		}
		catch(Exception e)
		{
			 logger.info("Error"+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/addLocation", method = RequestMethod.POST, produces = "application/json")
	public PointResp addLocation(@RequestBody AddFlush flushReq)
	{
		try
		{
		 PointResp res = new PointResp();
		 logger.info("Req ADD is+++"+flushReq.toString());
		 List<Point>  point = flushBo.addFlush(flushReq);
		 res.setPointResp(point);
		return res;
		}
		catch(Exception e)
		{
			logger.info("Error"+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getPoint", method = RequestMethod.POST, produces = "application/json")
	public PointResp getPoints(@RequestBody PointReq pointReq)
	{
		try
		{
		 PointResp res = new PointResp();
		
		 List<Point>  point = flushBo.getPoint(pointReq.getUserID());
		 res.setPointResp(point);
		return res;
		}
		catch(Exception e)
		{
			logger.info("Error"+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/approve", method = RequestMethod.POST, produces = "application/json")
	public PointResp approvePoints(@RequestBody Approve approve)
	{
		try
		{
		 PointResp res = new PointResp();
		flushBo.approve(approve);
		return res;
		}
		catch(Exception e)
		{
			logger.info("Error"+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/rate", method = RequestMethod.POST, produces = "application/json")
	public PointResp rate(@RequestBody Rate rate)
	{
		try
		{
		PointResp res = new PointResp();
		flushBo.rate(rate);
		return res;
		}
		catch(Exception e)
		{
			logger.info("Error"+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getRate", method = RequestMethod.POST, produces = "application/json")
	public RateResp getRate(@RequestBody Rating rate)
	{
		try
		{
		RateResp res = new RateResp();
		List<Rate> rateResp = flushBo.getRate(rate.getId());
		res.setRateResp(rateResp);
		return res;
		}
		catch(Exception e)
		{
			logger.info("Error"+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
}
