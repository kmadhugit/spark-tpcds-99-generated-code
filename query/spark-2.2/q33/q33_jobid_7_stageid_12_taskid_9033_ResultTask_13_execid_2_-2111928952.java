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
/* 029 */     values = new Object[2];
/* 030 */
/* 031 */     boolean isNull1 = i.isNullAt(0);
/* 032 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 033 */     if (isNull1) {
/* 034 */       values[0] = null;
/* 035 */     } else {
/* 036 */       values[0] = value1;
/* 037 */     }
/* 038 */
/* 039 */     boolean isNull2 = i.isNullAt(1);
/* 040 */     double value2 = isNull2 ? -1.0 : (i.getDouble(1));
/* 041 */     if (isNull2) {
/* 042 */       values[1] = null;
/* 043 */     } else {
/* 044 */       values[1] = value2;
/* 045 */     }
/* 046 */
/* 047 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 048 */     if (false) {
/* 049 */       mutableRow.setNullAt(0);
/* 050 */     } else {
/* 051 */
/* 052 */       mutableRow.update(0, value);
/* 053 */     }
/* 054 */
/* 055 */     return mutableRow;
/* 056 */   }
/* 057 */ }
