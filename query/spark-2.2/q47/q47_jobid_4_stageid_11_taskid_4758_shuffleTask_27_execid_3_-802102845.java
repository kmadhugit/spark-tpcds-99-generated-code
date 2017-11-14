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
/* 012 */   private int value_2;
/* 013 */   private boolean isNull_3;
/* 014 */   private int value_3;
/* 015 */
/* 016 */   public SpecificMutableProjection(Object[] references) {
/* 017 */     this.references = references;
/* 018 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(4);
/* 019 */     this.value_0 = -1;
/* 020 */     this.value_1 = -1;
/* 021 */     this.isNull_2 = true;
/* 022 */     this.value_2 = -1;
/* 023 */     this.isNull_3 = true;
/* 024 */     this.value_3 = -1;
/* 025 */
/* 026 */   }
/* 027 */
/* 028 */   public void initialize(int partitionIndex) {
/* 029 */
/* 030 */   }
/* 031 */
/* 032 */
/* 033 */
/* 034 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 035 */     mutableRow = row;
/* 036 */     return this;
/* 037 */   }
/* 038 */
/* 039 */   /* Provide immutable access to the last projected row. */
/* 040 */   public InternalRow currentValue() {
/* 041 */     return (InternalRow) mutableRow;
/* 042 */   }
/* 043 */
/* 044 */   public java.lang.Object apply(java.lang.Object _i) {
/* 045 */     InternalRow i = (InternalRow) _i;
/* 046 */
/* 047 */
/* 048 */
/* 049 */     this.value_0 = 0;
/* 050 */
/* 051 */
/* 052 */     this.value_1 = 1;
/* 053 */
/* 054 */
/* 055 */     final int value2 = -1;
/* 056 */     this.isNull_2 = true;
/* 057 */     this.value_2 = value2;
/* 058 */
/* 059 */
/* 060 */     final int value3 = -1;
/* 061 */     this.isNull_3 = true;
/* 062 */     this.value_3 = value3;
/* 063 */
/* 064 */     // copy all the results into MutableRow
/* 065 */     mutableRow.setInt(0, this.value_0);mutableRow.setInt(1, this.value_1);
/* 066 */     if (!this.isNull_2) {
/* 067 */       mutableRow.setInt(2, this.value_2);
/* 068 */     } else {
/* 069 */       mutableRow.setNullAt(2);
/* 070 */     }
/* 071 */
/* 072 */     if (!this.isNull_3) {
/* 073 */       mutableRow.setInt(3, this.value_3);
/* 074 */     } else {
/* 075 */       mutableRow.setNullAt(3);
/* 076 */     }
/* 077 */
/* 078 */     return mutableRow;
/* 079 */   }
/* 080 */ }
