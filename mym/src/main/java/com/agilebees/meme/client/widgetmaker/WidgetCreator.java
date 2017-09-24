package com.agilebees.meme.client.widgetmaker;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DropMoveEvent;
import com.smartgwt.client.widgets.events.DropMoveHandler;
import com.smartgwt.client.widgets.events.DropOutEvent;
import com.smartgwt.client.widgets.events.DropOutHandler;
import com.smartgwt.client.widgets.events.DropOverEvent;
import com.smartgwt.client.widgets.events.DropOverHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class WidgetCreator {
	
	
	public Canvas getViewPanel() {
		
		 HLayout layout = new HLayout();
	     layout.setWidth100();
	     layout.setHeight100();
	     layout.setMembersMargin(20);
		
	     layout.addMember(getLeftPanel());
	     layout.addMember(getRightPanel());
		 return layout;
	}
	
	public Canvas getRightPanel(){
		
		VLayout vLayout = new VLayout();
	     //vLayout.setShowEdges(true);
	 
	     vLayout.setWidth(850);
	     //vLayout.setMembersMargin(5);
	     //vLayout.setLayoutMargin(10);
	     //vLayout.setBorder("1px solid red");
	     
	     HLayout actionBar = new HLayout();
	     actionBar.setWidth100();
	     actionBar.setHeight(5);
	     IButton b = new ToolButton("Clear");
	     IButton s = new ToolButton("Save");
	     actionBar.addMember(s);
	     actionBar.addMember(b);
	     s.addClickHandler(new ClickHandler() {
	    	 @Override
	    	 public void onClick(ClickEvent event) {
	    		 Element element = DOM.getElementById("drawingCanvas");
	    		// Canvas c = (Canvas) element;
	    	 }
	    	 
	    	
	     });
	     vLayout.addMember(actionBar);
	     
	     VLayout drawingArea = new VLayout();
	     drawingArea.setShowEdges(true);
	     drawingArea.setWidth100();
	     drawingArea.setHeight100();
	     DrawingCanvas dc =  new DrawingCanvas();
	     drawingArea.addMember(dc.getViewPanel(false));
	     
	     vLayout.addMember(drawingArea);
	     
	     
	     GlobalObj.getInstance().setDrawingCanvasContainer(vLayout);
	     
	     return vLayout;
		
	}
	
	public Canvas getLeftPanel(){
		 
	      
	      VLayout vLayout = new VLayout();
	      vLayout.setShowEdges(true);
	      vLayout.setWidth(150);
	      //vLayout.setMembersMargin(5);
	      //vLayout.setLayoutMargin(10);
	  
	      vLayout.setBorder("1px solid black");
	      vLayout.addMember(ToolBox.getInstance().getPanel());
	     // vLayout.addMember(new BlueBox(null, 50, "height 50"));
	      //vLayout.addMember(new BlueBox((String) null, "*", "height *"));
	      //vLayout.addMember(new BlueBox((String) null, "30%", "height 30%"));
	     

	      return vLayout;
		
	}
	
	
	
	public Canvas getViewPanel(boolean makeThisFunAsDummy) {
		Canvas canvas = new Canvas();

		final Img img = new Img("pieces/48/pawn_green.png", 48, 48) {
			protected boolean setDragTracker() {
				Canvas c = new Canvas();
				String html = Canvas.imgHTML("pieces/24/pawn_green.png", 24, 24, null, null, null);
				EventHandler.setDragTracker(html);
				return false;
			}
		};
	    img.setCanDrag(true);
	    img.setCanDrop(true);
	    img.setDragAppearance(DragAppearance.TRACKER);
	
	    final DropLabel label = new DropLabel();
	    label.setLeft(100);
	    label.setWidth(300);
	    label.setHeight(300);
	    label.setBackgroundColor("lightblue");
	    label.setAlign(Alignment.CENTER);
	    label.setContents("Show Drop Reticle");
	    label.setOverflow(Overflow.HIDDEN);
	    label.setCanAcceptDrop(true);
	
	    canvas.addChild(img);
	    canvas.addChild(label);
	    return canvas;
	}
}



class DropLabel extends Label {

    private Canvas crossHairX;
    private Canvas crossHairY;

    protected void onInit() {
        crossHairX = createCrossHair();
        crossHairY = createCrossHair();
        addChild(crossHairX);
        addChild(crossHairY);

        this.addDropOverHandler(new DropOverHandler() {
            public void onDropOver(DropOverEvent event) {
                getCrossHairX().show();
                getCrossHairY().show();
                updateCrossHairs();
            }
        });

        this.addDropMoveHandler(new DropMoveHandler() {
            public void onDropMove(DropMoveEvent event) {
                updateCrossHairs();
            }
        });

        this.addDropOutHandler(new DropOutHandler() {
            public void onDropOut(DropOutEvent event) {
                getCrossHairX().hide();
                getCrossHairY().hide();
            }
        });

    }

    private Canvas createCrossHair() {
        Canvas canvas = new Canvas();
        canvas.setWidth(this.getWidth() + 2);
        canvas.setHeight(this.getHeight() + 2);
        canvas.setBorder("1px solid black");
        canvas.setVisibility(Visibility.HIDDEN);
        return canvas;
    }

    public Canvas getCrossHairX() {
        return crossHairX;
    }

    public Canvas getCrossHairY() {
        return crossHairY;
    }

    public void updateCrossHairs() {
        int x = getOffsetX();
        int y = getOffsetY();

        // crossHairX is the -X and +Y axis of the crossHair
        crossHairX.setLeft(x - getWidth() - 1);
        crossHairX.setTop(y - getHeight() - 1);

        // crossHairY is +X, -Y
        crossHairY.setLeft(x);
        crossHairY.setTop(y);
    }
}
