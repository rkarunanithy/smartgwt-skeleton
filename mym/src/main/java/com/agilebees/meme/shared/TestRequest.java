package com.agilebees.meme.shared;

import java.util.HashMap;

import net.customware.gwt.dispatch.shared.Action;

public class TestRequest implements CrudAction,Action<TestResponse>{

	private GWTTest test;
	

	private CACTION action;
	private HashMap<String,String> criteria = new HashMap<String,String>();
	
	

	//@Override
	public void setCriteria(HashMap<String, String> obj) {
		// TODO Auto-generated method stub
		this.criteria =obj;
	}

	//@Override
	public HashMap<String, String> getCriteria() {
		// TODO Auto-generated method stub
		return criteria;
	}

	//@Override
	public void setAction(CACTION c) {
		// TODO Auto-generated method stub
		this.action = c;
		
	}

	//@Override
	public CACTION getAction() {
		// TODO Auto-generated method stub
		return action;
	}
	
	public GWTTest getTest() {
		return test;
	}

	public void setTest(GWTTest test) {
		this.test = test;
	}

}
