Ext.define('Fiddle.model.League', {
	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields : [ {
		name : 'id',
		type : 'int'
	}, {
		name : 'name',
		type : 'string'
	}, {
		name : 'logo',
		type : 'string'
	}, {
		name : 'countryId',
		type : 'string'
	}, {
		name : 'countryName',
		type : 'string'
	}, {
		name : 'displayLeague',
		type : 'string',
		calculate : function(data) {
			return data.id + ' - ' + data.name;
		}
	}, {
		name : 'displayCountry',
		type : 'string',
		calculate : function(data) {
			return data.countryId + ' - ' + data.countryName;
		}
	}]
});
