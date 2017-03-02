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
/* 052 */       boolean isNull4 = i.isNullAt(8);
/* 053 */       double value4 = isNull4 ? -1.0 : (i.getDouble(8));
/* 054 */       boolean isNull3 = isNull4;
/* 055 */       double value3 = -1.0;
/* 056 */       if (!isNull4) {
/* 057 */         value3 = value4;
/* 058 */       }
/* 059 */       boolean isNull2 = isNull3;
/* 060 */       double value2 = value3;
/* 061 */       if (isNull2) {
/* 062 */
/* 063 */         boolean isNull5 = false;
/* 064 */         double value5 = -1.0;
/* 065 */         if (!false) {
/* 066 */           value5 = (double) 0;
/* 067 */         }
/* 068 */         if (!isNull5) {
/* 069 */           isNull2 = false;
/* 070 */           value2 = value5;
/* 071 */         }
/* 072 */       }
/* 073 */
/* 074 */       isNull = false; // resultCode could change nullability.
/* 075 */       value = value1 + value2;
/* 076 */
/* 077 */     }
/* 078 */     this.isNull_0 = isNull;
/* 079 */     this.value_0 = value;
/* 080 */
/* 081 */
/* 082 */     boolean isNull9 = i.isNullAt(8);
/* 083 */     double value9 = isNull9 ? -1.0 : (i.getDouble(8));
/* 084 */     boolean isNull7 = false;
/* 085 */     long value7 = -1L;
/* 086 */     if (!false && isNull9) {
/* 087 */
/* 088 */       boolean isNull10 = i.isNullAt(1);
/* 089 */       long value10 = isNull10 ? -1L : (i.getLong(1));
/* 090 */       isNull7 = isNull10;
/* 091 */       value7 = value10;
/* 092 */     } else {
/* 093 */
/* 094 */       boolean isNull11 = true;
/* 095 */       long value11 = -1L;
/* 096 */
/* 097 */       boolean isNull12 = i.isNullAt(1);
/* 098 */       long value12 = isNull12 ? -1L : (i.getLong(1));
/* 099 */       if (!isNull12) {
/* 100 */
/* 101 */
/* 102 */         isNull11 = false; // resultCode could change nullability.
/* 103 */         value11 = value12 + 1L;
/* 104 */
/* 105 */       }
/* 106 */       isNull7 = isNull11;
/* 107 */       value7 = value11;
/* 108 */     }
/* 109 */     this.isNull_1 = isNull7;
/* 110 */     this.value_1 = value7;
/* 111 */
/* 112 */     // copy all the results into MutableRow
/* 113 */
/* 114 */     if (!this.isNull_0) {
/* 115 */       mutableRow.setDouble(0, this.value_0);
/* 116 */     } else {
/* 117 */       mutableRow.setNullAt(0);
/* 118 */     }
/* 119 */
/* 120 */     if (!this.isNull_1) {
/* 121 */       mutableRow.setLong(1, this.value_1);
/* 122 */     } else {
/* 123 */       mutableRow.setNullAt(1);
/* 124 */     }
/* 125 */
/* 126 */     return mutableRow;
/* 127 */   }
/* 128 */ }
