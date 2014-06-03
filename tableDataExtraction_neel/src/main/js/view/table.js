var app = app || {};

app.View.Table = Backbone.View.extend({

	tagName : 'div',
	template : Handlebars.compile($('#tableTemplate').html()),

	events : {
		'click .selectRow' : 'handleSelectRow',
		'click .selectColumn' : 'handleSelectColumn',
		'click #buttonSave' : 'handleSave'
	},

	initialize : function(model) {

		this.$el = $('#table');

		this.model = model;

		this.listenTo(this.model, 'change', this.render);

		this.fetchModel();
	},

	render : function() {

		this.$el.html(this.template({
			table : this.model.toJSON()
		}));

		return this;
	},

	handleSelectRow : function(event) {

		row = $(event.currentTarget.parentElement.parentElement);
		rowNumber = row.data('rownumber');
		isLabelRow = this.model.get('expectedResult').rows[rowNumber];

		if (isLabelRow === true) {

			row.removeClass('success');
			this.model.get('expectedResult').rows[rowNumber] = false;

		} else {

			row.addClass('success');
			this.model.get('expectedResult').rows[rowNumber] = true;
		}
	},

	handleSelectColumn : function(event) {

		columns = $('.' + event.currentTarget.parentElement.className);
		columnNumber = $(event.currentTarget.parentElement)
				.data('columnnumber');

		isLabelColumn = this.model.get('expectedResult').columns[columnNumber];

		if (isLabelColumn === true) {

			classname = $(event.currentTarget.parentElement).data('classname');
			columns2 = $('.' + classname);
			columns2.removeClass('success');

			this.model.get('expectedResult').columns[columnNumber] = false;

		} else {

			columns.addClass('success');

			this.model.get('expectedResult').columns[columnNumber] = true;
		}
	},

	fetchModel : function() {

		this.model.fetch().fail(function() {

			app.messageView.model.set({
				message : {
					type : "warning",
					headline : "You made it!",
					message : "No tables left on the server."
				}
			});

		}).done(function() {

			app.table.model.set("expectedResult", {
				columns : {},
				rows : {}
			});
			app.table.render();
		});
	},

	handleSave : function(event) {

		this.model.save().fail(function() {

			app.messageView.model.set({
				type : "danger",
				title : "Error!",
				text : "Something went wrong."
			});

		}).done(function() {

			app.messageView.model.set({
				type : "success",
				title : "Success!",
				text : "The table was saved on the server."
			});

			app.table.fetchModel();
		});
	}
});