function loadDoc(){
    var xhr = new XMLHttpRequest();
    var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson'; /*URL*/
    var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'서비스키'; /*Service Key*/
    queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
    queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20200310'); /**/
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20200315'); /**/

    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myFunction(this);
        }
    };
    xhr.open('GET', url + queryParams, true);
    xhr.send();

    myFunction(data) {

        console.log(data);
    }
}



