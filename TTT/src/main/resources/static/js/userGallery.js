document.addEventListener('DOMContentLoaded', function() {
    // Function to add event listeners to cards
    function addCardEventListeners(card, poseIdx) {
        const deleteButton = card.querySelector('.delete-btn');

        deleteButton.addEventListener('click', () => {
    		const poseIdx = card.getAttribute('data-pose-id');

    		fetch('/pose/deleteImage', {
        		method: 'POST',
        		headers: {
            		'Content-Type': 'application/x-www-form-urlencoded'
        		},
        		body: new URLSearchParams({ poseIdx: poseIdx })
    		})
    		.then(response => {
        		if (response.ok) {
            		card.remove();
        		} else {
            		alert('이미지 삭제에 실패했습니다.');
        		}
    		})
    		.catch(error => {
        		console.error('Error deleting image:', error);
        		alert('이미지 삭제 중 오류가 발생했습니다.');
    		});
		});

    }

    // Initialize event listeners for existing cards
    document.querySelectorAll('.card').forEach(card => {
        const poseIdx = card.getAttribute('data-pose-id');
        addCardEventListeners(card, poseIdx);
    });

    document.getElementById('addPhotoBtn').addEventListener('click', addPhotoCard);
    document.getElementById('compareBtn').addEventListener('click', openCompareModal);
    document.getElementById('compareImagesBtn').addEventListener('click', compareSelectedImages);
    document.getElementById('opacityRange').addEventListener('input', adjustOpacity);

    const compareModal = document.getElementById('compareModal');
    const comparisonResult = document.getElementById('comparisonResult');
    const closeButtons = document.querySelectorAll('.close');

    function openCompareModal() {
        const section2 = document.getElementById('section2');
        const imageSelection = document.getElementById('imageSelection');
        imageSelection.innerHTML = ''; // 기존 선택 항목 초기화

        const images = section2.querySelectorAll('img');
        images.forEach((img, index) => {
            const imageContainer = document.createElement('div');
            imageContainer.classList.add('image-option');
            const checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.dataset.index = index;
            
            const clonedImage = img.cloneNode(true);
            imageContainer.appendChild(checkbox);
            imageContainer.appendChild(clonedImage);
            imageSelection.appendChild(imageContainer);
        });

        compareModal.style.display = 'block';
    }

    function compareSelectedImages() {
        const selectedImages = document.querySelectorAll('#imageSelection input[type="checkbox"]:checked');
        if (selectedImages.length !== 2) {
            alert('사진 2장을 선택해주세요.');
            return;
        }

        const section2 = document.getElementById('section2');
        const images = section2.querySelectorAll('img');
        
        const firstImageIndex = selectedImages[0].dataset.index;
        const secondImageIndex = selectedImages[1].dataset.index;

        const firstImage = document.getElementById('firstImage');
        const secondImage = document.getElementById('secondImage');

        firstImage.src = images[firstImageIndex].src;
        secondImage.src = images[secondImageIndex].src;

        compareModal.style.display = 'none';
        comparisonResult.style.display = 'block';
    }

    function adjustOpacity() {
        const opacity = document.getElementById('opacityRange').value;
        document.getElementById('secondImage').style.opacity = opacity / 100;
    }

    closeButtons.forEach(button => {
        button.onclick = function() {
            this.closest('.modal').style.display = 'none';
        };
    });

    compareModal.onclick = function(event) {
        if (event.target === compareModal) {
            compareModal.style.display = 'none';
        }
    }

    comparisonResult.onclick = function(event) {
        if (event.target === comparisonResult) {
            comparisonResult.style.display = 'none';
        }
    }

    function addPhotoCard() {
        const card = document.createElement('div');
        card.classList.add('card');

        const imageInput = document.createElement('input');
        imageInput.type = 'file';
        imageInput.accept = 'image/*';
        imageInput.style.display = 'none';

        const img = document.createElement('img');
        img.style.display = 'none';

        const addImageButton = document.createElement('button');
        addImageButton.innerText = '이미지 추가';
        addImageButton.addEventListener('click', () => imageInput.click());

        const typeContainer = document.createElement('div');
        const frontLabel = document.createElement('label');
        frontLabel.innerText = 'Front';
        const frontRadio = document.createElement('input');
        frontRadio.type = 'radio';
        frontRadio.name = 'imageType';
        frontRadio.value = 'front';

        const sideLabel = document.createElement('label');
        sideLabel.innerText = 'Side';
        const sideRadio = document.createElement('input');
        sideRadio.type = 'radio';
        sideRadio.name = 'imageType';
        sideRadio.value = 'side';

        typeContainer.appendChild(frontRadio);
        typeContainer.appendChild(frontLabel);
        typeContainer.appendChild(sideRadio);
        typeContainer.appendChild(sideLabel);

        imageInput.addEventListener('change', function() {
            const file = this.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function(e) {
                    img.src = e.target.result;
                    img.style.display = 'block';
                    addImageButton.style.display = 'none';
                };
                reader.readAsDataURL(file);
            }
        });

        const saveButton = document.createElement('button');
        saveButton.innerText = '저장';

        const cancelButton = document.createElement('button');
        cancelButton.innerText = '취소';
        cancelButton.addEventListener('click', () => card.remove());

        const actionButtons = document.createElement('div');
        actionButtons.classList.add('action-buttons');
        actionButtons.appendChild(saveButton);
        actionButtons.appendChild(cancelButton);

        card.appendChild(imageInput);
        card.appendChild(img);
        card.appendChild(typeContainer);
        card.appendChild(addImageButton);
        card.appendChild(actionButtons);

        document.getElementById('section2').appendChild(card);
        
        saveButton.addEventListener('click', function() {
            const selectedType = document.querySelector('input[name="imageType"]:checked');
            if (!selectedType) {
                alert('이미지 타입을 선택해주세요.');
                return;
            }

            const formData = new FormData();
            console.log(imageInput.files[0]);  // 파일 객체 확인 -> 나중에 지우기
            formData.append('poseImg', imageInput.files[0]);
            formData.append('poseType', selectedType.value);

            // 현재 날짜를 추가
            const currentDate = new Date().toISOString();
            formData.append('createdAt', currentDate);
			
			const userId = document.getElementById('userIdField').value;
			formData.append('userId', userId);
			
            fetch('/pose/processAndSave', {
                method: 'POST',
                body: formData
            })
            .then(response => response.json())
            .then(data => {
                    if (data.success) {
                        alert('이미지가 성공적으로 업로드되었습니다.');
                        saveButton.style.display = 'none';
                        cancelButton.style.display = 'none';

                        const deleteButton = document.createElement('button');
                        deleteButton.innerText = '삭제';
                        deleteButton.classList.add('delete-button');
                        deleteButton.addEventListener('click', function() {
                            card.remove();
                        });

                        card.appendChild(deleteButton);

                        const dateLabel = document.createElement('p');
                        dateLabel.classList.add('date-label');
                        dateLabel.innerHTML = `등록 일자: ${new Date(currentDate).toLocaleDateString('ko-KR')} | 타입: ${selectedType.value}`;
                        card.appendChild(dateLabel);
                        window.location.href = `/pose/Gallery?userId=${userId}`;
                    } else {
                        alert('이미지 업로드에 실패했습니다.');
                    }
              })
            .catch(error => {
                  console.error('Error uploading image:', error);
                  alert('이미지 업로드 중 오류가 발생했습니다.');
             });
        });
    }
});
