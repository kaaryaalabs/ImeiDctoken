var exec = require('cordova/exec');

module.exports.getImei = function (arg0, success, error) {
    exec(success, error, 'ImeiDctoken', 'getImei', [arg0]);
};
module.exports.getDcToken = function (arg0, success, error) {
    exec(success, error, 'ImeiDctoken', 'getDcToken', [arg0]);
};