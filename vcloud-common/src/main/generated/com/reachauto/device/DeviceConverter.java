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

package com.reachauto.device;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link com.reachauto.device.Device}.
 *
 * NOTE: This class has been automatically generated from the {@link com.reachauto.device.Device} original class using Vert.x codegen.
 */
public class DeviceConverter {

  public static void fromJson(JsonObject json, Device obj) {
    if (json.getValue("authInfo") instanceof String) {
      obj.setAuthInfo((String)json.getValue("authInfo"));
    }
    if (json.getValue("delFlag") instanceof String) {
      obj.setDelFlag((String)json.getValue("delFlag"));
    }
    if (json.getValue("desc") instanceof String) {
      obj.setDesc((String)json.getValue("desc"));
    }
    if (json.getValue("id") instanceof Number) {
      obj.setId(((Number)json.getValue("id")).intValue());
    }
    if (json.getValue("location") instanceof JsonObject) {
      obj.setLocation(new com.reachauto.device.Location((JsonObject)json.getValue("location")));
    }
    if (json.getValue("other") instanceof String) {
      obj.setOther((String)json.getValue("other"));
    }
    if (json.getValue("privat") instanceof Boolean) {
      obj.setPrivat((Boolean)json.getValue("privat"));
    }
    if (json.getValue("protocol") instanceof String) {
      obj.setProtocol(com.reachauto.device.ProtocolType.valueOf((String)json.getValue("protocol")));
    }
    if (json.getValue("tags") instanceof JsonArray) {
      java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<>();
      json.getJsonArray("tags").forEach( item -> {
        if (item instanceof String)
          list.add((String)item);
      });
      obj.setTags(list);
    }
    if (json.getValue("title") instanceof String) {
      obj.setTitle((String)json.getValue("title"));
    }
  }

  public static void toJson(Device obj, JsonObject json) {
    if (obj.getAuthInfo() != null) {
      json.put("authInfo", obj.getAuthInfo());
    }
    if (obj.getDelFlag() != null) {
      json.put("delFlag", obj.getDelFlag());
    }
    if (obj.getDesc() != null) {
      json.put("desc", obj.getDesc());
    }
    if (obj.getId() != null) {
      json.put("id", obj.getId());
    }
    if (obj.getOther() != null) {
      json.put("other", obj.getOther());
    }
    if (obj.getPrivat() != null) {
      json.put("privat", obj.getPrivat());
    }
    if (obj.getProtocol() != null) {
      json.put("protocol", obj.getProtocol().name());
    }
    if (obj.getTags() != null) {
      json.put("tags", new JsonArray(
          obj.getTags().
              stream().
              map(item -> item).
              collect(java.util.stream.Collectors.toList())));
    }
    if (obj.getTitle() != null) {
      json.put("title", obj.getTitle());
    }
  }
}