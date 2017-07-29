function logClass(target: any) { 
	var original = target;

	function construct(constructor, args) {
		var c: any = function() {
		return constructor.apply(this, args);
		}
		c.prototype = constructor.prototype;
		return new c();
	}
	var f: any = function(...args) {
		console.log("New: " + original.name);
		return construct(original, args);
	}
	f.prototype = original.prototype;
	return f;
}

function logMethod(target: any, key: string, descriptor: any) {
	var originalMethod = descriptor.value;
	descriptor.value = function(...args: any[]) {
		var a = args.map(a => JSON.stringify(a)).join();
		var result = originalMethod.apply(this, args);
		var r = JSON.stringify(result);
		console.log(`Call: ${key}(${a}) => ${r}`);
		
		return result;
	}
	return descriptor;	
}

function logProperty(target: any, key: string) {
	var _val = this[key];
	var getter = function () {
		console.log(`Get: ${key} => ${_val}`);
		return _val;
	};
	var setter = function (newVal) {
		console.log(`Set: ${key} => ${newVal}`);
		_val = newVal;
	};
	if (delete this[key]) {
		Object.defineProperty(target, key, {
			get: getter,
			set: setter,
			enumerable: true,
			configurable: true
		});
	}
}

function addMetadata(target: any, key: string, index: number) {
	var metadataKey = `_log_${key}_parameters`;
	if (Array.isArray(target[metadataKey])) {
		target[metadataKey].push(index);
	} else {
		target[metadataKey] = [index];
	}
}

function readMetadata (target: any, key: string, descriptor: any) {
	var originalMethod = descriptor.value;
	descriptor.value = function (...args: any[]) {
		var metadataKey = `_log_${key}_parameters`;
		var indices = target[metadataKey];

		if (Array.isArray(indices)) {
			for (var i = 0; i < args.length; i++) {
				if (indices.indexOf(i) !== -1) {
					var arg = args[i];
					var argStr = JSON.stringify(arg) || arg.toString();
					console.log(`${key} arg[${i}]: ${argStr}`);
				}
			}
			var result = originalMethod.apply(this, args);
			return result;
		}
	}
	return descriptor;
}

function log(...args: any[]) {
	switch(args.length) {
		case 1:
		 	return logClass.apply(this, args);
		case 2:
			// break instead of return as property
			// decorators don't have a return
			logProperty.apply(this, args);
			break;
		case 3:
			if (typeof args[2] === "number") {
				logParameter.apply(this, args);
			}
			return logMethod.apply(this, args);
		default:
			throw new Error("Decorators are not valid here!");
		}
}

function logClass(option: string) {
	return function(target: any) {
		var original = target;

	        function construct(constructor, args) {
        	        var c: any = function() {
        	       		return constructor.apply(this, args);
        	        }
        	        c.prototype = constructor.prototype;
        	        return new c();
       	 	}
      	 	var f: any = function(...args) {
      	        	console.log("New: " + original.name);
   	   		return construct(original, args);
   	     	}
	   	f.prototype = original.prototype;
		return f;
		console.log(target, option);
	}
}

		

@logClass("option")
class Person {
	@logProperty
	public name: string;
	public surname: string;

	constructor(name: string, surname: string) {
		this.name = name;
		this.surname = surname;
	}

	@logMethod
	@readMetadata
	public saySomething(@addMetadata something: string): string {
		return this.name + " " + this.surname + " says: " + something;
	}
}

var me = new Person("Vasiliy", "Sushko");
me.name = "Vasiliy A.";
var n = me.name;
me.saySomething("hello!");

