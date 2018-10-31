package org.rk.flush.controller;

import java.util.List;

import javax.sql.DataSource;

import org.rk.flush.bo.FlushBO;
import org.rk.flush.request.AddFlush;
import org.rk.flush.request.FlushLocReq;
import org.rk.flush.response.FlushLocResp;
import org.rk.flush.response.FlushResp;
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
	public Result addLocation(@RequestBody AddFlush flushReq)
	{
		try
		{
		 Result result = new Result();
		 logger.info("Req ADD is+++"+flushReq.toString());
		 flushBo.addFlush(flushReq);
		 result.setMessage("SUCCESS");
		return result;
		}
		catch(Exception e)
		{
			logger.info("Error"+e.getStackTrace());
			e.printStackTrace();
		}
		return null;
	}
	
}
