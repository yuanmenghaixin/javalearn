// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SubscribeReq.proto

package netty.chapter8.protobuf;

public final class SubscribeReqProto {
  private SubscribeReqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SubscribeReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:netty.SubscribeReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 subReqID = 1;</code>
     */
    boolean hasSubReqID();
    /**
     * <code>required int32 subReqID = 1;</code>
     */
    int getSubReqID();

    /**
     * <code>required string userName = 2;</code>
     */
    boolean hasUserName();
    /**
     * <code>required string userName = 2;</code>
     */
    java.lang.String getUserName();
    /**
     * <code>required string userName = 2;</code>
     */
    com.google.protobuf.ByteString
        getUserNameBytes();

    /**
     * <code>required string productName = 3;</code>
     */
    boolean hasProductName();
    /**
     * <code>required string productName = 3;</code>
     */
    java.lang.String getProductName();
    /**
     * <code>required string productName = 3;</code>
     */
    com.google.protobuf.ByteString
        getProductNameBytes();

    /**
     * <code>required string address = 4;</code>
     */
    boolean hasAddress();
    /**
     * <code>required string address = 4;</code>
     */
    java.lang.String getAddress();
    /**
     * <code>required string address = 4;</code>
     */
    com.google.protobuf.ByteString
        getAddressBytes();
  }
  /**
   * Protobuf type {@code netty.SubscribeReq}
   */
  public  static final class SubscribeReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:netty.SubscribeReq)
      SubscribeReqOrBuilder {
    // Use SubscribeReq.newBuilder() to construct.
    private SubscribeReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SubscribeReq() {
      subReqID_ = 0;
      userName_ = "";
      productName_ = "";
      address_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private SubscribeReq(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              subReqID_ = input.readInt32();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              userName_ = bs;
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              productName_ = bs;
              break;
            }
            case 34: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000008;
              address_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return netty.chapter8.protobuf.SubscribeReqProto.internal_static_netty_SubscribeReq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return netty.chapter8.protobuf.SubscribeReqProto.internal_static_netty_SubscribeReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq.class, netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq.Builder.class);
    }

    private int bitField0_;
    public static final int SUBREQID_FIELD_NUMBER = 1;
    private int subReqID_;
    /**
     * <code>required int32 subReqID = 1;</code>
     */
    public boolean hasSubReqID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 subReqID = 1;</code>
     */
    public int getSubReqID() {
      return subReqID_;
    }

    public static final int USERNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object userName_;
    /**
     * <code>required string userName = 2;</code>
     */
    public boolean hasUserName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string userName = 2;</code>
     */
    public java.lang.String getUserName() {
      java.lang.Object ref = userName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          userName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string userName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getUserNameBytes() {
      java.lang.Object ref = userName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PRODUCTNAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object productName_;
    /**
     * <code>required string productName = 3;</code>
     */
    public boolean hasProductName() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required string productName = 3;</code>
     */
    public java.lang.String getProductName() {
      java.lang.Object ref = productName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          productName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string productName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getProductNameBytes() {
      java.lang.Object ref = productName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ADDRESS_FIELD_NUMBER = 4;
    private volatile java.lang.Object address_;
    /**
     * <code>required string address = 4;</code>
     */
    public boolean hasAddress() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required string address = 4;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          address_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string address = 4;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasSubReqID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasUserName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasProductName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasAddress()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, subReqID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, userName_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, productName_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, address_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, subReqID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, userName_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, productName_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, address_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq)) {
        return super.equals(obj);
      }
      netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq other = (netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq) obj;

      boolean result = true;
      result = result && (hasSubReqID() == other.hasSubReqID());
      if (hasSubReqID()) {
        result = result && (getSubReqID()
            == other.getSubReqID());
      }
      result = result && (hasUserName() == other.hasUserName());
      if (hasUserName()) {
        result = result && getUserName()
            .equals(other.getUserName());
      }
      result = result && (hasProductName() == other.hasProductName());
      if (hasProductName()) {
        result = result && getProductName()
            .equals(other.getProductName());
      }
      result = result && (hasAddress() == other.hasAddress());
      if (hasAddress()) {
        result = result && getAddress()
            .equals(other.getAddress());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasSubReqID()) {
        hash = (37 * hash) + SUBREQID_FIELD_NUMBER;
        hash = (53 * hash) + getSubReqID();
      }
      if (hasUserName()) {
        hash = (37 * hash) + USERNAME_FIELD_NUMBER;
        hash = (53 * hash) + getUserName().hashCode();
      }
      if (hasProductName()) {
        hash = (37 * hash) + PRODUCTNAME_FIELD_NUMBER;
        hash = (53 * hash) + getProductName().hashCode();
      }
      if (hasAddress()) {
        hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
        hash = (53 * hash) + getAddress().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code netty.SubscribeReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:netty.SubscribeReq)
        netty.chapter8.protobuf.SubscribeReqProto.SubscribeReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return netty.chapter8.protobuf.SubscribeReqProto.internal_static_netty_SubscribeReq_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return netty.chapter8.protobuf.SubscribeReqProto.internal_static_netty_SubscribeReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq.class, netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq.Builder.class);
      }

      // Construct using netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        subReqID_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        userName_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        productName_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        address_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return netty.chapter8.protobuf.SubscribeReqProto.internal_static_netty_SubscribeReq_descriptor;
      }

      public netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq getDefaultInstanceForType() {
        return netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq.getDefaultInstance();
      }

      public netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq build() {
        netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq buildPartial() {
        netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq result = new netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.subReqID_ = subReqID_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.userName_ = userName_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.productName_ = productName_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.address_ = address_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq) {
          return mergeFrom((netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq other) {
        if (other == netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq.getDefaultInstance()) return this;
        if (other.hasSubReqID()) {
          setSubReqID(other.getSubReqID());
        }
        if (other.hasUserName()) {
          bitField0_ |= 0x00000002;
          userName_ = other.userName_;
          onChanged();
        }
        if (other.hasProductName()) {
          bitField0_ |= 0x00000004;
          productName_ = other.productName_;
          onChanged();
        }
        if (other.hasAddress()) {
          bitField0_ |= 0x00000008;
          address_ = other.address_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasSubReqID()) {
          return false;
        }
        if (!hasUserName()) {
          return false;
        }
        if (!hasProductName()) {
          return false;
        }
        if (!hasAddress()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int subReqID_ ;
      /**
       * <code>required int32 subReqID = 1;</code>
       */
      public boolean hasSubReqID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 subReqID = 1;</code>
       */
      public int getSubReqID() {
        return subReqID_;
      }
      /**
       * <code>required int32 subReqID = 1;</code>
       */
      public Builder setSubReqID(int value) {
        bitField0_ |= 0x00000001;
        subReqID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 subReqID = 1;</code>
       */
      public Builder clearSubReqID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        subReqID_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object userName_ = "";
      /**
       * <code>required string userName = 2;</code>
       */
      public boolean hasUserName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string userName = 2;</code>
       */
      public java.lang.String getUserName() {
        java.lang.Object ref = userName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            userName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string userName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getUserNameBytes() {
        java.lang.Object ref = userName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          userName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string userName = 2;</code>
       */
      public Builder setUserName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        userName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string userName = 2;</code>
       */
      public Builder clearUserName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        userName_ = getDefaultInstance().getUserName();
        onChanged();
        return this;
      }
      /**
       * <code>required string userName = 2;</code>
       */
      public Builder setUserNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        userName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object productName_ = "";
      /**
       * <code>required string productName = 3;</code>
       */
      public boolean hasProductName() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required string productName = 3;</code>
       */
      public java.lang.String getProductName() {
        java.lang.Object ref = productName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            productName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string productName = 3;</code>
       */
      public com.google.protobuf.ByteString
          getProductNameBytes() {
        java.lang.Object ref = productName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          productName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string productName = 3;</code>
       */
      public Builder setProductName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        productName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string productName = 3;</code>
       */
      public Builder clearProductName() {
        bitField0_ = (bitField0_ & ~0x00000004);
        productName_ = getDefaultInstance().getProductName();
        onChanged();
        return this;
      }
      /**
       * <code>required string productName = 3;</code>
       */
      public Builder setProductNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        productName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object address_ = "";
      /**
       * <code>required string address = 4;</code>
       */
      public boolean hasAddress() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required string address = 4;</code>
       */
      public java.lang.String getAddress() {
        java.lang.Object ref = address_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            address_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string address = 4;</code>
       */
      public com.google.protobuf.ByteString
          getAddressBytes() {
        java.lang.Object ref = address_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          address_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string address = 4;</code>
       */
      public Builder setAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        address_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string address = 4;</code>
       */
      public Builder clearAddress() {
        bitField0_ = (bitField0_ & ~0x00000008);
        address_ = getDefaultInstance().getAddress();
        onChanged();
        return this;
      }
      /**
       * <code>required string address = 4;</code>
       */
      public Builder setAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        address_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:netty.SubscribeReq)
    }

    // @@protoc_insertion_point(class_scope:netty.SubscribeReq)
    private static final netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq();
    }

    public static netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<SubscribeReq>
        PARSER = new com.google.protobuf.AbstractParser<SubscribeReq>() {
      public SubscribeReq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new SubscribeReq(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SubscribeReq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SubscribeReq> getParserForType() {
      return PARSER;
    }

    public netty.chapter8.protobuf.SubscribeReqProto.SubscribeReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_netty_SubscribeReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_netty_SubscribeReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022SubscribeReq.proto\022\005netty\"X\n\014Subscribe" +
      "Req\022\020\n\010subReqID\030\001 \002(\005\022\020\n\010userName\030\002 \002(\t\022" +
      "\023\n\013productName\030\003 \002(\t\022\017\n\007address\030\004 \002(\tB,\n" +
      "\027netty.chapter8.protobufB\021SubscribeReqPr" +
      "oto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_netty_SubscribeReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_netty_SubscribeReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_netty_SubscribeReq_descriptor,
        new java.lang.String[] { "SubReqID", "UserName", "ProductName", "Address", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
