var app = app || {};

app.View.Overview = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#overviewTemplate').html()),

	initialize : function() {

		this.$el = $('#content');
	},

	render : function() {

		this.$el.html(this.template());

		return this;
	}
});