define(function (require) {

    "use strict";

    var $ = require('jquery'),
        _ = require('underscore'),
        Backbone = require('backbone'),
        tpl = require('text!tpl/landing.html'),
        template = _.template(tpl);


    return Backbone.View.extend({
        render: function () {
            this.$el.attr('class', ' background landing')
            this.$el.html(template());

            return this;
        },
        events: {
            "click #questions":"create"
        },
        create:function(){
            var nom=$("#nom").val();
            var desc=$("#description").val();
            $.ajax({contentType:"application/json", type:"POST",url: "/projects",data:'{"nom": "'+nom+'","description":"'+desc+'"}',success:this.success});
        },
        success:function(a,b,c){
            var lh=c.getResponseHeader("Location").split("/");
            var id=lh[lh.length-1];
            window.location.hash="project/"+id;
        }
    });

});