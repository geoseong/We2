<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="member.info" /></h2>
	<form:form action="We2_MemberUpdate" commandName="member">
	<p>
	<label></label>
	<p>
		<label><spring:message code="userid" />:<br>
		<form:input path="userid" />
		<form:errors path="userid"/>
		</label>
	</p>
	
	<p>
		<label><spring:message code="name" />:<br>
		<form:input path="name" />
		<form:errors path="name"/>
		</label>
	</p>
	<p>
		<label><spring:message code="pwd" />:<br>
		<form:input path="pwd" />
		<form:errors path="pwd"/>
		</label>
	</p>
	<p>
		<label><spring:message code="email" />:<br>
		<form:password path="email" />
		<form:errors path="email"/>
		</label>
	</p>
	<p>
		<label><spring:message code="phone" />:<br>
		<form:password path="phone" />
		<form:errors path="phone"/>
		</label>
	</p>
	<p>
		<label><spring:message code="gender" />:<br>
		<form:password path="gender" />
		<form:errors path="gender"/>
		</label>
	</p>
	<p>
		<label><spring:message code="regDater" />:<br>
		<form:password path="regDater" />
		<form:errors path="regDate"/>
		</label>
	</p>
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="확인" onclick="return joincheck()">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소">
	</td>
	</tr>
	</form:form>
</body>
</html>
