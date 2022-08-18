$(function(){
    getQuestions()

    $("#answerForm").on("shown.bs.modal", function(event){
        $("#qaId").val($(event.relatedTarget).attr("qaId"))
    })

    $("#submitAnswer").on("click", function(){
        const answer = $("#answer")
        const data = {
            status: "answered", 
            serivceId: $("#userEmail").attr("uemail"),
            answer: answer.val(),
            id: $("#qaId").val()
        }
        answer.val("")
        console.log(data)
        $.ajax({
            url: `http://localhost:8080/user/updateQA`,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(json){
            getQuestions()
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })

})

function getQuestions(){
    $.ajax({
        url: `http://localhost:8080/getQAsByStatus?status=pending`,
        type: "get",
        contentType: "application/json",
        cache: false
    }).done(function(qas){
        console.log(qas)
        const view = $("#questions")
        view.empty()
        for(let qa of qas){
            view.append(setQuestion(qa))
        }

    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

function setQuestion({id, hotelId, question, createDate}){
    return `
    <tr qaId=${id}>
        <td>${createDate}</td>
        <td>${hotelId}</td>
        <td>${question}</td>
        <td>
            <button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#answerForm" qaId=${id}>To answer</button>
        </td>
    </tr>
    `
}