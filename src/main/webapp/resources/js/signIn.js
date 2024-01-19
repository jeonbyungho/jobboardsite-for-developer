console.log("👤signIn");

/**
 * @param {HTMLElement} parameterForm 
 */
async function requestForm(parameterForm){
	const formData = new FormData(parameterForm);
	const url = parameterForm.action;
	try{
		const resp = await fetch(url, {
			method: "POST",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
			},
			body: new URLSearchParams(formData),
		});
		if (!resp.ok){
			throw new Error("서버로부터 정상적인 응답을 받지 못했습니다.");
		}
		return resp.json();
	} catch (error){
		console.error("에러가 발생했습니다.", error);
	}
	return;
}

const formSignIn = document.getElementById("formSignIn");

formSignIn.onsubmit = async (event)=>{
	event.preventDefault();
	const form = event.target;
	const user = await requestForm(form);
	console.log(user);
};