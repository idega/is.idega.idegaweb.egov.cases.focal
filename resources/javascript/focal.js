var focal_project_row_id = null;

function selectFocalCasesRow(e) {
	if(e) {
		var newRow = document.getElementById(e);
		if(newRow != null) {
			if(newRow.className) {
				newRow.className = 'selectedProject';
				var oldRow = document.getElementById(focal_project_row_id);
				if(oldRow != null) {
					if(oldRow.className) {
						oldRow.className = 'firstRow';
					}
				}
				focal_project_row_id = e;
			}
		}
	}
}