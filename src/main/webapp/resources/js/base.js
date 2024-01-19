/**
 * @param {HTMLElement} parameterForm
 * @param {String} req_method
 */
async function requestForm(parameterForm, req_method="POST"){
	const formData = new FormData(parameterForm);
	const url = parameterForm.action;
	try{
		const resp = await fetch(url, {
			method: req_method,
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

/**
 * @param {Object} data 
 * @param {String} url 
 * @param {String} req_method 
 */
async function requestData(data, url, req_method="GET"){
	try{
		const resp = await fetch(url, {
			method: req_method,
			headers: {
				"Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
			},
			body: new URLSearchParams(data),
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