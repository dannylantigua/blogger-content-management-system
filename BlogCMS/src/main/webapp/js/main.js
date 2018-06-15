

//
//$(document).ready(function () {
//
//
//
//    tagBtn();
//
//});
//
//
//
//function tagBtn() {
//
//    $(document).on("click", "#tagButton", function () {
//        append();
//            var value = $("#tagsInput").val();
//    $("#currentTags").append(` <option>${value}</option>`);
//        console.log("hello");
//    });
//
//}

//
//function ajax() {
//    this.getLast10Tags = function (callback) {
//
//        $.ajax({
//            type: "GET",
//            url: "tags",
//            dataType: "json"
//        }).done(function (response) {
//            callback(response);
//        });
//
//    };
//    
//    this.savePostTags = function (callback) {
//        $.ajax({
//            type : "POST",
//            url : "tags",
//            dataType : "json"
//        }).done(function(response){
//           callback(response); 
//        });
//    }
//}