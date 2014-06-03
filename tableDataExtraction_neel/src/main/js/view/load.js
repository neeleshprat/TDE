var app = app || {};

app.View.Load = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#loadTemplate').html()),

	events : {
		'click #buttonStartLoad' : 'handleStart'
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
			title : "Loading ..."
		}));

		$.get("http://localhost:8080/tableDataExtraction/app/load", function(
				data) {

			var resultTemplate = Handlebars.compile($('#loadResultTemplate')
					.html());

			$('#content').html(resultTemplate({
				message : data
			}));

			// app.messageView.model.set(data);
		});
	}

});
