$(document).ready(function() {
    $('#login-form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
        	password: {
                validators: {
                    notEmpty: {
                        message: 'Please enter your password'
                    },
                    stringLength: {
                    	min: 8,
                    	message: 'Please supply a password with at least 8 characters'
                    }
            	}
			}
        }
	})
});