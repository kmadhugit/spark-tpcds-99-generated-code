/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificMutableProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificMutableProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private long value_0;
/* 010 */
/* 011 */   public SpecificMutableProjection(Object[] references) {
/* 012 */     this.references = references;
/* 013 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(1);
/* 014 */     this.value_0 = -1L;
/* 015 */
/* 016 */   }
/* 017 */
/* 018 */   public void initialize(int partitionIndex) {
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */
/* 023 */
/* 024 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 025 */     mutableRow = row;
/* 026 */     return this;
/* 027 */   }
/* 028 */
/* 029 */   /* Provide immutable access to the last projected row. */
/* 030 */   public InternalRow currentValue() {
/* 031 */     return (InternalRow) mutableRow;
/* 032 */   }
/* 033 */
/* 034 */   public java.lang.Object apply(java.lang.Object _i) {
/* 035 */     InternalRow i = (InternalRow) _i;
/* 036 */
/* 037 */
/* 038 */
/* 039 */     boolean isNull = false;
/* 040 */
/* 041 */     long value1 = i.getLong(0);
/* 042 */
/* 043 */     long value2 = i.getLong(1);
/* 044 */     long value = -1L;
/* 045 */     value = value1 + value2;
/* 046 */     this.value_0 = value;
/* 047 */
/* 048 */     // copy all the results into MutableRow
/* 049 */     mutableRow.setLong(0, this.value_0);
/* 050 */     return mutableRow;
/* 051 */   }
/* 052 */ }
