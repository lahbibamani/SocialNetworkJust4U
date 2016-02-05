define(function (require) {

    "use strict";

    var _           = require('underscore'),
        Backbone    = require('backbone'),
        tpl         = require('text!tpl/login.html'),

        template = _.template(tpl);

    return Backbone.View.extend({
        render: function () {
            //this.$el.attr('class', ' background-dark')
            this.$el.html(template());
            return this;
        },
        events: {
            "click .facebook-login":"fbLogin"
        },
        fbLogin:function(){
            FB.login();
        }
    });

});