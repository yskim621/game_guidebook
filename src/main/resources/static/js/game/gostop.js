window.addEventListener("load", function(){
	var gostop = document.getElementById("gostop_hover");
	var gostop_data = document.getElementById("gostop_data");



	gostop.addEventListener("click", function(){
		//alert("클릭");
		gostop_data.innerHTML = " ";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/hwatu/gostop";

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
			gostop_data.innerHTML = data.result

		});

	});


});

document.querySelector('#gostop_hover').style.display = "none";

function gostopChangeImg(){
	document.querySelector('#gostop').style.display = "none";
	document.querySelector('#gostop_hover').style.display = "block";	
}
  
function gostopShowOriginal() {	
	document.querySelector('#gostop_hover').style.display = "none";
	document.querySelector('#gostop').style.display = "block";
}

