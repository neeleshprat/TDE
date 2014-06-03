var app = app || {};

app.Model = {};
app.View = {};
app.Collection = {};

app.Workspace = Backbone.Router.extend({
	routes : {
		'' : 'index',
		'overview' : 'overview',
		'load' : 'load',
		'train' : 'train',
		'run' : 'run',
		'save' : 'save'
	},

	index : function() {

		app.router.navigate('overview', {
			trigger : true
		});
	},

	overview : function() {

		if (typeof app.frame === 'undefined') {

			app.frame = new app.View.Frame();
			app.frame.render();
		}

		if (typeof app.overview === 'undefined') {

			app.overview = new app.View.Overview();
		}

		app.navigation.model.get('overview').current = true;
		app.overview.render();
	},

	load : function() {

		if (typeof app.frame === 'undefined') {

			app.frame = new app.View.Frame();
			app.frame.render();
		}

		if (typeof app.load === 'undefined') {

			app.load = new app.View.Load();
		}

		app.navigation.model.get('load').current = true;
		app.load.render();
	},

	train : function() {

		if (typeof app.frame === 'undefined') {

			app.frame = new app.View.Frame();
			app.frame.render();
		}

		if (typeof app.train === 'undefined') {

			app.train = new app.View.Train();
		}

		app.navigation.model.get('train').current = true;
		app.train.render();
	},

	run : function() {

		if (typeof app.frame === 'undefined') {

			app.frame = new app.View.Frame();
			app.frame.render();
		}

		if (typeof app.run === 'undefined') {

			app.run = new app.View.Run();
		}

		app.navigation.model.get('run').current = true;
		app.run.render();
	},

	save : function() {

		if (typeof app.frame === 'undefined') {

			app.frame = new app.View.Frame();
			app.frame.render();
		}

		if (typeof app.save === 'undefined') {

			app.save = new app.View.Save();
		}

		app.navigation.model.get('save').current = true;
		app.save.render();
	}
});