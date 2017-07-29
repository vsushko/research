/// <reference path="./node_modules/reflect-metadata/reflect-metadata.d.ts"/>

import 'reflect-metadata';

class Demo {
	@logType
	public attr1: string;
}

function logType(target: any, key: string) {
	var t = Reflect.getMetadata('design:type', taget, key);
	console.log(`${key} type: ${t.name}`);
}
