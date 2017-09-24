package com.agilebees.meme.shared;

import java.util.HashMap;

public interface CrudAction {
	public enum CACTION{ADD,DELETE,UPDATE,FETCH}
	public void setAction(CACTION c);
	public CACTION getAction();
	public void setCriteria(HashMap<String,String> obj);
	public HashMap<String,String> getCriteria();
}
