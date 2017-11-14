/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificMutableProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificMutableProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private boolean isNull_0;
/* 010 */   private double value_0;
/* 011 */
/* 012 */   public SpecificMutableProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(1);
/* 015 */     this.isNull_0 = true;
/* 016 */     this.value_0 = -1.0;
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */
/* 026 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 027 */     mutableRow = row;
/* 028 */     return this;
/* 029 */   }
/* 030 */
/* 031 */   /* Provide immutable access to the last projected row. */
/* 032 */   public InternalRow currentValue() {
/* 033 */     return (InternalRow) mutableRow;
/* 034 */   }
/* 035 */
/* 036 */   public java.lang.Object apply(java.lang.Object _i) {
/* 037 */     InternalRow i = (InternalRow) _i;
/* 038 */
/* 039 */
/* 040 */
/* 041 */     boolean isNull = i.isNullAt(0);
/* 042 */     double value = isNull ? -1.0 : (i.getDouble(0));
/* 043 */     this.isNull_0 = isNull;
/* 044 */     this.value_0 = value;
/* 045 */
/* 046 */     // copy all the results into MutableRow
/* 047 */
/* 048 */     if (!this.isNull_0) {
/* 049 */       mutableRow.setDouble(0, this.value_0);
/* 050 */     } else {
/* 051 */       mutableRow.setNullAt(0);
/* 052 */     }
/* 053 */
/* 054 */     return mutableRow;
/* 055 */   }
/* 056 */ }
