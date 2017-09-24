package com.agilebees.meme.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.secure.CookieSecureSessionAccessor;
import net.customware.gwt.dispatch.client.secure.SecureDispatchAsync;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;



public class AppDispatchAsync implements DispatchAsync{

	private DispatchAsync dispatcher;
	
	@Inject
	public AppDispatchAsync(){
		this.dispatcher = new SecureDispatchAsync(new DefaultExceptionHandler(),new CookieSecureSessionAccessor("jsessionid"));
	}
	@Override
	public <A extends Action<R>, R extends Result> void execute(A action, final AsyncCallback<R> callback) {
		// TODO Auto-generated method stub
		
		dispatcher.execute(action, new AsyncCallback<R>(){

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				callback.onFailure(arg0);
				
			}

			@Override
			public void onSuccess(R arg0) {
				// TODO Auto-generated method stub
				callback.onSuccess(arg0);
			}
			
		});
	}
	
}