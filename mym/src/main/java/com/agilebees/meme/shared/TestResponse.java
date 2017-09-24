package com.agilebees.meme.shared;

import java.util.ArrayList;

import net.customware.gwt.dispatch.shared.Result;

public class TestResponse extends CrudResult implements Result {

	private ArrayList<GWTTest> list = new ArrayList<GWTTest>(0);
	private boolean success;
	
	@Override
	public ArrayList getList() {
		// TODO Auto-generated method stub
		return this.list;
	}
	public void setList(ArrayList<GWTTest> list) {
		// TODO Auto-generated method stub
		 this.list = list;
	}

	@Override
	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return this.success;
	}
	
	public void setSuccess(boolean success){
		this.success = success;
	}

}
