function AndrodHelpCenterPanel(o) {
	var onSubmit = function() {
		Ext.Ajax.request({
			url : Ext.ctx + '/samHelpCenterController',
			method : 'POST',
			defaultHeaders : {
				'Accept' : 'application/json'
			},
			success : Ext.ux.AjaxUtil.successHandler.createSequence(
					function(r) {
						helpcenterstore.reload();
						window.hide();
					}, this),
			failure : Ext.ux.AjaxUtil.failureHandler,
			params : function() {
				var params = {};
				fp.items.each(function(item, i) {
							params[item.name] = item.getValue();
						}, this);
				return params;
			}.createDelegate(this)()
		});
	};
	
	var deleteSubmit = function() {
		Ext.Ajax.request({
			url : Ext.ctx + '/samHelpCenterController/deleteSamHelpCenters',
			method : 'POST',
			defaultHeaders : {
				'Accept' : 'application/json'
			},
			success : Ext.ux.AjaxUtil.successHandler.createSequence(
					function(r) {
						helpcenterstore.reload();
						window.hide();
					}, this),
			failure : Ext.ux.AjaxUtil.failureHandler,
			params : function() {
				var params = new Array();
				var ids = Ext.getCmp('helpCenterGridId').getSelectionModel().getSelections();
					Ext.each(ids,function(items){
						params.push(items.data.uid);
					})
				return "ids="+params;
			}.createDelegate(this)()
		});
	};
	var Record = Ext.data.Record.create( [ {
		name : 'uid',
		type : 'string'
	}, {
		name : 'title',
		type : 'string'
	}, {
		name : 'content',
		type : 'string'
	}, {
		name : 'type',
		type : 'string'
	}, {
		name : 'version',
		type : 'string'
	} ]);

	var connection = new Ext.data.Connection( {
		url : Ext.ctx + '/samHelpCenterController/queryForWhereAnd?fields[type]=Android',
		method : 'GET',
		defaultHeaders : {
			'Accept' : 'application/json'
		},
		timeout : 10000
	});
	connection.on('requestexception', Ext.ux.AjaxUtil.failureHandler, this);

	var helpcenterstore = new Ext.data.JsonStore( {
		root : 'results',
		totalProperty : 'totalCount',
//		remoteSort : true,
		fields : Record,
		sortInfo : { field : 'version', direction : 'DESC' },
		proxy : new Ext.data.HttpProxy(connection)
	});
	helpcenterstore.load();

	var fp = new Ext.FormPanel(
			{
				id:'helpForm',
				fileUpload : true,
				width : 600,
				frame : true,
				labelWidth : 90,
				monitorValid : true,
				defaults : {
					xtype:'textfield',
					anchor : '95%',
					msgTarget : 'side',
					
				},
				items : [ {
					fieldLabel : 'TYPE',
					name:'type',
					value:'Android',
					hidden:true

				},{
					fieldLabel : '标题',
					name:'title',
					id:'title',
					allowBlank : false
				},{
					xtype:'textarea',
					fieldLabel : '内容',
					name:'content',
					allowBlank : false 
				} ,{
					name:'version',
					fieldLabel : '版本',
					xtype:'combo',
					allowBlank : false ,
					store : new Ext.data.JsonStore({
						root : 'results',
						fields : [ 'version' ],
						proxy : new Ext.data.HttpProxy({
							url :Ext.ctx+'/samUpgradeController/getVersionAllByType/Android',
							defaultHeaders : {
								'Accept' : 'application/json'
							},
							method : 'GET'
						})
					}),
					emptyText : '请选择...',
					displayField : 'version',
					valueField : 'version',
					triggerAction : 'all',
					typeAhead : true,
					editable : false,
					lazyRender : true,
					forceSelection : true
				}  ],

				buttons : [
						{
							text : '保存',
							formBind : true,
							handler : function() {
								onSubmit();
							}	 
						}, {
							text : '重置',
							handler : function() {
								fp.getForm().reset();
							}
						} ]
			});

	var window = new Ext.Window({
		title : '帮助发布',
		closeAction:'hide',
		items:[fp]
		
	});
	
	 
	var sm = new Ext.grid.CheckboxSelectionModel();// 设置多选
	var grid = new Ext.grid.GridPanel( {
		id:'helpCenterGridId',
		store : helpcenterstore,
		tbar : [ new Ext.Button( {
			text : '新增',
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
		})],
		sm:sm,
		columns : [new Ext.grid.RowNumberer(),
		           sm,{
			id : 'title',
			header : '标题',
			width : 160,
			sortable : true,
			dataIndex : 'title'
		}, {
			header : '内容',
			width : 75,
			sortable : true,
			dataIndex : 'content'
		}, {
			header : '版本号',
			width : 75,
			sortable : true,
			dataIndex : 'version'
		}  ],
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