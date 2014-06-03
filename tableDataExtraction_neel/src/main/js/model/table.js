var app = app || {};

app.Model.Table = Backbone.Model.extend({
	urlRoot : 'app/table',
	defaults : {
		expectedResult : {
			columns : {},
			rows : {}
		}
	}
});