function answerRequest(target){
    if($('#answerInput'+ target).val() === null){
        return
    }
   $.ajax({
     url: "/answer",
     type: "GET",
     cache: false,
     dataType: "json",
     data: {
       operand: $('#operand' + target).text(),
       answerInput: $('#answerInput' + target).val()
     },
     success: function(data){
        //form要素はval()だが、pタグなどはtext()
       if (data.judge) {
        $('#judge' + target).text("正解!")
        $('#judge' + target).css("color","black")
       } else {
        $('#judge' + target).text("不正解")
        $('#judge' + target).css("color","red")
       }
     },
     error: function(xhr, textStatus, errorThrown){
        console.log(errorThrown)
       alert('Error');
     }
   });
}