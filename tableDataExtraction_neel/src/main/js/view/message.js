var app = app || {};

app.View.Message = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#messageTemplate').html()),

	initialize : function() {

		this.$el = $('#message');
		this.model = new app.Model.Message;

		this.listenTo(this.model, 'change', this.render);
	},

	render : function() {

		this.$el.html(this.template({
			message : this.model.toJSON()
		}));

		return this;
	},
});