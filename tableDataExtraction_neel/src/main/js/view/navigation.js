var app = app || {};

app.View.Navigation = Backbone.View.extend({

	tagName : 'nav',
	template : Handlebars.compile($('#navigationTemplate').html()),

	events : {
		'click #title' : 'handleTitleClick'
	},

	initialize : function() {

		this.$el = $('nav');
		this.model = new app.Model.Navigation;
	},

	render : function() {

		this.$el.html(this.template({
			navigation : this.model.toJSON()
		}));

		return this;
	},

	handleTitleClick : function() {

		app.router.navigate('', {
			trigger : true
		});
	}
});