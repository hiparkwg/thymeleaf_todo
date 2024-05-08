/* todo */
// url 고정
history.pushState(null, null, "/todo_list");

// 저장
let btnRegister = document.querySelector('.btnRegister');
btnRegister.addEventListener('click', ()=>{
    let frm = document.querySelector('.register');
    frm.action = "/todo_register";
    frm.submit();
})

// 검색
let btnSearch = document.querySelector('.btnSearch');
btnSearch.addEventListener('click', ()=>{
    let frm = document.querySelector('.register');
    frm.action = "/todo_list";
    frm.submit();
})

let modify = (frm)=>{
    let yn=confirm('수정?');
    if(!yn){
        btnSearch.click();
        return;
    } 

    frm.action="/todo_update";
    frm.submit();
}
let del = (frm) =>{
    let yn=confirm('삭제?')
    if( !yn ) {
        btnSearch.click();
        return;
    }
    frm.action="/todo_delete";
    frm.submit();
}