package com.agilebees.meme.client.widgetmaker;

import com.agilebees.meme.client.framework.ui.ToolImage;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;

public class ToolBox extends Canvas {
	
	private static ToolBox toolBox;
	private HLayout layout = new HLayout();
	
	public  static ToolBox getInstance(){
		if(toolBox == null){
			toolBox = new ToolBox();
		}
		return toolBox;
	}
	
	private ToolBox(){
		init();
	}
	
	
	private void init(){
	 
	    layout.setBorder("2px solid #458B00");
	    layout.setMembersMargin(20);
	    layout.addMember( new ToolImage("circle.png") );
	    layout.addMember( new ToolImage("square.png") );
	    layout.addMember(new ToolButton("A"){
	    	
	    });
	    layout.addMember(new ToolButton("B"));
		
	}

	public Canvas getPanel(){
		return layout;
	}
	
	
}

class ToolButton extends IButton{
	
	
	ToolButton(String name){
		super(name);
	}
	
	
}
