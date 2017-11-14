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
/* 012 */   private long value_1;
/* 013 */
/* 014 */   public SpecificMutableProjection(Object[] references) {
/* 015 */     this.references = references;
/* 016 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(2);
/* 017 */     this.isNull_0 = true;
/* 018 */     this.value_0 = -1.0;
/* 019 */     this.isNull_1 = true;
/* 020 */     this.value_1 = -1L;
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
/* 045 */     boolean isNull = true;
/* 046 */     double value = -1.0;
/* 047 */
/* 048 */     boolean isNull1 = i.isNullAt(0);
/* 049 */     double value1 = isNull1 ? -1.0 : (i.getDouble(0));
/* 050 */     if (!isNull1) {
/* 051 */
/* 052 */       boolean isNull3 = i.isNullAt(8);
/* 053 */       double value3 = isNull3 ? -1.0 : (i.getDouble(8));
/* 054 */       boolean isNull2 = isNull3;
/* 055 */       double value2 = value3;
/* 056 */       if (isNull2) {
/* 057 */
/* 058 */         boolean isNull4 = false;
/* 059 */         double value4 = -1.0;
/* 060 */         if (!false) {
/* 061 */           value4 = (double) 0;
/* 062 */         }
/* 063 */         if (!isNull4) {
/* 064 */           isNull2 = false;
/* 065 */           value2 = value4;
/* 066 */         }
/* 067 */       }
/* 068 */
/* 069 */       isNull = false; // resultCode could change nullability.
/* 070 */       value = value1 + value2;
/* 071 */
/* 072 */     }
/* 073 */     this.isNull_0 = isNull;
/* 074 */     this.value_0 = value;
/* 075 */
/* 076 */
/* 077 */     boolean isNull8 = i.isNullAt(8);
/* 078 */     double value8 = isNull8 ? -1.0 : (i.getDouble(8));
/* 079 */     boolean isNull6 = false;
/* 080 */     long value6 = -1L;
/* 081 */     if (!false && isNull8) {
/* 082 */
/* 083 */       boolean isNull9 = i.isNullAt(1);
/* 084 */       long value9 = isNull9 ? -1L : (i.getLong(1));
/* 085 */       isNull6 = isNull9;
/* 086 */       value6 = value9;
/* 087 */     } else {
/* 088 */
/* 089 */       boolean isNull10 = true;
/* 090 */       long value10 = -1L;
/* 091 */
/* 092 */       boolean isNull11 = i.isNullAt(1);
/* 093 */       long value11 = isNull11 ? -1L : (i.getLong(1));
/* 094 */       if (!isNull11) {
/* 095 */
/* 096 */
/* 097 */         isNull10 = false; // resultCode could change nullability.
/* 098 */         value10 = value11 + 1L;
/* 099 */
/* 100 */       }
/* 101 */       isNull6 = isNull10;
/* 102 */       value6 = value10;
/* 103 */     }
/* 104 */     this.isNull_1 = isNull6;
/* 105 */     this.value_1 = value6;
/* 106 */
/* 107 */     // copy all the results into MutableRow
/* 108 */
/* 109 */     if (!this.isNull_0) {
/* 110 */       mutableRow.setDouble(0, this.value_0);
/* 111 */     } else {
/* 112 */       mutableRow.setNullAt(0);
/* 113 */     }
/* 114 */
/* 115 */     if (!this.isNull_1) {
/* 116 */       mutableRow.setLong(1, this.value_1);
/* 117 */     } else {
/* 118 */       mutableRow.setNullAt(1);
/* 119 */     }
/* 120 */
/* 121 */     return mutableRow;
/* 122 */   }
/* 123 */ }
