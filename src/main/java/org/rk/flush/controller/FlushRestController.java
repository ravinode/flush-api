package org.rk.flush.controller;

import java.util.List;

import javax.sql.DataSource;

import org.rk.flush.bo.FlushBO;
import org.rk.flush.request.FlushLocReq;
import org.rk.flush.response.FlushLocResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlushRestController {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	FlushBO flushBo;
	
	@RequestMapping(value = "/getLocation", method = RequestMethod.POST)
	public List<FlushLocResp> getLocation(@RequestBody FlushLocReq flushReq)
	{
		System.out.println("FLUSH"+flushReq.getLatitude());
		List<FlushLocResp> locationResult = flushBo.getLocation(flushReq);
		
		return locationResult;
	}
}
