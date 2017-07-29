var gulp = require("gulp"),
	tsc = require ("gulp-typescript"),
	typescript = require("typescript");

var tscProject = tsc.createProject({
	removeComments : false,
	noImplicitAny : false,
	target : "es5",
	module : "commonjs",
	declarationFiles : false,
	emitDecoratorMetadata : true,
	typescript : typescript
});

gulp.task("build-source", function() {
	return gulp.src(__dirname + "/decorators.ts")
		.pipe(tsc(tscProject))
		.js.pipe(gulp.dest(__dirname + "/"));
});
