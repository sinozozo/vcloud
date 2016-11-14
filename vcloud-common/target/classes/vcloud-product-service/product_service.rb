require 'vertx/util/utils.rb'
# Generated from com.reachauto.product.ProductService
module VcloudProductService
  #  Created by zouqiang on 2016/11/8.
  class ProductService
    # @private
    # @param j_del [::VcloudProductService::ProductService] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VcloudProductService::ProductService] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [Hash] product 
    # @yield 
    # @return [self]
    def add_product(product=nil)
      if product.class == Hash && block_given?
        @j_del.java_method(:addProduct, [Java::ComReachautoProduct::Product.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::ComReachautoProduct::Product.new(::Vertx::Util::Utils.to_json_object(product)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling add_product(product)"
    end
    # @param [Fixnum] id 
    # @yield 
    # @return [self]
    def delete_product(id=nil)
      if id.class == Fixnum && block_given?
        @j_del.java_method(:deleteProduct, [Java::JavaLang::Integer.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_integer(id),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling delete_product(id)"
    end
    # @param [Hash] product 
    # @yield 
    # @return [self]
    def update_product(product=nil)
      if product.class == Hash && block_given?
        @j_del.java_method(:updateProduct, [Java::ComReachautoProduct::Product.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::ComReachautoProduct::Product.new(::Vertx::Util::Utils.to_json_object(product)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling update_product(product)"
    end
    # @param [Fixnum] id 
    # @yield 
    # @return [self]
    def retrieve_product(id=nil)
      if id.class == Fixnum && block_given?
        @j_del.java_method(:retrieveProduct, [Java::JavaLang::Integer.java_class,Java::IoVertxCore::Handler.java_class]).call(::Vertx::Util::Utils.to_integer(id),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling retrieve_product(id)"
    end
    # @yield 
    # @return [self]
    def retrieve_all_product
      if block_given?
        @j_del.java_method(:retrieveAllProduct, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result.to_a.map { |elt| elt != nil ? JSON.parse(elt.toJson.encode) : nil } : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling retrieve_all_product()"
    end
  end
end
