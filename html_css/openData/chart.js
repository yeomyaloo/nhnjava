const labels = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
  ];

  const data = {
    labels: labels,
    datasets: [{
      label: 'My First dataset',
      backgroundColor: 'rgb(255, 99, 132)',
      borderColor: 'rgb(255, 99, 132)',
      data: [0, 10, 5, 2, 20, 30, 45],
    }]
  };

  const config = {
    type: 'line',
    data: data,
    options: {}
  };

  const myChart = new Chart(
    document.getElementById('myChart'),
    config
  );


  itemLabels = []
  decidePeople = []
$.get("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=EWUZvL0MKdidS2N8RzbZjE68K7EByoIycwq6DfiP8%2BDiUXcs1zz0eZVW3jtE2n%2F1E26V80w9fBp2G3ww1qLH3Q%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315",
function(data){
  $(data).find('item').each(function(){
    var $now = $(this);
    var date = $now.find('stateDt').text();
    var decideCnt = $now.find('decideCnt').text();
    
    itemLabels.push(date);
    decidePeople.push(decideCnt);

  });
    const Chart = new Chart(document.getElementById("myChart",{

        
        labels: itemLabels,
        datasets: [{
          label: 'My First dataset',
          backgroundColor: 'rgb(255, 99, 132)',
          borderColor: 'rgb(255, 99, 132)',
          data: decidePeople,
        }]

    }));   
});




