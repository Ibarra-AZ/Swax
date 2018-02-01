$(document).ready(function() {
    $('#register-form').bootstrapValidator({
//        feedbackIcons: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
        fields: {
        	userName: {
                validators: {
                    notEmpty: {
                        message: 'Please supply a user name'
                    }
                }
            },
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
            country: {
                validators: {
                    notEmpty: {
                        message: 'Please select your country'
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
			},
        	password2: {
                validators: {
                    notEmpty: {
                        message: 'Please enter your password'
                    },
                	identical: {
                        field: 'password',
                        message: 'This password is not the same'
                    }
            	}
			},
			discogsName: {
                validators: {
                    notEmpty: {
                        message: 'A discogs user name is necessary to fetch your collection and wantlist'
                    }
                }
            }
        }
	})
});