$(document).ready(function() {
    $('#swapAlbum-form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	uploadFileInfo: {
                validators: {
                    notEmpty: {
                        message: 'Please supply a picture'
                    }
                }
            }
        }
	})
	
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#imgId').attr('src', e.target.result);
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#uploadImg").change(function(){
        readURL(this);
    });
	
});