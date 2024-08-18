document.querySelectorAll('.toggle-labels label').forEach(label => {
    label.addEventListener('click', function () {
        document.querySelectorAll('.toggle-labels label').forEach(l => l.classList.remove('active'));
        this.classList.add('active');
    });
});
