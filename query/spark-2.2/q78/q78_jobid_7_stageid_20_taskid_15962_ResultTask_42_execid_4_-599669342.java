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
/* 027 */     double value6 = i.getDouble(5);
/* 028 */     if (false) {
/* 029 */       values[5] = null;
/* 030 */     } else {
/* 031 */       values[5] = value6;
/* 032 */     }
/* 033 */
/* 034 */     double value7 = i.getDouble(6);
/* 035 */     if (false) {
/* 036 */       values[6] = null;
/* 037 */     } else {
/* 038 */       values[6] = value7;
/* 039 */     }
/* 040 */
/* 041 */   }
/* 042 */
/* 043 */
/* 044 */   private void apply_0(InternalRow i) {
/* 045 */
/* 046 */     boolean isNull1 = i.isNullAt(0);
/* 047 */     double value1 = isNull1 ? -1.0 : (i.getDouble(0));
/* 048 */     if (isNull1) {
/* 049 */       values[0] = null;
/* 050 */     } else {
/* 051 */       values[0] = value1;
/* 052 */     }
/* 053 */
/* 054 */     boolean isNull2 = i.isNullAt(1);
/* 055 */     long value2 = isNull2 ? -1L : (i.getLong(1));
/* 056 */     if (isNull2) {
/* 057 */       values[1] = null;
/* 058 */     } else {
/* 059 */       values[1] = value2;
/* 060 */     }
/* 061 */
/* 062 */     boolean isNull3 = i.isNullAt(2);
/* 063 */     double value3 = isNull3 ? -1.0 : (i.getDouble(2));
/* 064 */     if (isNull3) {
/* 065 */       values[2] = null;
/* 066 */     } else {
/* 067 */       values[2] = value3;
/* 068 */     }
/* 069 */
/* 070 */     boolean isNull4 = i.isNullAt(3);
/* 071 */     double value4 = isNull4 ? -1.0 : (i.getDouble(3));
/* 072 */     if (isNull4) {
/* 073 */       values[3] = null;
/* 074 */     } else {
/* 075 */       values[3] = value4;
/* 076 */     }
/* 077 */
/* 078 */     long value5 = i.getLong(4);
/* 079 */     if (false) {
/* 080 */       values[4] = null;
/* 081 */     } else {
/* 082 */       values[4] = value5;
/* 083 */     }
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */
/* 088 */   public java.lang.Object apply(java.lang.Object _i) {
/* 089 */     InternalRow i = (InternalRow) _i;
/* 090 */
/* 091 */     values = new Object[7];
/* 092 */     apply_0(i);
/* 093 */     apply_1(i);
/* 094 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 095 */     if (false) {
/* 096 */       mutableRow.setNullAt(0);
/* 097 */     } else {
/* 098 */
/* 099 */       mutableRow.update(0, value);
/* 100 */     }
/* 101 */
/* 102 */     return mutableRow;
/* 103 */   }
/* 104 */ }
