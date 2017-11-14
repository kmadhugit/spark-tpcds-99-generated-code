/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificMutableProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificMutableProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private int value_0;
/* 010 */   private int value_1;
/* 011 */   private boolean isNull_2;
/* 012 */   private Decimal value_2;
/* 013 */
/* 014 */   public SpecificMutableProjection(Object[] references) {
/* 015 */     this.references = references;
/* 016 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(3);
/* 017 */     this.value_0 = -1;
/* 018 */     this.value_1 = -1;
/* 019 */     this.isNull_2 = true;
/* 020 */     this.value_2 = null;
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
/* 045 */     this.value_0 = 0;
/* 046 */
/* 047 */
/* 048 */     this.value_1 = 1;
/* 049 */
/* 050 */
/* 051 */     final Decimal value2 = null;
/* 052 */     this.isNull_2 = true;
/* 053 */     this.value_2 = value2;
/* 054 */
/* 055 */     // copy all the results into MutableRow
/* 056 */     mutableRow.setInt(0, this.value_0);mutableRow.setInt(1, this.value_1);
/* 057 */     if (!this.isNull_2) {
/* 058 */       mutableRow.setDecimal(2, this.value_2, 35);
/* 059 */     } else {
/* 060 */       mutableRow.setDecimal(2, null, 35);
/* 061 */     }
/* 062 */
/* 063 */     return mutableRow;
/* 064 */   }
/* 065 */ }
