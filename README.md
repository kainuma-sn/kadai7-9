# 第7＆9回課題
```mermaid
sequenceDiagram
    participant postman as Postman
    participant controller as Controller
    participant service as Service
    participant mapper as Mapper
    participant mysql as MySQL

    postman ->> controller: リクエスト(GET,POST,PATCH,DELETE)
    controller ->> service: beanを取得
    service ->> mapper: インプリメントで取得
    mapper ->> mysql: Mybatisでmysqlにアクセス
    mysql ->> mapper: 検索結果を返す(GET)
    mapper ->> service: serviceに呼び出される
    service ->> controller: beanとしてcontrollerに呼び出される<br/>(サーバーエラー、検索結果が空又はnull、<br/>検索結果がない場合、エラーを検出)
    controller ->> postman: 結果を出力する

```
## 課題内容
### 最終版
> [null又は空白、データベースから検索結果なし等を検出し、エラーを返す処理を実装](https://github.com/kainuma-sn/kadai7-9/pull/20#issuecomment-1766459598)<br>

### 第7回
#### HTTPメソッドのGET/POST/PATCH/DELETEのリクエストを扱うControllerの実装
> [HTTPからGETでMySQLのデータが取得できる環境を構築](https://github.com/kainuma-sn/kadai7/pull/4#issuecomment-1763379540)<br>
> [HTTPからPOSTでMySQLにデータを追加できる環境を構築 ](https://github.com/kainuma-sn/kadai7-9/pull/6#issuecomment-1763424214)<br>
> [HTTPからPATCHでMySQLにデータを更新できる環境を構築](https://github.com/kainuma-sn/kadai7-9/pull/7#issuecomment-1763438563)<br>
> [HTTPからDELETEでMySQLのデータを削除できる環境を構築](https://github.com/kainuma-sn/kadai7-9/pull/8#issuecomment-1763445120)<br>
#### オリジナルの仕様を追加
> [HTTPからGETでMySQLのデータを検索できる環境を構築](https://github.com/kainuma-sn/kadai7-9/pull/15#issuecomment-1765314542)<br>

### 第9回
#### MyBatisでRead等の実装
> [HTTPからGETでMySQLのデータが取得できる環境を構築](https://github.com/kainuma-sn/kadai7/pull/4#issuecomment-1763379540)<br>
#### 例外をハンドリングする処理を実装
> [null又は空白、データベースから検索結果なし等を検出し、エラーを返す処理を実装](https://github.com/kainuma-sn/kadai7-9/pull/20#issuecomment-1766459598)<br>

<br><br>

## 実装<br>
### Dockerファイルとmysqlファイルの設定<br>
> [DockerファイルとMySQLファイルの実装](https://github.com/kainuma-sn/kadai7/pull/1#issuecomment-1763373325)<br>

### HTTPからGETでMySQLのデータが取得できる環境を構築<br>
> [HTTPからGETでMySQLのデータが取得できる環境を構築](https://github.com/kainuma-sn/kadai7/pull/4#issuecomment-1763379540)<br>

## CRUD,GET/POST/PATCH/DELETEを実装<br>
### POST,CREATE<br>
> [HTTPからPOSTでMySQLにデータを追加できる環境を構築 ](https://github.com/kainuma-sn/kadai7-9/pull/6#issuecomment-1763424214)<br>
### PATCH,UPDATE<br>
> [HTTPからPATCHでMySQLにデータを更新できる環境を構築](https://github.com/kainuma-sn/kadai7-9/pull/7#issuecomment-1763438563)<br>
### DELETE<br>
> [HTTPからDELETEでMySQLのデータを削除できる環境を構築](https://github.com/kainuma-sn/kadai7-9/pull/8#issuecomment-1763445120)<br>
### ~~GET ※指定したIDを取得~~<br>
> ~~[HTTPからGETでMySQLの指定したレコードを取得できる環境を構築](https://github.com/kainuma-sn/kadai7-9/pull/13#issuecomment-1763450212)~~<br>
### GET ※検索した文字を含む商品を取得<br>
> [HTTPからGETでMySQLのデータを検索できる環境を構築](https://github.com/kainuma-sn/kadai7-9/pull/15#issuecomment-1765314542)<br>
### 各コードにコメントアウトを追加。~~また、Loggerによるエラーハンドリングを実装~~<br>
> [各コードにコメントアウトを追加。~~また、Loggerによるエラーハンドリングを実装~~](https://github.com/kainuma-sn/kadai7-9/pull/14#issue-1946083340)<br>
### ~~null又は空白を検出するバリデーションを実装<br>~~
> ~~[データベースのnull、名前のnullや空白を検出するバリデーションを実装]~~(https://github.com/kainuma-sn/kadai7-9/pull/17#issuecomment-1765359503)<br>
### null又は空白、データベースから検索結果なし等を検出し、エラーを返す処理を実装<br>
> [null又は空白、データベースから検索結果なし等を検出し、エラーを返す処理を実装](https://github.com/kainuma-sn/kadai7-9/pull/20#issuecomment-1766459598)<br>
