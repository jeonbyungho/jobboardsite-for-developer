console.log("👤signIn");

const formSignIn = document.getElementById("formSignUp");

formSignUp.onsubmit = async (event)=>{
	event.preventDefault();
	const form = event.target;
	const result = await requestForm(form);
	console.log(result);
};

const btnDuplicateUsernameCheck = document.getElementById("btnDuplicateUsernameCheck");
const inputUsername = document.getElementById("inputUsername");
btnDuplicateUsernameCheck.onclick = async ()=>{
	const result = await requestData({username:inputUsername.value}, location.origin + "/signup/duplicate", "POST")
	if (result.duplicate){
		alert("아이디가 중복입니다.")
	}
}