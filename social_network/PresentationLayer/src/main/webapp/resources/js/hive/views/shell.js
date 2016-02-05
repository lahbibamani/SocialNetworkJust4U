define(function (require) {

    "use strict";

    var $ = require('jquery'),
        _ = require('underscore'),
        Backbone = require('backbone'),
        tpl = require('text!tpl/shell.html'),
        template = _.template(tpl);


    return Backbone.View.extend({
        render: function () {
            this.$el.attr('class', ' background landing')
            this.$el.html(template());
            return this;
        }
    });

});