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
/* 025 */
/* 026 */   public java.lang.Object apply(java.lang.Object _i) {
/* 027 */     InternalRow i = (InternalRow) _i;
/* 028 */
/* 029 */     values = new Object[3];
/* 030 */
/* 031 */     boolean isNull1 = i.isNullAt(0);
/* 032 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 033 */     if (isNull1) {
/* 034 */       values[0] = null;
/* 035 */     } else {
/* 036 */       values[0] = value1;
/* 037 */     }
/* 038 */
/* 039 */     long value2 = i.getLong(1);
/* 040 */     if (false) {
/* 041 */       values[1] = null;
/* 042 */     } else {
/* 043 */       values[1] = value2;
/* 044 */     }
/* 045 */
/* 046 */     boolean isNull3 = i.isNullAt(2);
/* 047 */     int value3 = isNull3 ? -1 : (i.getInt(2));
/* 048 */     if (isNull3) {
/* 049 */       values[2] = null;
/* 050 */     } else {
/* 051 */       values[2] = value3;
/* 052 */     }
/* 053 */
/* 054 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 055 */     if (false) {
/* 056 */       mutableRow.setNullAt(0);
/* 057 */     } else {
/* 058 */
/* 059 */       mutableRow.update(0, value);
/* 060 */     }
/* 061 */
/* 062 */     return mutableRow;
/* 063 */   }
/* 064 */ }
