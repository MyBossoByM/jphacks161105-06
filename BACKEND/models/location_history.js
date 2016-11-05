/* Created by tdomen on 2016/10/26 */

// /backend/models/location_history.js

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var LocationHistory = new Schema({
    latitude : { type: Number, min: 0 },
    longitude : { type: Number, min: 0 },
    time : Date
});

module.exports = mongoose.model('location_history', LocationHistory);
