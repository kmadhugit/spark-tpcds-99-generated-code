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
/* 041 */     boolean isNull1 = true;
/* 042 */     double value1 = -1.0;
/* 043 */
/* 044 */     boolean isNull3 = i.isNullAt(0);
/* 045 */     double value3 = isNull3 ? -1.0 : (i.getDouble(0));
/* 046 */     boolean isNull2 = isNull3;
/* 047 */     double value2 = value3;
/* 048 */     if (isNull2) {
/* 049 */
/* 050 */       boolean isNull4 = false;
/* 051 */       double value4 = -1.0;
/* 052 */       if (!false) {
/* 053 */         value4 = (double) 0;
/* 054 */       }
/* 055 */       if (!isNull4) {
/* 056 */         isNull2 = false;
/* 057 */         value2 = value4;
/* 058 */       }
/* 059 */     }
/* 060 */
/* 061 */     boolean isNull7 = i.isNullAt(3);
/* 062 */     double value7 = isNull7 ? -1.0 : (i.getDouble(3));
/* 063 */     boolean isNull6 = isNull7;
/* 064 */     double value6 = -1.0;
/* 065 */     if (!isNull7) {
/* 066 */       value6 = value7;
/* 067 */     }
/* 068 */     if (!isNull6) {
/* 069 */
/* 070 */       isNull1 = false; // resultCode could change nullability.
/* 071 */       value1 = value2 + value6;
/* 072 */
/* 073 */     }
/* 074 */     boolean isNull = isNull1;
/* 075 */     double value = value1;
/* 076 */     if (isNull) {
/* 077 */
/* 078 */       boolean isNull8 = i.isNullAt(0);
/* 079 */       double value8 = isNull8 ? -1.0 : (i.getDouble(0));
/* 080 */       if (!isNull8) {
/* 081 */         isNull = false;
/* 082 */         value = value8;
/* 083 */       }
/* 084 */     }
/* 085 */     this.isNull_0 = isNull;
/* 086 */     this.value_0 = value;
/* 087 */
/* 088 */     // copy all the results into MutableRow
/* 089 */
/* 090 */     if (!this.isNull_0) {
/* 091 */       mutableRow.setDouble(0, this.value_0);
/* 092 */     } else {
/* 093 */       mutableRow.setNullAt(0);
/* 094 */     }
/* 095 */
/* 096 */     return mutableRow;
/* 097 */   }
/* 098 */ }
