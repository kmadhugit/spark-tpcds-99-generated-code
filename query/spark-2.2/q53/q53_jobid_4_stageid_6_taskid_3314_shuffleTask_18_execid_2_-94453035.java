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
/* 041 */     boolean isNull3 = i.isNullAt(1);
/* 042 */     long value3 = isNull3 ? -1L : (i.getLong(1));
/* 043 */     boolean isNull2 = isNull3;
/* 044 */     double value2 = -1.0;
/* 045 */     if (!isNull3) {
/* 046 */       value2 = (double) value3;
/* 047 */     }
/* 048 */     boolean isNull = false;
/* 049 */     double value = -1.0;
/* 050 */     if (isNull2 || value2 == 0) {
/* 051 */       isNull = true;
/* 052 */     } else {
/* 053 */
/* 054 */       boolean isNull1 = i.isNullAt(0);
/* 055 */       double value1 = isNull1 ? -1.0 : (i.getDouble(0));
/* 056 */       if (isNull1) {
/* 057 */         isNull = true;
/* 058 */       } else {
/* 059 */         value = (double)(value1 / value2);
/* 060 */       }
/* 061 */     }
/* 062 */     this.isNull_0 = isNull;
/* 063 */     this.value_0 = value;
/* 064 */
/* 065 */     // copy all the results into MutableRow
/* 066 */
/* 067 */     if (!this.isNull_0) {
/* 068 */       mutableRow.setDouble(0, this.value_0);
/* 069 */     } else {
/* 070 */       mutableRow.setNullAt(0);
/* 071 */     }
/* 072 */
/* 073 */     return mutableRow;
/* 074 */   }
/* 075 */ }
