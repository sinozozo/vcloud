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
 * Converter for {@link com.reachauto.device.Location}.
 *
 * NOTE: This class has been automatically generated from the {@link com.reachauto.device.Location} original class using Vert.x codegen.
 */
public class LocationConverter {

  public static void fromJson(JsonObject json, Location obj) {
    if (json.getValue("ele") instanceof Number) {
      obj.setEle(((Number)json.getValue("ele")).doubleValue());
    }
    if (json.getValue("lat") instanceof Number) {
      obj.setLat(((Number)json.getValue("lat")).doubleValue());
    }
    if (json.getValue("lon") instanceof Number) {
      obj.setLon(((Number)json.getValue("lon")).doubleValue());
    }
  }

  public static void toJson(Location obj, JsonObject json) {
    if (obj.getEle() != null) {
      json.put("ele", obj.getEle());
    }
    if (obj.getLat() != null) {
      json.put("lat", obj.getLat());
    }
    if (obj.getLon() != null) {
      json.put("lon", obj.getLon());
    }
  }
}