var app = app || {};

app.View.Statistics = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#statisticsTemplate').html()),

	initialize : function() {

		this.$el = $('#statistics');
		this.model = new app.Model.Statistics;

		this.listenTo(this.model, 'change', this.render);

		this.fetchModel();
	},

	render : function() {

		this.$el.html(this.template({
			statistics : this.model.toJSON()
		}));

		return this;
	},

	fetchModel : function() {

		this.model.fetch();
		this.render();
	}
});