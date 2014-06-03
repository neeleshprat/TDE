var app = app || {};

app.View.Run = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#runTemplate').html()),

	events : {
		'click #buttonStartRun' : 'handleStart'
	},

	initialize : function() {

		this.$el = $('#content');
	},

	render : function() {

		this.$el.html(this.template());

		return this;
	},

	handleStart : function() {

		var waitTemplate = Handlebars.compile($('#waitTemplate').html());

		$('#content').html(waitTemplate({
			title : "Running ..."
		}));

		$.get("http://localhost:8080/tableDataExtraction/app/validate",
				function(data) {

					var resultTemplate = Handlebars.compile($(
							'#runResultTemplate').html());

					$('#content').html(resultTemplate({
						message : data
					}));

					// app.messageView.model.set(data);
				});
	}
});
