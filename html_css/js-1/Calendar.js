
//현재 해당하는 일을 가져온다.
const Day = document.querySelector('.day'); 
const month = document.querySelector('.chooseMonth');
const date = new Date();


//앞달로 가는 버튼, 뒷달로 가는 버튼을 저장.
const preBtn = document.querySelector('.left');
const nextBtn = document.querySelector('.right');


/* todolist 관련 
    - querySelector = 해당 이름을 가진 선택자를 가져옴*/
//todo field 가져옴
const todoField = document.querySelector('.todo');
//todo list의 제목에 오늘의 날짜를 표시 todo list on ~ (오늘 날짜)
const todoTitle = document.querySelector('.todo-title');
const todoList = document.querySelector('.todoList');

/* todolist edit 관련
    - input: 입력 값을 받아옴(입력이 하나 밖에 없어서 가능?)

*/
const input = document.querySelector('input[type ="text"]');
const add = document.querySelector('.add');
const reset = document.querySelector('.reset');
const allReset = document.querySelector('.allReset'); 

/*
    현재 날짜를 받아옴 year, month, day
*/
let currentMon = date.getMonth() + 1;
let currentYear = date.getUTCFullYear();
let currentDay = date.getDate();


let dayOfChoice = currentDay;
let monOfChoice = currentMon;
let yearOfChoice = currentYear;

let year = currentYear;
let mon = currentMon;

let clickEventArr = [];
let storeTodo = [];


//윤년 계산 -> 2월이 윤년인 경우가 있기 때문
function isLeapYear(year) {
    return(year%4 === 0 ) && ((year%400 === 0)||year % 100 === 0);
}

//해당 달이 며칠까지 있는지를 확인(해당 달에 일수를 돌려줌 2 -> 28 or 29일을 돌려주는 것과 같음)
function getDayOfMon(mon, year){
    if(mon === 1 || mon === 3 || mon === 5 ||mon === 7 || mon === 8 || mon === 10 || mon === 12){
        return 31;
    } 
    else if (mon == 2){ 
        return isLeapYear(year) ? 29 : 28 ;
    }
    else{
        return 30;
    }
}


// 해당 형식을 Date()에 넣어 만들고 해당 요일일을 돌려줄 수 있게 한다.
function getDay(year, mon, date){
    const conYMD = year + '-' + mon + '-' + date;
    return (new Date(conYMD).getDay());
}



/**
 * 
 * dayCount -> getDayOfMon(mon, yaer) 을 널어주면 해당 달의 일수만큼 for문이 돈다.
 * 
 */
function makeCalendar(year, mon, dayCount){
    clickEventArr = [];
    
    // 해당 날짜에 맞게 변하는 selector day를 빈 문자로 초기화
    Day.innerHTML = '';
    
    //해당 년도, 달에 1일에 해당하는 값을 찾아온다.
    let getFirstDay = getDay(year, mon,1);
    
    
    //해당 값이 1월일 경우 전달은 12월이다.
    let preveiousMon;
    if(currentMon - 1 < 0){
        preveiousMon = 12;
    }
    
    else{ // 1월이 아닌 나머지 경우라면 현재 달에서 -1 해주면 된다.
        preveiousMon = currentMon - 1;
    }


    let getDayPreMon = getDayOfMon(preveiousMon, year);
    for (let i = (getFirstDay + 6)%7 ; i>0 ; i--){
        const listPre = document.createElement('li');

        /**
         * document.createElement('li') -> <li> 추가하는 방식 
         * textContent -> <li>가져온 month의 day를 그리기</li>
         *  */ 
        listPre.textContent = `${getDayPreMon(i-1)}`;
        listPre.style.opacity = '0.5'; //불투명도? 
        listPre.classList.add('disabled');
        Day.appendChild(listPre);
    }

    /**
     * 해당 선택한 날짜에 빨간 테두리
     * 선택하지 않은 날짜의 캘린더의 태두리는 검은색
     */
    for (let i = 1; i <= dayCount; i++) {
        if(i === currentDay && year === currentYear && mon === currentMon){
            const onlyOneList = document.createElement('li');
            onlyOneList.textContent = `${i}`;
            if(currentYear === yearOfChoice && currentMon === monOfChoice && currentDay === dayOfChoice){
                onlyOneList.style.border = '3px solid red';
            } 
            else{
                onlyOneList.style.border = '3px solid black';
            }

            /**
             * 해당 day가 일요일, 토요일일 경우엔 해당 색으로 날짜를 표시해준다.
             */
            if(0 === getDay(year,mon, i)) {
                onlyOneList.style.color = 'red';
            } else if(6==getDay(year,mon,i)){
                onlyOneList.style.color = 'blue';
            }


            //현재 년, 월이 같을 경우
            Day.addEventListener('click', (event)=>{
                if(event.target !== onlyOneList) {
                    onlyOneList.style.border = '3px solid black'; 
                }
            });

            Day.appendChild(onlyOneList);
            continue;
        } //if문 끝


        
        const list = document.createElement('li');
        list.textContent = `${i}`;

        /**
         * 해당 날짜가 내가 선택한 날짜라면 빨간 테두리 생성
         */
        if(i === dayOfChoice && year === yearOfChoice && mon === monOfChoice){
            list.style.border = '3px solid res';

            Day.addEventListener('click', (event)=>{
                if(event.target !== list ){
                    list.style.border = 'none';
                }
            });
        }

        //해당 
        if(0 === getDay(year,mon, i)) {
            onlyOneList.style.color = 'red';
        } 
        else if(6==getDay(year,mon,i)){
            onlyOneList.style.color = 'blue';
        }

        Day.appendChild(list);
    }
}

