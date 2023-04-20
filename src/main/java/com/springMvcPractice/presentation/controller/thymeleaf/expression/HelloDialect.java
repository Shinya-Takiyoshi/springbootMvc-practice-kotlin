package com.springMvcPractice.presentation.controller.thymeleaf.expression;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * 自前のユーティリティオブジェクト作成
 * 参考:https://qiita.com/su-kun1899/items/af71c0e8de0426dfb8f6
 * メリット：受け渡しているjavaのオブジェクト以外で共通メソッドが呼び出しできて処理できること。
 * 複雑な処理の場合に、htmlに全て記載するよりも簡潔に見えて良い。
 **/
@Component
@RequiredArgsConstructor
public class HelloDialect implements IExpressionObjectDialect {
    private final HelloExpression hello;
    // Thymeleafで使用したい名前
    private static final String HELLO_EXPRESSION_NAME = "hello";

    // 名前管理するSet
    private static final Set<String> ALL_EXPRESSION_NAMES = new HashSet<String>() {
        {
            add(HELLO_EXPRESSION_NAME);
        }
    };

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new IExpressionObjectFactory() {
            @Override
            public Set<String> getAllExpressionObjectNames() {
                return ALL_EXPRESSION_NAMES;
            }

            @Override
            public Object buildObject(IExpressionContext context, String expressionObjectName) {
                // 独自Utilityのインスタンスと名前を紐付け
                if (expressionObjectName.equals(HELLO_EXPRESSION_NAME)) {
                    return hello;
                }
                return null;
            }

            @Override
            public boolean isCacheable(String expressionObjectName) {
                // 必要に応じて実装
                return false;
            }
        };
    }

    @Override
    public String getName() {
        return "YearMonth";
    }
}
