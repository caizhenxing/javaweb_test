Ext.ux.MsgUtil = {
	
	showError: function(msg) {
		Ext.Msg.show({
			 title: '错误'
			,msg:Ext.util.Format.ellipsis(msg, 2000)
			,icon:Ext.Msg.ERROR
			,buttons:Ext.Msg.OK
			,minWidth:1200 > String(msg).length ? 260 : 600
		});
	},
	
	showInfo: function(msg) {
		Ext.Msg.show({
			 title: '提示'
			,msg:Ext.util.Format.ellipsis(msg, 2000)
			,icon:Ext.Msg.INFO
			,buttons:Ext.Msg.OK
			,minWidth:1200 > String(msg).length ? 260 : 600
		});
	},
	
	showWarn: function(msg) {
		Ext.Msg.show({
			 title: '警告'
			,msg:Ext.util.Format.ellipsis(msg, 2000)
			,icon:Ext.Msg.WARNING
			,buttons:Ext.Msg.OK
			,minWidth:1200 > String(msg).length ? 260 : 600
		});
	},
	
	showException: function(msg) {
		Ext.Msg.show({
			 title: '异常'
			,msg:Ext.util.Format.ellipsis(msg, 2000)
			,icon:Ext.Msg.ERROR
			,buttons:Ext.Msg.OK
			,minWidth:1200 > String(msg).length ? 360 : 600
		});
	}
};

Ext.ux.AjaxUtil = {
	
	successHandler:function(response, options) {
		try {
			var o = Ext.decode(response.responseText);
		} catch(e) {
			Ext.ux.MsgUtil.showError(response.responseText);
			return false;
		}
		
		if(!o) {
			Ext.ux.MsgUtil.showInfo('连接超时, 请稍候再试.');
			return false;
		}
		
		if(o.message) {
			Ext.ux.MsgUtil.showInfo(o.message);
			return false;
		}
		
		if(o.error) {
			Ext.ux.MsgUtil.showError(o.error);
			return false;
		}
		
		return response.isSuccess = o.success || false;
	}
	
	,failureHandler:function(response, options) {
		try {
			var o = Ext.util.JSON.decode(response.responseText);
		} catch(e) {
			Ext.ux.MsgUtil.showError(response.responseText);
			return false;
		}
		
		if(!o) {
			Ext.ux.MsgUtil.showInfo('连接超时, 请稍候再试.');
			return false;
		}
		
		if('true' !== o.failure) {
			Ext.ux.MsgUtil.showError(o.error || '通信格式不正确.');
			return false;
		}
		
		if(o['exception.message']) {
			Ext.ux.MsgUtil.showException(o['exception.message'], '异常');
			return false;
		}
		
		return o.failure;
	}
	
	,submitSuccessHandler:function(form, action) {
		return Ext.ux.AjaxUtil.successHandler(action.response, action.options);
	}
	
	,submitFailureHandler:function(form, action) {
		return Ext.ux.AjaxUtil.failureHandler(action.response, action.options);
	}
	
	,validateSignHandler:function(conn, response, options) {
		try {
			var o = Ext.util.JSON.decode(response.responseText);
		} catch(e) {
			Ext.ux.MsgUtil.showError(response.responseText);
			return false;
		}
		
		if('true' == o.resign) {
			window.location = './signoff.json';
			return false;
		}
	}
};