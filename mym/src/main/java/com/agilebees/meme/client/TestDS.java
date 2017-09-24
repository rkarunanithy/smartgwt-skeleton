package com.agilebees.meme.client;

import com.agilebees.meme.client.rpc.GwtRpcListGridDataSource;
import com.agilebees.meme.shared.CrudAction;
import com.agilebees.meme.shared.GWTTest;
import com.agilebees.meme.shared.TestRequest;
import com.agilebees.meme.shared.TestResponse;
import com.smartgwt.client.data.fields.DataSourceEnumField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class TestDS extends GwtRpcListGridDataSource{

	public TestDS() {
		super(new TestRequest(), new TestResponse());
		// TODO Auto-generated constructor stub
		DataSourceEnumField id = new DataSourceEnumField();
		id.setPrimaryKey(true);
		id.setHidden(true);
		DataSourceTextField nameItem = new DataSourceTextField("nameItem");
		
		setFields(nameItem);
	}

	@Override
	protected <A extends CrudAction> void copyFromListValues(ListGridRecord from, CrudAction to) {
		// TODO Auto-generated method stub
		TestRequest req = (TestRequest) to;
		GWTTest dto = new GWTTest();
		
		dto.setName(from.getAttributeAsString("nameItem"));
		req.setTest(dto);
	}

	@Override
	protected void copyToListValues(Object from, ListGridRecord to) {
		// TODO Auto-generated method stub
		GWTTest dto = (GWTTest) from;
		if(dto.getName() != null){
			to.setAttribute("nameItem", dto.getName());
		}
		
	}

}
