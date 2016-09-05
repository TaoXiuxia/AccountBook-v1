function setLeftColumn(){
	console.log($("#income").val());
	$("#income").addClass("left-column-button-inactive");
	$("#income").addClass("left-column-button-inactive-font");
	$("#expenditure").addClass("left-column-button-inactive");
	$("#expenditure").addClass("left-column-button-inactive-font");
	$("#borrow").addClass("left-column-button-active");
	$("#borrow").addClass("left-column-button-active-font");
}
