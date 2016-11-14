require 'vertx/util/utils.rb'
# Generated from com.reachauto.device.DeviceService
module VcloudDeviceService
  #  Created by zouqiang on 23/10/2016.
  class DeviceService
    # @private
    # @param j_del [::VcloudDeviceService::DeviceService] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VcloudDeviceService::DeviceService] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [Hash] device 
    # @yield 
    # @return [self]
    def add_device(device=nil)
      if device.class == Hash && block_given?
        @j_del.java_method(:addDevice, [Java::ComReachautoDevice::Device.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::ComReachautoDevice::Device.new(::Vertx::Util::Utils.to_json_object(device)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling add_device(device)"
    end
    # @param [String] id 
    # @yield 
    # @return [self]
    def delete_device(id=nil)
      if id.class == String && block_given?
        @j_del.java_method(:deleteDevice, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(id,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling delete_device(id)"
    end
    # @param [Hash] device 
    # @yield 
    # @return [self]
    def update_device(device=nil)
      if device.class == Hash && block_given?
        @j_del.java_method(:updateDevice, [Java::ComReachautoDevice::Device.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::ComReachautoDevice::Device.new(::Vertx::Util::Utils.to_json_object(device)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling update_device(device)"
    end
    # @param [String] id 
    # @yield 
    # @return [self]
    def retrieve_device(id=nil)
      if id.class == String && block_given?
        @j_del.java_method(:retrieveDevice, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(id,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling retrieve_device(id)"
    end
  end
end
