package com.agilebees.meme.client.widgetmaker;

import com.smartgwt.client.widgets.Canvas;

public class GlobalObj {
	
	private static GlobalObj globalObj = null;
	private Canvas drawingCanvasContainer;
	
	public static GlobalObj getInstance(){
		
		if( globalObj == null){
			globalObj = new GlobalObj();
		}
		return globalObj;
		
	}
	
	public void setDrawingCanvasContainer(Canvas canvas){
		this.drawingCanvasContainer = canvas;
	}
	
	public Canvas getDrawingCanvasContainer(){
		return drawingCanvasContainer;
	}

}
