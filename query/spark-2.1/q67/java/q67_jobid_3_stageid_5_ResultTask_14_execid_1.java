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
/* 012 */   private double value_2;
/* 013 */
/* 014 */   public SpecificMutableProjection(Object[] references) {
/* 015 */     this.references = references;
/* 016 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(3);
/* 017 */     this.value_0 = -1;
/* 018 */     this.value_1 = -1;
/* 019 */     this.isNull_2 = true;
/* 020 */     this.value_2 = -1.0;
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */   public void initialize(int partitionIndex) {
/* 025 */
/* 026 */   }
/* 027 */
/* 028 */
/* 029 */   private void apply_1(InternalRow i) {
/* 030 */
/* 031 */
/* 032 */     boolean isNull11 = false;
/* 033 */
/* 034 */     int value12 = i.getInt(1);
/* 035 */
/* 036 */     int value11 = -1;
/* 037 */     value11 = value12 + 1;
/* 038 */     this.value_1 = value11;
/* 039 */
/* 040 */
/* 041 */     boolean isNull14 = i.isNullAt(11);
/* 042 */     double value14 = isNull14 ? -1.0 : (i.getDouble(11));
/* 043 */     this.isNull_2 = isNull14;
/* 044 */     this.value_2 = value14;
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */
/* 049 */   private void apply_0(InternalRow i) {
/* 050 */
/* 051 */
/* 052 */     boolean isNull3 = i.isNullAt(11);
/* 053 */     double value3 = isNull3 ? -1.0 : (i.getDouble(11));
/* 054 */     boolean isNull4 = i.isNullAt(2);
/* 055 */     double value4 = isNull4 ? -1.0 : (i.getDouble(2));
/* 056 */     boolean value2 = (isNull3 && isNull4) ||
/* 057 */     (!isNull3 && !isNull4 && (java.lang.Double.isNaN(value3) && java.lang.Double.isNaN(value4)) || value3 == value4);
/* 058 */     boolean value1 = false;
/* 059 */
/* 060 */     if (value2) {
/* 061 */
/* 062 */       boolean isNull5 = false;
/* 063 */
/* 064 */       boolean isNull6 = false;
/* 065 */
/* 066 */       int value7 = i.getInt(0);
/* 067 */
/* 068 */       boolean value6 = false;
/* 069 */       value6 = value7 == 0;
/* 070 */       boolean value5 = false;
/* 071 */       value5 = !(value6);
/* 072 */       value1 = value5;
/* 073 */     }
/* 074 */     boolean isNull = false;
/* 075 */     int value = -1;
/* 076 */     if (!false && value1) {
/* 077 */
/* 078 */       int value9 = i.getInt(0);
/* 079 */       isNull = false;
/* 080 */       value = value9;
/* 081 */     } else {
/* 082 */
/* 083 */       int value10 = i.getInt(1);
/* 084 */       isNull = false;
/* 085 */       value = value10;
/* 086 */     }
/* 087 */     this.value_0 = value;
/* 088 */
/* 089 */   }
/* 090 */
/* 091 */
/* 092 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 093 */     mutableRow = row;
/* 094 */     return this;
/* 095 */   }
/* 096 */
/* 097 */   /* Provide immutable access to the last projected row. */
/* 098 */   public InternalRow currentValue() {
/* 099 */     return (InternalRow) mutableRow;
/* 100 */   }
/* 101 */
/* 102 */   public java.lang.Object apply(java.lang.Object _i) {
/* 103 */     InternalRow i = (InternalRow) _i;
/* 104 */
/* 105 */     apply_0(i);
/* 106 */     apply_1(i);
/* 107 */     // copy all the results into MutableRow
/* 108 */     mutableRow.setInt(0, this.value_0);mutableRow.setInt(1, this.value_1);
/* 109 */     if (!this.isNull_2) {
/* 110 */       mutableRow.setDouble(2, this.value_2);
/* 111 */     } else {
/* 112 */       mutableRow.setNullAt(2);
/* 113 */     }
/* 114 */
/* 115 */     return mutableRow;
/* 116 */   }
/* 117 */ }
