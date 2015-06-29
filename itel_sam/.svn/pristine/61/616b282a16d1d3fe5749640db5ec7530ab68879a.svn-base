Ext.define('Wlan', {
    extend: 'Ext.data.Model',

    config: {
        fields: [{
			name : 'wlanName',
			type : 'string'
		}, {
			name : 'wlanType',
			type : 'string'
		}, {
			name : 'wlanArea',
			type : 'string'
		}, {
			name : 'ap',
			type : 'string'
		}, {
			name : 'company',
			type : 'string'
		}], 
		proxy: {
	        type: 'rest',
	        method: 'GET',
	        url : Ext.cts + 'ars/wlan',
	        reader: {
	            type: 'json',
	            rootProperty: 'wlan'
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
            // If we are not on a phone, we want to make the formpanel model and give it a fixed with and height.
            Ext.apply(form, {
                modal: true,
                height: 505,
                width: 480,
                centered: true,

                // Disable hideOnMaskTap so it cannot be hidden
                hideOnMaskTap: false
            });

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
                    labelWidth: '40%',
                    inputCls: 'form-input'
                },
                items: [
                    {
                        xtype: 'textfield',
                        name: 'wlanName',
                        label: 'WLAN名称:',
                        readOnly: true,
                        autoCapitalize: false
                    }, {
                        xtype: 'textfield',
                        name: 'wlanType',
                        label: 'WLAN类型:',
                        readOnly: true
                    }, {
                        xtype: 'textfield',
                        name: 'wlanArea',
                        label: '覆盖范围:',
                        readOnly: true
                    }, {
                        xtype: 'textfield',
                        name: 'ap',
                        label: 'AP:',
                        readOnly: true
                    }, {
                        xtype: 'textfield',
                        name: 'company',
                        label: '公司名称:',
                        readOnly: true
                    }
                ]
            }
        ];
    }
});

