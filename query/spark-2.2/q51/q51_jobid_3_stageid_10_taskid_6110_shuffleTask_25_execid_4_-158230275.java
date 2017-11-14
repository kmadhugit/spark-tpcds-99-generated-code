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
/* 011 */   private boolean isNull_1;
/* 012 */   private double value_1;
/* 013 */
/* 014 */   public SpecificMutableProjection(Object[] references) {
/* 015 */     this.references = references;
/* 016 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(2);
/* 017 */     this.isNull_0 = true;
/* 018 */     this.value_0 = -1.0;
/* 019 */     this.isNull_1 = true;
/* 020 */     this.value_1 = -1.0;
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */   public void initialize(int partitionIndex) {
/* 025 */
/* 026 */   }
/* 027 */
/* 028 */
/* 029 */
/* 030 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 031 */     mutableRow = row;
/* 032 */     return this;
/* 033 */   }
/* 034 */
/* 035 */   /* Provide immutable access to the last projected row. */
/* 036 */   public InternalRow currentValue() {
/* 037 */     return (InternalRow) mutableRow;
/* 038 */   }
/* 039 */
/* 040 */   public java.lang.Object apply(java.lang.Object _i) {
/* 041 */     InternalRow i = (InternalRow) _i;
/* 042 */
/* 043 */
/* 044 */
/* 045 */     final double value = -1.0;
/* 046 */     this.isNull_0 = true;
/* 047 */     this.value_0 = value;
/* 048 */
/* 049 */
/* 050 */     final double value1 = -1.0;
/* 051 */     this.isNull_1 = true;
/* 052 */     this.value_1 = value1;
/* 053 */
/* 054 */     // copy all the results into MutableRow
/* 055 */
/* 056 */     if (!this.isNull_0) {
/* 057 */       mutableRow.setDouble(0, this.value_0);
/* 058 */     } else {
/* 059 */       mutableRow.setNullAt(0);
/* 060 */     }
/* 061 */
/* 062 */     if (!this.isNull_1) {
/* 063 */       mutableRow.setDouble(1, this.value_1);
/* 064 */     } else {
/* 065 */       mutableRow.setNullAt(1);
/* 066 */     }
/* 067 */
/* 068 */     return mutableRow;
/* 069 */   }
/* 070 */ }
