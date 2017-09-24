package com.agilebees.meme.server.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agilebees.meme.server.TestService;
import com.agilebees.meme.shared.CrudAction;
import com.agilebees.meme.shared.TestRequest;
import com.agilebees.meme.shared.TestResponse;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.DispatchException;

@ActionHandlerBean
public class TestHandler implements ActionHandler<TestRequest,TestResponse > {

	

	@Autowired
	private TestService testService;
	
	@Override
	public TestResponse execute(TestRequest request, ExecutionContext ex) throws DispatchException {
		TestResponse resp = new TestResponse();
		// TODO Auto-generated method stub
		try{
			
			
			if(request.getAction() == CrudAction.CACTION.ADD || request.getAction() == CrudAction.CACTION.UPDATE){
				boolean res = testService.saveTest(request.getTest());
				if(res){
					resp.getList().add(request.getTest());
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return resp;
	}


	public Class<TestRequest> getActionType() {
		// TODO Auto-generated method stub
		return TestRequest.class;
	}

	@Override
	public void rollback(TestRequest request, TestResponse arg1, ExecutionContext arg2) throws DispatchException {
		// TODO Auto-generated method stub
		
	}

}
