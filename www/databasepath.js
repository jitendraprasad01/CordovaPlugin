
module.exports = {
    getDatabasePath: function (callback) {
        cordova.exec(callback, function(err){
			alert(err);
		}, "DatabasePath", "getDatabasePath", []);
    }
}
