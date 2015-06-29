Ext.ux.FormUtil = {
		
	formInit: function(form, record) {
		form.items.each(function(item, i) {
			if(item.items) {
				this.formInit(item, record);
			} else {
				item.setValue(record.data[item.name]);
			}
		}, this);
	},
	
	getItemParams: function(form, params) {
		params = params || {};
		
		form.items.each(function(item, i) {
			if(item.items) {
				Ext.apply(params, this.getItemParams(item, params));
			} else {
				params[item.name] = item.xtype == 'datefield'? 
					(item.getValue() == null || item.getValue() == '' ? item.getValue() : item.getValue().format('Y-m-d')) : item.getValue();
			}
		}, this);
		
		return params;
	},
	
	setItemValue: function(form, name, value) {
		form.items.each(function(item, i) {
			if(item.items) {
				this.setItemValue(item, name, value);
			} else {
				if(item.name == name) {
					item.setValue(value);
					return false;
				}
			}
		}, this);
	},
	
	findItem: function(form, name) {
		var it = false;
		form.items.each(function(item, i) {
			if(item.items) {
				this.findItem(item, name);
			} else {
				if(item.name == name) {
					it = item;
					return false;
				}
			}
		}, this);
		
		return it;
	}
};