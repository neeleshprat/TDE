var app = app || {};

app.View.Frame = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#frameTemplate').html()),

	initialize : function() {

		this.$el = $('#frame');
	},

	render : function() {

		this.$el.html(this.template());

		app.navigation = new app.View.Navigation();
		app.navigation.model.set({
			overview : {
				title : "Overview",
				current : false,
				url : "#overview"
			},
			load : {
				title : "1. Load",
				current : false,
				url : "#load"
			},
			train : {
				title : "2. Train",
				current : false,
				url : "#train"
			},
			run : {
				title : "3. Run",
				current : false,
				url : "#run"
			},
			save : {
				title : "4. Save",
				current : false,
				url : "#save"
			}
		});
		app.navigation.render();

		app.messageView = new app.View.Message();

		return this;
	}
});