<% 
if(session.getAttribute("UserID") == null) {
	response.sendRedirect("login.jsp");
}

%>
<jsp:include page="header.jsp"/>
	<div class="content">
		<div class="content-head">
			<h3 style="float:left;"></h3>
			<div style="float:right;"><button class="easyui-linkbutton" style="width:130px;height:35px;" data-options="iconCls:'icon-add'" onClick="window.location='/add.jsp'">Add Customer</button></div>
		</div>
		<div style="margin-bottom:10px;clear:both;"></div>
		<table style="width:100%;height:480px;" id="dgList"></table>
	</div>
	
	
	<script>
	$(function(){
		$('#dgList').datagrid({
			url:'http://localhost:9999/customer',
			columns:[[
				{field: 'cus_id', align:"center",width:"60",formatter:function(value,row,index){
					
					return "<a href='/edit?id="+value+"'><img src='images/edit.png' style='width:20px;'/></a>";
				}},
				{field: 'cus_name', title: "Customer Name", width: "140"},
				{field: 'cus_gender', title: "Gender", width: "100", formatter:function(value,row,index){
					if(value == 1) {
						return "Male";
					}else{
						return "Female";
					}
				}},
				{field: 'cus_dob', title: "Date Of Birth",width: "140"},
				{field: 'cus_email_address', title: "Email Address",width: "250"},
				{field: 'cus_address', title: "Address",width: "250"},
				{field: 'cus_phone', title: "Phone", width: "140"},
				{field: 'cus_created', title: "Created", width: "140"}
			]],
			rownumbers: true,
			pagination: true,
			singleSelect: true,
			pageSize: 20,
			pageList: [20,30,40,50,100,200]
			
		});
	});
	</script>
	
<jsp:include page="footer.jsp"/>
