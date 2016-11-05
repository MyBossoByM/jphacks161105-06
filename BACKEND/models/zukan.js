/* Created by tdomen on 2016/10/26 */

// /backend/models/location_history.js

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var Zukan = new Schema({
    username : { type: String, unique: true},
    characterID : { type: String}
});

module.exports = mongoose.model('zukan', Zukan);
