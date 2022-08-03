$(function(){
    $("#userSubmit").on("click", function(){

        const data = {roleNames: []}
        const inputs = $("#userInfo").children(".form-control")
        const roles = $("#userInfo").children(".roleNames")
        for(let i of inputs){
            data[$(i).attr("name")] = $(i).val()
        }

        for(let r of roles){
            data.roleNames.push($(r).val())
        }

        $.ajax({
            url: `http://localhost:8080/registerUser`,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(json){
            console.log(json)
            alert(json.message)
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
    
})