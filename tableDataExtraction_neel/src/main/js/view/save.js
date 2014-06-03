var app = app || {};

app.View.Save = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#saveTemplate').html()),

	events : {
		'click #buttonSave' : 'handleSave'
	},

	initialize : function() {

		this.$el = $('#content');
	},

	render : function() {

		this.$el.html(this.template());

		return this;
	},

	handleSave : function() {

		$.get("app/save", function(data) {

			app.messageView.model.set(data);
		});
	}
});