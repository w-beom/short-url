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
            let shortUrl = response.data.shortUrl;
            let text = document.createTextNode(shortUrl.shortUrl);
            shortUrlText.appendChild(text);
        })
        .catch(function (error) {
            alert(error.message);
        });
});
