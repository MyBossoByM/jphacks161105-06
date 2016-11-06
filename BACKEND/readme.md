# ユーザ管理および図鑑用のバックエンド  

## 環境  
* node.js : v4.4.7  
* express : 4.x
* MongoDB
* Mongoose

## 成果物  

### ディレクトリ構成  

今回はexpressで自動生成されたプロジェクト構成に準拠
~~~
$ tree .
backend
|
|--app.js
|--package.json
|--nodejs_installer.sh
|--models
|  |--user.js
|  |--zukan.js
|--routes
   |--auth
   |  |--login.js
   |--zukan
      |--zukan.js
~~~

### 主要なスクリプト  

#### app.js  

#### nodejs_installer.sh  
    * このサーバを動かすために必要なもの一式揃えるシェルスクリプト  

  