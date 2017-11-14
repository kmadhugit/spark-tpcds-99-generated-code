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
/* 041 */     boolean isNull4 = i.isNullAt(1);
/* 042 */     long value4 = isNull4 ? -1L : (i.getLong(1));
/* 043 */     boolean isNull3 = isNull4;
/* 044 */     double value3 = -1.0;
/* 045 */     if (!isNull4) {
/* 046 */       value3 = (double) value4;
/* 047 */     }
/* 048 */     boolean isNull = false;
/* 049 */     double value = -1.0;
/* 050 */     if (isNull3 || value3 == 0) {
/* 051 */       isNull = true;
/* 052 */     } else {
/* 053 */
/* 054 */       boolean isNull2 = i.isNullAt(0);
/* 055 */       double value2 = isNull2 ? -1.0 : (i.getDouble(0));
/* 056 */       boolean isNull1 = isNull2;
/* 057 */       double value1 = -1.0;
/* 058 */       if (!isNull2) {
/* 059 */         value1 = value2;
/* 060 */       }
/* 061 */       if (isNull1) {
/* 062 */         isNull = true;
/* 063 */       } else {
/* 064 */         value = (double)(value1 / value3);
/* 065 */       }
/* 066 */     }
/* 067 */     this.isNull_0 = isNull;
/* 068 */     this.value_0 = value;
/* 069 */
/* 070 */     // copy all the results into MutableRow
/* 071 */
/* 072 */     if (!this.isNull_0) {
/* 073 */       mutableRow.setDouble(0, this.value_0);
/* 074 */     } else {
/* 075 */       mutableRow.setNullAt(0);
/* 076 */     }
/* 077 */
/* 078 */     return mutableRow;
/* 079 */   }
/* 080 */ }
