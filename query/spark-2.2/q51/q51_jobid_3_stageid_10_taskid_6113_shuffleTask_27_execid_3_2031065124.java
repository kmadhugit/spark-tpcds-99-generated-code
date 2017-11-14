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
/* 045 */     boolean isNull = i.isNullAt(0);
/* 046 */     double value = isNull ? -1.0 : (i.getDouble(0));
/* 047 */     this.isNull_0 = isNull;
/* 048 */     this.value_0 = value;
/* 049 */
/* 050 */
/* 051 */     boolean isNull1 = i.isNullAt(1);
/* 052 */     double value1 = isNull1 ? -1.0 : (i.getDouble(1));
/* 053 */     this.isNull_1 = isNull1;
/* 054 */     this.value_1 = value1;
/* 055 */
/* 056 */     // copy all the results into MutableRow
/* 057 */
/* 058 */     if (!this.isNull_0) {
/* 059 */       mutableRow.setDouble(0, this.value_0);
/* 060 */     } else {
/* 061 */       mutableRow.setNullAt(0);
/* 062 */     }
/* 063 */
/* 064 */     if (!this.isNull_1) {
/* 065 */       mutableRow.setDouble(1, this.value_1);
/* 066 */     } else {
/* 067 */       mutableRow.setNullAt(1);
/* 068 */     }
/* 069 */
/* 070 */     return mutableRow;
/* 071 */   }
/* 072 */ }
