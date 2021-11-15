Ext.define('Fiddle.model.Team', {
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
		name : 'display',
		type : 'string',
		calculate : function(data) {
			return data.id + ' - ' + data.name;
		}
	} ]
});
