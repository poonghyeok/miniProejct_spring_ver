/**
 * 
 */
 
$(function(){
	$.ajax({
		type : 'post',
		url : '/miniProject/member/getMemberBySessionId',
		dataType : 'json',
		success : function(member){
			console.log(JSON.stringify(member));
			$('input[name="nameWrite"]').val(member.name);
			$('input[name="idWrite"]').val(member.id);
			$('input[name="gender"][value="'+member.name+'"]').prop('checked', true);
			$('input[name="email1"]').val(member.email1);
			$('input[name="email2"]').val(member.email2);
			$('input[name="tel1"]').val(member.tel1);
			$('input[name="tel2"]').val(member.tel2);
			$('input[name="tel3"]').val(member.tel3);
			$('input[name="zipcode"]').val(member.zipcode);
			$('input[name="address1"]').val(member.address1);
			$('input[name="address2"]').val(member.address2);
		},
		error : function(err){
			console.log(err);
		}
	})
})
	
$('#checkValOrSubmit').click(function(){
	$('#nameDivWrite').empty();
	$('#pwdDivWrite').empty();
	
	if($('#nameWrite').val() === ''){
		$('#nameDivWrite').html('이름을 입력하세요 제이쿼리!');
	}else if($('#pwdWrite').val() === ''){
		$('#pwdDivWrite').html('변경할 비밀번호를 입력해주세요 제이쿼리!');
	}else if($('#pwdWrite').val() !== $('#pwd2Write').val()){
		$('#pwdDivWrite').html('동일한 비밀번호를 입력해주세요 제이쿼리!');
	}else{
		$.ajax({
			type: 'post',
			url : '/miniProject/member/memberUpdate',
			data : {
				name : $('#nameWrite').val(),
				id: $('#idWrite').val(),
				pwd: $('#pwdWrite').val(),
				gender : $('input[type="radio"]:checked').val(),
				email1 : $('#email1').val(),
				email2 : $('#email2').val(),
				tel1 : $('#tel1').val(),
				tel2 : $('#tel2').val(),
				tel3 : $('#tel3').val(),
				zipcode : $('#zipcode').val(),
				address1 : $('#address1').val(),
				address2 : $('#address2').val(),
			},
			/* serialize만 해주고 넘겨도 &로 구분되어서 넘어가기 때문에 서블릿에서 다 받아먹을 수 있다. get방식으로 보냈을 때 &로 구분되어서 딜리버 되는 것처럼 */
			success:function(){
				alert('회원정보를 수정하였습니다!');
				location.href = '/miniProject/index';
			},
			error : function(err){
				console.log(err);
			}
		});
	}
})

$('#checkDuplicate').click(function(){
	if($('#idWrite').val() === ''){
		$('#idDivWrite').html('먼저 아이디를 입력하세요!');
		$('#idDivWrite').css('color','magenta');
		$('#idDivWrite').css('font-size','8pt');
		$('#idDivWrite').css('font-weight','bold');
	}else{
		$.ajax({
			url: 'http://localhost:8080/miniProject/member/checkDuplicate',
			type: 'post',
			data : {id:$('#idWrite').val()},
			success : function(data){
				if(data === 'exist'){
					$('#idDivWrite').html('이미 존재하는 id입니다.');
				}else{
					$('#idDivWrite').html('사용가능한 아이디입니다.');
					$('#checkedId').val($('#idWrite').val());		
				}
			},
			error : function(error){
				console.log(error);
			} 
		})
	}
})