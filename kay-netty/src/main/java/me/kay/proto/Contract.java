// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Contract.proto

package me.kay.proto;

public final class Contract {
  private Contract() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_me_kay_proto_Transfer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_me_kay_proto_Transfer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_me_kay_proto_TriggerContract_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_me_kay_proto_TriggerContract_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_me_kay_proto_CreateContract_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_me_kay_proto_CreateContract_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016Contract.proto\022\014me.kay.proto\"E\n\010Transf" +
      "er\022\025\n\rowner_address\030\001 \001(\t\022\016\n\006amount\030\002 \001(" +
      "\005\022\022\n\nto_address\030\003 \001(\t\"[\n\017TriggerContract" +
      "\022\025\n\rowner_address\030\001 \001(\t\022\030\n\020contract_addr" +
      "ess\030\002 \001(\t\022\027\n\017contract_params\030\003 \001(\t\"m\n\016Cr" +
      "eateContract\022\025\n\rowner_address\030\001 \001(\t\022\024\n\014c" +
      "ontract_abi\030\002 \001(\t\022\025\n\rcontract_code\030\003 \001(\t" +
      "\022\027\n\017contract_params\030\004 \001(\tB\032\n\014me.kay.prot" +
      "oB\010ContractP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_me_kay_proto_Transfer_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_me_kay_proto_Transfer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_me_kay_proto_Transfer_descriptor,
        new String[] { "OwnerAddress", "Amount", "ToAddress", });
    internal_static_me_kay_proto_TriggerContract_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_me_kay_proto_TriggerContract_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_me_kay_proto_TriggerContract_descriptor,
        new String[] { "OwnerAddress", "ContractAddress", "ContractParams", });
    internal_static_me_kay_proto_CreateContract_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_me_kay_proto_CreateContract_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_me_kay_proto_CreateContract_descriptor,
        new String[] { "OwnerAddress", "ContractAbi", "ContractCode", "ContractParams", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}