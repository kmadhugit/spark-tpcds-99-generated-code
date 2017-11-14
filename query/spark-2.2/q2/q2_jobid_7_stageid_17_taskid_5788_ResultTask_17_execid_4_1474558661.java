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
/* 027 */     boolean isNull6 = i.isNullAt(5);
/* 028 */     double value6 = isNull6 ? -1.0 : (i.getDouble(5));
/* 029 */     if (isNull6) {
/* 030 */       values[5] = null;
/* 031 */     } else {
/* 032 */       values[5] = value6;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(6);
/* 036 */     double value7 = isNull7 ? -1.0 : (i.getDouble(6));
/* 037 */     if (isNull7) {
/* 038 */       values[6] = null;
/* 039 */     } else {
/* 040 */       values[6] = value7;
/* 041 */     }
/* 042 */
/* 043 */     boolean isNull8 = i.isNullAt(7);
/* 044 */     double value8 = isNull8 ? -1.0 : (i.getDouble(7));
/* 045 */     if (isNull8) {
/* 046 */       values[7] = null;
/* 047 */     } else {
/* 048 */       values[7] = value8;
/* 049 */     }
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */
/* 054 */   private void apply_0(InternalRow i) {
/* 055 */
/* 056 */     boolean isNull1 = i.isNullAt(0);
/* 057 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 058 */     if (isNull1) {
/* 059 */       values[0] = null;
/* 060 */     } else {
/* 061 */       values[0] = value1;
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull2 = i.isNullAt(1);
/* 065 */     double value2 = isNull2 ? -1.0 : (i.getDouble(1));
/* 066 */     if (isNull2) {
/* 067 */       values[1] = null;
/* 068 */     } else {
/* 069 */       values[1] = value2;
/* 070 */     }
/* 071 */
/* 072 */     boolean isNull3 = i.isNullAt(2);
/* 073 */     double value3 = isNull3 ? -1.0 : (i.getDouble(2));
/* 074 */     if (isNull3) {
/* 075 */       values[2] = null;
/* 076 */     } else {
/* 077 */       values[2] = value3;
/* 078 */     }
/* 079 */
/* 080 */     boolean isNull4 = i.isNullAt(3);
/* 081 */     double value4 = isNull4 ? -1.0 : (i.getDouble(3));
/* 082 */     if (isNull4) {
/* 083 */       values[3] = null;
/* 084 */     } else {
/* 085 */       values[3] = value4;
/* 086 */     }
/* 087 */
/* 088 */     boolean isNull5 = i.isNullAt(4);
/* 089 */     double value5 = isNull5 ? -1.0 : (i.getDouble(4));
/* 090 */     if (isNull5) {
/* 091 */       values[4] = null;
/* 092 */     } else {
/* 093 */       values[4] = value5;
/* 094 */     }
/* 095 */
/* 096 */   }
/* 097 */
/* 098 */
/* 099 */   public java.lang.Object apply(java.lang.Object _i) {
/* 100 */     InternalRow i = (InternalRow) _i;
/* 101 */
/* 102 */     values = new Object[8];
/* 103 */     apply_0(i);
/* 104 */     apply_1(i);
/* 105 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 106 */     if (false) {
/* 107 */       mutableRow.setNullAt(0);
/* 108 */     } else {
/* 109 */
/* 110 */       mutableRow.update(0, value);
/* 111 */     }
/* 112 */
/* 113 */     return mutableRow;
/* 114 */   }
/* 115 */ }
