



var xhr = new XMLHttpRequest();
var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'EWUZvL0MKdidS2N8RzbZjE68K7EByoIycwq6DfiP8%2BDiUXcs1zz0eZVW3jtE2n%2F1E26V80w9fBp2G3ww1qLH3Q%3D%3D';
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20200310'); /**/
queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20200315'); /**/
xhr.open('GET', url + queryParams);
xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
    }
};

xhr.send('');

function responseApi(){
    fetch(url)
    .then(res => res.json())
    .then(myJson => {
        const obj= myJson.data[0];
        console.log(obj)
        const startDay = obj.totalFirstCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        const totalSecond = obj.totalSecondCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        const totalthird = obj.totalThirdCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        const firstCount = obj.firstCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        const secondCount = obj.secondCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        const thirdCnt = obj.thirdCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        document.querySelector(".first-vaccine__numbers").innerHTML = totalFirst;
        document.querySelector(".second-vaccine__numbers").innerHTML = totalSecond;
        document.querySelector(".third-vaccine__numbers").innerHTML = totalthird;
        document.querySelector(".first-vaccine__increase__counts").innerHTML = firstCount
        document.querySelector(".second-vaccine__increase__counts").innerHTML = secondCount;
        document.querySelector(".third-vaccine__increase__counts").innerHTML = thirdCnt;
        document.querySelector(".update-date").innerHTML = "기준: " + obj.baseDate;
    
    })
}