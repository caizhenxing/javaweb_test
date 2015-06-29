Ext.define('Wlan', {
    extend: 'Ext.data.Model',

    config: {
        fields: [{
    		name : 'bid',
    		type : 'string'
    	}, {
    		name : 'ne',
    		type : 'string'
    	}, {
    		name : 'level',
    		type : 'string'
    	}, {
    		name : 'programmewarning',
    		type : 'string'
    	}, {
    		name : 'warningtype',
    		type : 'string'
    	}, {
    		name : 'neobject',
    		type : 'string'
    	}, {
    		name : 'warningtitle',
    		type : 'string'
    	}, {
    		name : 'warningtime',
    		type : 'string'
    	}, {
    		name : 'mark',
    		type : 'string'
    	}, {
    		name : 'affirmtime',
    		type : 'string'
    	}, {
    		name : 'affirminfo',
    		type : 'string'
    	}, {
    		name : 'listmark',
    		type : 'string'
    	}, {
    		name : 'cellid',
    		type : 'string'
    	}, {
    		name : 'city',
    		type : 'string'
    	}, {
    		name : 'area',
    		type : 'string'
    	}, {
    		name : 'swaphandle',
    		type : 'string'
    	}, {
    		name : 'listNo',
    		type : 'string'
    	}, {
    		name : 'warningobjecttype',
    		type : 'string'
    	}, {
    		name : 'type',
    		type : 'string'
    	}], 
		proxy: {
	        type: 'rest',
	        method: 'GET',
	        url : Ext.cts + 'ars/nature/cellWarnInfo',
	        reader: {
	            type: 'json',
	            rootProperty: 'data'
	        }
	    }
    }
});

Ext.Ajax.setDefaultHeaders({
    'Accept': 'application/json'
});

// Define our simple application
Ext.application({
	
    glossOnIcon: false,

    /**
     * The launch method of our application gets called when the application is good to launch.
     * In here, we are going to build the structure of our application and add it into the Viewport.
     */
    launch: function() {
        // Get all the items for our form.
        var items = this.getFormItems(), form, tabPanel;

        form = Ext.create('Ext.form.Panel', {
            items: items	
        });

        // If we are on a phone, we just want to add the form into the viewport as is.
        // This will make it stretch to the size of the Viewport.
        if (Ext.os.deviceType == 'Phone') {
        	tabPanel = Ext.Viewport.add(form);
        } else {
            // Add it to the Viewport and show it.
            tabPanel = Ext.Viewport.add(form);
            tabPanel.show();
        }
        
        Wlan.load(Ext.param.id, {
         	scope: this,
         	success: function (record, operation) {
         		form.setRecord(record);
         	}
        });
        
        this.form = form;
    },
    
    /**
     * This method returns an array of all items we should add into the form panel we create above in our launch function.
     * We have created this function to simply make things cleaner and easier to read and understand. You could just put these items
     * inline up above in the form `config`.
     * @return {Array} items
     */
    getFormItems: function() {
        return [
            {
                xtype : 'toolbar',
                docked: 'top',
                title: 'WLAN信息'
            }, {
                xtype: 'fieldset',
                instructions: 'WLAN的基本维护信息',
                defaults: {
                    labelAlign: 'left',
                    labelWidth: '70%',
                    inputCls: 'form-input'
                },
                items: [{
                    xtype: 'textfield',
                    name: 'warningtime',
                    label: '告警时间:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'ne',
                    label: '网元:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'level',
                    label: '告警级别:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'programmewarning',
                    label: '工程告警:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'warningtype',
                    label: '告警类型:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'neobject',
                    label: '网元对象:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'warningtitle',
                    label: '告警标题:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'affirmtime',
                    label: '确认时间:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'affirminfo',
                    label: '确认信息:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'listmark',
                    label: '派单标志:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'warningobjecttype',
                    label: '告警对象类型:',
                    readOnly: true
                }]
            }
        ];
    }
});

