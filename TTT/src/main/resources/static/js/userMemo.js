const noteContainer = document.getElementById('noteContainer');
const addNoteButton = document.getElementById('addNoteButton');

addNoteButton.addEventListener('click', () => {
    // 새로운 메모지 생성
    const newNote = document.createElement('div');
    newNote.className = 'note';
    
    newNote.innerHTML = `
        <div class="note-header">
            <div class="note-title">
                <label>제 목:</label>
                <input type="text" placeholder="제목을 입력하세요">
            </div>
            <div class="note-buttons">
                <button class="save-btn">저장</button>
                <button class="cancel-btn">취소</button>
            </div>
        </div>
        <div class="note-content">
            <textarea placeholder="내용을 입력하세요"></textarea>
        </div>
        <div class="note-footer">작성 날짜: </div>
    `;

    // 취소 버튼 기능
    const cancelButton = newNote.querySelector('.cancel-btn');
    cancelButton.addEventListener('click', () => {
        noteContainer.removeChild(newNote);
    });

    // 저장 버튼 기능
    const saveButton = newNote.querySelector('.save-btn');
    saveButton.addEventListener('click', () => {
        const titleInput = newNote.querySelector('.note-title input');
        const contentTextarea = newNote.querySelector('.note-content textarea');
        const footer = newNote.querySelector('.note-footer');
        const now = new Date();
        const formattedDate = `${now.getFullYear()}/${now.getMonth() + 1}/${now.getDate()} ${now.getHours()}:${now.getMinutes()}`;
        
        // 제목과 내용을 저장 상태로 변경
        newNote.innerHTML = `
            <div class="note-header">
                <div class="note-title">${titleInput.value}</div>
                <div class="note-buttons">
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </div>
            </div>
            <div class="note-content">${contentTextarea.value}</div>
            <div class="note-footer">작성 날짜: ${formattedDate}</div>
        `;

        // 수정 버튼 기능
        const editButton = newNote.querySelector('.edit-btn');
        editButton.addEventListener('click', () => {
            newNote.innerHTML = `
                <div class="note-header">
                    <div class="note-title">
                        <label>제 목:</label>
                        <input type="text" value="${titleInput.value}">
                    </div>
                    <div class="note-buttons">
                        <button class="save-btn">저장</button>
                        <button class="cancel-btn">취소</button>
                    </div>
                </div>
                <div class="note-content">
                    <textarea>${contentTextarea.value}</textarea>
                </div>
                <div class="note-footer">작성 날짜: ${formattedDate}</div>
            `;
            addNoteEventListeners(newNote);
        });

        // 삭제 버튼 기능
        const deleteButton = newNote.querySelector('.delete-btn');
        deleteButton.addEventListener('click', () => {
            noteContainer.removeChild(newNote);
        });
    });

    // 메모지를 컨테이너에 추가
    noteContainer.appendChild(newNote);
});

function addNoteEventListeners(note) {
    const saveButton = note.querySelector('.save-btn');
    const cancelButton = note.querySelector('.cancel-btn');

    cancelButton.addEventListener('click', () => {
        noteContainer.removeChild(note);
    });

    saveButton.addEventListener('click', () => {
        const titleInput = note.querySelector('.note-title input');
        const contentTextarea = note.querySelector('.note-content textarea');
        const footer = note.querySelector('.note-footer');
        const now = new Date();
        const formattedDate = `${now.getFullYear()}/${now.getMonth() + 1}/${now.getDate()} ${now.getHours()}:${now.getMinutes()}`;
        
        note.innerHTML = `
            <div class="note-header">
                <div class="note-title">${titleInput.value}</div>
                <div class="note-buttons">
                    <button class="edit-btn">수정</button>
                    <button class="delete-btn">삭제</button>
                </div>
            </div>
            <div class="note-content">${contentTextarea.value}</div>
            <div class="note-footer">작성 날짜: ${formattedDate}</div>
        `;

        const editButton = note.querySelector('.edit-btn');
        editButton.addEventListener('click', () => {
            note.innerHTML = `
                <div class="note-header">
                    <div class="note-title">
                        <label>제 목:</label>
                        <input type="text" value="${titleInput.value}">
                    </div>
                    <div class="note-buttons">
                        <button class="save-btn">저장</button>
                        <button class="cancel-btn">취소</button>
                    </div>
                </div>
                <div class="note-content">
                    <textarea>${contentTextarea.value}</textarea>
                </div>
                <div class="note-footer">작성 날짜: ${formattedDate}</div>
            `;
            addNoteEventListeners(note);
        });

        const deleteButton = note.querySelector('.delete-btn');
        deleteButton.addEventListener('click', () => {
            noteContainer.removeChild(note);
        });
    });
}
