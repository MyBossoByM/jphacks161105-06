// ---- Created by tdomen on 2016/10/26 -----

var express = require('express');
var bodyParser = require('body-parser');
var router = express.Router();
// DBへアクセス
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/backend');

// モデルの宣言
var Zukan = require('../../models/zukan');

// POSTリクエストがきた時の処理
/* POST内容はJSON形式で飛ばされる
 * JSON format
 * {
 *  "username"    : "String" 
 *  "characterID" : "String"
 * }
 *
 * Request URL: http://localhost:3000/zukan
 */
router.post('/', function(request, response){
    console.log("catch the post request for adding location_history");
    response.setHeader('Content-Type', 'text/plain');

    // 新しいロケーション情報を登録
    var zukan = new Zukan();
    
    // リクエストボディを出力
    console.log(request.body);
    // パラメータ名、usernameとpassを出力
    console.log(request.body.username);
    console.log(request.body.characterID);

    // ユーザの各カラムの情報を取得する．
    zukan.username = request.body.username;
    zukan.characterID = request.body.characterID;

    // ユーザ情報をinsertする．
    zukan.save(function(err) {
        if (err) response.send(err);
        response.json({ message: 'zukan insert!' });
    });

});

module.exports = router;
