console.log("✍️recruitBull_write");

const formRecruitBull = document.forms.recruitBullForm;

formRecruitBull.onsubmit = async (event)=>{
	event.preventDefault();
	const form = event.target;
	const result = await sendForm(form);
	console.log(result);
};