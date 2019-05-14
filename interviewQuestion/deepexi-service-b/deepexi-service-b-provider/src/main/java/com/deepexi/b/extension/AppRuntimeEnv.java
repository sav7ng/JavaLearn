package com.deepexi.b.extension;

import com.deepexi.b.extension.ApplicationException;
import com.deepexi.util.IdGenerator;
import org.springframework.stereotype.Component;

/**
 * author      : dormi330
 * date        : 2018/6/30
 * project     : mybatis
 * description : 应用运行上下文
 * 遇到过很多这样的场景, 与领域无关的东西, 渗透到领域模型里面去
 * 想通过某种方式解决这个问题,
 */
@Component
public class AppRuntimeEnv {

    // 租户编码
    private ThreadLocal<String> tenantId = ThreadLocal.withInitial(() -> null);
    // token信息
    private ThreadLocal<String> token = ThreadLocal.withInitial(() -> null);


    public AppRuntimeEnv ensureToken(String token) throws Exception {
        if (null == token) throw new ApplicationException("400", "token must not be null");
        this.token.set(token);
        return this;
    }

    public AppRuntimeEnv ensureTenantId(String tenantId) throws Exception {
        if (null == tenantId) throw new ApplicationException("400", "tenantId must not be null");
        this.tenantId.set(tenantId);
        return this;
    }

    public String getTenantId() {
        return tenantId.get();
    }

    public String getToken() {
        return token.get();
    }

    // requestId
    private ThreadLocal<String> requestId = ThreadLocal.withInitial(IdGenerator::getUuId);

    public String getRequestId() {
        return requestId.get();
    }

}