/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificMutableProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificMutableProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private double value_0;
/* 010 */   private long value_1;
/* 011 */
/* 012 */   public SpecificMutableProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(2);
/* 015 */     this.value_0 = -1.0;
/* 016 */     this.value_1 = -1L;
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
/* 041 */     boolean isNull = false;
/* 042 */     double value = -1.0;
/* 043 */     if (!false) {
/* 044 */       value = (double) 0;
/* 045 */     }
/* 046 */     this.value_0 = value;
/* 047 */
/* 048 */
/* 049 */     this.value_1 = 0L;
/* 050 */
/* 051 */     // copy all the results into MutableRow
/* 052 */     mutableRow.setDouble(0, this.value_0);mutableRow.setLong(1, this.value_1);
/* 053 */     return mutableRow;
/* 054 */   }
/* 055 */ }
