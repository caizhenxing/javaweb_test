Ext.ux.FileUtil = {
	
	downloadFile: function(url, exportFormat, params) {

		// create hidden target iframe
		var id = Ext.id();
		var frame = document.createElement('iframe');
		frame.id = id;
		frame.name = id;
		frame.className = 'x-hidden';
		if (Ext.isIE) {
			frame.src = Ext.SSL_SECURE_URL;
		}
		document.body.appendChild(frame);
		
		if (Ext.isIE) {
			document.frames[id].name = id;
		}

		var form = Ext.DomHelper.append(document.body, {
			tag : 'form',
			method : 'GET',
			action : url,
			target : id
		});

		document.body.appendChild(form);
		
		// append path to form
		var hidden = document.createElement('input');
		hidden.type = 'hidden';
		hidden.name = 'export';
		hidden.value = exportFormat;
		form.appendChild(hidden);
		
		var param = Ext.apply({}, params);
		if(this.store) {
			param = Ext.apply(param, this.store.baseParams, this.store.lastOptions.params);
		}
		
		Ext.each(param, function(item, i) {
			for(var p in item){
				if(typeof(item[p])!="function"){    
					var hidden = document.createElement('input');
					hidden.type = 'hidden';
					hidden.name = p;
					hidden.value = item[p];
					form.appendChild(hidden);
				}
		    }
		});

		var callback = function() {
			Ext.EventManager.removeListener(frame, 'load', callback, this);
			setTimeout(function() {
				document.body.removeChild(form);
			}, 100);
		};
		
		Ext.EventManager.on(frame, 'load', callback, this);
		form.submit();
	}
};