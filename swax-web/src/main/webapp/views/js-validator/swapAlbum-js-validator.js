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
});