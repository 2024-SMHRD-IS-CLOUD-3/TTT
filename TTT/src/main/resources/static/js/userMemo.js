const noteContainer = document.getElementById('noteContainer');
const addNoteButton = document.getElementById('addNoteButton');

const userId = document.getElementById('userIdField').value;

addNoteButton.addEventListener('click', () => {
    // 새로운 메모지 생성
    const newNote = document.createElement('div');
    newNote.className = 'note';
    
    newNote.innerHTML = `
        <div class="note-header">
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
        const contentTextarea = newNote.querySelector('.note-content textarea');
        const footer = newNote.querySelector('.note-footer');
        const now = new Date();
        const formattedDate = `${now.getFullYear()}/${now.getMonth() + 1}/${now.getDate()} ${now.getHours()}:${now.getMinutes()}`;
        
        // 서버에 메모를 저장하기 위한 API 호출
        fetch('/createMemo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                userId: userId, // 실제 사용자 ID로 변경 필요
                memoContent: contentTextarea.value,
                createdAt: now.toISOString() // ISO 형식으로 저장
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                newNote.innerHTML = `
                    <div class="note-header">
                        <div class="note-buttons">
                            <button class="edit-btn">수정</button>
                            <button class="delete-btn">삭제</button>
                        </div>
                    </div>
                    <div class="note-content">${contentTextarea.value}</div>
                    <div class="note-footer">작성 날짜: ${formattedDate}</div>
                `;
                addNoteEventListeners(newNote, data.memoIdx); // memoIdx 추가
            }
        })
        .catch(error => {
            console.error('Error saving memo:', error);
            alert('메모 저장 중 오류가 발생했습니다.');
        });
    });

    // 메모지를 컨테이너에 추가
    noteContainer.appendChild(newNote);
});

function addNoteEventListeners(note, memoIdx) {
    const editButton = note.querySelector('.edit-btn');
    const deleteButton = note.querySelector('.delete-btn');
    
    editButton.addEventListener('click', () => {
        const noteContent = note.querySelector('.note-content').innerText;

        const now = new Date();
        const formattedDate = `${now.getFullYear()}/${now.getMonth() + 1}/${now.getDate()} ${now.getHours()}:${now.getMinutes()}`;

        note.innerHTML = `
            <div class="note-header">
                <div class="note-buttons">
                    <button class="save-btn">저장</button>
                    <button class="cancel-btn">취소</button>
                </div>
            </div>
            <div class="note-content">
                <textarea>${noteContent}</textarea>
            </div>
            <div class="note-footer">작성 날짜: ${formattedDate}</div>
        `;

        const saveButton = note.querySelector('.save-btn');
        const cancelButton = note.querySelector('.cancel-btn');

        cancelButton.addEventListener('click', () => {
            location.reload(); // 페이지를 다시 로드하여 수정 취소
        });

        saveButton.addEventListener('click', () => {
            const updatedContent = note.querySelector('.note-content textarea').value;

            // 서버에 수정된 메모를 업데이트하기 위한 API 호출
            fetch(`/updateMemo/${memoIdx}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    memoContent: updatedContent,
                    createdAt: new Date().toISOString() // 현재 시간으로 갱신
                })
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    note.innerHTML = `
                        <div class="note-header">
                            <div class="note-buttons">
                                <button class="edit-btn">수정</button>
                                <button class="delete-btn">삭제</button>
                            </div>
                        </div>
                        <div class="note-content">${updatedContent}</div>
                        <div class="note-footer">작성 날짜: ${new Date().toLocaleString()}</div>
                    `;
                    addNoteEventListeners(note, memoIdx); // 수정 후 이벤트 리스너 다시 추가
                }
            })
            .catch(error => {
                console.error('Error updating memo:', error);
                alert('메모 수정 중 오류가 발생했습니다.');
            });
        });
    });

    deleteButton.addEventListener('click', () => {
        // 삭제 버튼 클릭 시 서버에 삭제 요청
        fetch(`/deleteMemo/${memoIdx}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                noteContainer.removeChild(note);
            } else {
                alert('메모 삭제에 실패했습니다.');
            }
        })
        .catch(error => {
            console.error('Error deleting memo:', error);
            alert('메모 삭제 중 오류가 발생했습니다.');
        });
    });
}
