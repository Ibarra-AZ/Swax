$(document).ready(function() {
    $('#swapAlbum-form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	uploadImg: {
                validators: {
                    notEmpty: {
                        message: 'Please supply a picture'
                    },
                    file: {
                        extension: 'jpg,jpeg',
                        type: 'image/jpeg',
                        maxSize: 5242880,
                        message: 'Please try to upload a jpg/jpeg file, maximum size 5MB'
                    }
                }
            }
        }
	});
    	
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