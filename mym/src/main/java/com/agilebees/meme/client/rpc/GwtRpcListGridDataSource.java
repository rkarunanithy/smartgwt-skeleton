package com.agilebees.meme.client.rpc;

import java.util.ArrayList;

import com.agilebees.meme.shared.CrudAction;
import com.agilebees.meme.shared.CrudResult;
import com.agilebees.meme.shared.CrudAction.CACTION;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public abstract class GwtRpcListGridDataSource extends GwtRpcDataSource {
	
	Action<Result> input;
	Result result;
	
	public <A extends Action<R>, R extends Result> GwtRpcListGridDataSource(A a , R r){
		super();
		this.result = r;
		this.input = (Action<Result>) a;
	}

	@Override
	protected void executeFetch(String requestId, DSRequest request, DSResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void executeAdd(final String requestId, final DSRequest request, final DSResponse response) {
		// TODO Auto-generated method stub
		JavaScriptObject data = request.getData();
		ListGridRecord rec = new ListGridRecord(data);
		copyFromListValues(rec, (CrudAction) input);
		((CrudAction) input).setAction(CACTION.ADD);
		dispatchAsync.execute(input,new AsyncCallback<Result>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				processResponse(requestId, response);
			}

			@Override
			public void onSuccess(Result result) {
				// TODO Auto-generated method stub
				
				ListGridRecord[] list = new ListGridRecord[1];
				ListGridRecord newRec = new ListGridRecord();
				ArrayList localList = ((CrudResult) result).getList();
				if(localList.size() > 0){
					copyToListValues(localList.get(0),newRec);
				}
				list[0] = newRec;
				response.setData(list);
				processResponse(requestId,response);
				
			}
			
		});
	}

	@Override
	protected void executeUpdate(final String requestId, final DSRequest request, final DSResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				JavaScriptObject data = request.getData();
				ListGridRecord rec = new ListGridRecord(data);
				copyFromListValues(rec, (CrudAction) input);
				((CrudAction) input).setAction(CACTION.UPDATE);
				dispatchAsync.execute(input,new AsyncCallback<Result>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						processResponse(requestId, response);
					}

					@Override
					public void onSuccess(Result result) {
						// TODO Auto-generated method stub
						
						ListGridRecord[] list = new ListGridRecord[1];
						ListGridRecord newRec = new ListGridRecord();
						ArrayList localList = ((CrudResult) result).getList();
						if(localList.size() > 0){
							copyToListValues(localList.get(0),newRec);
						}
						list[0] = newRec;
						response.setData(list);
						processResponse(requestId,response);
						
					}
					
				});
		
	}

	@Override
	protected void executeRemove(String requestId, DSRequest request, DSResponse response) {
		// TODO Auto-generated method stub
		
	}

	protected abstract<A extends CrudAction> void copyFromListValues(ListGridRecord from,CrudAction to);
	protected abstract void copyToListValues(Object from,ListGridRecord to);
	
	
}
