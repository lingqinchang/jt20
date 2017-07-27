$(function(){
	//验证用户名
	$("[name=loginName]").blur(function(){
		var loginName = $(this).val();
		$.ajax({
			url:"../user",
			type:"get",
			data:{"method":"isLoginName","loginName":loginName},
			dataType:"json",
			success:function(data){
				if(data.flag == 0){
					$("[name=loginName]").css("border","1px solid green");
				}else{
					$("[name=loginName]").css("border","1px solid red");
				}
			},
			error:function(){
				$("[name=loginName]").css("border","1px solid red");
			}
		})
	})
	
	//注册用户
	$(".log_btn").on("click",function(){
		if($("#pwd1").val() != $("#pwd2").val()){
			alert("两次密码不一致!");
			return false;
		}
		$.ajax({
			url:"../user",
			type:"get",
			data:$("form").serialize(),
			dataType:"json",
			success:function(data){
				if(data.flag == 0){
					alert("注册成功");
					window.location.href="Login.jsp";
				}else{
					alert("注册失败");
				}
			}
		})
	})
	
})


