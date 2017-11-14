/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */     byte value5 = i.getByte(2);
/* 028 */     if (false) {
/* 029 */       values[2] = null;
/* 030 */     } else {
/* 031 */       values[2] = value5;
/* 032 */     }
/* 033 */
/* 034 */     boolean isNull6 = i.isNullAt(3);
/* 035 */     double value6 = isNull6 ? -1.0 : (i.getDouble(3));
/* 036 */     if (isNull6) {
/* 037 */       values[3] = null;
/* 038 */     } else {
/* 039 */       values[3] = value6;
/* 040 */     }
/* 041 */
/* 042 */     boolean isNull7 = i.isNullAt(4);
/* 043 */     double value7 = isNull7 ? -1.0 : (i.getDouble(4));
/* 044 */     if (isNull7) {
/* 045 */       values[4] = null;
/* 046 */     } else {
/* 047 */       values[4] = value7;
/* 048 */     }
/* 049 */
/* 050 */     boolean isNull8 = i.isNullAt(5);
/* 051 */     double value8 = isNull8 ? -1.0 : (i.getDouble(5));
/* 052 */     if (isNull8) {
/* 053 */       values[5] = null;
/* 054 */     } else {
/* 055 */       values[5] = value8;
/* 056 */     }
/* 057 */
/* 058 */     boolean isNull9 = i.isNullAt(6);
/* 059 */     double value9 = isNull9 ? -1.0 : (i.getDouble(6));
/* 060 */     if (isNull9) {
/* 061 */       values[6] = null;
/* 062 */     } else {
/* 063 */       values[6] = value9;
/* 064 */     }
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */
/* 069 */   private void apply_0(InternalRow i) {
/* 070 */
/* 071 */     boolean isNull2 = i.isNullAt(0);
/* 072 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 073 */     boolean isNull1 = true;
/* 074 */     java.lang.String value1 = null;
/* 075 */     if (!isNull2) {
/* 076 */
/* 077 */       isNull1 = false;
/* 078 */       if (!isNull1) {
/* 079 */
/* 080 */         Object funcResult = null;
/* 081 */         funcResult = value2.toString();
/* 082 */         value1 = (java.lang.String) funcResult;
/* 083 */
/* 084 */       }
/* 085 */     }
/* 086 */     if (isNull1) {
/* 087 */       values[0] = null;
/* 088 */     } else {
/* 089 */       values[0] = value1;
/* 090 */     }
/* 091 */
/* 092 */     boolean isNull4 = i.isNullAt(1);
/* 093 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 094 */     boolean isNull3 = true;
/* 095 */     java.lang.String value3 = null;
/* 096 */     if (!isNull4) {
/* 097 */
/* 098 */       isNull3 = false;
/* 099 */       if (!isNull3) {
/* 100 */
/* 101 */         Object funcResult1 = null;
/* 102 */         funcResult1 = value4.toString();
/* 103 */         value3 = (java.lang.String) funcResult1;
/* 104 */
/* 105 */       }
/* 106 */     }
/* 107 */     if (isNull3) {
/* 108 */       values[1] = null;
/* 109 */     } else {
/* 110 */       values[1] = value3;
/* 111 */     }
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */
/* 116 */   public java.lang.Object apply(java.lang.Object _i) {
/* 117 */     InternalRow i = (InternalRow) _i;
/* 118 */
/* 119 */     values = new Object[7];
/* 120 */     apply_0(i);
/* 121 */     apply_1(i);
/* 122 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 123 */     if (false) {
/* 124 */       mutableRow.setNullAt(0);
/* 125 */     } else {
/* 126 */
/* 127 */       mutableRow.update(0, value);
/* 128 */     }
/* 129 */
/* 130 */     return mutableRow;
/* 131 */   }
/* 132 */ }
