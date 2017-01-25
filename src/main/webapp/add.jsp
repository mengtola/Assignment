<% 
if(session.getAttribute("UserID") == null) {
	response.sendRedirect("login.jsp");
}

%>
<jsp:include page="header.jsp"/>
	<div class="content">
		<div class="content-head">
			<h3 style="float:left;"></h3>
			<div style="float:right;"><button class="easyui-linkbutton" style="width:130px;height:35px;" data-options="iconCls:'icon-add'" onClick="window.location='/'">Customer List</button></div>
		</div>
		<div style="margin-bottom:10px;clear:both;"></div>
		<form action="/add" method="post" >
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" style="width:200px;height:28px;" class="easyui-textbox"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" style="width:200px;height:28px;" class="easyui-textbox"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>
						<select name="gender" style="width:200px;height:28px;" class="easyui-combobox">
							<option value="0">Female</option>
							<option value="1">Male</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" style="width:200px;height:28px;" class="easyui-textbox"/></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><input type="text" name="dob" style="width:200px;height:28px;" class="easyui-textbox"/></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" style="width:200px;height:28px;" class="easyui-textbox"/></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" style="width:200px;height:28px;" class="easyui-textbox"/></td>
				</tr>
				<tr>
					<td></td>
					<td><button class="easyui-linkbutton" style="width:80px;height:32px;" data-options="iconCls:'icon-save'">Save</button></td>
				</tr>
			</table>
		</form>
	</div>
	
	
<jsp:include page="footer.jsp"/>
