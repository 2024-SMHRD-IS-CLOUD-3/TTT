
document.addEventListener('DOMContentLoaded', function () {
    const calendarEl = document.getElementById('calendar');

    const calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        editable: true,
        selectable: true,
        locale: 'ko',
        height: 'auto',
        events: fetchEventsFromServer,
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek'
        },
        select: function (info) {
            openModal('새로운 일정', null, function () {
                const title = document.getElementById('eventTitle').value;
                const description = document.getElementById('eventDescription').value;
                const trainerId = document.getElementById('trainerId').value;
                const userId = document.getElementById('userId').value;
                const color = document.getElementById('eventColor').value;
                const status = document.getElementById('eventStatus').value;

                if (trainerId && userId) {
                    const newEvent = {
					    id: Date.now(),
					    description: description,
					    startDate: info.startStr.split('T')[0],
					    startTime: info.startStr.split('T')[1] ? info.startStr.split('T')[1] + '+09:00' : '00:00:00+09:00',
					    endDate: info.endStr ? info.endStr.split('T')[0] : info.startStr.split('T')[0],
					    endTime: info.endStr ? (info.endStr.split('T')[1]||'00:00:00') + '+09:00' : '23:59:59+09:00',
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
            openModal('일정 수정', info.event, function () {
                const title = document.getElementById('eventTitle').value;
                const description = document.getElementById('eventDescription').value;
                const trainerId = document.getElementById('trainerId').value;
                const userId = document.getElementById('userId').value;
                const color = document.getElementById('eventColor').value;
                const status = document.getElementById('eventStatus').value;

                if (trainerId && userId) {
                    info.event.setProp('title', title);
                    info.event.setExtendedProp('description', description);
                    info.event.setExtendedProp('trainerId', trainerId);
                    info.event.setExtendedProp('userId', userId);
                    info.event.setExtendedProp('color', color);
                    info.event.setExtendedProp('status', status);

					const updatedEventData = {
			            id: info.event.id,
			            description: description,
			            startDate: info.event.startStr.split('T')[0],
			            startTime: info.event.startStr.split('T')[1] || '00:00:00',
			            endDate: info.event.endStr ? info.event.endStr.split('T')[0] : info.event.startStr.split('T')[0],
			            endTime: info.event.endStr ? info.event.endStr.split('T')[1] || '23:59:59' : '23:59:59',
			            trainerId : trainerId,  // 수정된 부분
			            userId : userId,      // 수정된 부분
			            color: color,
			            status: status
			        };
			        
					saveEventToServer(updatedEventData, true);
                }
                
                
            }, function () {
                deleteEventFromServer(info.event);
                info.event.remove();
            });
            
            document.getElementById('eventTitle').value = info.event.title || '';
		    document.getElementById('eventDescription').value = info.event.extendedProps.description || '';
		    document.getElementById('trainerId').value = info.event.extendedProps.trainerId || '';
		    document.getElementById('userId').value = info.event.extendedProps.userId || '';
		    document.getElementById('eventColor').value = info.event.extendedProps.color || '#ff0000';
		    document.getElementById('eventStatus').value = info.event.extendedProps.status || '';
        },
        eventDrop: function (info) {
        	console.log("eventDrop 부분");
        	
        	updatedEventData = {
			            id: info.event.id,
			            description: info.event.extendedProps.description,
			            startDate: info.event.startStr.split('T')[0],
			            startTime: info.event.startStr.split('T')[1] || '00:00:00',
			            endDate: info.event.endStr ? info.event.endStr.split('T')[0] : info.event.startStr.split('T')[0],
			            endTime: info.event.endStr ? info.event.endStr.split('T')[1] || '23:59:59' : '23:59:59',
			            trainerId: info.event.extendedProps.trainerId , // trainer 객체로 래핑
	       				userId: info.event.extendedProps.userId,            // user 객체로 래핑
			            color: info.event.extendedProps.color,
			            status: info.event.extendedProps.status
			};
        	
    		saveEventToServer(updatedEventData, true);    	
        },
        eventResize: function (info) {
        	console.log("eventResize 부분 : ", info.event);
        	console.log(info.event.extendedProps.trainerId);
        	updatedEventData = {
			            id: info.event.id,
			            description: info.event.extendedProps.description,
			            startDate: info.event.startStr.split('T')[0],
			            startTime: info.event.startStr.split('T')[1] || '00:00:00',
			            endDate: info.event.endStr ? info.event.endStr.split('T')[0] : info.event.startStr.split('T')[0],
			            endTime: info.event.endStr ? info.event.endStr.split('T')[1] || '23:59:59' : '23:59:59',
			            trainerId: info.event.extendedProps.trainerId , // trainer 객체로 래핑
	       				userId: info.event.extendedProps.userId,            // user 객체로 래핑
			            color: info.event.extendedProps.color,
			            status: info.event.extendedProps.status
			};
        	
            saveEventToServer(updatedEventData, true);

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
                        trainerId: schedule.trainer.id,
                        userId: schedule.user.urId,
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
            return response.text();
        })
        .then(text => {
	        if (text) {
	            console.log('Event deleted response:', JSON.parse(text));
	        } else {
	            console.log('Event deleted successfully, no content returned.');
	        }
    	})
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

