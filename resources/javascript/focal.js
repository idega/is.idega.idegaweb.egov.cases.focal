var focal_project_row_id = null;

function selectFocalCasesRow(e) {
	if(e) {
		var temp = focal_project_row_id;
		var newRow = document.getElementById(e);
		if(newRow != null) {
			if(newRow.className) {
				newRow.className = 'selectedProject';
				if(focal_project_row_id != null && focal_project_row_id != e) {
					var oldRow = document.getElementById(focal_project_row_id);
					if(oldRow != null) {
						if(oldRow.className) {
							oldRow.className = 'focalRow';
						}
					}
				}
				focal_project_row_id = e;
			}
		}
	}
}

function isProjectSelected() {
	
}

function searchProjects(event) {
	if(isEnterEvent(event)) {
		changeInputValue(findObj('cp_prm_action'), '4');
		document.forms['focalProjectSearchForm'].submit();
	}
}

function doProjectSearch(searchString) {
	if(searchString != null && searchString != '') {
		FocalCasesIntegration.findProjects(searchString, updateProjectTable);
	}
}

function updateProjectTable(dataList) {
	if(dataList != null) {
		var projectTable = document.getElementById('projectTable');
		if(projectTable != null) {
			if(projectTable.childNodes) {
				var tbody = projectTable.childNodes[5];
				if(tbody != null) {
					for(var i=0;i<dataList.length;i++) {
						var row = createProjectTableRow(dataList[i], i);
						tbody.appendChild(row);
					}
				}
			}
		}
	}
}

function createProjectTableRow(parameter, index) {
	var row = document.createElement('tr');
	row.id = 'focalRow' + index;
	row.setAttribute('class', 'firstRow');
	
	var cell1 = document.createElement('td');
	cell1.setAttribute('class', 'firstColumn caseNumber');
	var projectName = document.createTextNode(parameter.name);
	cell1.appendChild(projectName);
	row.appendChild(cell1);
	
	var cell2 = document.createElement('td');
	cell2.setAttribute('class', 'lastColumn caseNumber');
	var customerName = document.createTextNode(parameter.customer);
	cell2.appendChild(customerName);
	row.appendChild(cell2);
	
	var cell3 = document.createElement('td');
	cell3.setAttribute('class', 'view');
	var link = document.createElement('a');
	link.setAttribute('onclick', 'changeInputValue(findObj(\'prm_project_pk\'), this.id);selectFocalCasesRow(\'focalRow' + index + '\');return false;');
	link.setAttribute('href', '#');
	var icon = document.createElement('img');
	icon.setAttribute('name', 'View case');
	icon.setAttribute('src', '/idegaweb/bundles/is.idega.idegaweb.egov.cases.focal.bundle/resources/edit.png');
	link.appendChild(icon);
	cell3.appendChild(link);
	row.appendChild(cell3);
	return row;
}