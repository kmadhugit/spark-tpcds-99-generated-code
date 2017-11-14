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
/* 027 */     boolean isNull6 = i.isNullAt(4);
/* 028 */     double value6 = isNull6 ? -1.0 : (i.getDouble(4));
/* 029 */     if (isNull6) {
/* 030 */       values[4] = null;
/* 031 */     } else {
/* 032 */       values[4] = value6;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(5);
/* 036 */     double value7 = isNull7 ? -1.0 : (i.getDouble(5));
/* 037 */     if (isNull7) {
/* 038 */       values[5] = null;
/* 039 */     } else {
/* 040 */       values[5] = value7;
/* 041 */     }
/* 042 */
/* 043 */     boolean isNull8 = i.isNullAt(6);
/* 044 */     double value8 = isNull8 ? -1.0 : (i.getDouble(6));
/* 045 */     if (isNull8) {
/* 046 */       values[6] = null;
/* 047 */     } else {
/* 048 */       values[6] = value8;
/* 049 */     }
/* 050 */
/* 051 */     boolean isNull9 = i.isNullAt(7);
/* 052 */     double value9 = isNull9 ? -1.0 : (i.getDouble(7));
/* 053 */     if (isNull9) {
/* 054 */       values[7] = null;
/* 055 */     } else {
/* 056 */       values[7] = value9;
/* 057 */     }
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */
/* 062 */   private void apply_0(InternalRow i) {
/* 063 */
/* 064 */     boolean isNull2 = i.isNullAt(0);
/* 065 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 066 */     boolean isNull1 = true;
/* 067 */     java.lang.String value1 = null;
/* 068 */     if (!isNull2) {
/* 069 */
/* 070 */       isNull1 = false;
/* 071 */       if (!isNull1) {
/* 072 */
/* 073 */         Object funcResult = null;
/* 074 */         funcResult = value2.toString();
/* 075 */         value1 = (java.lang.String) funcResult;
/* 076 */
/* 077 */       }
/* 078 */     }
/* 079 */     if (isNull1) {
/* 080 */       values[0] = null;
/* 081 */     } else {
/* 082 */       values[0] = value1;
/* 083 */     }
/* 084 */
/* 085 */     boolean isNull3 = i.isNullAt(1);
/* 086 */     double value3 = isNull3 ? -1.0 : (i.getDouble(1));
/* 087 */     if (isNull3) {
/* 088 */       values[1] = null;
/* 089 */     } else {
/* 090 */       values[1] = value3;
/* 091 */     }
/* 092 */
/* 093 */     boolean isNull4 = i.isNullAt(2);
/* 094 */     double value4 = isNull4 ? -1.0 : (i.getDouble(2));
/* 095 */     if (isNull4) {
/* 096 */       values[2] = null;
/* 097 */     } else {
/* 098 */       values[2] = value4;
/* 099 */     }
/* 100 */
/* 101 */     boolean isNull5 = i.isNullAt(3);
/* 102 */     double value5 = isNull5 ? -1.0 : (i.getDouble(3));
/* 103 */     if (isNull5) {
/* 104 */       values[3] = null;
/* 105 */     } else {
/* 106 */       values[3] = value5;
/* 107 */     }
/* 108 */
/* 109 */   }
/* 110 */
/* 111 */
/* 112 */   public java.lang.Object apply(java.lang.Object _i) {
/* 113 */     InternalRow i = (InternalRow) _i;
/* 114 */
/* 115 */     values = new Object[8];
/* 116 */     apply_0(i);
/* 117 */     apply_1(i);
/* 118 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 119 */     if (false) {
/* 120 */       mutableRow.setNullAt(0);
/* 121 */     } else {
/* 122 */
/* 123 */       mutableRow.update(0, value);
/* 124 */     }
/* 125 */
/* 126 */     return mutableRow;
/* 127 */   }
/* 128 */ }
