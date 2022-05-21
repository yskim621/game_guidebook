window.addEventListener("load", function(){
	var hoola = document.getElementById("hoola_hover");
	var hoola_data = document.getElementById("hoola_data");


	
	hoola.addEventListener("click", function(){
		//alert("클릭");
		hoola_data.innerHTML = " ";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/trumpcard/hoola";
		
		//ajax 객체를 생성
		var request = new XMLHttpRequest();
		
		//요청을 생성
		request.open('get', url, true);
		
		
		//요청을 전송
		request.send('');
		// console.log(formData);
		
		//ajax 요청에 응답이 오면
		request.addEventListener("load", function(e){
			// alert("클릭");
			// console.log(e.target.responseText)
			// 결과를 파싱
			var data = JSON.parse(e.target.responseText);
			// alert(data.result);
			// console.log(data);
			hoola_data.innerHTML = data.result
			
		});
		
	});
	
	
});

function hoolaChangeImg(){
	document.querySelector('#hoola').style.display = "none";
	document.querySelector('#hoola_hover').style.display = "block";	
}
  
function hoolaShowOriginal() {	
	document.querySelector('#hoola_hover').style.display = "none";
	document.querySelector('#hoola').style.display = "block";
}

