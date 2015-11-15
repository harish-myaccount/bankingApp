
//use grunt.cmd in windows

module.exports = function (grunt) {
    grunt.initConfig({
        injector: {
            options: { ignorePath: 'src/main/resources/static/', addRootSlash: true },
            local_dependencies: {
                files: {
                    'src/main/resources/static/index.html': ['bower.json', 'src/main/resources/static/js/app/**/*.js', 'src/main/resources/static/css/**/*.css']
                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-injector');
    grunt.registerTask('default', 'injector');
};

