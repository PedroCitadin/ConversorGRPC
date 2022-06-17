package com.proto.conversor;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *&#47;/service para conversão
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: conversor/conversor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversorServiceGrpc {

  private ConversorServiceGrpc() {}

  public static final String SERVICE_NAME = "conversor.ConversorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.conversor.ConversorRequest,
      com.proto.conversor.ConversorResponse> getConversorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "conversor",
      requestType = com.proto.conversor.ConversorRequest.class,
      responseType = com.proto.conversor.ConversorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.conversor.ConversorRequest,
      com.proto.conversor.ConversorResponse> getConversorMethod() {
    io.grpc.MethodDescriptor<com.proto.conversor.ConversorRequest, com.proto.conversor.ConversorResponse> getConversorMethod;
    if ((getConversorMethod = ConversorServiceGrpc.getConversorMethod) == null) {
      synchronized (ConversorServiceGrpc.class) {
        if ((getConversorMethod = ConversorServiceGrpc.getConversorMethod) == null) {
          ConversorServiceGrpc.getConversorMethod = getConversorMethod =
              io.grpc.MethodDescriptor.<com.proto.conversor.ConversorRequest, com.proto.conversor.ConversorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "conversor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.conversor.ConversorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.conversor.ConversorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversorServiceMethodDescriptorSupplier("conversor"))
              .build();
        }
      }
    }
    return getConversorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConversorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversorServiceStub>() {
        @java.lang.Override
        public ConversorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversorServiceStub(channel, callOptions);
        }
      };
    return ConversorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversorServiceBlockingStub>() {
        @java.lang.Override
        public ConversorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversorServiceBlockingStub(channel, callOptions);
        }
      };
    return ConversorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConversorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversorServiceFutureStub>() {
        @java.lang.Override
        public ConversorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversorServiceFutureStub(channel, callOptions);
        }
      };
    return ConversorServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *&#47;/service para conversão
   * </pre>
   */
  public static abstract class ConversorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void conversor(com.proto.conversor.ConversorRequest request,
        io.grpc.stub.StreamObserver<com.proto.conversor.ConversorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConversorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConversorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.proto.conversor.ConversorRequest,
                com.proto.conversor.ConversorResponse>(
                  this, METHODID_CONVERSOR)))
          .build();
    }
  }

  /**
   * <pre>
   *&#47;/service para conversão
   * </pre>
   */
  public static final class ConversorServiceStub extends io.grpc.stub.AbstractAsyncStub<ConversorServiceStub> {
    private ConversorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversorServiceStub(channel, callOptions);
    }

    /**
     */
    public void conversor(com.proto.conversor.ConversorRequest request,
        io.grpc.stub.StreamObserver<com.proto.conversor.ConversorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConversorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *&#47;/service para conversão
   * </pre>
   */
  public static final class ConversorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConversorServiceBlockingStub> {
    private ConversorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.conversor.ConversorResponse conversor(com.proto.conversor.ConversorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConversorMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *&#47;/service para conversão
   * </pre>
   */
  public static final class ConversorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ConversorServiceFutureStub> {
    private ConversorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.conversor.ConversorResponse> conversor(
        com.proto.conversor.ConversorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConversorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONVERSOR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConversorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConversorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONVERSOR:
          serviceImpl.conversor((com.proto.conversor.ConversorRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.conversor.ConversorResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConversorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.conversor.Conversor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConversorService");
    }
  }

  private static final class ConversorServiceFileDescriptorSupplier
      extends ConversorServiceBaseDescriptorSupplier {
    ConversorServiceFileDescriptorSupplier() {}
  }

  private static final class ConversorServiceMethodDescriptorSupplier
      extends ConversorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConversorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConversorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConversorServiceFileDescriptorSupplier())
              .addMethod(getConversorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
