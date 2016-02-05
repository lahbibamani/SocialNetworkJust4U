
define(function (require) {
    var $ = require('jquery'),
        _ = require('underscore'),
        Backbone = require('backbone'),
        tpl = require('text!tpl/order.html'),
        template = _.template(tpl),
        project;

    $.fn.select2 = require('select2');

    $.fn.collapse = require("collapse");
    $.fn.button = require("button");
    var module;
    return Backbone.View.extend({
        initialize: function (options) {

            this.project = options.project;
            module = this;
        },
        render: function () {
            console.log(this.project);
            this.$el.html(template());
            $.ajax({contentType: "application/json", type: "GET", url: "/tags", success: function (d) {
                d.content.forEach(function (e, i) {
                    $("#filtres").append('<option value="' + e.designation + '">' + e.designation + '</option>');
                });
            }});

            $.ajax({contentType: "application/json", type: "GET", url: "/criteres", success: this.renderCriteres});
            $(".chzn-select").each(function () {
                $(this).select2($(this).data());
            });
            $('.btn').button();
            return this;
        },
        events: {
            "click .eicon-cancel-circled": "deleteQuestion",
            "click #save": "repondre",
            "change #filtres": "doFilter"
        },
        renderQuestions: function ($e, ci, d) {
            var question = d.content;
            question.forEach(function (e, i) {
                var arr = e.links[0].href.split("/");
                var id = arr[arr.length - 1];
                var $q = $('<li id="' + id + '"  class="panel question">' +
                    '<div class="panel-heading">' +
                    '<a class="accordion-toggle" data-toggle="collapse" data-parent="' + $e.attr("id") + '" href="#question-' + ci + "-" + i + '">' +
                    '<i class="fa eicon-cancel-circled pull-right"></i>' +
                    e.valeur +
                    '</a>' +
                    '</div>' +
                    '<div id="question-' + ci + "-" + i + '" class="panel-collapse collapse">' +
                    '<div class="panel-body">' +
                    '<div class="btn-group  voffset15 " style="margin-left: 30px;"' +
                    'data-toggle="buttons">' +

                    '    <label class="btn btn-danger active mrgleft0">' +
                    '        <input type="radio" name="options1" id="option111"> Tres' +
                    '        mauvais' +
                    '         </label>' +
                    '         <label class="btn btn-warning mrgleft0">' +
                    '             <input type="radio" name="options1" id="option112">Mauvais' +
                    '             </label>' +
                    '             <label class="btn btn-white mrgleft0">' +
                    '                <input type="radio" name="options1" id="option113"> Moyen' +
                    '                </label>' +
                    '                 <label class="btn btn-info mrgleft0">' +
                    '                     <input type="radio" name="options1" id="option114"> Bon' +
                    '                     </label>' +
                    '                     <label class="btn btn-success mrgleft0">' +
                    '                        <input type="radio" name="options1" id="option115">Tres' +
                    '                        bon' +
                    '                           </label>' +
                    '                     </div>' +
                    '                    <br/><br/>' +
                    '                     <label style="margin-left: 60px;">Justification </label><textarea></textarea>' +
                    '                 </div>' +
                    ' </div>' +
                    '</div>' +
                    '</li>');
                $.ajax({contentType: "application/json", type: "GET", url: e.links[2].href.substr(25), success: function (d) {

                    d.content.forEach(function (e, i) {
                        $q.addClass(e.designation);
                    });
                }});
                $e.find(".panel-body").first().append($q);
            });
            return this;
        },
        renderCriteres: function (d) {
            var that = this;
            var creteres = d.content;
            creteres.forEach(function (e, i) {
                    var $temp = $('<li  class="panel">' +
                        '<div class="panel-heading">' +
                        '<a class="accordion-toggle" data-toggle="collapse" data-parent="#criteres" href="#critere' + i + '">' +
                        e.designation +
                        '</a>' +
                        '</div>' +
                        '<div id="critere' + i + '" class="panel-collapse collapse">' +
                        '<div class="panel-body">' +
                        ' </div>' +
                        '</div>' +
                        '</li>');
                    $("#criteres").append($temp);
                    $.ajax({contentType: "application/json", type: "GET", url: "/questions/search/findByCritere_Id?critere=" + (i + 1), success: function (d) {
                        module.renderQuestions($temp, i, d)
                    }});

                }
            );
            return this;
        },


        deleteQuestion: function (evt) {
            $(evt.target).closest(".question").remove();
        },

        doFilter: function (evt) {
            $(".question").removeClass("hidden")
            $(evt.target).val().forEach(function (d) {
                console.log(d);
                var c = " ." + d;

                $(".question ").not(c).addClass("hidden");
            });
        },
        repondre: function () {
            var answers = [];
            $(".question").not(".hidden").each(function (i, e) {
                var qid=$(e).attr("id");
                var value=$(e).find("label.active").text().trim();
                var just=$(e).find("textarea").val().trim();
                var pid=window.location.hash.split("/")[1];
                answers.push('{' +
                    '"valeur":"'+value+'",' +
                    '"justification":"'+just+'",' +
                    ' "question":{' +
                    '  "rel" : "question",' +
                    '       "href" : "http://localhost:8087/api/questions/'+qid+'"' +
                    '},' +
                    '"project": {' +
                    '  "rel" : "project",' +
                    '       "href" : "http://localhost:8087/api/projects/'+pid+'"' +
                    '}' +
                    ' }');

            });
            answers.forEach(function(d){
                $.ajax({contentType:"application/json", type:"POST",url: "/reponse",data:d});
            });
            this.modalMessage("Operation reussite","Votre audit est enregistrer !");
        },
        modalMessage: function (mlabel, mbody) {
            $("#myModalLabel").html(mlabel);
            $(".modal-body").first().html(mbody);
            $('#myModal').modal('show');
        }
    });
});

