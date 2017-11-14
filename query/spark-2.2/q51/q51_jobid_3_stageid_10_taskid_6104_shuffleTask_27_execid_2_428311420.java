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
/* 045 */     boolean isNull1 = i.isNullAt(0);
/* 046 */     double value1 = isNull1 ? -1.0 : (i.getDouble(0));
/* 047 */     boolean isNull = isNull1;
/* 048 */     double value = value1;
/* 049 */
/* 050 */
/* 051 */     boolean isNull2 = i.isNullAt(4);
/* 052 */     double value2 = isNull2 ? -1.0 : (i.getDouble(4));
/* 053 */     if (!isNull2 && (isNull ||
/* 054 */         (org.apache.spark.util.Utils.nanSafeCompareDoubles(value2, value)) > 0)) {
/* 055 */       isNull = false;
/* 056 */       value = value2;
/* 057 */     }
/* 058 */     this.isNull_0 = isNull;
/* 059 */     this.value_0 = value;
/* 060 */
/* 061 */
/* 062 */     boolean isNull4 = i.isNullAt(1);
/* 063 */     double value4 = isNull4 ? -1.0 : (i.getDouble(1));
/* 064 */     boolean isNull3 = isNull4;
/* 065 */     double value3 = value4;
/* 066 */
/* 067 */
/* 068 */     boolean isNull5 = i.isNullAt(5);
/* 069 */     double value5 = isNull5 ? -1.0 : (i.getDouble(5));
/* 070 */     if (!isNull5 && (isNull3 ||
/* 071 */         (org.apache.spark.util.Utils.nanSafeCompareDoubles(value5, value3)) > 0)) {
/* 072 */       isNull3 = false;
/* 073 */       value3 = value5;
/* 074 */     }
/* 075 */     this.isNull_1 = isNull3;
/* 076 */     this.value_1 = value3;
/* 077 */
/* 078 */     // copy all the results into MutableRow
/* 079 */
/* 080 */     if (!this.isNull_0) {
/* 081 */       mutableRow.setDouble(0, this.value_0);
/* 082 */     } else {
/* 083 */       mutableRow.setNullAt(0);
/* 084 */     }
/* 085 */
/* 086 */     if (!this.isNull_1) {
/* 087 */       mutableRow.setDouble(1, this.value_1);
/* 088 */     } else {
/* 089 */       mutableRow.setNullAt(1);
/* 090 */     }
/* 091 */
/* 092 */     return mutableRow;
/* 093 */   }
/* 094 */ }
