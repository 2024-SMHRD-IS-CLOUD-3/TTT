let memberCount = 4; // 기존 멤버 수

function addMember() {
    memberCount++;
    const table = document.getElementById("memberTable").getElementsByTagName("tbody")[0];
    const newRow = table.insertRow();
    newRow.innerHTML = `
        <td>Item #${memberCount}</td>
        <td>Description</td>
        <td>Description</td>
        <td>Description</td>
        <td>Description</td>
    `;
}



function deleteMember() {
    const table = document.getElementById("memberTable").getElementsByTagName("tbody")[0];
    if (table.rows.length > 0) {
        table.deleteRow(table.rows.length - 1);
        memberCount--;
    }
}

function editMember() {
    const table = document.getElementById("memberTable").getElementsByTagName("tbody")[0];
    if (table.rows.length > 0) {
        const rowToEdit = table.rows[table.rows.length - 1];
        rowToEdit.cells[1].textContent = "Edited Name";
        rowToEdit.cells[2].textContent = "Edited Gender";
        rowToEdit.cells[3].textContent = "Edited Date";
        rowToEdit.cells[4].textContent = "Edited Count";
    }
}
