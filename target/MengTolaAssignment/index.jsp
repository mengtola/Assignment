<% 
if(session.getAttribute("UserID") == null) {
	response.sendRedirect("login.jsp");
}

%>
<jsp:include page="header.jsp"/>
	<div class="content">
		<div class="content-head">
			<h3 style="float:left;"></h3>
			<div style="float:right;"><button class="easyui-linkbutton" style="width:130px;height:35px;" data-options="iconCls:'icon-add'">Add Customer</button></div>
		</div>
		<div style="margin-bottom:10px;clear:both;"></div>
		<table style="width:100%;height:480px;" id="dgList"></table>
	</div>
	
	
	<script>
	$(function(){
		$('#dgList').datagrid({
			url:'http://localhost:9999/customer',
			columns:[[		
				{field: 'cus_name', title="Customer Name"},
				{field: 'cus_gender', title="Gender"},
				{field: 'cus_dob', title="Date Of Birth"},
				{field: 'cus_email_address', title="Email Address"},
				{field: 'cus_phone', title ="Phone"},
				{field: 'cus_created', title = "Created"}
			]],
			rownumbers: true,
			pagination: true,
			singleSelect: true,
			
		});
	});
	</script>
	
<jsp:include page="footer.jsp"/>
