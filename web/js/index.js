/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// MODAL AGREGADO USUARIO
$(document).ready(function () {
    $("#addUser_form").on("submit", function(e) 
    {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#signUp_dialog .modal-header .modal-title').html("Result");
                $('#signUp_dialog .modal-body').html(data);
                $("#submitAddUserForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });
    $("#submitAddUserForm").on('click', 
        function() 
        {
            $("#addUser_form").submit();
        }
    );
});


$(document).ready(function () {
    $("#forgotPassword_form").on("submit", function(e) 
    {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#forgotPassword_dialog .modal-header .modal-title').html("Result");
                $('#forgotPassword_dialog .modal-body').html(data);
                $('#forgotPasswordCloseBtn').removeClass('hide');
                $("#submitAddUserForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });
    $("#submitForgotPass").on('click', 
        function() 
        {
            $("#forgotPassword_form").submit();
        }
    );
});


