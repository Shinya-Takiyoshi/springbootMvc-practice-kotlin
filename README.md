# springBootMVC-practice-kotlin
springBoot-practice-kotlin

下記をkotlin用に置き換える
## java→kotlin移行の感想
dataクラスの扱いがjavaのモデルクラスと違っていて慣れない
コンストラクタ宣言やゲッターのアクセス方法も変わってくるため慣れが必要
基本は変数はvalで良し。どうしても変更したい場合はvarを使う。
ローカル変数は明示的に型定義した方が可読性あり？
kotklinがデフォルトでnull禁止なので,javaでnulll許容があるとうまく噛み合わないケースあり。
java→kotlin変換機能があるので慣れるまではこれで良さそう。
java,kotlinの混合パターンと
kotlin→javaに変換機能は無いので、基本文法のマッピングはできるようにする。

#  このプロジェクトで確認できること

### ・RequestParamの使い方
### ・thymeleafの外部ファイル読み込みお作法
      jsファイルの配置場所など
### ・constratcorアノテーションの使い分け
### ・ControllerAdvice,HandlerMethodArgumentResolverの処理する順番
### ・ExceptionHandlerの実装
### ・自前のユーティリティオプジェクト作成
### ・HandlerInterceptorの処理順確認
### HandlerIntercepterで引数になっているModelAndViewには設定したmodelオブジェクトと、controllerでreturnしたviewNameが設定されている
### intelijの機能で、コードの整形とインポート最適化は最後に実施でインデントずれや、不要なインポートの削除をする