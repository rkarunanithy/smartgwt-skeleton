package com.agilebees.meme.server;

import org.springframework.stereotype.Component;

import com.agilebees.meme.shared.GWTTest;

@Component
public class TestService {

	public boolean saveTest(GWTTest dto){
		
		dto.setName("Hello Ravi");
		return true;
	}
}
