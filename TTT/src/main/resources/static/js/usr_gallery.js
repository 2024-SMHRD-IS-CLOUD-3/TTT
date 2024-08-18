document.addEventListener('DOMContentLoaded', function() {
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
            imageContainer.appendChild(checkbox);
            imageContainer.appendChild(img.cloneNode(true));
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
        card.appendChild(addImageButton);
        card.appendChild(actionButtons);

        document.getElementById('section2').appendChild(card);

        saveButton.addEventListener('click', function() {
            saveButton.style.display = 'none';
            cancelButton.style.display = 'none';

            const deleteButton = document.createElement('button');
            deleteButton.innerText = '삭제';
            deleteButton.classList.add('delete-button');
            deleteButton.addEventListener('click', function() {
                showConfirmDialog(card);
            });

            card.appendChild(deleteButton);

            const currentDate = new Date().toLocaleDateString('ko-KR');
            const dateLabel = document.createElement('p');
            dateLabel.classList.add('date-label');
            dateLabel.innerHTML = `등록 일자: ${currentDate}`;
            card.appendChild(dateLabel);
        });
    }

    function showConfirmDialog(card) {
        const confirmDialog = document.createElement('div');
        confirmDialog.classList.add('confirm-dialog');

        const confirmText = document.createElement('p');
        confirmText.innerText = '삭제하시겠습니까?';

        const confirmButtons = document.createElement('div');
        confirmButtons.classList.add('confirm-buttons');

        const yesButton = document.createElement('button');
        yesButton.innerText = '예';
        yesButton.addEventListener('click', () => {
            card.remove();
            confirmDialog.remove();
        });

        const noButton = document.createElement('button');
        noButton.innerText = '아니오';
        noButton.addEventListener('click', () => confirmDialog.remove());

        confirmButtons.appendChild(yesButton);
        confirmButtons.appendChild(noButton);
        confirmDialog.appendChild(confirmText);
        confirmDialog.appendChild(confirmButtons);

        document.body.appendChild(confirmDialog);
    }
});