console.log("👤signUp");

const formSignIn = document.getElementById("formSignIn");
const urlParams = new URL(location.href).searchParams;

formSignIn.onsubmit = async (event)=>{
	event.preventDefault();
	const form = event.target;
	const result = await requestForm(form);
	console.log(result);
	if(result.success) {
		location.href = location.origin + urlParams.get("redirect");
	}
};