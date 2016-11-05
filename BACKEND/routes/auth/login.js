// ---- Created by tdomen on 2016/10/25 -----

var express = require('express');
var bodyParser = require('body-parser');
var router = express.Router();
// var MongoStore = require('connect-mongo')(express);

// POSTリクエストがきた時の処理
/* POST内容はJSON形式で飛ばされる
 * JSON format
 * {
 *  "username" : String
 *  "pass"     : String
 * }
 */
router.post('/', function(request, response){
    console.log("catch the post request");
    response.setHeader('Content-Type', 'text/plain');
    // app.use(express.session({
    //     secret: 'secret',
    //     store: new MongoStore({
    //         db: 'session',
    //         host: domain,
    //         clear_interval: 60 * 60
    //     }),
    //     cookie: {
    //         httpOnly: false,
    //         maxAge: new Date(Date.now() + 60 * 60 * 1000)
    //     }
    // }));

    // var loginCheck = function(request, response, next) {
    // 	if (request.session.username){
    // 	    request.session.username = {
    // 		username:request.body.username
    // 	    };
    // 	}
    // 	else{
    // 	    response.send('false');
    // 	}
    // };

    // リクエストボディを出力
    console.log(request.body);
    // パラメータ名、usernameとpassを出力
    console.log(request.body.username);
    console.log(request.body.pass);

    response.send(request.body.username);
    
});

module.exports = router;