function setMonthTitle(year,mon){
    //해당 <p>의 content로 현재 선택한 year.month 형식으로 출력된다.
    month.textContent = `${year}.${mon}`;
}

function nextMonthOrYear(){

    /**
     * 현재 해당 월이 12월인 경우 다음 년도를 누르면 1월로 바뀌고 년이 1년 추가되어야 한다.
     */
    if(mon === 12){
        year = year + 1;
        mon = 1;
    } 
    else{
        mon = mon + 1;
    }

    setMonthTitle(year, mon);
    makeCalendar(year, mon, getDayOfMon(mon, year)); //getDayOfMon -> 해당 달에 해당하는 일수를 돌려줌.

}

function preMonthOrYear(){
    if(mon === 1){
        year = year - 1;
        mon = 12;
    }
    else{
        mon = mon - 1;
    }

    setMonthTitle(year, mon);
    makeCalendar(year, mon, getDayOfMon(mon, year))
}



function main(){
    setMonthTitle(year, mon);
    makeCalendar(year, mon, getDayOfMon(mon,year));
    todoTitle.textContent = `${year}.${mon}.${currentDay} Todo list!`;
    displayTodoOnDays();
}

function displayTodoOnDays(){
    todoList.innerHTML = '';


    //선택한 날짜에 작성했던 todoList 보여주기
    const YMD  = year + '-' + mon + '-' + dayOfChoice;

    let arrayToDo;

    const elementTodo = document.createElement('li');


    //해당 이이템이 없는 경우 종료
    if(!localStorage.getItem(YMD)) {
        return;
    }

    if(localStorage.getItem(YMD).includes(',')){
        arrayToDo = localStorage.getItem(YMD).split(',');
        arrayToDo.forEach((value) => {
            const deleteBtn = document.createElement('button');
            deleteBtn.innerHTML = '<i class = "far fa-minus-square"></i>';

            const elementToDo = document.createElement('li');
            elementToDo.innerText = value;
            elementToDo.appendChild(deleteBtn);

            elementToDo.scrollTo();

            todoList.appendChild(elementToDo);
        });
    }
    else{
        const deleteBtn = document.createElement('button');
        deleteBtn.setAttribute('class', 'deleteBtn');
        deleteBtn.innerHTML = '<i class = "far fa-minus-square"></i>';
        
        elementTodo.textContent = localStorage.getItem(YMD);
        elementTodo.appendChild(deleteBtn);
        todoList.appendChild(elementTodo);
    }
}


preBtn.addEventListener('click', preMonthOrYear);
nextBtn.addEventListener('click', nextMonthOrYear);

function clearEvent(){
    clickEventArr.forEach((value) =>{
        value.style.border = 'none';
    })
}

Day.addEventListener('click', (event) => {
    if(event.target.tagName === 'UL'){
        return;
    }
    if(event.target.className !=='disabled'){
        clearEvent();

        todoTitle.textContent = `${year}.${mon}.${event.target.textContent} Todo list!`
        event.target.style.border = '3px solid red';
        dayOfChoice(event.target.textContent) * 1;
        monOfChoice = mon;
        yearOfChoice = year;

        displayTodoOnDays();
        clickEventArr.push(event.target);
        console.log(clickEventArr);
        input.focus();    
    }
});

function keepStore(){
    const YMD = year + '-' + mon + '-' + dayOfChoice;
    let arrayToDo; 
    let arr = new Array();
    const elementToDo = document.createElement('li');
    if (!localStorage.getItem(YMD).includes(',')){
        arrayToDo = localStorage.getItem(YMD).split(',');
        arrayToDo.forEach((value) => {
            arr.push(value);
        });
    }
    else{
        arr.push(localStorage.getItem(YMD));
    }
    return arr;
}

function addToDoList(){
    if(input.value === ''){
        alert('해야 할일을 작성해주세요.');
        return;
    }

    storeTodo = keepStore();
    storeTodo.push(input.value);

    const YMD = year + '-' + mon + '-' + dayOfChoice;
    localStorage.setItem(YMD, storeTodo);

    displayTodoOnDays();

    input.value = "";
    input.focus();
}

add.addEventListener('click', (event) => {
    addToDoList();
})

input.addEventListener('keypress', (event)=> {

    //input에 엔터 이벤트가 감지되는 경우
    if(event.key === 'Enter'){
        addToDoList();
    }
});

reset.addEventListener('click', (event) => {
    const result = prompt(`정말 ${year}.${mon}.${dayOfChoice}에 작성된 것을 지우시겠습니까? Enter (y/n)`);
    const YMD = year + '-' + mon + '-' + dayOfChoice;
    if(result == y){
        localStorage.removeItem(YMD);
        displayTodoOnDays();
    }
});

allReset.addEventListener('click', (event) => {
    const result = prompt(`정말 목록을 모두 지우시겠습니까? Enter (y/n)`);
    const YMD = year + '-' + mon + '-' + dayOfChoice;
    if(result == y){
        localStorage.clear();
        displayTodoOnDays();
    }
});

todoList.addEventListener('click',(event) =>{
    if(event.target.className === 'far fa-minus-square'){
        console.log("a: " + event.target.parentNode.textContent);
        const YMD = year + '-' + mon + '-' + dayOfChoice;

        if(localStorage.getItem(YMD).includes(',')){
            let array = localStorage.getItem(YMF).split(',');
            let copyArray = [];

            array.forEach((value)=> {
                if(value !== event.target.parentNode.parentNode.textContent){
                    copyArray.push(value);
                }
            });
            localStorage.setItem(YMD, copyArray);
        }

        else{
            localStorage.removeItem(YMD);
        }
        todoList.removeChild(event.target.parentNode.parentNode);
    }
} );



main();
