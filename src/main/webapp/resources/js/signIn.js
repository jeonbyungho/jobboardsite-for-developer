console.log("👤signUp");

const formSignIn = document.getElementById("formSignIn");

formSignIn.onsubmit = async (event)=>{
	event.preventDefault();
	const form = event.target;
	const result = await requestForm(form);
	console.log(result);
	if(result.success) {
		alert("가입 성공");
	} else {
		alert("가입 실패");
	}
};