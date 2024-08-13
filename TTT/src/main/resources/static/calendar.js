document.addEventListener('DOMContentLoaded', function() {
    // $(function () {
    //     var request = $ajax({
    //         url: "/full-calendar/calendar-admin", // 변경하기
    //         method: "GET",
    //         dataType: "json"
    //     });

        var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth', // 기본 뷰를 월간 달력으로 설정
                editable: true, // 드래그 앤 드롭, 리사이즈를 가능하게 함
                selectable: true, // 달력에서 드래그하여 새 이벤트 생성 가능
                events: [
                    {
                        id: '1',
                        title: 'Event 1',
                        start: '2024-08-15',
                        description: 'This is a cool event',
                        location: 'New York'
                    },
                    {
                        id: '2',
                        title: 'Event 2',
                        start: '2024-08-16T09:25',
                        end: '2024-08-18',
                        description: 'Another great event',
                        location: 'Los Angeles'
                    }
                ],
                headerToolbar: {
                    left: 'prev,next today', // 왼쪽에 이전, 다음, 오늘 버튼
                    center: 'title', // 가운데에 달력 제목
                    right: 'dayGridMonth,timeGridWeek' // 오른쪽에 뷰 선택 버튼
                },

                select: function(info) {  // 날짜 선택 시 새로운 이벤트 추가
                    openModal('Add Event', null, function() {
                        var title = document.getElementById('eventTitle').value;
                        var description = document.getElementById('eventDescription').value;
                        if (title) {
                            var newEvent = {
                                id: Date.now().toString(),
                                title: title,
                                start: info.start,
                                end: info.end,
                                allDay: info.allDay,
                                description: description,
                            };

                            calendar.addEvent(newEvent);
                            saveEventToServer(newEvent);  // 서버로 이벤트 전송
                        }
                    });
                    calendar.unselect();
                },

                eventClick: function(info) {
                    console.log(info);
                    openModal('Edit Event', info.event, function() {
                        var title = document.getElementById('eventTitle').value;
                        var description = document.getElementById('eventDescription').value;

                        if (title) {
                            info.event.setProp('title', title);
                            info.event.setExtendedProp('description', description);
                            saveEventToServer(info.event, true); 
                        }
                    }, function() {
                        // 삭제 버튼 클릭 시 이벤트 삭제
                        deleteEventFromServer(info.event);
                        info.event.remove();
                    });
                },
                // 이벤트 드래그 앤 드롭 후 수정된 날짜를 콘솔에 출력
                eventDrop: function(info) {
                    console.log(info);
                    console.log(`Event ${info.event.title} was dropped on ${info.event.start.toISOString()}`);
                    saveEventToServer(info.event, true);
                },
                // 이벤트 리사이즈 후 수정된 날짜를 콘솔에 출력
                eventResize: function(info) {
                    console.log(`Event ${info.event.title} was resized to end on ${info.event.end.toISOString()}`);
                    saveEventToServer(info.event, true);
                }
            }   
        )
        calendar.render();
    
        function saveEventToServer(eventData, isEdit = false) {
            const url = isEdit ? `/api/events/${eventData.id}` : '/api/events';
            const method = isEdit ? 'PUT' : 'POST';

            const eventObject = {
                id: eventData.id,
                title: eventData.title,
                start: new Date(eventData.start).toLocaleString('sv-SE', { timeZone: 'Asia/Seoul', hour12: false }).replace(' ', 'T'), 
                end: eventData.end ? new Date(eventData.end).toLocaleString('sv-SE', { timeZone: 'Asia/Seoul', hour12: false }).replace(' ', 'T') : null,
                allDay: eventData.allDay,
                description: eventData.description
            };
            console.log(eventObject)

            fetch(url, {
                method: method,
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(eventObject)
            })
            .then(response => response.json())
            .then(data => console.log('Event saved:', data))
            .catch(error => console.error('Error:', error));
        }
    
        function deleteEventFromServer(eventData) {
            fetch(`/api/events/${eventData.id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.json())
            .then(data => console.log('Event deleted:', data))
            .catch(error => console.error('Error:', error));
        }
    
    
    
        function openModal(modalTitle, event, saveCallback, deleteCallback) {
            var modal = document.getElementById('eventModal');
            var titleInput = document.getElementById('eventTitle');
            var descriptionInput = document.getElementById('eventDescription');
            var saveButton = document.getElementById('saveEvent');
            var deleteButton = document.getElementById('deleteEvent');
            var closeButton = document.getElementById('closeModal');
            var modalTitleElement = document.getElementById('modalTitle');
    
            // 모달 제목 설정
            modalTitleElement.textContent = modalTitle;
    
            // 기존 이벤트가 있으면 값을 채우기
            if (event) {
                titleInput.value = event.title;
                descriptionInput.value = event.extendedProps.description;
                deleteButton.style.display = 'inline'; // 삭제 버튼 표시
    
            } else {
                titleInput.value = '';
                descriptionInput.value = '';
                deleteButton.style.display = 'none'; // 삭제 버튼 숨기기
            }
    
            // 모달 창 표시
            modal.style.display = 'flex';
    
            // 이벤트 저장 버튼 클릭 시
            saveButton.onclick = function() {
                saveCallback();
                modal.style.display = 'none';
            };
    
            // 이벤트 삭제 버튼 클릭 시
            deleteButton.onclick = function() {
                deleteCallback();
                modal.style.display = 'none';
            };
    
            // 모달 창 취소 버튼 클릭 시
            closeButton.onclick = function() {
                modal.style.display = 'none';
            };
        }
    }
);

    // function saveEventToServer(eventData, isEdit = false) {
    //     const url = isEdit ? `/api/events/${eventData.id}` : '/api/events';
    //     const method = isEdit ? 'PUT' : 'POST';
    
    //     return fetch(url, {
    //         method: method,
    //         headers: {
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify(eventData)
    //     })
    //     .then(response => response.json());
    // }
    
    // function fetchEventsFromServer() {
    //     return fetch('/api/events')
    //         .then(response => response.json());
    // }
    
