/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.reachauto.account;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link com.reachauto.account.Account}.
 *
 * NOTE: This class has been automatically generated from the {@link com.reachauto.account.Account} original class using Vert.x codegen.
 */
public class AccountConverter {

  public static void fromJson(JsonObject json, Account obj) {
    if (json.getValue("delFlag") instanceof String) {
      obj.setDelFlag((String)json.getValue("delFlag"));
    }
    if (json.getValue("id") instanceof Number) {
      obj.setId(((Number)json.getValue("id")).intValue());
    }
    if (json.getValue("password") instanceof String) {
      obj.setPassword((String)json.getValue("password"));
    }
    if (json.getValue("username") instanceof String) {
      obj.setUsername((String)json.getValue("username"));
    }
  }

  public static void toJson(Account obj, JsonObject json) {
    if (obj.getDelFlag() != null) {
      json.put("delFlag", obj.getDelFlag());
    }
    if (obj.getId() != null) {
      json.put("id", obj.getId());
    }
    if (obj.getPassword() != null) {
      json.put("password", obj.getPassword());
    }
    if (obj.getUsername() != null) {
      json.put("username", obj.getUsername());
    }
  }
}