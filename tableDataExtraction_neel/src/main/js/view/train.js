var app = app || {};

app.View.Train = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#trainTemplate').html()),

	initialize : function() {

		this.$el = $('#content');
	},

	render : function() {

		this.$el.html(this.template({
			title : 'Train'
		}));

		app.table = new app.View.Table(new app.Model.Table());
		app.table.render();

		return this;
	}
});