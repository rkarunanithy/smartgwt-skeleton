package com.agilebees.meme.server.init;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.google.inject.Inject;
//import javax.inject.Inject;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.DefaultActionHandlerRegistry;

@Component
public class ActionHandlerRegistryBean extends DefaultActionHandlerRegistry {
    
	@Autowired
	public void setHandlers(List<ActionHandler<?,?>> handlers){
		for(ActionHandler<?,?> actionHandler : handlers){
			addHandler(actionHandler);
		}
	}
}
