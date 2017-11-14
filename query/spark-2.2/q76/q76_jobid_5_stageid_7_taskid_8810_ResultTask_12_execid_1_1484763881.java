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
/* 027 */     boolean isNull7 = i.isNullAt(4);
/* 028 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(4));
/* 029 */     boolean isNull6 = true;
/* 030 */     java.lang.String value6 = null;
/* 031 */     if (!isNull7) {
/* 032 */
/* 033 */       isNull6 = false;
/* 034 */       if (!isNull6) {
/* 035 */
/* 036 */         Object funcResult1 = null;
/* 037 */         funcResult1 = value7.toString();
/* 038 */         value6 = (java.lang.String) funcResult1;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull6) {
/* 043 */       values[4] = null;
/* 044 */     } else {
/* 045 */       values[4] = value6;
/* 046 */     }
/* 047 */
/* 048 */     long value8 = i.getLong(5);
/* 049 */     if (false) {
/* 050 */       values[5] = null;
/* 051 */     } else {
/* 052 */       values[5] = value8;
/* 053 */     }
/* 054 */
/* 055 */     boolean isNull9 = i.isNullAt(6);
/* 056 */     double value9 = isNull9 ? -1.0 : (i.getDouble(6));
/* 057 */     if (isNull9) {
/* 058 */       values[6] = null;
/* 059 */     } else {
/* 060 */       values[6] = value9;
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_0(InternalRow i) {
/* 067 */
/* 068 */     UTF8String value2 = i.getUTF8String(0);
/* 069 */     boolean isNull1 = true;
/* 070 */     java.lang.String value1 = null;
/* 071 */     if (!false) {
/* 072 */
/* 073 */       isNull1 = false;
/* 074 */       if (!isNull1) {
/* 075 */
/* 076 */         Object funcResult = null;
/* 077 */         funcResult = value2.toString();
/* 078 */         value1 = (java.lang.String) funcResult;
/* 079 */
/* 080 */       }
/* 081 */     }
/* 082 */     if (isNull1) {
/* 083 */       values[0] = null;
/* 084 */     } else {
/* 085 */       values[0] = value1;
/* 086 */     }
/* 087 */
/* 088 */     boolean isNull3 = i.isNullAt(1);
/* 089 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 090 */     if (isNull3) {
/* 091 */       values[1] = null;
/* 092 */     } else {
/* 093 */       values[1] = value3;
/* 094 */     }
/* 095 */
/* 096 */     boolean isNull4 = i.isNullAt(2);
/* 097 */     int value4 = isNull4 ? -1 : (i.getInt(2));
/* 098 */     if (isNull4) {
/* 099 */       values[2] = null;
/* 100 */     } else {
/* 101 */       values[2] = value4;
/* 102 */     }
/* 103 */
/* 104 */     boolean isNull5 = i.isNullAt(3);
/* 105 */     int value5 = isNull5 ? -1 : (i.getInt(3));
/* 106 */     if (isNull5) {
/* 107 */       values[3] = null;
/* 108 */     } else {
/* 109 */       values[3] = value5;
/* 110 */     }
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */
/* 115 */   public java.lang.Object apply(java.lang.Object _i) {
/* 116 */     InternalRow i = (InternalRow) _i;
/* 117 */
/* 118 */     values = new Object[7];
/* 119 */     apply_0(i);
/* 120 */     apply_1(i);
/* 121 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 122 */     if (false) {
/* 123 */       mutableRow.setNullAt(0);
/* 124 */     } else {
/* 125 */
/* 126 */       mutableRow.update(0, value);
/* 127 */     }
/* 128 */
/* 129 */     return mutableRow;
/* 130 */   }
/* 131 */ }
