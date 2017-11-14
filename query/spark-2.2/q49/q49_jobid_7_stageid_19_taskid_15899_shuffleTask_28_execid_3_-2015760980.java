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
/* 029 */   private void apply_1(InternalRow i) {
/* 030 */
/* 031 */
/* 032 */     boolean isNull14 = i.isNullAt(4);
/* 033 */     Decimal value14 = isNull14 ? null : (i.getDecimal(4, 35, 20));
/* 034 */     this.isNull_2 = isNull14;
/* 035 */     this.value_2 = value14;
/* 036 */
/* 037 */   }
/* 038 */
/* 039 */
/* 040 */   private void apply_0(InternalRow i) {
/* 041 */
/* 042 */
/* 043 */     boolean isNull3 = i.isNullAt(4);
/* 044 */     Decimal value3 = isNull3 ? null : (i.getDecimal(4, 35, 20));
/* 045 */     boolean isNull4 = i.isNullAt(2);
/* 046 */     Decimal value4 = isNull4 ? null : (i.getDecimal(2, 35, 20));
/* 047 */     boolean value2 = (isNull3 && isNull4) ||
/* 048 */     (!isNull3 && !isNull4 && value3.equals(value4));
/* 049 */     boolean value1 = false;
/* 050 */
/* 051 */     if (value2) {
/* 052 */
/* 053 */       boolean isNull5 = false;
/* 054 */
/* 055 */       boolean isNull6 = false;
/* 056 */
/* 057 */       int value7 = i.getInt(0);
/* 058 */
/* 059 */       boolean value6 = false;
/* 060 */       value6 = value7 == 0;
/* 061 */       boolean value5 = false;
/* 062 */       value5 = !(value6);
/* 063 */       value1 = value5;
/* 064 */     }
/* 065 */     boolean isNull = false;
/* 066 */     int value = -1;
/* 067 */     if (!false && value1) {
/* 068 */
/* 069 */       int value9 = i.getInt(0);
/* 070 */       isNull = false;
/* 071 */       value = value9;
/* 072 */     } else {
/* 073 */
/* 074 */       int value10 = i.getInt(1);
/* 075 */       isNull = false;
/* 076 */       value = value10;
/* 077 */     }
/* 078 */     this.value_0 = value;
/* 079 */
/* 080 */
/* 081 */     boolean isNull11 = false;
/* 082 */
/* 083 */     int value12 = i.getInt(1);
/* 084 */
/* 085 */     int value11 = -1;
/* 086 */     value11 = value12 + 1;
/* 087 */     this.value_1 = value11;
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
/* 110 */       mutableRow.setDecimal(2, this.value_2, 35);
/* 111 */     } else {
/* 112 */       mutableRow.setDecimal(2, null, 35);
/* 113 */     }
/* 114 */
/* 115 */     return mutableRow;
/* 116 */   }
/* 117 */ }
