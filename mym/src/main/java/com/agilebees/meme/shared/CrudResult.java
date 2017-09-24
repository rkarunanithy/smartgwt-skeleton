package com.agilebees.meme.shared;

import java.util.ArrayList;

import net.customware.gwt.dispatch.shared.Result;

public abstract class CrudResult implements Result {
	public abstract ArrayList getList();
	public abstract boolean isSuccess();
	
}
