/**
 * 
 */
$('#memberUpdateButton').click(function(){
	alert('정보수정 클릭됨!');
	location.href='http://localhost:8080/miniProject/member/memberUpdateForm';
})

$('#logoutButton').click(function(){
	if(confirm('정말로 로그아웃하시겠습니까?')){
		location.href = 'http://localhost:8080/miniProject/member/logout';
	}
})

	
$('#loginButton').click(function(){
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	$('#loginResultDiv').empty();
	
	if($('#id').val() === ''){
		$('#idDiv').html('아이디를 입력하세요!');
		$('#idDiv').css({'color':'magenta',
		'font-size':'8pt',
		'font-weight':'bold',
		'background':'yellow'
		});
		
	}else if($('#pwd').val() === ''){
		$('#pwdDiv').html('비밀번호를 입력하세요!');
		$('#pwdDiv').css({'color':'magenta',
		'font-size':'8pt',
		'font-weight':'bold',
		'background':'yellow'
		});
	}else{
		$.ajax({
			url: 'http://localhost:8080/miniProject/member/login',
			type: 'post',
			data : {id:$('#id').val(),
					pwd:$('#pwd').val()},
			success : function(result){
				console.log(JSON.stringify(result));
				
				if(result === ''){
					$('#loginResultDiv').html('일치하는 회원정보가 없습니다.')
					$('#loginResultDiv').css({'color':'magenta',
						'font-size':'8pt',
						'font-weight':'bold',
						'background':'yellow'
						});
				}else{
					alert(result.name+ ' 님 반갑습니다.');
					location.href='/miniProject/index';
				}
			},
			error : function(error){
				console.log(error);
			} 
		});
	}
})

$('#memberWriteButton').click(function(){
	location.href = "http://localhost:8080/miniProject/member/writeForm";
	/*$('#section').load("http://localhost:8080/miniProject/member/writeForm");*/
	/*$.ajax({
			url: 'http://localhost:8080/miniProject/member/writeForm',
			type: 'get',
			success : function(){
				
			},
			error : function(error){
				console.log(error);
			} 
		});
	*/
})
			