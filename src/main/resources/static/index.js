const submitButton = document.getElementById("submit-btn");
const input = document.getElementById("input-url");
const shortUrlText = document.getElementById("short-url-text")

submitButton.addEventListener('click', () => {
    axios({
        method: 'post',
        url: '/short-url',
        headers: {
            'Content-Type': 'application/json'
        },
        data: {
            url: input.value
        }
    })
        .then(function (response) {
            shortUrlText.innerHTML = "";

            let shortUrl = response.data.shortUrl;
            let fullUrl = window.location.protocol + '//' + window.location.hostname + '/' + shortUrl;
            let aTag = document.createElement('a');
            aTag.setAttribute("href", fullUrl);

            let text = document.createTextNode(fullUrl);
            aTag.appendChild(text);
            shortUrlText.appendChild(aTag);
        })
        .catch(function (error) {
            console.log(error);
            if (error.response.status === 400) {
                alert('유효하지 않은 URL입니다.');
            }
        });
});
