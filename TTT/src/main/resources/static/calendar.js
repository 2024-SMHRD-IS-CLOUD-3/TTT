
document.addEventListener('DOMContentLoaded', function () {
    const calendarEl = document.getElementById('calendar');

    const calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        editable: true,
        selectable: true,
        events: fetchEventsFromServer,
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek'
        },
        select: function (info) {
            openModal('Add Event', null, function () {
                const title = document.getElementById('eventTitle').value;
                const description = document.getElementById('eventDescription').value;
                const trainerId = document.getElementById('trainerId').value;
                const userId = document.getElementById('userId').value;
                const color = document.getElementById('eventColor').value;
                const status = document.getElementById('eventStatus').value;

                if (title && trainerId && userId) {
                    const newEvent = {
                        id: Date.now(),
                        description: description,
                        startDate: info.startStr.split('T')[0],
                        startTime: info.startStr.split('T')[1] || '00:00:00',
                        endDate: info.endStr ? info.endStr.split('T')[0] : info.startStr.split('T')[0],
                        endTime: info.endStr ? info.endStr.split('T')[1] || '23:59:59' : '23:59:59',
                        trainerId: trainerId,
                        userId: userId,
                        color: color,
                        status: status
                    };
                    calendar.addEvent({
                        title: title,
                        start: newEvent.startDate + 'T' + newEvent.startTime,
                        end: newEvent.endDate + 'T' + newEvent.endTime,
                        extendedProps: newEvent
                    });
                    saveEventToServer(newEvent);
                }
            });
            calendar.unselect();
        },
        eventClick: function (info) {
            openModal('Edit Event', info.event, function () {
                const title = document.getElementById('eventTitle').value;
                const description = document.getElementById('eventDescription').value;
                const trainerId = document.getElementById('trainerId').value;
                const userId = document.getElementById('userId').value;
                const color = document.getElementById('eventColor').value;
                const status = document.getElementById('eventStatus').value;

                if (title && trainerId && userId) {
                    info.event.setProp('title', title);
                    info.event.setExtendedProp('description', description);
                    info.event.setExtendedProp('trainerId', trainerId);
                    info.event.setExtendedProp('userId', userId);
                    info.event.setExtendedProp('color', color);
                    info.event.setExtendedProp('status', status);
                    saveEventToServer(info.event.extendedProps, true);
                }
            }, function () {
                deleteEventFromServer(info.event);
                info.event.remove();
            });
        },
        eventDrop: function (info) {
            saveEventToServer(info.event.extendedProps, true);
        },
        eventResize: function (info) {
            saveEventToServer(info.event.extendedProps, true);
        }
    });

    calendar.render();


    function fetchEventsFromServer(fetchInfo, successCallback, failureCallback) {
        fetch('/api/schedules')
            .then(response => response.json())
            .then(data => {
                const events = data.map(schedule => ({
                    id: schedule.id,
                    title: schedule.description, // Assuming title is the description
                    start: schedule.startDate + 'T' + schedule.startTime,
                    end: schedule.endDate + 'T' + schedule.endTime,
                    extendedProps: {
                        description: schedule.description,
                        trainerId: schedule.trainerId,
                        userId: schedule.userId,
                        color: schedule.color,
                        status: schedule.status
                    }
                }));
                successCallback(events);
            })
            .catch(error => failureCallback(error));
    }

    function saveEventToServer(eventData, isEdit = false) {
    const url = isEdit ? `/api/schedules/${eventData.id}` : '/api/schedules';
    const method = isEdit ? 'PUT' : 'POST';

    // 서버에서 기대하는 필드 이름과 일치하도록 전송하는 데이터 형식을 맞춥니다.
    const eventObject = {
        id: eventData.id,
        description: eventData.description,
        startDate: eventData.startDate,
        startTime: eventData.startTime,
        endDate: eventData.endDate,
        endTime: eventData.endTime,
        trainer: { id: eventData.trainerId }, // trainer 객체로 래핑
        user: { urId: eventData.userId },            // user 객체로 래핑
        color: eventData.color,
        status: eventData.status
    };

    console.log("Sending event object to server:", eventObject);

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(eventObject)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Server error: ${response.status}`);
        }
        return response.json();
    })
    .then(data => console.log('Event saved:', data))
    .catch(error => console.error('Error:', error));
}

    function deleteEventFromServer(eventData) {
        fetch(`/api/schedules/${eventData.id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Server error: ${response.status}`);
            }
            return response.json();
        })
        .then(data => console.log('Event deleted:', data))
        .catch(error => console.error('Error:', error));
    }

            function openModal(modalTitle, event, saveCallback, deleteCallback) {
            const modal = document.getElementById('eventModal');
            const titleInput = document.getElementById('eventTitle');
            const descriptionInput = document.getElementById('eventDescription');
            const trainerInput = document.getElementById('trainerId');
            const userInput = document.getElementById('userId');
            const colorInput = document.getElementById('eventColor');
            const statusInput = document.getElementById('eventStatus');
            const saveButton = document.getElementById('saveEvent');
            const deleteButton = document.getElementById('deleteEvent');
            const closeButton = document.getElementById('closeModal');
            const modalTitleElement = document.getElementById('modalTitle');

            if (!modal || !titleInput || !descriptionInput || !trainerInput || !userInput || !colorInput || !statusInput) {
                console.error('One or more modal elements are missing.');
                return;
            }

            modalTitleElement.textContent = modalTitle;

            if (event) {
                titleInput.value = event.title || '';
                descriptionInput.value = event.extendedProps.description || '';
                trainerInput.value = event.extendedProps.trainerId || '';
                userInput.value = event.extendedProps.userId || '';
                colorInput.value = event.extendedProps.color || '#ff0000';
                statusInput.value = event.extendedProps.status || '';
                deleteButton.style.display = 'inline';
            } else {
                titleInput.value = '';
                descriptionInput.value = '';
                trainerInput.value = '';
                userInput.value = '';
                colorInput.value = '#ff0000';
                statusInput.value = '';
                deleteButton.style.display = 'none';
            }

            modal.style.display = 'flex';

            saveButton.onclick = function () {
                saveCallback();
                modal.style.display = 'none';
            };

            if (deleteCallback) {
                deleteButton.onclick = function () {
                    deleteCallback();
                    modal.style.display = 'none';
                };
            }

            closeButton.onclick = function () {
                modal.style.display = 'none';
            };
        
    }
});

