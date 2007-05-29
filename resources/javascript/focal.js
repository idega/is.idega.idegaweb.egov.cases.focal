function selectFocalCasesRow(e) {
	if (!e) e = window.event;
	if (!e) return false;
	if(e.srcElement) {
		
	} else if(e.target) {
		alert(e.target);
	}
}