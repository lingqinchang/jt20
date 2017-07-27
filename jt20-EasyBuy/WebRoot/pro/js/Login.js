$(function(){
	//登录操作
	$(".log_btn").on('click',function(){
		var loginName = $(".l_user").val();
		var password = $(".l_pwd").val();
		
		if(loginName == "" || password == ""){
			alert("用户名或密码不能为空!");
			return false;
		}
		
		$.post("../user",{"loginName":loginName,"password":password,"method":"login"},function(data){
			if(data.flag == 0){
				//到首页
				window.location.href = "../product?method=home";
			}else if(data.flag == 1){
				alert("用户名错误!");
			}else{
				alert("密码错误!");
			}
		},"json");
	})
})


