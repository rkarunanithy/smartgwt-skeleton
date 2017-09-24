package com.agilebees.meme.client.widgetmaker;

import com.smartgwt.client.types.LineCap;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawPath;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawSector;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.Layout;

public class DrawingCanvas {
	DrawPane mainPane ;
	public Canvas getViewPanel() {
	    mainPane = new DrawPane();
	    mainPane.setWidth100();
	    mainPane.setHeight100();
	    //mainPane.setShowEdges(true);
	    mainPane.addDrawHandler(new DrawHandler() {
	        @Override
	        public void onDraw(DrawEvent event) {
	        	 final DrawLine drawLine = new DrawLine();
	        	 int x = Page.getHeight() - ((Canvas)mainPane).getVisibleHeight();
	        	 int y = Page.getWidth() - ((Canvas)mainPane).getVisibleWidth();
	        	 int x1 = x;
	        	 int y1 = Page.getWidth();
	        	 Canvas c = ((Canvas)mainPane);
	        	 x = c.getLeft();
	        	 y = c.getTop();
	        	 
	        	 x1 = x;
	        	 y1 = c.getBottom();
	        	 
	        	 System.out.println(x+" "+y+" "+x1+" "+y1);
	        	 x = c.getAbsoluteLeft();
	        	 y = c.getAbsoluteTop();
	        	 
	        	 x1 = x;
	        	 y1 = y;

	        	 System.out.println(x+" "+y+" "+x1+" "+y1);
	        	 
	        	 //int x = 300;//mainPane.getParent().getAbsoluteTop();
	        	 //int y = 200;//mainPane.getParent().getAbsoluteLeft();
		         drawLine.setStartPoint(new Point(x, y));
		         drawLine.setEndPoint(new Point(x1, y1));
		         //drawLine.setTitle("Line");
		         //applyCommonProps(drawLine);
		         drawLine.draw();
	        }
	    });

	    final Layout layout = new HStack();
	    layout.setWidth100();
	    layout.setBorder("1px solid red");
	    layout.setMembers(mainPane);
	    return layout;
	}
	public Canvas getViewPanel(boolean test){
		
		final Canvas canvas = new Canvas("drawingCanvas");/*{
			@Override
			public void draw(){
				super.draw();
				Canvas  drawingCanvasContainer =  GlobalObj.getInstance().getDrawingCanvasContainer();
				String p = " AbLeft "+ this.getAbsoluteLeft() + " AbTop "+this.getAbsoluteTop();
				System.out.println(p);
				String p1 = " offsetX "+this.getOffsetX()+" offsetY "+this.getOffsetY()+" offsetWidth "+this.getOffsetWidth()+ " offsetHeight "+this.getOffsetHeight();
				System.out.println(p1);
				
			}
		};
		canvas.draw();*/
		

		canvas.addDrawHandler(new DrawHandler() {
			@Override
	        public void onDraw(DrawEvent event) {
				  Object source = event.getSource();
		            if (source instanceof BaseWidget) { //This shall cover all Buttons and UI elements.
		                int buttonLeftPosition = ((BaseWidget) source).getAbsoluteLeft();
		                int buttonTopPosition = ((BaseWidget) source).getAbsoluteTop();
		                
		                System.out.println("Left "+buttonLeftPosition+" Top "+buttonTopPosition);
		            }
		            Canvas  drawingCanvasContainer =  GlobalObj.getInstance().getDrawingCanvasContainer();
		            if(drawingCanvasContainer != null){
			            System.out.println("L : "+drawingCanvasContainer.getLeft()+ " T "+drawingCanvasContainer.getTop());
			            System.out.println("AL : "+drawingCanvasContainer.getAbsoluteLeft()+ " AT "+drawingCanvasContainer.getAbsoluteTop());
			            System.out.println("W : "+drawingCanvasContainer.getWidth()+ " H "+drawingCanvasContainer.getHeight());
		            }
			           
			           
				/*
				final DrawLine drawLine = new DrawLine();
				int x = 300;//mainPane.getParent().getAbsoluteTop();
	        	int y = 200;//mainPane.getParent().getAbsoluteLeft();
		        drawLine.setStartPoint(new Point(x, y));
		        drawLine.setEndPoint(new Point(x+300, y));
		        //drawLine.setTitle("Line");
		        //applyCommonProps(drawLine);
		        drawLine.draw();*/
	        }
		});
		
		/*body {
		    background-size: 40px 40px;
		    background-image: radial-gradient(circle, #000000 1px, rgba(0, 0, 0, 0) 1px);
		}*/
		//canvas.getElement().getStyle().setProperty("backgroundImage", "radial-gradient(circle, #000000 1px, rgba(0, 0, 0, 0) 1px");
		//canvas.getElement().getStyle().setProperty("backgroundSize","40px 40px");
		return canvas;
	}

}
