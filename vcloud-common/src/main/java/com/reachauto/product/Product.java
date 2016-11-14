package com.reachauto.product;

import com.reachauto.account.Account;
import com.reachauto.common.entity.BaseEntity;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Created by zouqiang on 2016/11/8.
 */
@DataObject(generateConverter=true)
public class Product extends BaseEntity{
    private String name;
    private String apiKey;
    private Account account;

    public Product() {
    }

    public Product(JsonObject json) {
        ProductConverter.fromJson(json,this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        ProductConverter.toJson(this, json);
        return json;
    }

    public Product(String jsonStr) {
        ProductConverter.fromJson(new JsonObject(jsonStr), this);
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Product setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }


    public Account getAccount() {
        return account;
    }

    public Product setAccount(Account account) {
        this.account = account;
        return this;
    }

    @Override
    public String toString() {
        return toJson().encodePrettily();
    }
}
