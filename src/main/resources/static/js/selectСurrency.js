document.querySelector(".form-control").addEventListener('change', async (event)=>{

    document.querySelector('.info-block').innerHTML = "";

    const currencyId = event.target.value;
    /**
     *
     * Текущая дата - 4 сентября (просто так данные таблица заполнены,
     * если бы это было настоящее приложение с реальными выгруженными свежими данными?
     * то просто передавали бы new Date()
     *
     */
    let date = new Date(2020,8, 5);
    let data = {"id" : currencyId,
                "date" : date};
    console.log(data);
    let response = await fetch('/currentDate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    let result = await response.json();

    document.querySelector('.info-block').insertAdjacentHTML("beforeend", `
    <div class="current-info">
                <div class="info-header">Текущий курс</div>
                <div class="current-date">${result['currentDate']}</div>
                <div class="current-course">${result['currentValue']}</div>
            </div>
            <div class="day-before-info">
                <div class="info-header">Вчера</div>
                <div class="day-before">${result['dayBeforeDate']}</div>
                <div class="course-day-before">${result['dayBeforeValue']}</div>
            </div>
            <div class="two-days-before-info">
                <div class="info-header">Позавчера</div>
                <div class="two-days-before">${result['twoDaysBeforeDate']}</div>
                <div class="course-two-days-before">${result['twoDaysBeforeValue']}</div>
            </div>
    `);

});