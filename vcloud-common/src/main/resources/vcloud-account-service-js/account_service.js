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

/** @module vcloud-account-service-js/account_service */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JAccountService = com.reachauto.account.AccountService;
var Account = com.reachauto.account.Account;

/**
 Created by zouqiang on 27/10/2016.

 @class
*/
var AccountService = function(j_val) {

  var j_accountService = j_val;
  var that = this;

  /**

   @public
   @param account {Object} 
   @param resultHandler {function} 
   @return {AccountService}
   */
  this.addAccount = function(account, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_accountService["addAccount(com.reachauto.account.Account,io.vertx.core.Handler)"](account != null ? new Account(new JsonObject(JSON.stringify(account))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param id {number} 
   @param resultHandler {function} 
   @return {AccountService}
   */
  this.deleteAccount = function(id, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] ==='number' && typeof __args[1] === 'function') {
      j_accountService["deleteAccount(java.lang.Integer,io.vertx.core.Handler)"](utils.convParamInteger(id), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param account {Object} 
   @param resultHandler {function} 
   @return {AccountService}
   */
  this.updateAccount = function(account, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_accountService["updateAccount(com.reachauto.account.Account,io.vertx.core.Handler)"](account != null ? new Account(new JsonObject(JSON.stringify(account))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param id {number} 
   @param resultHandler {function} 
   @return {AccountService}
   */
  this.retrieveAccount = function(id, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] ==='number' && typeof __args[1] === 'function') {
      j_accountService["retrieveAccount(java.lang.Integer,io.vertx.core.Handler)"](utils.convParamInteger(id), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_accountService;
};

// We export the Constructor function
module.exports = AccountService;