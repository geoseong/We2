<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Modal</title>
<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script type="text/javascript">
	$(function(){
	    $("#popbutton").click(function(){
	        $('div.modal').modal({
                     remote : '../we2/test_modal/modalson.jsp'
             });
	    });
	});
</script>


</head>
<body>

	<button class="btn btn-default" id="popbutton">
		모달출력버튼
	</button><br/>
	<div class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	        <!-- remote ajax call이 되는영역 -->
	    </div>
	  </div>
	</div>

</body>
</html>