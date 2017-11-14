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
/* 043 */   }
/* 044 */
/* 045 */
/* 046 */   private void apply_0(InternalRow i) {
/* 047 */
/* 048 */     boolean isNull2 = i.isNullAt(0);
/* 049 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 050 */     boolean isNull1 = true;
/* 051 */     java.lang.String value1 = null;
/* 052 */     if (!isNull2) {
/* 053 */
/* 054 */       isNull1 = false;
/* 055 */       if (!isNull1) {
/* 056 */
/* 057 */         Object funcResult = null;
/* 058 */         funcResult = value2.toString();
/* 059 */         value1 = (java.lang.String) funcResult;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull1) {
/* 064 */       values[0] = null;
/* 065 */     } else {
/* 066 */       values[0] = value1;
/* 067 */     }
/* 068 */
/* 069 */     boolean isNull3 = i.isNullAt(1);
/* 070 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 071 */     if (isNull3) {
/* 072 */       values[1] = null;
/* 073 */     } else {
/* 074 */       values[1] = value3;
/* 075 */     }
/* 076 */
/* 077 */     boolean isNull4 = i.isNullAt(2);
/* 078 */     double value4 = isNull4 ? -1.0 : (i.getDouble(2));
/* 079 */     if (isNull4) {
/* 080 */       values[2] = null;
/* 081 */     } else {
/* 082 */       values[2] = value4;
/* 083 */     }
/* 084 */
/* 085 */     boolean isNull5 = i.isNullAt(3);
/* 086 */     double value5 = isNull5 ? -1.0 : (i.getDouble(3));
/* 087 */     if (isNull5) {
/* 088 */       values[3] = null;
/* 089 */     } else {
/* 090 */       values[3] = value5;
/* 091 */     }
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */
/* 096 */   public java.lang.Object apply(java.lang.Object _i) {
/* 097 */     InternalRow i = (InternalRow) _i;
/* 098 */
/* 099 */     values = new Object[6];
/* 100 */     apply_0(i);
/* 101 */     apply_1(i);
/* 102 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 103 */     if (false) {
/* 104 */       mutableRow.setNullAt(0);
/* 105 */     } else {
/* 106 */
/* 107 */       mutableRow.update(0, value);
/* 108 */     }
/* 109 */
/* 110 */     return mutableRow;
/* 111 */   }
/* 112 */ }
