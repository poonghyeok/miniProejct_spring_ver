/**
 * 
 */

$('#menuWriteButton').click(function(){
	location.href = 'http://localhost:8080/miniProject/board/boardWriteForm';
	/*$.ajax({
		url: 'http://localhost:8080/miniPJ/board/boardWriteForm.do',
		type: 'post',
		dataType : 'html',
		success : function(result){
			$('div#section').html(result);	
		}
		,
		error : function(error){
			console.log(error);
		} 
	});
	*/
})
	
$('#boardWriteButton').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val() === ''){
		$('#subjectDiv').html('제목 입력하세요! 제이쿼리!');
		
	}else if($('#content').val() === ''){
		$('#contentDiv').html('내용을 입력하세요! 제이쿼리!');
		
	}else{
		$.ajax({
			url: 'http://localhost:8080/miniProject/board/boardWrite',
			type: 'post',
			data : {subject : $('#subject').val(),
					content : $('#content').val()},
			success : function(){
				console.log('boardForm data ::: ' + $('#subject').val() + $('#content').val());
				alert('글 작성을 완료했습니다..!');
				location.href = '/miniProject/index';
			}
			,
			error : function(error){
				console.log(error);
			} 
		});
	}
});


$('#boardListButton').click(function(){
	location.href = 'http://localhost:8080/miniProject/board/boardList.do?pg=1';
/*	$.ajax({
		l
		url: 'http://localhost:8080/miniPJ/board/boardList.do?pg=1',
		type: 'post',
		dataType : 'html',
		success : function(result){
			$('div#section').html(result);
		}
		,
		error : function(error){
			console.log(error);
		} 
	});
*/	
})

	
 