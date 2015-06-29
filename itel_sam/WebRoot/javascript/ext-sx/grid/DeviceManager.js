function DeviceManager(o) {
	
	var onSubmit = function() {
		Ext.Ajax.request({
			url : Ext.ctx + '/samPushController/pushMessage',
			method : 'POST',
			defaultHeaders : {
				'Accept' : 'application/json'
			},
			success : Ext.ux.AjaxUtil.successHandler.createSequence(
					function(r) {
						noticstore.reload();
						msgwindow.hide();
					}, this),
			failure : Ext.ux.AjaxUtil.failureHandler,
			params : function() {
				var params = {};
				msgform.items.each(function(item, i) {
					if(item.name == 'type' | item.name == 'platForm' | item.name == 'target' | item.name == 'iosenv'){
						params[item.name] = item.getValue().inputValue;
					}else{
						params[item.name] = item.getValue();
					}
							
						}, this);
				return params;
			}.createDelegate(this)()
		});
	};
	 
	var Record = Ext.data.Record.create( [ {
		name : 'uid',
		type : 'string'
	}, {
		name : 'pushtype',
		type : 'string'
	}, {
		name : 'platform',
		type : 'string'
	}, {
		name : 'alltarget',
		type : 'string'
	}, {
		name : 'alias',
		type : 'string'
	}, {
		name : 'registrationid',
		type : 'string'
	}, {
		name : 'title',
		type : 'string'
	}, {
		name : 'content',
		type : 'string'
	} , {
		name : 'msgtype',
		type : 'string'
	} , {
		name : 'pubtime',
		type : 'string'
	} ]);

	var connection = new Ext.data.Connection( {
		url : Ext.ctx + '/samPushController/getPushMsgList',
		method : 'GET',
		defaultHeaders : {
			'Accept' : 'application/json'
		},
		timeout : 10000
	});
	connection.on('requestexception', Ext.ux.AjaxUtil.failureHandler, this);

	var noticstore = new Ext.data.JsonStore( {
		root : 'results',
		totalProperty : 'totalCount',
		remoteSort : true,
		fields : Record,
		sortInfo : { field : 'pubtime', direction : 'DESC' },
						 
		proxy : new Ext.data.HttpProxy(connection)
	});
	noticstore.load();
	
	var msgform = new Ext.form.FormPanel({
		frame : true,
		border : false,
		labelWidth : 100,
		labelAlign : 'left',
		region : 'center',
		buttonAlign : 'right',
		monitorValid : true,
		waitMsgTarget : true,
		defaultType : 'textfield',
		defaults:{
		width : 500
		},
		bodyStyle : 'padding-top:10px;padding-left:20px;padding-right:20px;',
		items : [ {
			hidden:true,
			name:'type'
		},{
			hidden:true,
			name:'target'
		},{
			hidden:true,
			name:'platForm'
		},{
            xtype: 'radiogroup',
            name:'type',
            fieldLabel: '推送类型',
            items: [
                {boxLabel: '通知', name: 'type', inputValue:'PUSH_Notification',checked:true},
                {boxLabel: '消息', name: 'type', inputValue:'PUSH_Message'}
            ],
            listeners:{/*
				'change':function(e,checked){
					var platForm = checked.inputValue;
					if(platForm=='Android'){
						Ext.getCmp('androidapk').setDisabled(false);
						Ext.getCmp('iosUrlInput').setDisabled(true);
						Ext.getCmp('iosUrlInput').setValue('');
					}else{
						Ext.getCmp('androidapk').setDisabled(true);
						Ext.getCmp('iosUrlInput').setDisabled(false);
					}
				}
			*/}
        },{
            xtype: 'radiogroup',
            name:'platForm',
            fieldLabel: '设备平台',
            items: [
                {boxLabel: '所有', name: 'platForm', inputValue:'Push_AllPlatForm',checked:true},
                {boxLabel: '安卓', name: 'platForm', inputValue:'PUSH_AndroidPlatForm'},
                {boxLabel: '苹果', name: 'platForm', inputValue:'PUSH_IOSPlatForm'}
            ] 
        },{
            xtype: 'radiogroup',
            name:'iosenv',
            fieldLabel: 'IOS环境',
            items: [
                {boxLabel: '开发环境', name: 'iosenv', inputValue:'PUSH_IOS_dev',checked:true},
                {boxLabel: '生产环境', name: 'iosenv', inputValue:'PUSH_IOS_pro'}
            ] 
        },{
            xtype: 'radiogroup',
            name:'target',
            fieldLabel: '推送对象',
            items: [
                {boxLabel: '所有人', name: 'target', inputValue:'PUSH_Target_All',checked:true},
                {boxLabel: '设备别名(Alias)', name: 'target', inputValue:'PUSH_Target_Alias'},
                {boxLabel: 'Registration ID', name: 'target', inputValue:'PUSH_Target_Registration'}
            ] ,
            listeners:{
				'change':function(e,checked){
					var platForm = checked.inputValue;
					if(platForm=='PUSH_Target_All'){
						Ext.getCmp('aliasId').setValue('');
						Ext.getCmp('registrationId').setValue('');
						Ext.getCmp('aliasId').setDisabled(true);
						Ext.getCmp('registrationId').setDisabled(true);
					}else if(platForm=='PUSH_Target_Alias'){
						Ext.getCmp('registrationId').setValue('');
						Ext.getCmp('registrationId').setDisabled(true);
						Ext.getCmp('aliasId').setDisabled(false);
					}else if(platForm=='PUSH_Target_Registration'){
						Ext.getCmp('aliasId').setValue('');
						Ext.getCmp('aliasId').setDisabled(true);
						Ext.getCmp('registrationId').setDisabled(false);
					}
				}
        	}
			
        },{
			fieldLabel : '别名Alias',
			name : 'uitel',
			disabled:true,
			id:'aliasId'
		},{
			fieldLabel : 'Registration ID',
			name : 'channel',
			disabled:true,
			id:'registrationId'
		},{
			fieldLabel : '标题',
			name : 'title',
			allowBlank : false 
		},{
			xtype:'textarea',
			fieldLabel : '内容',
			name : 'content',
			allowBlank : false 
		}, {
			fieldLabel : '消息类型',
			name : 'msgType',
			xtype:'combo',
// hiddenName:'noticType',
            store: new Ext.data.ArrayStore({
            	id:'deviceTypeCombo',
                fields: ['noticType', 'noticTypeCH'],
                data:[['System','系统消息'],['Person','个人消息']]
            }),
            valueField:'noticType',
            displayField:'noticTypeCH',
            typeAhead: true,
            mode: 'local',
            triggerAction: 'all',
            emptyText:'请选择消息类型...',
            selectOnFocus:true 
		}/*, {
			fieldLabel : '设备类型',
			name : 'deviceType',
			xtype:'combo',
// hiddenName:'deviceType',
            store: new Ext.data.ArrayStore({
            	id:'deviceTypeCombo',
                fields: ['deviceType', 'deviceTypeCH'],
                data:[['S','摄像头'],['M','猫眼']]
            }),
            valueField:'deviceType',
            displayField:'deviceTypeCH',
            typeAhead: true,
            mode: 'local',
            triggerAction: 'all',
            emptyText:'请选择设备类型...',
            selectOnFocus:true 
		}*//*, {
			fieldLabel : 'uItel',
			name : 'uItel' 
		} */],
		buttons : [ {
			text : '确定',
			formBind : true,
			handler:function(){
				onSubmit();
		}
		}, {
			text : '取消',
			handler : function() {
				window.hide();
				
			}
		} ],

		keys : [ {
			key : [ 10, 13 ],
			stopEvent : true
		/*
		 * , fn : onSubmit
		 */
		} ]
	});

	var msgwindow = new Ext.Window( {
		title : '消息发布',
		items : [ msgform ],
		closeAction : 'hide'
	});
	
	var sm = new Ext.grid.CheckboxSelectionModel();// 设置多选
	var grid = new Ext.grid.GridPanel( {
		id:'noticGridId',
		store : noticstore,
		tbar : [ /*new Ext.Button( {
			text : '消息发布',
			listeners : {
				'click' : function() {
					window.show();
				}
			}
		}), '-', new Ext.Button( {
			text : '删除',
			listeners:{
				'click':function(){
				deleteSubmit();
				}
			}
		}), '-', */new Ext.Button( {
			text : '推送消息',
			listeners:{
				'click':function(){
			msgwindow.show();
				}
			}
		}) ],
		sm:sm,
		columns : [new Ext.grid.RowNumberer(),
		           sm,{
			id : 'pushtype',
			header : 'pushtype',
			width : 160,
			sortable : true,
			dataIndex : 'pushtype'
		}, {
			header : 'platform',
			width : 75,
			sortable : true,
			dataIndex : 'platform'
		}, {
			header : 'alltarget',
			width : 75,
			sortable : true,
			dataIndex : 'alltarget'
		}, {
			header : 'alias',
			width : 75,
			sortable : true,
			dataIndex : 'alias'
		}, {
			header : 'registrationid',
			width : 75,
			sortable : true,
			dataIndex : 'registrationid'
		}, {
			header : 'title',
			width : 85,
			sortable : true,
			dataIndex : 'title'
		}, {
			header : 'content',
			width : 85,
			sortable : true,
			dataIndex : 'content'
		}, {
			header : 'msgtype',
			width : 85,
			sortable : true,
			dataIndex : 'msgtype'
		}, {
			header : 'pubtime',
			width : 85,
			sortable : true,
			dataIndex : 'pubtime'
		} ],
		viewConfig : {
			forceFit : true
		},
		stripeRows : true,
		autoExpandColumn : 'company',
		height : 650,
		stateful : true,
		stateId : 'grid'
	});

	return grid;

}
