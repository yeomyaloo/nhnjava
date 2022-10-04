

$(document).ready(function(){
    $.ajax({
        url:'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=EWUZvL0MKdidS2N8RzbZjE68K7EByoIycwq6DfiP8%2BDiUXcs1zz0eZVW3jtE2n%2F1E26V80w9fBp2G3ww1qLH3Q%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315', //통신을 원하는 URL 주소
        type: 'GET',
        dataType: 'xml', //서버로부터 받을 데이터 타입 입력
        success: function(response){
            xmlPasing(response); //내가 만들 parsing
        },
        error: function(xhr, status, msg){
            console.log('상태값 : ' + status+' Http에러메서지' + msg);
        },
    });

    function xmlPasing(data){
        var infoList = ``;
        $(data).find('item').each(function(indext, stuff){
            infoList += `<tr>
                            <td>${$(this).find('stateDt').text()}</td>
                            <td>${$(this).find('decideCnt').text()}</td>
                            <td>${$(this).find('accExamCnt').text()}</td>
                        </tr>
            `;

            $('.covid_dashboard_data').empty().append(infoList);
 
        });
    }
});




