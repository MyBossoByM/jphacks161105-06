// ---- Created by tdomen on 2016/10/26 -----

var express = require('express');
var bodyParser = require('body-parser');
var router = express.Router();
// DBへアクセス
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/backend');

// モデルの宣言
var LocationHistory = require('../../models/location_history');

// POSTリクエストがきた時の処理
/* POST内容はJSON形式で飛ばされる
 * JSON format
 * {
 *  "latitude" : Number
 *  "longitude": Number
 *  "time"     : Data
 * }
 *
 * Request URL: http://localhost:3000/end
 */
router.post('/', function(request, response){
    console.log("catch the post request for adding location_history");
    response.setHeader('Content-Type', 'text/plain');

    // 新しいロケーション情報を登録
    var location_history = new LocationHistory();
    
    // リクエストボディを出力
    console.log(request.body);
    // パラメータ名、usernameとpassを出力
    console.log(request.body.username);
    console.log(request.body.pass);

    // ユーザの各カラムの情報を取得する．
    location_history.latitude = request.body.latitude;
    location_history.longitude = request.body.longitude;
    location_history.time = request.body.time;

    // ユーザ情報をセーブする．
    location_history.save(function(err) {
        if (err) response.send(err);
        response.json({ message: 'New Location History created!' });
    });

});

module.exports = router;
