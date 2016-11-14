require 'vertx/util/utils.rb'
# Generated from com.reachauto.account.AccountService
module VcloudAccountService
  #  Created by zouqiang on 27/10/2016.
  class AccountService
    # @private
    # @param j_del [::VcloudAccountService::AccountService] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VcloudAccountService::AccountService] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [Hash] account 
    # @yield 
    # @return [self]
    def add_account(account=nil)
      if account.class == Hash && block_given?
        @j_del.java_method(:addAccount, [Java::ComReachautoAccount::Account.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::ComReachautoAccount::Account.new(::Vertx::Util::Utils.to_json_object(account)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling add_account(account)"
    end
    # @param [Fixnum] id 
    # @yield 
    # @return [self]
    def delete_account(id=nil)
      if id.class == Fixnum && block_given?
        @j_del.java_method(:deleteAccount, [Java::JavaLang::Integer.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_integer(id),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling delete_account(id)"
    end
    # @param [Hash] account 
    # @yield 
    # @return [self]
    def update_account(account=nil)
      if account.class == Hash && block_given?
        @j_del.java_method(:updateAccount, [Java::ComReachautoAccount::Account.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::ComReachautoAccount::Account.new(::Vertx::Util::Utils.to_json_object(account)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling update_account(account)"
    end
    # @param [Fixnum] id 
    # @yield 
    # @return [self]
    def retrieve_account(id=nil)
      if id.class == Fixnum && block_given?
        @j_del.java_method(:retrieveAccount, [Java::JavaLang::Integer.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_integer(id),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling retrieve_account(id)"
    end
  end
end
