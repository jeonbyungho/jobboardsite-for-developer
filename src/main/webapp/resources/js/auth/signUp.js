console.log("👤signIn");

const formSignIn = document.forms.formSignUp;

formSignUp.onsubmit = async (event)=>{
	event.preventDefault();
	const form = event.target;
	const result = await sendForm(form);
	console.log(result);
};

const btnDuplicateUsernameCheck = document.getElementById("btnDuplicateUsernameCheck");
const inputUsername = document.getElementById("inputUsername");

btnDuplicateUsernameCheck.onclick = async ()=>{
	const result = await sendData({username:inputUsername.value}, location.origin + "/signup/duplicate", "POST")
	if (result.duplicate){
		alert("아이디가 중복입니다.");
	} else {
		alert("사용 가능한 아이디입니다.");
	}
}