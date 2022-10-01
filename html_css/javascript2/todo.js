const todoForm = document.querySelector('.todoForm');
const todoInput = document.querySelector('.todoInput');
const todoList = document.querySelector('todoList-ul');

const TODOS_LS = "toDos";

function makeTodo(text){

    // createElement -> ul 안에 li 생성
    const li = document.createElement("li");

    //버튼 생성
    const deletBtn = document.createElement("button");
    deletBtn.innerText = "❌"; //버튼 모양

    //<span> 생성
    const span = document.createElement("span");
    span.innerText = text;// function에서 온 값을 span에 널어줌

    //li 태그 안에 deleteButton과 Span을 자식으로 넣어준다.
    li.appendChild(deletBtn);
    li.appendChild(span);

    //위에 자식들을 추가한 li를 todoList의 자식으로 넣어준다
    todoList.appendChild(li)

}

function handleSubmit(event){
    event.preventDefault();
    const currentValue = todoInput.value;
    makeTodo(currentValue);


    //엔터를 눌렀을 때 todo 생성, 삭제 
    todoInput.value= "";

}

function loadTodos(){
    const toDos = localStorage.getItem(TODOS_LS);

    if(toDos !== null){

    }
}


function init(){
    loadTodos();
    todoForm.addEventListener("submit", handleSubmit);
}

init();