/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificMutableProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificMutableProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */
/* 010 */
/* 011 */   public SpecificMutableProjection(Object[] references) {
/* 012 */     this.references = references;
/* 013 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(0);
/* 014 */
/* 015 */   }
/* 016 */
/* 017 */   public void initialize(int partitionIndex) {
/* 018 */
/* 019 */   }
/* 020 */
/* 021 */
/* 022 */
/* 023 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 024 */     mutableRow = row;
/* 025 */     return this;
/* 026 */   }
/* 027 */
/* 028 */   /* Provide immutable access to the last projected row. */
/* 029 */   public InternalRow currentValue() {
/* 030 */     return (InternalRow) mutableRow;
/* 031 */   }
/* 032 */
/* 033 */   public java.lang.Object apply(java.lang.Object _i) {
/* 034 */     InternalRow i = (InternalRow) _i;
/* 035 */
/* 036 */
/* 037 */     // copy all the results into MutableRow
/* 038 */
/* 039 */     return mutableRow;
/* 040 */   }
/* 041 */ }
